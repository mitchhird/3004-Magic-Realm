package views.PopupViews;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import views.MainViews.GameView;
import models.characterModels.PlayerBase;
import models.otherEntities.TreasureModel;

public class TreasureViewDialog extends JDialog{

	//Variable declarations
	private JButton lootButton;
	private JButton searchButton;
	private JButton cancelButton;
	private JList<TreasureModel> treasureList;
	private JScrollPane scrollPane;
	
	private ArrayList <TreasureModel> treasures;
	private PlayerBase thePlayer;
	
	protected GridBagLayout layout = new GridBagLayout();
	protected GridBagConstraints layoutConstraints = new GridBagConstraints(); 
	
	protected GameView parent;
	
	private static final long serialVersionUID = -7494254554569510620L;
		
	// Dialog That The Player Will See When Looting
	public TreasureViewDialog (GameView owner, String title, boolean modal, ArrayList<TreasureModel> treasures, PlayerBase player) {
		super(owner, title, modal);
		this.treasures = treasures;
		this.thePlayer = player;
		this.parent = owner;
		initWindow();
		addListeners();
	}
	
	// Initialize The Window
	private void initWindow() {
		setSize (300,300);
		setLayout(layout);
		TreasureModel[] temp = new TreasureModel[treasures.size()];
		temp = treasures.toArray(temp);
		
		treasureList = new JList<>(temp);
		scrollPane = new JScrollPane(treasureList);
		lootButton = new JButton("Loot Treasure");
		cancelButton = new JButton("Cancel");
		searchButton = new JButton ("Search Clearing");
		
		// Add The Stuff To The View
		addToFrame(scrollPane, 0, 0, 2, 2);
		addToFrame(lootButton, 0, 2, 1, 1);
		addToFrame(searchButton, 1, 2, 1, 1);
		addToFrame(cancelButton, 0, 3, 2, 1);
	}
	
	// Add The Listeners
	private void addListeners () {
		lootButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Loot Button Has Been Pressed");
				handleLootButton();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		searchButton.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handleSearchButton();
			}
		});
	}
	
	
	// Handles The Looting
	private void handleLootButton () {
		if (thePlayer.getAvailableActions() > 0) {
			thePlayer.getCurrentClearing().playerLootClearing(thePlayer, parent);		
			refreshTreasureList();
		} else {
    		JOptionPane.showMessageDialog(this, "You Have No More Actions For This Turn");
    	}
	}
	
    // Handles The Searching
	private void handleSearchButton() {
		// If There Is Available Actions
		if (thePlayer.getAvailableActions() > 0 || thePlayer.getAmountOfExtraSearchesLeft() > 0) {
			thePlayer.searchCurrentClearing();
			refreshTreasureList();
		} else {
    		JOptionPane.showMessageDialog(this, "You Have No More Actions For This Turn");
    	}
	}

	private void refreshTreasureList() {
		treasures = thePlayer.getCurrentClearing().getTreasuresPlayerFound(thePlayer);
		TreasureModel[] temp = new TreasureModel[treasures.size()];
		temp = treasures.toArray(temp);
		treasureList.setListData(temp);
	}
    
	// Add To This Frame 
	protected void addToFrame (JComponent theComponent, int x, int y, int gridWidth, int gridHeight){
		layoutConstraints.gridx = x;
		layoutConstraints.gridy = y;
		layoutConstraints.gridwidth = gridWidth;
		layoutConstraints.gridheight = gridHeight;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		layout.setConstraints(theComponent, layoutConstraints);
		add(theComponent);
	}
}
