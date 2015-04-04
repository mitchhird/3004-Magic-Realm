package views.PopupViews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;

import models.characterModels.PlayerBase;
import models.chitModels.ActionChit;
import views.MainViews.GameView;

public class ChitSelectionView extends JDialog {

	private PlayerBase thePlayer;
	private ArrayList<ActionChit> aList;
	private static final long serialVersionUID = 1459520823075758208L;
	public ChitSelectionView(GameView theParent, PlayerBase p) {
    	super(theParent,true);
    	thePlayer = p;
    	aList = thePlayer.getActiveThisRound();
		initComponents();
		setVisible(true);
    }
	
	private String[] makeArrayAction(ArrayList<ActionChit> f){
    	String[] rStrings = new String[f.size()];
    	System.out.println(f.size());
    	int k = 0;
    	for(int i = 0; i < f.size(); ++i){
    		if(f.get(i).isFight())
    			continue;
    		rStrings[k] = f.get(i).toString();
    		++k;
    	}
    	for(int i = 0; i < f.size(); ++i)
    		System.out.println(rStrings[i]);
    	return rStrings;
    }
                        
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(makeArrayAction(thePlayer.getActiveThisRound())));

        jButton1.setText("Select");
        
        addListeners();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        
        pack();
    }
    

    private void addListeners() {
    	jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//set the lists
				thePlayer.usedRoundChit(aList.get(jComboBox1.getSelectedIndex()));
				dispose();
			}
		});
    }

    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    // End of variables declaration                   
}

