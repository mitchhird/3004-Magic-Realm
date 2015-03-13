package views;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.Defences;
import models.chitModels.WeaponChit;
import controller.CombatPVPHandler;

public class CombatView extends FrameBase {

    /**
	 * 
	 */
	private static final long serialVersionUID = -611514956127664758L;
    // Variables declaration                     
    private javax.swing.JButton chargeButton;
    private javax.swing.JButton dodgeButton;
    private javax.swing.JButton duckButton;
    private javax.swing.JButton runButton;
    private javax.swing.JButton alertButton;
    private javax.swing.JButton activateButton;
    private javax.swing.JButton abandonButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton endButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton thrustButton;
    private javax.swing.JButton swingButton;
    private javax.swing.JButton smashButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private JLabel targetPlayerLabel;
    private JLabel weaponLabel;
    private JLabel weaponHarmLabel;
    private javax.swing.JLabel smashShield;
    private javax.swing.JLabel swingShield;
    private javax.swing.JLabel thrustShield;
    private javax.swing.JLabel suitOfArmor;
    private javax.swing.JLabel breastPlate;
    private javax.swing.JLabel helmet;
    private javax.swing.JTextArea textArea;  
    private JScrollPane textContainer;
    private JComboBox<PlayerBase> playersCanAttack;
    
    // Setup The Combat Handler For The View
    private CombatPVPHandler combatHandler;
    private ArrayList<PlayerBase> combatingPlayers;
    private ArrayList<PlayerBase> targetPlayers;
    private Toolkit tk = Toolkit.getDefaultToolkit();
    
    // Constructor For This
    public CombatView(ArrayList<PlayerBase> combatingPlayers) {
    	this.combatingPlayers = combatingPlayers;
    	combatHandler = new CombatPVPHandler(combatingPlayers, this);

    	initComponents();
        initWindow();
        addAllComponents();
        update();
    }
    
    // Initialize The Window
    public void initWindow () {
		setSize(760,300);
		setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		setLayout(layout);
		setName ("Combat Screen");
		setVisible(true);
    }
    
    // Adds All Of The Components To The Window
    public void addAllComponents () {
    
    	// First Is The Text Area
    	addToFrame(this, textContainer, layout, 0, 0, 5, 6);
    	    	
    	// Add In All Of The Attack Buttons
    	addToFrame(this, jLabel2, layout, 5, 0, 1, 1);
    	addToFrame(this, smashButton, layout, 6, 0, 1, 1);
    	addToFrame(this, thrustButton, layout, 7, 0, 1, 1);
    	addToFrame(this, swingButton, layout, 8, 0, 1, 1);
    	
    	//Add In All Of The Defence Buttons
    	addToFrame(this, jLabel1, layout, 5, 1, 1, 1);
    	addToFrame(this, suitOfArmor, layout, 6, 1, 1, 1);
    	addToFrame(this, helmet, layout, 7, 1, 1, 1);
    	addToFrame(this, breastPlate, layout, 8, 1, 1, 1);
    	addToFrame(this, dodgeButton, layout, 6, 2, 1, 1);
    	addToFrame(this, duckButton, layout, 7, 2, 1, 1);
    	addToFrame(this, chargeButton, layout, 8, 2, 1, 1);

    	// Weapon Information
    	addToFrame(this, weaponLabel, layout, 5, 3, 1, 1);
    	addToFrame(this, weaponHarmLabel, layout, 6, 3, 1, 1);
    	
    	// Attackable Players Window
    	addToFrame(this, targetPlayerLabel, layout, 5, 4, 1, 1);
    	addToFrame(this, playersCanAttack, layout, 6, 4, 3, 1);
    	
    	// More Buttons
    	addToFrame (this, nextButton, layout, 5, 5, 2, 1);
    	addToFrame (this, runButton, layout, 7, 5, 2, 1);
    }
                     
    private void initComponents() {

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
        alertButton = new javax.swing.JButton();
        activateButton = new javax.swing.JButton();
        abandonButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        endButton = new javax.swing.JButton();
        
        // Labels
        smashShield = new javax.swing.JLabel();
        swingShield = new javax.swing.JLabel();
        thrustShield = new javax.swing.JLabel();
        suitOfArmor = new javax.swing.JLabel();
        breastPlate = new javax.swing.JLabel();
        helmet = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        targetPlayerLabel = new JLabel("Target:");
        weaponLabel = new JLabel();
        weaponHarmLabel = new JLabel();
        playersCanAttack = new JComboBox<>();
        
        // Setup The Listeners For This View
        setupListeners();
        
        // Setup The Scroll Pane For The Text Field
        textArea.setColumns(20);
        textArea.setRows(5);
        textContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

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
        alertButton.setText("Alert Wepon/Chit");
        activateButton.setText("Activate/Inactivate");
        abandonButton.setText("Abandon Belongings");
        nextButton.setText("Move To Next Attacker");
        endButton.setText("End");
        smashShield.setText("Smash Shield");
        swingShield.setText("Swing Shield");
        thrustShield.setText("Thrust Shield");
        suitOfArmor.setText("Suit of Armor");
        breastPlate.setText("Breastplate");
        helmet.setText("Helmet");
        resetButton.setText("Reset");

        nextButton.setEnabled(false);
        dodgeButton.setEnabled(false);
        duckButton.setEnabled(false);
        chargeButton.setEnabled(false);
    }

    // Set up all the action listeners
	private void setupListeners() {
		thrustButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                combatHandler.setCurrentAttack(Attacks.THRUST);
                dodgeButton.setEnabled(true);
                duckButton.setEnabled(true);
                chargeButton.setEnabled(true);
                println("Setting Current Attack To " + Attacks.THRUST);
            }
        });
        swingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                combatHandler.setCurrentAttack(Attacks.SWING);
                dodgeButton.setEnabled(true);
                duckButton.setEnabled(true);
                chargeButton.setEnabled(true);
                println("Setting Current Attack To " + Attacks.SWING);
            }
        });
        smashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                combatHandler.setCurrentAttack(Attacks.SMASH);
                dodgeButton.setEnabled(true);
                duckButton.setEnabled(true);
                chargeButton.setEnabled(true);
                println("Setting Current Attack To " + Attacks.SMASH);
            }
        });
        dodgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	combatHandler.setCurrentDefence(Defences.DODGE);
                println("Setting Current Defence To " + Defences.DODGE);
                nextButton.setEnabled(true);
                System.out.println("dodge pressed");
            }
        });
        duckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	combatHandler.setCurrentDefence(Defences.DUCK);
                println("Setting Current Defence To " + Defences.DUCK);
                nextButton.setEnabled(true);
            	System.out.println("duck pressed");
            }
        });
        chargeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	combatHandler.setCurrentDefence(Defences.CHARGE);
                println("Setting Current Defence To " + Defences.CHARGE);
                nextButton.setEnabled(true);
            	System.out.println("charge pressed");
            }
        });
        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("run pressed");
                dispose();
            }
        });
        
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("next pressed");
                combatHandler.setCurrentDefender(targetPlayers.get(playersCanAttack.getSelectedIndex()));
                
                // Display For Display Purposes
                println ("Attack Submitted:");
                println ("  --- Attacker: " + combatHandler.getCurrentAttacker().getName());
                println ("  --- Defender: " + combatHandler.getCurrentDefender().getName());
                println ("");
                
                // Go To The Next Attack
                combatHandler.setNextAttacker();
                nextButton.setEnabled(false);
                dodgeButton.setEnabled(false);
                duckButton.setEnabled(false);
                chargeButton.setEnabled(false);
                update();
            }
        });
        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("end pressed");
            }
        });
        alertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("alert pressed");
            }
        });
        activateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("activate pressed");
            }
        });
        abandonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("abandon pressed");
            }
        });
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("reset pressed");
            }
        });
	}
    
    // Updates This Window With Need Material
    private void update () {
    	// Get The Combobox ready
    	targetPlayers = getPlayersToAttack();
        PlayerBase[] attackables = new PlayerBase[targetPlayers.size()];
        attackables = targetPlayers.toArray(attackables);
        DefaultComboBoxModel<PlayerBase> model = new DefaultComboBoxModel<>( attackables );
        playersCanAttack.setModel(model);
        
        // Set The Next Player To Disabled
        nextButton.setText((combatHandler.getReadyPlayerNum() == combatingPlayers.size() - 1) 
        					? "Start Combat" : "Move To Next Attacker");
        
        // Player Weapon Display
        WeaponChit equipWeapon = combatHandler.getCurrentAttacker().getWeapon();
        weaponLabel.setText("Equipped Weapon: " + equipWeapon.getWeaponName());
        weaponHarmLabel.setText("Harm Level: " + equipWeapon.getWeaponDamage());
    }
    
    // Get All Of The Players To Attack
    private ArrayList<PlayerBase> getPlayersToAttack () {
    	ArrayList<PlayerBase> returnVal = new ArrayList<>();
    	for (PlayerBase p: combatingPlayers) {
    		if (p != combatHandler.getCurrentAttacker()) {
    			returnVal.add(p);
    		}
    	}
    	return returnVal;
    }
    
    //Used to set the armor labels
    public void setArmor(String suit, String breast, String newHelmet){
    	suitOfArmor.setText(suit);
    	breastPlate.setText(breast);
    	helmet.setText(newHelmet);
    }
    
    //used to print a line to the text area
    public void println(String theLine){
    	textArea.append(theLine + "\n");
    }
}
