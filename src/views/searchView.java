package views;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.characterModels.PlayerBase;
import models.otherEntities.TreasureModel;
import utils.GameUtils;

public class searchView extends javax.swing.JPanel {

	/**
	 * 
	 */
	
	private gameView parentView;
	private static final long serialVersionUID = 3566830746092036299L;
	
	public searchView(gameView parent) {
        initComponents();
        initListeners();
        parentView = parent;
    }
                    
    private void initComponents() {

    	setLootButton(new javax.swing.JButton());
        setFindButton(new javax.swing.JButton());
        setCancelButton(new javax.swing.JButton());

        getLootButton().setText("Loot");

        getFindButton().setText("Find");

        getCancelButton().setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(getLootButton())
                    .addComponent(getFindButton())
                    .addComponent(getCancelButton()))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(getLootButton())
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getFindButton())
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(getCancelButton())
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    public void initListeners () {
		getFindButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	handleSearchButton();
            }
        });
		
		getLootButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	handleLootButton();
            }
        });
    }
    
    // Handles The Searching
    private void handleSearchButton() {
    	System.out.println("Find test");
    	
    	// If The Game Has Started Then Execute The Search
    	if (parentView.hasGameStarted()){
    		ArrayList <TreasureModel> foundTreasures = parentView.getCurrentPlayer().searchCurrentClearing();
    		
    		if (foundTreasures.size() == 0) {
    			JOptionPane.showMessageDialog(this, "You Didn't Find Anything In Your Search");
    		} else {
    			JOptionPane.showMessageDialog(this, "You Found Some Treasure In The Clearing. You Can Now Loot It");
    		}
    	}
    }
    
    // Handles The looting
    private void handleLootButton () {
    	System.out.println("Loot test");
    	if (parentView.hasGameStarted()){
    		PlayerBase currPlayer = parentView.getCurrentPlayer();
    		ArrayList<TreasureModel> treasures = currPlayer.getCurrentClearing().getTreasuresPlayerFound(currPlayer);
    		
    		// Make The Dialog Appear
    		TreasureViewDialog lootDialog = new TreasureViewDialog(parentView, "Loot", false, treasures, currPlayer);
    		lootDialog.setVisible(true);
    	}
    }
    
    public javax.swing.JButton getFindButton() {
		return findButton;
	}

	public void setFindButton(javax.swing.JButton findButton2) {
		this.findButton = findButton2;
	}


	public javax.swing.JButton getLootButton() {
		return lootButton;
	}

	public void setLootButton(javax.swing.JButton lootButton) {
		this.lootButton = lootButton;
	}


	public javax.swing.JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(javax.swing.JButton cancelButton) {
		this.cancelButton = cancelButton;
	}


	// Variables declaration - do not modify                     
    private javax.swing.JButton lootButton;
    private javax.swing.JButton findButton;
    private javax.swing.JButton cancelButton;
    // End of variables declaration                   
}
