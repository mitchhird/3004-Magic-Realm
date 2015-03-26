package views.MainViews;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import views.PopupViews.CombatView;
import views.PopupViews.TradeView;
import views.PopupViews.TreasureViewDialog;
import networking.sendables.MessageType;
import networking.sendables.UpdateDataObject;
import models.characterModels.PlayerBase;
import models.otherEntities.TreasureModel;

public class PlayerControllView extends javax.swing.JPanel {
	// Variables declaration                   
    private javax.swing.JButton jButton1;
    private javax.swing.JButton sendTurnButton;
    private javax.swing.JButton cancelActionButton;
    private javax.swing.JButton hideButton;
    private javax.swing.JButton moveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton restButton;
    private javax.swing.JButton tradeButton;
    private javax.swing.JLabel playerFameLabel;
    private javax.swing.JLabel playerNotirityLabel;
    private javax.swing.JLabel playerVulnerLabel;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel playerLabel;
    private javax.swing.JLabel playerClassDisplayLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel classLabel;
    private javax.swing.JLabel playerDisplayLabel;
    private javax.swing.JLabel playerGoldLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTable playerRecord;
	private static final long serialVersionUID = 1336340316590856087L;
    
	private GameView parent;
	private javax.swing.JTable jTable2;
	private JScrollPane jScrollPane3;
	private JTable jTable3;
	private JScrollPane jScrollPane4;
	
	private Toolkit tk = Toolkit.getDefaultToolkit();
	
	//constructor for the playerControllView
    public PlayerControllView(GameView parentView) {
        initComponents();
        massSetButtonState(false);
        parent = parentView;
    }
    
    //initializes the components in this view
    private void initComponents() {

        setjButton1(new javax.swing.JButton());
        playerLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        setjLabel8(new javax.swing.JLabel());
        setPlayerGoldLabel(new javax.swing.JLabel());
        playerFameLabel = new javax.swing.JLabel();
        playerNotirityLabel = new javax.swing.JLabel();
        playerVulnerLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerRecord = new javax.swing.JTable();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        sendTurnButton = new javax.swing.JButton();
        cancelActionButton = new javax.swing.JButton();
        hideButton = new javax.swing.JButton();
        moveButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        restButton = new javax.swing.JButton();
        tradeButton = new javax.swing.JButton();
        classLabel = new javax.swing.JLabel();
        setjLabel20(new javax.swing.JLabel());
        jTable2 = new JTable();
        jTable3 = new JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4= new javax.swing.JScrollPane();

        //Set the text of components in this view
        getjButton1().setText("Show Card");
        playerLabel.setText("Player:");
        jLabel3.setText("Gold:");
        jLabel4.setText("Fame:");
        jLabel5.setText("Notoriety:");
        jLabel6.setText("Vulnerability:");
        getPlayerDisplayLabel().setText("None");
        getPlayerGoldLabel().setText("1");
        playerFameLabel.setText("2");
        playerNotirityLabel.setText("3");
        playerVulnerLabel.setText("4");
        jLabel13.setText("Badges:");
        jLabel14.setText("Colors:");
        jLabel15.setText("Curses:");
        jLabel16.setText("None");
        jLabel17.setText("None");
        jLabel18.setText("None");

        //Table declarations
        playerRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Turn", "Mon", "Day", "Color", "Phases", "Action", "Kills"
            }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 7653752904224053856L;
			boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Name","Details"
                }
            ) {
                /**
    			 * 
    			 */
    			private static final long serialVersionUID = 7653752904224053856L;
    			boolean[] canEdit = new boolean [] {
                    false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Name","Details","Status", "IP"
                }
            ) {
                /**
    			 * 
    			 */
    			private static final long serialVersionUID = 7653752904224053856L;
    			boolean[] canEdit = new boolean [] {
                    false, false,false,false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        
        jScrollPane1.setViewportView(playerRecord);
        jScrollPane3.setViewportView(jTable2);
        jScrollPane4.setViewportView(jTable3);
        
        jTabbedPane1.addTab("Record", jScrollPane1);
        jTabbedPane1.addTab("Chits", jScrollPane3);
        jTabbedPane1.addTab("Inventory", jScrollPane4);
        jTabbedPane1.addTab("Spells", jTabbedPane4);
        jTabbedPane1.addTab("Discoveries", jTabbedPane5);
        jTabbedPane1.addTab("Victory Requirements", jTabbedPane6);

        jScrollPane2.setViewportView(jTabbedPane1);

        
        //Action listeners
        sendTurnButton.setText("Send Turn");
        sendTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parent.sendTurn();
            }
        });
        
        cancelActionButton.setText("Cancel Action");
        cancelActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Cancel Action Has Been Pressed");
            }
        });
        

        hideButton.setText("Hide");
        hideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleHideButton(evt);
            }
        });

        moveButton.setText("Move");
        moveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleMoveButtonPress(evt);
            }
        });

        searchButton.setText("Search");

        // Button Needs To Be Expanded On And So Do Treasure
        searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Search Button Has Been Pressed");
				handleSearchButtonPressed();
			}
		});

        restButton.setText("Rest");
        restButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 System.out.println("Rest Button Has Been Pressed");
				 parent.getCurrentPlayer().getCurrentClearing().updateConnectedTiles();
			}
		});

        tradeButton.setText("Trade");
        tradeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 System.out.println("Trade Button Has Been Pressed");
				 parent.getCurrentPlayer().getCurrentClearing().updateConnectedTiles();
				 startTrading();
			}
		});

        classLabel.setText("Class:");
        getPlayerClassLabel().setText("None");

        //Layout for this view
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(playerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addComponent(classLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerVulnerLabel)
                            .addComponent(getPlayerGoldLabel())
                            .addComponent(playerFameLabel)
                            .addComponent(playerNotirityLabel))
                        .addGap(267, 267, 267)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getPlayerDisplayLabel())
                            .addComponent(getPlayerClassLabel()))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(getjButton1())))
                .addContainerGap())
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sendTurnButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelActionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hideButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tradeButton)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(getjButton1())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(classLabel)
                            .addComponent(getPlayerClassLabel()))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerLabel)
                            .addComponent(getPlayerDisplayLabel()))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(getPlayerGoldLabel()))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(playerFameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(playerNotirityLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(playerVulnerLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel18))))))
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendTurnButton)
                    .addComponent(cancelActionButton)
                    .addComponent(hideButton)
                    .addComponent(moveButton)
                    .addComponent(searchButton)
                    .addComponent(restButton)
                    .addComponent(tradeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }                     

	/*---------------------- Update The View With A Player --------------------- */
    public void update(PlayerBase p) {
    	playerDisplayLabel.setText(p.getName());
    	playerClassDisplayLabel.setText(p.getPlayerClass().name());
    	playerGoldLabel.setText("" + p.getCurrentGold());
    	playerFameLabel.setText("" + p.getCurrentFame());
    	playerNotirityLabel.setText("" + p.getCurrentNotirity());
    	playerVulnerLabel.setText ("" + p.getVulnerability().name());
    	
    	displayRecord(p);
    }
    
    // Builds The Record Panel Table
    private void displayRecord (PlayerBase p) { 
    	// Initialize The Data
    	ArrayList<String> playerLog = p.getRecordLog();
        String[] headers = {"Turn", "Mon", "Day", "Color", "Phases", "Action", "Kills"};
    	String[][] data = new String[playerLog.size()][headers.length];
    	
    	// Loop Over The Data
    	for (int i = 0; i < playerLog.size(); i++) {
    		data[i][0] = "" + i;
    		data[i][1] = "";
    		data[i][2] = "";
    		data[i][3] = "";
    		data[i][4] = "";
    		data[i][5] = playerLog.get(i);
    		data[i][6] = "" + p.getKillCount();
    	}
    	
    	// Get The Table Model Ready
    	DefaultTableModel newModel = new DefaultTableModel(data, headers);
    	playerRecord.setModel(newModel);
    }
    
    // Opens The New Search Dialog
    private void search() {
		PlayerBase currPlayer = parent.getCurrentPlayer();
		ArrayList<TreasureModel> treasures = currPlayer.getCurrentClearing().getTreasuresPlayerFound(currPlayer);
		
		// Make The Dialog Appear
		TreasureViewDialog lootDialog = new TreasureViewDialog(parent, "Loot", false, treasures, currPlayer);
		lootDialog.setVisible(true);
	}
   
	public void startTrading(){
		TradeView tradePanel = new TradeView();
		tradePanel.setSize(495,355);
		tradePanel.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		tradePanel.setVisible(true);
	}
	
	// Method Enables / Disables All Buttons Based On Whether Or Not The Player Is Currently Playing 
	public void updateButtonsForNetwork () {
		if (parent.isNetworkedGame()) {
			boolean isLocalPlayer = parent.getCurrentPlayer().getPlayerIP().equals("localhost");
			searchButton.setEnabled(isLocalPlayer);
			moveButton.setEnabled(isLocalPlayer);
			sendTurnButton.setEnabled(isLocalPlayer);
			hideButton.setEnabled(isLocalPlayer);
			tradeButton.setEnabled(isLocalPlayer);
			cancelActionButton.setEnabled(isLocalPlayer);
			restButton.setEnabled(isLocalPlayer);
		}
	}
	
    /*---------------------- Event Handler Methods ----------------------------- */
	private void handleSearchButtonPressed() {
		PlayerBase currentPlayer = parent.getCurrentPlayer();
		currentPlayer.getCurrentClearing().updateConnectedTiles();
		
		if (currentPlayer.getAvailableActions() > 0 || currentPlayer.getAmountOfExtraSearchesLeft() > 0) {
			search();
		} else {
    		JOptionPane.showMessageDialog(this, "You Have No More Actions For This Turn");
    	}
	}
	
    private void handleHideButton(java.awt.event.ActionEvent evt) {                                         
    	System.out.println("Hide Button Has Been Pressed");
    	PlayerBase currentPlayer = parent.getCurrentPlayer();
    	
    	if(currentPlayer == null){
    		return;
    	}
    	
    	// Still Want To Update And Clear The Surronding Tiles If Need Be
    	currentPlayer.getCurrentClearing().updateConnectedTiles();

    	// If The Player Can Do The Action
    	if (currentPlayer.getAvailableActions() > 0 || currentPlayer.getAmountOfExtraHidesLeft() > 0) {
    		currentPlayer.attemptHide();
    		UpdateDataObject data = new UpdateDataObject(currentPlayer, MessageType.UPDATE_PLAYER_HIDE);
    		parent.sendMessage(data);
    	} else {
    		JOptionPane.showMessageDialog(this, "You Have No More Actions For This Turn");
    	}
    }                                        

    // Handles The Move Button Press
    private void handleMoveButtonPress(java.awt.event.ActionEvent evt) {                                         
    	System.out.println("Move Has Been Pressed");
    	PlayerBase currentPlayer = parent.getCurrentPlayer();
    	
    	// If There Is No Current Player Do Nothing
    	if(currentPlayer==null){
    		return;
    	}
    	
    	// If The Player Still Has Actions Available
    	if (currentPlayer.getAvailableActions() > 0) {
    		currentPlayer.getCurrentClearing().highlightConnectedClearings(currentPlayer);
    		currentPlayer.setMoving(true);
    	} else {
    		JOptionPane.showMessageDialog(this, "You Have No More Actions For This Turn");
    	}
    }                                        

	// Shows The Combat In It's Own View
	public void startCombat(ArrayList <PlayerBase> combatingPlayers){
		new CombatView(combatingPlayers, parent);
	}
	
    /*----------------- Getters And Setters ------------------- */
    
    public javax.swing.JLabel getPlayerClassLabel() {
		return playerClassDisplayLabel;
	}

	public void setjLabel20(javax.swing.JLabel jLabel20) {
		this.playerClassDisplayLabel = jLabel20;
	}


	public javax.swing.JLabel getPlayerDisplayLabel() {
		return playerDisplayLabel;
	}

	public void setjLabel8(javax.swing.JLabel jLabel8) {
		this.playerDisplayLabel = jLabel8;
	}


	public javax.swing.JLabel getPlayerGoldLabel() {
		return playerGoldLabel;
	}

	public void setPlayerGoldLabel(javax.swing.JLabel jLabel9) {
		this.playerGoldLabel = jLabel9;
	}

	public javax.swing.JButton getjButton1() {
		return jButton1;
	}

	public void setjButton1(javax.swing.JButton jButton1) {
		this.jButton1 = jButton1;
	}   
	
	// ---------Methods used for inventory records and chits
	public void addToInventory(String theName, String theDetails){
		((DefaultTableModel) getjTable3().getModel()).addRow(new Object[]{theName,theDetails,"Active"});
	}
	
	public void addToChits(String theName, String theDetails){
		((DefaultTableModel) getjTable2().getModel()).addRow(new Object[]{theName,theDetails});
	}
	
	public void removeFromInvenotry(){
		if(getjTable3().getSelectedRow()==-1){
			return;
		}
		((DefaultTableModel) getjTable3().getModel()).removeRow(getjTable3().getSelectedRow());
	}
	
	public void addToRecord(String theTurn, String theMon, String theDay, String theColor, String thePhases, String theAction, String theKills){
		((DefaultTableModel) getjTable1().getModel()).addRow(new Object[]{theTurn,theMon,theDay,theColor,thePhases,theAction,theKills});
	}
	
	private JTable getjTable1() {
		return jTable2;
	}

	public void removeFromRecord(){
		if(getjTable1().getSelectedRow()==-1){
			return;
		}
		((DefaultTableModel) getjTable1().getModel()).removeRow(getjTable1().getSelectedRow());
	}
	
	public void removeFromChits(){
		if(getjTable2().getSelectedRow()==-1){
			return;
		}
		((DefaultTableModel) getjTable2().getModel()).removeRow(getjTable2().getSelectedRow());
	}
	
	public void changeItemStatus(String theStatus){
		((DefaultTableModel) getjTable3().getModel()).setValueAt(theStatus, getjTable2().getSelectedRow(), 2);
	}

	private JTable getjTable3() {
		return jTable3;
	}

	private JTable getjTable2() {
		return jTable2;
	}
	
	public void massSetButtonState (boolean state) {
		sendTurnButton.setEnabled(state);
		cancelActionButton.setEnabled(state);
		hideButton.setEnabled(state);
		moveButton.setEnabled(state);
		searchButton.setEnabled(state);
		restButton.setEnabled(state);
		tradeButton.setEnabled(state);
	}
}
