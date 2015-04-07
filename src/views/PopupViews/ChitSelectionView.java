package views.PopupViews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JDialog;

import models.characterModels.PlayerBase;
import models.chitModels.ActionChit;
import models.chitModels.ChitType;
import views.MainViews.GameView;

public class ChitSelectionView extends JDialog {

	private ChitType displayTable;
	private PlayerBase thePlayer;
	private Vector<ActionChit> aList;
	private static final long serialVersionUID = 1459520823075758208L;
	
	public ChitSelectionView(GameView theParent, PlayerBase p, ChitType c) {
    	super(theParent,true);
    	thePlayer = p;
    	displayTable = c;
    	aList = getDisplayChits();

		// Initialize All Components And Place The Dialog In The Window
		initComponents();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private Vector<ActionChit> getDisplayChits () {
		Vector<ActionChit> returnVal = new Vector<>();
		switch (displayTable) {
		case FIGHT_CHIT:
			returnVal.addAll(thePlayer.getFightChits());
			break;
		case MOVE_CHIT:
			returnVal.addAll(thePlayer.getMovementChits());
			break;
		default:
			break;
		}
		return returnVal;
	}
                        
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(aList));

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
				if (displayTable == ChitType.MOVE_CHIT) {
					thePlayer.setCurrentMovementChit(aList.get(jComboBox1.getSelectedIndex()));
				} else {
					thePlayer.setCurrentFightChit(aList.get(jComboBox1.getSelectedIndex()));
				}
				dispose();
			}
		});
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    // End of variables declaration                   
}

