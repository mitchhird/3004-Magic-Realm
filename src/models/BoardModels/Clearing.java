package models.BoardModels;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import networking.sendables.MessageType;
import networking.sendables.TreasureUpdateModel;
import utils.GameUtils;
import utils.Pair;
import views.MainViews.GameView;
import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.TileType;
import models.chitModels.EnvironmentChit.SiteChit;
import models.chitModels.EnvironmentChit.SoundChit;
import models.chitModels.EnvironmentChit.WarningChit;
import models.otherEntities.EntityBase;
import models.otherEntities.SpecificTreasure;
import models.otherEntities.TreasureModel;
import models.otherEntities.TreasurePile;
import models.otherEntities.monsterModels.MonsterBase;

/*
 * Object that represents the logic behind the clearing objects
 * Used mainly for the character's movement but can be expanded on if needed
 */
public class Clearing implements Serializable {

	private boolean blocked;
	private String clearingName;
	private JButton buttonTiedToClearing;
	private int clearingNumber;
	private String clearingType;
	
	private WarningChit warningChit;
	private SoundChit soundChit;
	private SiteChit siteChit;

	private ArrayList<Dwelling> dwellingsOnThis;
	private ArrayList<MonsterBase> monstersOnThis;
	private Set <Clearing> connectedClearings;
	private Set <PlayerBase> playersInClearing;	
	private transient Tile tileThisOn;
	private transient Set <Image> imageEnitiesOnThis;
	private transient Set <EntityBase> entitiesInClearing;
	
	// Lists For Clearings
	private ArrayList <TreasurePile> pilesInClearing;
	private ArrayList <TreasureModel> treasuresInClearing;
	private ArrayList <Pair<Clearing, ArrayList<PlayerBase>>> hiddenClearings;
	private static final long serialVersionUID = -3697827851116659513L;
	
	// Initial Coordinates
	private int startX = 0;
	private int startY = 0;
	private int startWidth = 0;
	private int startHeight = 0;

	public Clearing (String clearingName, Tile tileOn, int theNumber, String clearingType) {
		blocked = false;
		this.clearingName = clearingName;
		tileThisOn = tileOn;
		clearingNumber = theNumber;
		entitiesInClearing = new HashSet<>();
		connectedClearings = new HashSet<>();
		playersInClearing = new HashSet<>();
		imageEnitiesOnThis = new HashSet<>();
		this.clearingType = clearingType;
		dwellingsOnThis = new ArrayList<Dwelling>();

		// Clearing Lists
		treasuresInClearing = new ArrayList<>();
		hiddenClearings = new ArrayList<>();
		monstersOnThis = new ArrayList<MonsterBase>();
		pilesInClearing = new ArrayList<TreasurePile>();
		
		// Create The Button Tied To The Clearing
		buttonTiedToClearing = new JButton("");
		buttonTiedToClearing.setSize(30, 30);
		buttonTiedToClearing.setOpaque(false);
		buttonTiedToClearing.setContentAreaFilled(false);
		
		startHeight = 30;
		startWidth = 30;
		
		// Create Some Random Treasures For This
		genRandomTreasures();
	}
	
	public Clearing (String clearingName) {
		blocked = false;
		this.clearingName = clearingName;
		entitiesInClearing = new HashSet<>();
		connectedClearings = new HashSet<>();
		playersInClearing = new HashSet<>();
		imageEnitiesOnThis = new HashSet<>();

		// Clearing Lists
		treasuresInClearing = new ArrayList<>();
		hiddenClearings = new ArrayList<>();
		pilesInClearing = new ArrayList<TreasurePile>();
		
		// Create The Button Tied To The Clearing
		buttonTiedToClearing = new JButton("");
		buttonTiedToClearing.setSize(30, 30);
		buttonTiedToClearing.setOpaque(false);
		buttonTiedToClearing.setContentAreaFilled(false);
		
		startHeight = 30;
		startWidth = 30;
		
		// Create Some Random Treasures For This
		genRandomTreasures();
	}
	
	// Player Movement To The Clearing
	public void playerMovedToThis (PlayerBase p) {
		blocked = true;
		
		// Move Off Of The Current Clearing And Onto The Next
		p.setCurrentClearing(this);
		
		// Add Them To The Entity Listing
		entitiesInClearing.add(p);
		playersInClearing.add(p);
		
		updateImage();
	}
	
	// Player Moved Away From Clearing
	public void playerMovedOffOf (PlayerBase p) {
		entitiesInClearing.remove(p);
		playersInClearing.remove(p);
		updateImage();
	}
	
	
	// Checks Player Movement Against The Adjancent Tiles
	public boolean isVaildMove (Clearing c, PlayerBase player) {
		if (connectedClearings.contains(c)) {
			return true;
		}
		
		// Now For The Hidden Clearings
		for (Pair<Clearing, ArrayList<PlayerBase>> hiddenClearing: hiddenClearings) {
			if (hiddenClearing.getSecond().contains(player)) {
				return true;
			}
		}
		
		return false;
	}
	
	/// Highlight The Clearing If There Isn't An Image For It
	public void highlightForMove () {
		
		ArrayList<Image> images = getImageEnitiesOnThis();
		
		// If There Is Not An Image On This Tile
		if (images.size() == 0) {
			JButton clearingButton = getButtonTiedToClearing();
			try {
				Image highlight = ImageIO.read(getClass().getResource("/moveableClearing.png"));
				Image icon = highlight.getScaledInstance(buttonTiedToClearing.getWidth(), buttonTiedToClearing.getHeight(), Image.SCALE_SMOOTH);
				clearingButton.setIcon(new ImageIcon(icon));
				clearingButton.repaint();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Tile getTileThisOn(){
		return tileThisOn;
	}
	
	// Highlight The Connected Clearings If They Don't Contain An Image
	public void highlightConnectedClearings (PlayerBase player) {
		for (Clearing c: connectedClearings) {
			if (checkIfPlayerCanMoveTo(player, c)) {
				c.highlightForMove();
			}
		} 
		
		// Also Do The Hidden Ones If The Player Has Found It
		for (Pair<Clearing, ArrayList<PlayerBase>> hiddenClearing: hiddenClearings) {
			if (hiddenClearing.getSecond().contains(player)) {
				hiddenClearing.getFirst().highlightForMove();
			}
		}
	}
	
	// Add The Treasures To This Clearing
	public void addTreasures (TreasureModel ... treasures) {
		for (TreasureModel t: treasures) {
			treasuresInClearing.add(t);
		}
	}
	
	// Check To See If We The Player Can Move To This Based On Movement Restrictions
	private boolean checkIfPlayerCanMoveTo (PlayerBase player, Clearing c) {
		
		// If We Are Moving To A Tile Type We Are Already On Then Nothing Extra Needs To Be Done
		TileType tileToHighlight = c.getTileThisOn().getType();
		TileType playerTile = player.getCurrentClearing().getTileThisOn().getType();
		
		if (playerTile != tileToHighlight) {
			return true;
		} else {
			// If The Player Has Two Available Movements Left The Don't Attempt To Highlight
			if (player.getAvailableActions() < 2 && (tileToHighlight == TileType.CAVES || tileToHighlight == TileType.MOUNTAIN)) {
				return false;
			}
		}
		
		return true;
	}
	
	// Generate Some Random Treasure Because We Can
	private void genRandomTreasures () {
		// Wheither Or Not We Should Have Treasures On This Clearing (20% chance)
		if (Math.random() <= 1) {
			int numOfTreasures = GameUtils.createRandomInt(1, 5);
			
			for (int i = 0; i < numOfTreasures; i++) {
				boolean greatTreasure = (Math.random() < 0.2);
				addTreasures(new TreasureModel(greatTreasure));
			}
		} 
	}
	
	// Player Search's Clearing When Called
	public ArrayList<TreasureModel> searchClearing(PlayerBase p) {
		int dieRoll = GameUtils.createRandomInt(1, 6);
		ArrayList <TreasureModel> returnVal = new ArrayList<>();
		String message = "You Didn't Find Anything In Your Search";
		
		// Temp Holder For Treasure
		if (dieRoll <= 2) {
			for (TreasureModel t : treasuresInClearing) {
				t.playerFound(p);
				returnVal.add(t);
			}
			
			// Find All Treasure Piles
			for (TreasurePile pile: pilesInClearing) {
				pile.playerFound(p);
			}
			
			if (treasuresInClearing.size() != 0)
				message = "You Found Some Treasure In The Clearing. You Can Now Loot It";
		}
		else if (dieRoll <= 3) {
			boolean foundHidden = false;
			
			for (PlayerBase player: playersInClearing) {
				if (!p.equals(player)) {
					if (player.isHidden()){
						player.unHide();
						foundHidden = true;
					}
				}
			}
			// If We Found A Hidden Player
			if (foundHidden) {
				message = "Found Hidden Players, They Are Unhidden";
			} 
		}else if (dieRoll <= 5){
			// Add The Player To The Hidden Clearings
			for (Pair<Clearing, ArrayList<PlayerBase>> pair: hiddenClearings) {
				// TODO: Fix bug where hidden paths aren't 2 way
				pair.getSecond().add(p);
				
				// Link This Clearing To The Path As Well
				for (Pair<Clearing, ArrayList<PlayerBase>> c: pair.getFirst().hiddenClearings) {
					if (c.getFirst().equals(this)) {
						c.getSecond().add(p);
					}
				}
			}
			
			if (hiddenClearings.size() != 0)
				message = "You Found Some Hidden Paths, They Are Now Available To You";
			
		} 

		JOptionPane.showMessageDialog(new JTextField(), message);
		
		return returnVal;
	}
	
	// Loots The Clearing And Grabs All Treasure Out
	public void playerLootClearing (PlayerBase p, GameView writer) {
		ArrayList<TreasureModel> treasuresFound = getTreasuresPlayerFound(p);
		
		// Roll The Random Die, And If The Player Scores A Value That Is In The Range Then Loot That
		int lootTreasureAt = GameUtils.createRandomInt(0, treasuresFound.size() + pilesInClearing.size()- 1);
		
		// If It Is A Valid Treasure, Then We Can Loot It
		if (lootTreasureAt <= treasuresFound.size() + pilesInClearing.size()- 1) {
			removeTreasureAt(p, lootTreasureAt);
			writer.sendMessage(new TreasureUpdateModel(p, lootTreasureAt));
		}
	}

	public void removeTreasureAt(PlayerBase p, int lootTreasureAt) {
		// We Are Removing From The Treasures So Loot
		if (lootTreasureAt <= treasuresInClearing.size() - 1) {
			TreasureModel newTreasure = treasuresInClearing.remove(lootTreasureAt);

		    if (newTreasure instanceof SpecificTreasure) {
				p.addSpecficTreasure((SpecificTreasure) newTreasure);
			} else {
				p.addTreasure(newTreasure);
			}
		} else {
			TreasurePile newPile = pilesInClearing.remove(lootTreasureAt - treasuresInClearing.size() -1);
			
			// For Each Treasure In The Pile
			for (TreasureModel newTreasure: newPile.getTreasureListing()) {
			    if (newTreasure instanceof SpecificTreasure) {
					p.addSpecficTreasure((SpecificTreasure) newTreasure);
				} else {
					p.addTreasure(newTreasure);
				}
			}
		}
	}

	// Get The Treasure In The Clearing The PLayer Knows About
	public ArrayList<TreasureModel> getTreasuresPlayerFound(PlayerBase p) {
		ArrayList<TreasureModel> treasures = new ArrayList<>();
		for (TreasureModel t: treasuresInClearing) {
			if (t.hasPlayerFound(p))
				treasures.add(t);
		}
		
		for (TreasureModel t: pilesInClearing) {
			if (t.hasPlayerFound(p))
				treasures.add(t);
		}
		return treasures;
	}
	
	// When Adding An Image
	public void addImageToList (Image i) {
		imageEnitiesOnThis.add(i);
		updateImage();
	}
	
	// Adds The Monster Into The Current List
	public void addToMonsterList (MonsterBase b) {
		monstersOnThis.add(b);
		b.setActualClearingThisOn(this);
		imageEnitiesOnThis.add(b.getImage());
		updateImage();
	}
	
	// Removes The New Monster From The List
	public void removeMonsterFromlist (MonsterBase b) {
		monstersOnThis.remove(b);
		imageEnitiesOnThis.remove(b.getImage());
		updateImage();
	}
	
	// Removes A Monster A Particular Index
	public void removeMonsterAtIndex (int index) {
		// Sanity Check
		if (index < monstersOnThis.size()) {
			removeMonsterFromlist(monstersOnThis.get(index));
		}
	}
	
	// When Remove An Image Then Update As Well 
	public void removeImageToList (Image i) {
		imageEnitiesOnThis.remove(i);
		updateImage();
	}

	// Reupdates The Tiles Image With What Is In The List
	public void updateImage () {
		ImageIcon displayIcon = new ImageIcon();
		
		int width = buttonTiedToClearing.getWidth();
		int height = buttonTiedToClearing.getHeight();
		
		// Gather The Images On The Clearing
		ArrayList<Image> images = getImageEnitiesOnThis();
		
		// If There Only One Image
		if (images.size() == 1) { 
			Image display = images.iterator().next();
			Image icon = display.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			displayIcon = new ImageIcon(icon);
		} else if (images.size() > 1){
			try {
				Image icon = ImageIO.read(getClass().getResource("/custom/characters/question.gif"));
				Image multiDisplayIcon = icon.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				displayIcon = new ImageIcon(multiDisplayIcon);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		buttonTiedToClearing.setIcon(displayIcon);
		buttonTiedToClearing.repaint();
	}
	
	// Update All Of The Connected Tiles
	public void updateConnectedTiles () {
		for (Clearing c: connectedClearings) {
			c.updateImage();
		}
		
		for (Pair<Clearing, ArrayList<PlayerBase>> c: hiddenClearings) {
			c.getFirst().updateImage();
		}
	}
	
	// Removes The Treasure At This Index
	public void removeTreasureAt (int size) {
		if (size < treasuresInClearing.size()) {
			treasuresInClearing.remove(size);
		}
	}
	
	/* ------------------- Getters And Setters Below Here -------------------*/
	public boolean isBlocked() {
		return blocked;
	}
	
	public Set <EntityBase> getEntitiesInClearing () {
		return entitiesInClearing;
	}

	public JButton getButtonTiedToClearing() {
		return buttonTiedToClearing;
	}
	
	public Set <EntityBase> getUnhiddenEntities () {
		TreeSet<EntityBase> returnVal = new TreeSet<>();
		for (EntityBase e: entitiesInClearing) {
			if (!e.isHidden())
				returnVal.add(e);
		}
		return returnVal;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	public void setButtonTiedToClearing(JButton buttonTiedToClearing) {
		this.buttonTiedToClearing = buttonTiedToClearing;
	}

	public void setLocation (int x, int y) {
		
		startX = (startX == 0) ? x : startX;
		startY = (startY == 0) ? y : startY;
		
		buttonTiedToClearing.setLocation(x, y);
	}
	
	public void setSize (int x, int y) {
		startWidth = (startWidth == 0) ? x : startWidth;
		startHeight = (startHeight == 0) ? y : startHeight;
		
		buttonTiedToClearing.setSize(x, y);
	}
	
	public void scaleClearing (float scale) {
		buttonTiedToClearing.setLocation((int) (startX * scale), (int) (startY * scale));
		buttonTiedToClearing.setSize((int) (startWidth * scale), (int) (startHeight * scale));
		updateImage();
	}

		
	public Set<Clearing> getConnectedClearings() {
		return connectedClearings;
	}

	public void setConnectedClearings(Set<Clearing> connectedClearings) {
		this.connectedClearings = connectedClearings;
	}
	
	public void addConnectedClearing (Clearing newClearing) {
		this.connectedClearings.add(newClearing);
		newClearing.getConnectedClearings().add(this);
	}
	
	// Adds A New Hidden Clearing When Called
	public void addConnectedHiddenClearing (Clearing ... clearings) {
		for (Clearing c: clearings) {
			c.hiddenClearings.add(new Pair<Clearing, ArrayList<PlayerBase>>(this, new ArrayList<PlayerBase>()));
			hiddenClearings.add(new Pair<Clearing, ArrayList<PlayerBase>>(c, new ArrayList<PlayerBase>()));
		}
	}
	
	// Multi Clearing Connection
	public void addToConnectedClearings (Clearing ... clearings) {
		for (Clearing c: clearings) {
			this.addConnectedClearing(c);
		}
	}

	public String getClearingName() {
		return clearingName;
	}

	public void setClearingName(String clearingName) {
		this.clearingName = clearingName;
	}

	public ArrayList<Image> getImageEnitiesOnThis() {
		ArrayList<Image> images = new ArrayList<>();
		for (Image i: imageEnitiesOnThis) {
			images.add(i);
		}
		
		// Add The Player Image's 
		for (PlayerBase p: playersInClearing) {
			images.add(p.getImage());
		}
		
		return images;
	}

	public void setImageEnitiesOnThis(Set<Image> imageEnitiesOnThis) {
		this.imageEnitiesOnThis = imageEnitiesOnThis;
	}

	public ArrayList<PlayerBase> getPlayersInClearing() {
		ArrayList<PlayerBase> returnVal = new ArrayList<>();
		for (PlayerBase p: playersInClearing) {
			returnVal.add(p);
		}
		return returnVal;
	}

	public void setPlayersInClearing(HashSet<PlayerBase> playersInClearing) {
		this.playersInClearing = playersInClearing;
	}
	
	public ArrayList<TreasureModel> getTreasuresInClearing() {
		ArrayList<TreasureModel> returnVal = new ArrayList<TreasureModel>();
		for (TreasureModel t: treasuresInClearing) {
			returnVal.add(t);
		}
		
		for (TreasurePile t: pilesInClearing) {
			returnVal.add(t);
		}
		
		return treasuresInClearing;
	}

	@Override
	public String toString(){
		return clearingName;
	}
	
	public void addEntityToClearing(EntityBase newEntity){
		entitiesInClearing.add(newEntity);
	}
	
	public void setSoundChit(SoundChit newSound){
		soundChit = newSound;
		addImageToList(newSound.getChitImage());
	}
	
	public SoundChit getSoundChit(){
		return soundChit;
	}
	
	public String getClearingType(){
		return clearingType;
	}

	public ArrayList<Dwelling> getDwellingsOnThis() {
		return dwellingsOnThis;
	}

	public void addDwellingsOnThis(Dwelling newDwelling) {
		dwellingsOnThis.add(newDwelling);
	}

	public SiteChit getSiteChit() {
		return siteChit;
	}

	public void setSiteChit(SiteChit siteChit) {
		this.siteChit = siteChit;
		addImageToList(siteChit.getChitImage());
	}

	public WarningChit getWarningChit() {
		return warningChit;
	}

	public void setWarningChit(WarningChit warningChit) {
		this.warningChit = warningChit;
		addImageToList(warningChit.getChitImage());
	}

	public ArrayList<MonsterBase> getMonstersOnThis() {
		return monstersOnThis;
	}
	
	public void addTreasurePile (TreasurePile p) {
		pilesInClearing.add(p);
	}
	
}
