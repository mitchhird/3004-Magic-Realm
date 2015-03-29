package views.MainViews;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.CharacterClass;

	public class PlayerListView extends javax.swing.JPanel {

		//Variable declarations
		private javax.swing.JButton addPlayerButton;
	    private javax.swing.JButton removePlayerButton;
	    private javax.swing.JButton startGameButton;
	    private javax.swing.JScrollPane jScrollPane3;
	    private javax.swing.JTable jTable2;      
	    
	    private GameView parent;
	    private ArrayList <PlayerBase> playersConnected;
	    
		private static final long serialVersionUID = 1L;
		
		//Constructor for this view
	    public PlayerListView(GameView parent) {
	    	this.parent = parent; 
	    	playersConnected = new ArrayList<>();
	        initComponents();
	    }
                
	    //Initializes the components in this view
	    private void initComponents() {

	        setjButton1(new javax.swing.JButton());
	        setjButton2(new javax.swing.JButton());
	        startGameButton = new javax.swing.JButton();
	        jScrollPane3 = new javax.swing.JScrollPane();
	        setjTable2(new javax.swing.JTable());

	        getAddPlayerButton().setText("Add Player");
	        getjButton2().setText("Remove Player");
	        startGameButton.setText("Start Game");
	        
	        //Table declaration
	        getjTable2().setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Class", "Player", "Status", "IP Address"
	            }
	        ) {
	            /**
				 * 
				 */
				private static final long serialVersionUID = -7438589133658495131L;
				boolean[] canEdit = new boolean [] {
	                false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
			getjTable2().setSelectionMode(1);
			
			//Action listeners
			getjTable2().addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		  JTable target = (JTable)e.getSource();
	        	      int row = target.getSelectedRow();

	        	      String test = (String) jTable2.getValueAt(row, 1);
	        	      CharacterClass characterClass = CharacterClass.valueOf((String)jTable2.getValueAt(row, 0));
	        	      parent.updatePlayer(test, characterClass);
	        	}
			});

	        jScrollPane3.setViewportView(getjTable2());

	        //Layout for this view
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(getjButton2(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(getAddPlayerButton(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(startGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(getAddPlayerButton())
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(getjButton2())
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(startGameButton)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
	        );
	        
	        // Finally Update The Buttons With The Table Value
	        update();
	    }       
	    
	    // Sets The Current Player To Active While The Others Are Waiting
	    public void updateTable () {
	    	PlayerBase currentPlayer = parent.getCurrentPlayer();
	    	
	    	for (int i = 0; i < jTable2.getRowCount(); i++) {
	    		String playerClass = (String)jTable2.getValueAt(i, 0);
	    		String playerName = (String)jTable2.getValueAt(i, 1);
	    		
	    		// If The Player Is The Current Player Then Set Them To Playing
	    		if (currentPlayer.getName().equals(playerName) && currentPlayer.getPlayerClass().name().equals(playerClass))
	    			jTable2.setValueAt("Playing", i, 2);
	    		else
	    			jTable2.setValueAt("Waiting", i, 2);
	    	}
	    }
   
	    // Updates The Buttons Enability
	    public void update (){
	    	boolean isClient = parent.getClientReaderThread() != null;
	    	startGameButton.setEnabled((jTable2.getRowCount() > 0) && !isClient);
	    }
	    
	    
	    /*************************************** Getters And Setters ***************************************/
	    public javax.swing.JButton getjButton2() {
			return removePlayerButton;
		}

		public void setjButton2(javax.swing.JButton jButton2) {
			this.removePlayerButton = jButton2;
		}

		public javax.swing.JButton getAddPlayerButton() {
			return addPlayerButton;
		}
		
		public void setjButton1(javax.swing.JButton jButton1) {
			this.addPlayerButton = jButton1;
		}
		
		public javax.swing.JButton getStartGameButton() {
			return startGameButton;
		}

		public void setStartGameButton(javax.swing.JButton startGameButton) {
			this.startGameButton = startGameButton;
		}

		public void addPlayer(PlayerBase newPlayer){
			playersConnected.add(newPlayer);
			((DefaultTableModel) getjTable2().getModel()).addRow(new Object[]{newPlayer.getPlayerClass().name(),
																			  newPlayer.getName(),"Waiting", newPlayer.getPlayerIP()});
			update();
		}
		
		public void removePlayer(){
			if(getjTable2().getSelectedRow()==-1){
				return;
			}
			((DefaultTableModel) getjTable2().getModel()).removeRow(getjTable2().getSelectedRow());
		}

		public void removePlayer (String playerName) {
			DefaultTableModel tableModel = (DefaultTableModel) getjTable2().getModel();
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				if (tableModel.getValueAt(i, 1).equals(playerName)) {
					tableModel.removeRow(i);
				}
			}
		}
		
		public javax.swing.JTable getjTable2() {
			return jTable2;
		}

		public void setjTable2(javax.swing.JTable jTable2) {
			this.jTable2 = jTable2;
		}         
	}
