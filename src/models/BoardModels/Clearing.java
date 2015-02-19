package models.BoardModels;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import utils.GameUtils;
import models.characterModels.PlayerBase;
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
	
	public Clearing (String clearingName) {
		blocked = false;
		connectedClearings = new HashSet<>();
		treasuresInClearing = new HashSet<>();
		this.clearingName = clearingName;
		
		// Create The Button Tied To The Clearing
		buttonTiedToClearing = new JButton("");
		buttonTiedToClearing.setSize(30, 30);
		buttonTiedToClearing.setOpaque(false);
		buttonTiedToClearing.setContentAreaFilled(false);
	}
	
	// Player Movement To The Clearing
	public void playerMovedToThis (PlayerBase p) {
		blocked = true;
		p.setCurrentClearing(this);

		// Set The Button's Icon The Player's Class Image
		int iconWidth = buttonTiedToClearing.getWidth();
		int iconHeight = buttonTiedToClearing.getHeight();
		Image playerIcon = p.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
		buttonTiedToClearing.setIcon(new ImageIcon(playerIcon));
		buttonTiedToClearing.repaint();
	}
	
	// Moves The Player Off 
	public void resetClearing () {
		blocked = false;
		buttonTiedToClearing.setIcon(new ImageIcon());
		buttonTiedToClearing.repaint();
	}
	
	public void resetConnectedClearings() {
		for (Clearing c: connectedClearings) {
			c.resetClearing();
		}
	}

	// Checks Player Movement Against The Adjancent Tiles
	public boolean isVaildMove (Clearing c) {
		return connectedClearings.contains(c);
	}
	
	/// Highlight Move
	public void highlightForMove () {
		for (Clearing c: connectedClearings) {
			JButton clearingButton = c.getButtonTiedToClearing();
			clearingButton.setIcon(new ImageIcon(GameUtils.getValidClearingImg(clearingButton)));
			clearingButton.repaint();
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
	
	/* ------------------- Getters And Setters Below Here -------------------*/
	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public JButton getButtonTiedToClearing() {
		return buttonTiedToClearing;
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
