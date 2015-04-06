package views.CombatViews;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import models.chitModels.WeaponChit;
import views.DialogBase;
import views.FrameBase;
import views.MainViews.GameView;

/**
 * A Base Class For The Combat Window
 * @author Mitchell
 *
 */
public class CombatViewBlockingBase extends DialogBase {

    protected javax.swing.JButton chargeButton;
    protected javax.swing.JButton dodgeButton;
    protected javax.swing.JButton duckButton;
    protected javax.swing.JButton runButton;
    protected javax.swing.JButton thrustButton;
    protected javax.swing.JButton swingButton;
    protected javax.swing.JButton smashButton;
    protected javax.swing.JButton beginCombatButton;    
    protected javax.swing.JButton smashShield;
    protected javax.swing.JButton swingShield;
    protected javax.swing.JButton thrustShield;
    protected javax.swing.JButton alertWeaponButton;
    
    // Labels
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel movements;
    protected JLabel weaponLabel;
    protected JLabel weaponHarmLabel;
    protected JLabel weaponStateLabel;

    // Text Area
    protected javax.swing.JTextArea textArea;  
    protected JScrollPane textContainer;
    
    private Toolkit tk = Toolkit.getDefaultToolkit();
    
    public CombatViewBlockingBase (GameView parent, String displayName, boolean modal) {
    	super(parent, displayName, modal);
    }
    
    protected void addAllComponents () {
    	    	
    	// Add In All Of The Attack Buttons
    	addToFrame(this, jLabel2, layout, 5, 0, 1, 1);
    	addToFrame(this, smashButton, layout, 6, 0, 1, 1);
    	addToFrame(this, thrustButton, layout, 7, 0, 1, 1);
    	addToFrame(this, swingButton, layout, 8, 0, 1, 1);
    	
    	//Add In All Of The Defence Buttons
    	addToFrame(this, jLabel1, layout, 5, 1, 1, 1);
    	addToFrame(this, smashShield, layout, 6, 1, 1, 1);
    	addToFrame(this, thrustShield, layout, 7, 1, 1, 1);
    	addToFrame(this, swingShield, layout, 8, 1, 1, 1);
    	
    	addToFrame(this, movements, layout, 5, 2, 1, 1);
    	addToFrame(this, dodgeButton, layout, 6, 2, 1, 1);
    	addToFrame(this, duckButton, layout, 7, 2, 1, 1);
    	addToFrame(this, chargeButton, layout, 8, 2, 1, 1);

    	// Weapon Information
    	addToFrame(this, weaponLabel, layout, 5, 3, 1, 1);
    	addToFrame(this, weaponHarmLabel, layout, 6, 3, 1, 1);
    	addToFrame(this, weaponStateLabel, layout, 7, 3, 1, 1);
    	addToFrame(this, alertWeaponButton, layout, 8, 3, 1, 1);
    	
    	// More Buttons
    	addToFrame(this, beginCombatButton, layout, 6, 6, 1, 1);
    	addToFrame (this, runButton, layout, 7, 6, 2, 1);
    }
    
    protected void initComponents () {
        textArea = new javax.swing.JTextArea();
        textContainer = new JScrollPane(textArea);
        
        // Buttons
        thrustButton = new javax.swing.JButton();
        swingButton = new javax.swing.JButton();
        smashButton = new javax.swing.JButton();
        chargeButton = new javax.swing.JButton();
        dodgeButton = new javax.swing.JButton();
        duckButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        runButton = new javax.swing.JButton();

        alertWeaponButton = new JButton("Alert Weapon");
        beginCombatButton = new javax.swing.JButton("Start Combat");
        smashShield = new javax.swing.JButton("Smash");
        swingShield = new javax.swing.JButton("Swing");
        thrustShield = new javax.swing.JButton("Thrust");
        
        // Labels
        weaponStateLabel = new JLabel();
        movements = new JLabel("Movements:");
        weaponLabel = new JLabel();
        weaponHarmLabel = new JLabel();

        // Set the text of all the components
        thrustButton.setText("Thrust");
        swingButton.setText("Swing");
        smashButton.setText("Smash");
        chargeButton.setText("Charge");
        dodgeButton.setText("Dodge");
        duckButton.setText("Duck");
        jLabel1.setText("Defences:");
        jLabel2.setText("Attacks:");
        runButton.setText("Run");
        smashShield.setText("Smash Shield");
        swingShield.setText("Swing Shield");
        thrustShield.setText("Thrust Shield");

        dodgeButton.setEnabled(false);
        duckButton.setEnabled(false);
        chargeButton.setEnabled(false);
        
        // Setup The Scroll Pane For The Text Field
        textArea.setColumns(30);
        textArea.setRows(5);
        textContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }
    
    // Initialize The Window
    public void initWindow () {
		setSize(900,350);
		setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		setLayout(layout);
		setTitle("Combat Screen");
    }
    
	// Enables The Defense Buttons
	protected void enableDefenses() {
		dodgeButton.setEnabled(true);
        duckButton.setEnabled(true);
        chargeButton.setEnabled(true);
	} 
	
    // Used to print a line to the text area
    public void println(String theLine){
    	textArea.append(theLine + "\n");
    }
}
