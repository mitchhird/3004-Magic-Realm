package views;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Attacks;
import controller.CombatPVPHandler;

public class CombatView extends FrameBase {

    /**
	 * 
	 */
	private static final long serialVersionUID = -611514956127664758L;
    // Variables declaration - do not modify                     
    private javax.swing.JButton enemy1Button;
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
    private javax.swing.JButton enemy2Button;
    private javax.swing.JButton enemy3Button;
    private javax.swing.JButton enemy4Button;
    private javax.swing.JButton enemy5Button;
    private javax.swing.JButton enemy6Button;
    private javax.swing.JButton thrustButton;
    private javax.swing.JButton swingButton;
    private javax.swing.JButton smashButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private JLabel targetPlayerLabel;
    private javax.swing.JLabel smashShield;
    private javax.swing.JLabel swindShield;
    private javax.swing.JLabel thrustShield;
    private javax.swing.JLabel suitOfArmor;
    private javax.swing.JLabel breastPlate;
    private javax.swing.JLabel helmet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;  
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
    
    // Adds All Of The Compoents To The Window
    public void addAllComponents () {
    
    	// First Is The Text Area
    	addToFrame(this, textArea, layout, 0, 0, 1, 4);
    	    	
    	// Add In All Of The Buttons
    	addToFrame(this, jLabel2, layout, 1, 0, 1, 1);
    	addToFrame(this, smashButton, layout, 2, 0, 1, 1);
    	addToFrame(this, thrustButton, layout, 3, 0, 1, 1);
    	addToFrame(this, swingButton, layout, 4, 0, 1, 1);
    	
    	// Attackable Players Window
    	addToFrame(this, targetPlayerLabel, layout, 1, 1, 1, 1);
    	addToFrame(this, playersCanAttack, layout, 2, 1, 3, 1);
    	
    	// More Buttons
    	addToFrame (this, nextButton, layout, 1, 3, 2, 1);
    	addToFrame (this, runButton, layout, 3, 3, 2, 1);
    }
                     
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        enemy1Button = new javax.swing.JButton();
        enemy2Button = new javax.swing.JButton();
        enemy3Button = new javax.swing.JButton();
        enemy4Button = new javax.swing.JButton();
        enemy5Button = new javax.swing.JButton();
        enemy6Button = new javax.swing.JButton();
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
        smashShield = new javax.swing.JLabel();
        swindShield = new javax.swing.JLabel();
        thrustShield = new javax.swing.JLabel();
        suitOfArmor = new javax.swing.JLabel();
        breastPlate = new javax.swing.JLabel();
        helmet = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        targetPlayerLabel = new JLabel("Target:");
        playersCanAttack = new JComboBox<>();
        
        enemy3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("enemy3 pressed");
            }
        });
        enemy4Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("enemy4 pressed");
            }
        });
        enemy5Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("enemy5 pressed");
            }
        });
        enemy6Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("enemy6 pressed");
            }
        });
        
        thrustButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("thrust pressed");
                combatHandler.setCurrentAttack(Attacks.THRUST);
                nextButton.setEnabled(true);
                println("Setting Current Attack To " + Attacks.THRUST);
            }
        });
        swingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("swing pressed");
                combatHandler.setCurrentAttack(Attacks.SWING);
                nextButton.setEnabled(true);
                println("Setting Current Attack To " + Attacks.SWING);
            }
        });
        smashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("smash pressed");
                nextButton.setEnabled(true);
                println("Setting Current Attack To " + Attacks.SMASH);
            }
        });
        dodgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("dodge pressed");
            }
        });
        duckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("duck pressed");
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

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        enemy1Button.setText("Enemy 1");

        enemy2Button.setText("Enemy 2");

        enemy3Button.setText("Enemy 3");

        enemy4Button.setText("Enemy 4");

        enemy5Button.setText("Enemy 5");

        enemy6Button.setText("Enemy 6");

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

        smashShield.setText("Protects Against Smash");

        swindShield.setText("Protects Against Swing");

        thrustShield.setText("Protects Against Thrust");

        suitOfArmor.setText("Suit of Armor");

        breastPlate.setText("Breastplate");

        helmet.setText("Helmet");

        resetButton.setText("Reset");
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
        nextButton.setEnabled(false);
        nextButton.setText((combatHandler.getReadyPlayerNum() == combatingPlayers.size() - 1) 
        					? "Start Combat" : "Move To Next Attacker");
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
    
    public void setArmor(String suit, String breast, String newHelmet){
    	suitOfArmor.setText(suit);
    	breastPlate.setText(breast);
    	helmet.setText(newHelmet);
    }
    
    public void println(String theLine){
    	textArea.append(theLine + "\n");
    }
}
