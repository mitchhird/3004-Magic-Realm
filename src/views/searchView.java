package views;

public class searchView extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3566830746092036299L;
	
	public searchView() {
        initComponents();
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
