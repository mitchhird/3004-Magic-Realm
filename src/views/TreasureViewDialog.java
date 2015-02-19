package views;

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
import javax.swing.JScrollPane;

import models.characterModels.PlayerBase;
import models.otherEntities.TreasureModel;

public class TreasureViewDialog extends JDialog{

	private JButton lootButton;
	private JButton cancelButton;
	private JList<TreasureModel> treasureList;
	private JScrollPane scrollPane;
	
	private ArrayList <TreasureModel> treasures;
	private PlayerBase thePlayer;
	
	protected GridBagLayout layout = new GridBagLayout();
	protected GridBagConstraints layoutConstraints = new GridBagConstraints(); 
	
	private static final long serialVersionUID = -7494254554569510620L;
		
	// Dialog That The Player Will See When Looting
	public TreasureViewDialog (JFrame owner, String title, boolean modal, ArrayList<TreasureModel> treasures, PlayerBase player) {
		super(owner, title, modal);
		this.treasures = treasures;
		this.thePlayer = player;
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
		
		// Add The Stuff To The View
		addToFrame(scrollPane, 0, 0, 2, 2);
		addToFrame(lootButton, 0, 2, 1, 1);
		addToFrame(cancelButton, 1, 2, 1, 1);
	}
	
	// Add The Listeners
	private void addListeners () {
		lootButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Loot Button Has Been Pressed");
				thePlayer.getCurrentClearing().playerLootClearing(thePlayer);
				treasures = thePlayer.getCurrentClearing().getTreasuresPlayerFound(thePlayer);
				
				// Refresh The List
				TreasureModel[] temp = new TreasureModel[treasures.size()];
				temp = treasures.toArray(temp);
				treasureList.setListData(temp);
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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
