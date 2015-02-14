package views;

import javax.swing.table.DefaultTableModel;

	public class playerListView extends javax.swing.JPanel {

		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton startGameButton;
	    private javax.swing.JScrollPane jScrollPane3;
	    private javax.swing.JTable jTable2;      
	    
		private static final long serialVersionUID = 1L;
	    public playerListView() {
	        initComponents();
	    }
                   
	    private void initComponents() {

	        setjButton1(new javax.swing.JButton());
	        setjButton2(new javax.swing.JButton());
	        startGameButton = new javax.swing.JButton();
	        jScrollPane3 = new javax.swing.JScrollPane();
	        setjTable2(new javax.swing.JTable());

	        getjButton1().setText("Add Player");

	        getjButton2().setText("Remove Player");

	        startGameButton.setText("Start Game");
	        getjTable2().setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Class", "Player", "Status"
	            }
	        ) {
	            /**
				 * 
				 */
				private static final long serialVersionUID = -7438589133658495131L;
				boolean[] canEdit = new boolean [] {
	                false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
			getjTable2().setSelectionMode(1);

	        jScrollPane3.setViewportView(getjTable2());

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(getjButton2(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(getjButton1(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(startGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(getjButton1())
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(getjButton2())
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(startGameButton)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
	        );
	    }                                                      
   
	    public javax.swing.JButton getjButton2() {
			return jButton2;
		}

		public void setjButton2(javax.swing.JButton jButton2) {
			this.jButton2 = jButton2;
		}

		public javax.swing.JButton getjButton1() {
			return jButton1;
		}
		
		public void setjButton1(javax.swing.JButton jButton1) {
			this.jButton1 = jButton1;
		}
		
		public javax.swing.JButton getStartGameButton() {
			return startGameButton;
		}

		public void setStartGameButton(javax.swing.JButton startGameButton) {
			this.startGameButton = startGameButton;
		}

		public void addPlayer(String pName, String pClass){
			((DefaultTableModel) getjTable2().getModel()).addRow(new Object[]{pClass,pName,"Waiting"});
		}
		
		public void removePlayer(){
			if(getjTable2().getSelectedRow()==-1){
				return;
			}
			((DefaultTableModel) getjTable2().getModel()).removeRow(getjTable2().getSelectedRow());
		}

		public javax.swing.JTable getjTable2() {
			return jTable2;
		}

		public void setjTable2(javax.swing.JTable jTable2) {
			this.jTable2 = jTable2;
		}         
	}
