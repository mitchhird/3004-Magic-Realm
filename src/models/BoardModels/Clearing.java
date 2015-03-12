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

import utils.GameUtils;
import models.characterModels.PlayerBase;
import models.otherEntities.EntityBase;
import models.otherEntities.TreasureModel;

/*
 * Object that represents the logic behind the clearing objects
 * Used mainly for the character's movement but can be expanded on if needed
 */
public class Clearing implements Serializable {

	private boolean blocked;
	private String clearingName;
	private JButton buttonTiedToClearing;
	private Set <Clearing> connectedClearings;
	private Set <TreasureModel> treasuresInClearing;
	private Set <PlayerBase> playersInClearing;
	
	private transient Set <Image> imageEnitiesOnThis;
	private transient Set <EntityBase> entitiesInClearing;
	private static final long serialVersionUID = -3697827851116659513L;

	public Clearing (String clearingName) {
		blocked = false;
		this.clearingName = clearingName;
		
		entitiesInClearing = new HashSet<>();
		connectedClearings = new HashSet<>();
		treasuresInClearing = new HashSet<>();
		playersInClearing = new HashSet<>();
		imageEnitiesOnThis = new HashSet<>();
		
		// Create The Button Tied To The Clearing
		buttonTiedToClearing = new JButton("");
		buttonTiedToClearing.setSize(30, 30);
		buttonTiedToClearing.setOpaque(false);
		buttonTiedToClearing.setContentAreaFilled(false);
		
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
	public boolean isVaildMove (Clearing c) {
		return connectedClearings.contains(c);
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
	
	// Highlight The Connected Clearings If They Don't Contain An Image
	public void highlightConnectedClearings () {
		for (Clearing c: connectedClearings) {
			c.highlightForMove();
		}
	}
	
	// Add The Treasures To This Clearing
	public void addTreasures (TreasureModel ... treasures) {
		for (TreasureModel t: treasures) {
			treasuresInClearing.add(t);
		}
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
		
		// Temp Holder For Treasure
		if (dieRoll < 4) {
			for (TreasureModel t : treasuresInClearing) {
				t.playerFound(p);
				returnVal.add(t);
			}
		}
		
		return returnVal;
	}
	
	// Loots The Clearing And Grabs All Treasure Out
	public void playerLootClearing (PlayerBase p) {
		ArrayList<TreasureModel> treasuresFound = getTreasuresPlayerFound(p);
		for (TreasureModel t: treasuresFound) {
			treasuresInClearing.remove(t);
			p.addTreasure(t);
		}
	}
	
	// Get The Treasure In The Clearing The PLayer Knows About
	public ArrayList<TreasureModel> getTreasuresPlayerFound(PlayerBase p) {
		ArrayList<TreasureModel> treasures = new ArrayList<>();
		for (TreasureModel t: treasuresInClearing) {
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
		buttonTiedToClearing.setLocation(x, y);
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
}
