package views.PopupViews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;

import models.characterModels.PlayerBase;
import models.chitModels.ActionChit;
import views.MainViews.GameView;

@SuppressWarnings("rawtypes")
public class ActionChitView extends JDialog {

  
    /**
	 * 
	 */
	private static final long serialVersionUID = 8983521157590447209L;
	
	GameView parent;
	String name;
	PlayerBase thePlayer;
	int amountNeeded, initAmount;
	ArrayList<ActionChit> aList, iList, wList;

    /*
     * public ArrayList<ActionChit> getAllActive(){
	}
	
	public ArrayList<ActionChit> getActiveThisRound(){
	}
	
	public ArrayList<ActionChit> getUsedThisRound(){
	}
	
	public ArrayList<ActionChit> getInactive(){
	}
	
	public ArrayList<ActionChit> getWounded(){
	}
	
	public void setActive(ArrayList<ActionChit> update){
	}
	
	public void setInactive(ArrayList<ActionChit> update){
	}
	
	public void setWounded(ArrayList<ActionChit> update){
	}
     */
	
	public ActionChitView(GameView gameView,PlayerBase player, int amount) {
		super(gameView,true);
		parent = gameView;
		thePlayer = player;
		System.out.println("have added player");
		System.out.println("have active: " + thePlayer.getAllActive().size());
		amountNeeded = amount;
		initAmount = 0;
		aList = new ArrayList<ActionChit>();
		if(thePlayer.getInactive().size() != 0)
			aList.addAll(thePlayer.getActiveThisRound());
		iList = new ArrayList<ActionChit>();
		if(thePlayer.getInactive().size() != 0)
			iList.addAll(thePlayer.getInactive());
		wList = new ArrayList<ActionChit>();
		if(thePlayer.getInactive().size() != 0)
			wList.addAll(thePlayer.getWounded());
        initComponents();
        setVisible(true);
    }
	
	private String[] makeArrayAction(ArrayList f){
    	String[] rStrings = new String[f.size()];
    	for(int i = 0; i < f.size(); ++i)
    		rStrings[i] = "" + f.get(i);
    	return rStrings;
    }
    
    @SuppressWarnings({ "unchecked"})
    private void initComponents() {

        activeLabel = new javax.swing.JLabel();
        activeScrollPane = new javax.swing.JScrollPane();
        activeList = new javax.swing.JList();
        inactiveActive = new javax.swing.JButton();
        activeInactive = new javax.swing.JButton();
        inactiveScrollPane = new javax.swing.JScrollPane();
        inactiveList = new javax.swing.JList();
        woundedInactive = new javax.swing.JButton();
        inactiveWounded = new javax.swing.JButton();
        woundedScrollPane = new javax.swing.JScrollPane();
        woundedList = new javax.swing.JList();
        inactiveLabel = new javax.swing.JLabel();
        woundedLabel = new javax.swing.JLabel();
        neededLabel = new javax.swing.JLabel();
        currStarsLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        activeLabel.setText("Active");
        
        activeList.setModel(new javax.swing.AbstractListModel() {
        	//have to some how put aList into a string or have the objects do something
        	//so that they can be added to the scroll pane
        	//maybe a toString() for the chits
            String[] strings = makeArrayAction(aList);
            public int getSize() { return strings.length ; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        activeScrollPane.setViewportView(activeList);

        inactiveActive.setText("Move Left");

        activeInactive.setText("Move Right");

        inactiveList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Inactive" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        inactiveScrollPane.setViewportView(inactiveList);

        woundedInactive.setText("Move Left");
        inactiveWounded.setText("Move Right");

        woundedList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Wounded" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        woundedScrollPane.setViewportView(woundedList);

        inactiveLabel.setText("Inactive");

        woundedLabel.setText("Wounded");
        
        String amountS = Integer.toString(amountNeeded);

        neededLabel.setText("Stars Needed " + amountS + ":");

        currStarsLabel.setText("0");

        confirmButton.setText("Confirm");

        cancelButton.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(activeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(activeInactive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(inactiveActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(activeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(inactiveScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(inactiveWounded, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(woundedInactive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(inactiveLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(woundedLabel)
                                    .addComponent(woundedScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(neededLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currStarsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirmButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activeLabel)
                    .addComponent(inactiveLabel)
                    .addComponent(woundedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inactiveActive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activeInactive))
                    .addComponent(inactiveScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(woundedInactive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inactiveWounded))
                    .addComponent(woundedScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(neededLabel)
                    .addComponent(currStarsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                        

    // Variables declaration - do not modify                     
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton inactiveActive;
    private javax.swing.JButton activeInactive;
    private javax.swing.JButton woundedInactive;
    private javax.swing.JButton inactiveWounded;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel activeLabel;
    private javax.swing.JLabel inactiveLabel;
    private javax.swing.JLabel woundedLabel;
    private javax.swing.JLabel neededLabel;
    private javax.swing.JLabel currStarsLabel;
    private javax.swing.JList activeList;
    private javax.swing.JList inactiveList;
    private javax.swing.JList woundedList;
    private javax.swing.JScrollPane activeScrollPane;
    private javax.swing.JScrollPane inactiveScrollPane;
    private javax.swing.JScrollPane woundedScrollPane;
    // End of variables declaration                   
}
