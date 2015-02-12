package models.BoardModels;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;

import models.characterModels.PlayerBase;

/*
 * Object that represents the logic behind the clearing objects
 * Used mainly for the character's movement but can be expanded on if needed
 */
public class Clearing {

	private boolean blocked;
	private JButton buttonTiedToClearing;
	private Set <Clearing> connectedClearings;			// A Set Because We Don't Want Duplicate Clearings
	
	public Clearing () {
		blocked = false;
		buttonTiedToClearing = null;
		connectedClearings = new HashSet<>();
	}
	
	// Constructor When The Adjancent Clearings Are Known
	public Clearing (JButton repButton, Clearing ... clearings) {
		blocked = false;
		buttonTiedToClearing = repButton;
		connectedClearings = new HashSet<>();
		for (Clearing c: clearings) {
			addConnectedClearing(c);
		}
	}
	
	// Player Movement To The Clearing
	public void playerMovedToThis (PlayerBase p) {
		blocked = true;
		p.setCurrentClearing(this);
		
		// TODO: Implement This
		// buttonTiedToClearing.setIcon(p.getImage());
		// buttonTiedToClearing.repaint();
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
}
