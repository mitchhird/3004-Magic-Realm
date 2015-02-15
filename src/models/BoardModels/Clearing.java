package models.BoardModels;

import java.awt.Image;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import utils.GameUtils;
import models.characterModels.PlayerBase;

/*
 * Object that represents the logic behind the clearing objects
 * Used mainly for the character's movement but can be expanded on if needed
 */
public class Clearing {

	private boolean blocked;
	private JButton buttonTiedToClearing;
	private Set <Clearing> connectedClearings;
	
	public Clearing () {
		blocked = false;
		connectedClearings = new HashSet<>();
		
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
}
