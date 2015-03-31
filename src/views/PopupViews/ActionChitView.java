package views.PopupViews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JTextField;

import models.characterModels.playerEnums.CharacterClass;
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
	CharacterClass theClass;
                   
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    
    private javax.swing.JLabel activeLabel;
    private javax.swing.JLabel inActiveLabel;
    private javax.swing.JLabel woundedLabel;
    
    private javax.swing.JList<ActionChit> activeList;//characterclass.getactiveChits
    private javax.swing.JList<ActionChit> inactiveList; //characterClass.getInactiveChits
    private javax.swing.JList<ActionChit> woundedList; //characterClass.getWoundedChits()
    
    private javax.swing.JButton activeToInactiveButton;// -1
    private javax.swing.JButton inactiveToActiveButton;// +1
    private javax.swing.JButton inactiveToWoundedButton;// -1
    private javax.swing.JButton woundedToInactiveButton;// +1
    
    //an uneditable textfeild that will have the current amount of fatigue stars moved
    //- being fatigued stars and + being rested stars
    private javax.swing.JLabel starAmountLabel; // will be the amount of stars needed to reach
    private javax.swing.JTextField starCounterTextField;
    
    //these will set the chits still in the jlists to an arraylist and then go
    //and apply them to the character and then close the program
    private javax.swing.JButton okButton;
    private javax.swing.JButton cancelButton;
    
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
	
	public ActionChitView(GameView gameView, String string, CharacterClass characterClass, int amount) {
		parent = gameView;
		name = string;
		theClass = characterClass;
		starAmountLabel = new javax.swing.JLabel();
		starAmountLabel.setText("Amount needed " + amount);
        initComponents();
    }
    
    @SuppressWarnings({ "unchecked"})
	private void initComponents() {

    	activeLabel = new javax.swing.JLabel();
    	inActiveLabel = new javax.swing.JLabel();
    	woundedLabel = new javax.swing.JLabel();
    	starCounterTextField = new javax.swing.JTextField();
    	activeToInactiveButton = new javax.swing.JButton();
    	inactiveToActiveButton = new javax.swing.JButton();
    	woundedToInactiveButton = new javax.swing.JButton();
    	inactiveToWoundedButton = new javax.swing.JButton();
    	okButton = new javax.swing.JButton();
    	cancelButton = new javax.swing.JButton();
    	activeList = new javax.swing.JList<ActionChit>();
    	inactiveList = new javax.swing.JList<ActionChit>();
    	woundedList = new javax.swing.JList<ActionChit>();
    	

    	activeToInactiveButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		//selected in active to inactive list
        	}
        });
    	inactiveToActiveButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		//selected in inactive to active list
        	}
        });
    	woundedToInactiveButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		//selected wounded to inactive list
        	}
        });
    	inactiveToWoundedButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		//selected inactive to wounded list
        	}
        });
    	okButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
//        		need to setup the characterclass arraylists
//        		follow up with the close window function
        		
//        		theClass.setActive(activeList);
//        		theClass.setInactive(inactiveList);
//        		theClass.setWounded(woundedList);
        		dispose();
        	}
        });
    	cancelButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
//        		just close the window function
        		dispose();
        	}
        });
    	
    	activeLabel.setText("Active");
    	inActiveLabel.setText("Inactive");
    	woundedLabel.setText("Wounded");
    	starCounterTextField.setText("0");
    	okButton.setText("OK");
    	cancelButton.setText("Cancel");
//    	actionList = theClass.getAllActive();
//    	inactiveList = theClass.getInActive();
//    	woundedList = theClass.getWounded();
    	
    	
    	
//    	--------
    	
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0","1", "2", "3", "4", "5" }));

        jLabel1.setText("Gold:");

        jLabel2.setText("Fame:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0","1", "2", "3", "4", "5" }));
        
        jLabel3.setText("Notoriety:");

        jLabel4.setText("Treasures:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0","1", "2", "3", "4", "5" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0","1", "2", "3", "4", "5" }));
        
        jButton1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		setVPs();
        	}
        });

        jButton1.setText("Set VPs");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();

    	setVisible(true);
    }                     

    private void setVPs() {
    	if(Integer.parseInt((String) jComboBox1.getSelectedItem())+Integer.parseInt((String) jComboBox2.getSelectedItem())+Integer.parseInt((String) jComboBox3.getSelectedItem())+Integer.parseInt((String) jComboBox4.getSelectedItem())==5){
    		ArrayList<Integer> points = new ArrayList<Integer>();
    		points.add(Integer.parseInt((String) jComboBox1.getSelectedItem()));
	    	points.add(Integer.parseInt((String) jComboBox2.getSelectedItem()));
	    	points.add(Integer.parseInt((String) jComboBox3.getSelectedItem()));
	    	points.add(Integer.parseInt((String) jComboBox4.getSelectedItem()));
    		parent.addPlayer(name,theClass,points);
	    	dispose();
    	}
	}                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VPSelecterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPSelecterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPSelecterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPSelecterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }                 
}
