package views.PopupViews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import models.characterModels.PlayerBase;
import models.chitModels.ActionChit;
import models.chitModels.ChitType;
import views.CombatViews.CombatView;
import views.MainViews.GameView;

public class ChitSelectionView extends JDialog {

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    
	private ChitType displayTable;
	private PlayerBase thePlayer;
	private Vector<ActionChit> aList;
	private static final long serialVersionUID = 1459520823075758208L;
	
	public ChitSelectionView(PlayerBase p, ChitType c) {
    	super(new JFrame(), true);
    	thePlayer = p;
    	displayTable = c;
    	aList = getDisplayChits();

		// Initialize All Components And Place The Dialog In The Window
		initComponents();
		setLocationRelativeTo(null);
		setTitle("Select A Chit");
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
    

    // Add In The Listeners That We Need For This Window
    private void addListeners() {
    	jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// If We Pass The 2 Star Check, Then Continue Going
				if (aList.get(jComboBox1.getSelectedIndex()).getStars() + thePlayer.getCurrentStarAmount() <= 2) {
					// Set The Data That We Need As We Have Passed The Check
					if (displayTable == ChitType.MOVE_CHIT) {
						
						// If We Can use This Chit In Combat Then Set It, Else Let Them Know
						if (aList.get(jComboBox1.getSelectedIndex()).getCapacity().getWeightValue() 
									  >= thePlayer.getWeapon().getWeaponDamage().getWeightValue()) {
							thePlayer.setCurrentMovementChit(aList.get(jComboBox1.getSelectedIndex()));
							dispose();
						} else {
							JOptionPane.showMessageDialog(new JTextArea(), "Fight Chit Weight Is Less Then Weapon Weight, Please Select Another");
						}
					} else {
						thePlayer.setCurrentFightChit(aList.get(jComboBox1.getSelectedIndex()));
						dispose();
					}
				} else {
					JOptionPane.showMessageDialog(new JTextArea(), "Chit Exceeds 2* Limit, Please Select Another");
				}
			}
		});
    }
	                
}

