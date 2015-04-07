package views.PopupViews;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JDialog;

import models.characterModels.PlayerBase;
import models.chitModels.ActionChit;
import views.MainViews.GameView;

@SuppressWarnings("rawtypes")
public class RestView extends JDialog {
	
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
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 8983521157590447209L;
	
	GameView parent;
	String name;
	PlayerBase thePlayer;
	int amountNeeded, initAmount;
	ArrayList<ActionChit> aList, iList, wList;
	
	public RestView(GameView gameView,PlayerBase player, int amount) {
		super(gameView,true);
		parent = gameView;
		thePlayer = player;
		System.out.println("have added player");
		System.out.println("have active: " + thePlayer.getAllActive().size());
		amountNeeded = amount;
		initAmount = 2;
		aList = thePlayer.getActive();
		iList = thePlayer.getInactive();
		wList = thePlayer.getWounded();
		
        initComponents();
        update();
        setName("Rest Window");
        setVisible(true);
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
        
    
        activeScrollPane.setViewportView(activeList);

        inactiveActive.setText("Move Left");

        activeInactive.setText("Move Right");

        inactiveScrollPane.setViewportView(inactiveList);

        woundedInactive.setText("Move Left");
        inactiveWounded.setText("Move Right");

        woundedScrollPane.setViewportView(woundedList);
        
        
        inactiveLabel.setText("Fatigued");

        woundedLabel.setText("Wounded");
        
        String amountS = Integer.toString(amountNeeded);

        neededLabel.setText("Remaing Rests Left: ");

        currStarsLabel.setText("" + initAmount);

        confirmButton.setText("Confirm");

        cancelButton.setText("Cancel");
        
        addListeners();

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
    
    // Update The Lists Will The Needed Possibles
    private void update(){
        neededLabel.setText("Remaing Rests Left: ");
        currStarsLabel.setText("" + initAmount);
        
        // Populate The List
        aList = thePlayer.getActive();
		iList = thePlayer.getInactive();
		wList = thePlayer.getWounded();
        activeList.setListData(convertListToVector(thePlayer.getActive()));
        inactiveList.setListData(convertListToVector(thePlayer.getInactive()));
        woundedList.setListData(convertListToVector(thePlayer.getWounded()));
    }
    
    private Vector<ActionChit> convertListToVector (ArrayList <ActionChit> a) {
    	Vector<ActionChit> returnVal = new Vector<>();
    	returnVal.addAll(a);
    	return returnVal;
    }
    
    // Add In The Listeners To This View
    private void addListeners() {
    	confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//set the lists
				return;
//				dispose();
			}
		});
    	cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
    	inactiveActive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("inactive->active");
				
				// If We Still Have Movments Available
				if (initAmount > 0) {
					if (iList.size() == 0)
						return;

					int selected = inactiveList.getSelectedIndex();
					if (selected == -1) {
						return;
					}
					iList.get(selected).restChit();
					initAmount--;
					update();
				}
			}
		});
    	activeInactive.addActionListener(new ActionListener() {
			@Override
			//working on
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("active-->inactive");
				if(aList.size() == 0)
					return;
				int selected = activeList.getSelectedIndex();
				if(selected == -1){
					return;
				}
			
				aList.get(selected).woundChit();
				initAmount++;
				update();
			}
		});
    	woundedInactive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("wounded->inactive");
				if (initAmount > 0) {
					if (wList.size() == 0)
						return;

					int selected = woundedList.getSelectedIndex();
					if (selected == -1) {
						return;
					}
					wList.get(selected).restChit();
					initAmount--;
					update();
				}
			}
		});
    	inactiveWounded.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("inactive->wounded");
				if(iList.size() == 0)
					return;
				
				int selected = inactiveList.getSelectedIndex();
				if(selected == -1){
					return;
				}
				iList.get(selected).woundChit();
				initAmount++;
				update();
			}
		});
    }

    // End of variables declaration                   
}
