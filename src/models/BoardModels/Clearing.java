package models.BoardModels;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
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
public class Clearing {

	private boolean blocked;
	private String clearingName;
	private JButton buttonTiedToClearing;
	private Set <Clearing> connectedClearings;
	private Set <TreasureModel> treasuresInClearing;
	private Set <EntityBase> entitiesInClearing;
	private ArrayList <Image> imageEnitiesOnThis;
	
	public Clearing (String clearingName) {
		blocked = false;
		this.clearingName = clearingName;
		
		entitiesInClearing = new HashSet<>();
		connectedClearings = new HashSet<>();
		treasuresInClearing = new HashSet<>();
		imageEnitiesOnThis = new ArrayList<>();
		
		// Create The Button Tied To The Clearing
		buttonTiedToClearing = new JButton("");
		buttonTiedToClearing.setSize(30, 30);
		buttonTiedToClearing.setOpaque(false);
		buttonTiedToClearing.setContentAreaFilled(false);
	}
	
	// Player Movement To The Clearing
	public void playerMovedToThis (PlayerBase p) {
		blocked = true;
		
		// Move Off Of The Current Clearing And Onto The Next
		p.setCurrentClearing(this);

		// Set The Button's Icon The Player's Class Image
		addImageToList(p.getImage());
		
		// Add Them To The Entity Listing
		entitiesInClearing.add(p);
	}
	
	// Player Moved Away From Clearing
	public void playerMovedOffOf (PlayerBase p) {
		entitiesInClearing.remove(p);
		removeImageToList(p.getImage());
	}
	
	
	// Checks Player Movement Against The Adjancent Tiles
	public boolean isVaildMove (Clearing c) {
		return connectedClearings.contains(c);
	}
	
	/// Highlight The Clearing If There Isn't An Image For It
	public void highlightForMove () {
		// If There Is Not An Image On This Tile
		if (imageEnitiesOnThis.size() == 0) {
			JButton clearingButton = getButtonTiedToClearing();
			clearingButton.setIcon(new ImageIcon(GameUtils.getValidClearingImg(clearingButton)));
			clearingButton.repaint();
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
		boolean removal = imageEnitiesOnThis.remove(i);
		updateImage();
	}

	// Reupdates The Tiles Image With What Is In The List
	public void updateImage () {
		ImageIcon displayIcon = new ImageIcon();
		
		int width = buttonTiedToClearing.getWidth();
		int height = buttonTiedToClearing.getHeight();
		
		// If There Only One Image
		if (imageEnitiesOnThis.size() == 1) { 
			Image display = imageEnitiesOnThis.get(0);
			Image icon = display.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			displayIcon = new ImageIcon(icon);
		} else if (imageEnitiesOnThis.size() > 1){
			File multiIcon = new File(System.getProperty("user.dir") + "/images/custom/characters", "question.gif");
			try {
				Image icon = ImageIO.read(multiIcon);
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
}
