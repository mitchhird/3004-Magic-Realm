package views.PopupViews;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import networking.sendables.MessageType;
import views.FrameBase;
import views.MainViews.GameView;
import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.Defences;
import models.chitModels.WeaponChit;
import models.otherEntities.CombatDataContainer;
import controller.CombatPVPHandler;

public class CombatView extends FrameBase implements WindowListener {

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
    private javax.swing.JButton beginCombatButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel movements;
    private JLabel targetPlayerLabel;
    private JLabel weaponLabel;
    private JLabel weaponHarmLabel;
    private JLabel weaponStateLabel;
    private JButton alertWeaponButton;
    private javax.swing.JButton smashShield;
    private javax.swing.JButton swingShield;
    private javax.swing.JButton thrustShield;
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
    
    // Need The Parent So We Can Send Messages Back And Forth
    private GameView ourParent;
    
    // Constructor For This
    public CombatView(ArrayList<PlayerBase> combatingPlayers, GameView parent) {
    	// Variable Setting
    	ourParent = parent;
    	this.combatingPlayers = combatingPlayers;
    	combatHandler = new CombatPVPHandler(combatingPlayers, this);

    	// Setup All The Components
    	initComponents();
        initWindow();
        addAllComponents();
        update();
        
        setTitle("Combat PVP");
        addWindowListener(this);
        ourParent.setCurrentCombatWindow(this);
    }
    
    // Initialize The Window
    public void initWindow () {
		setSize(900,350);
		setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		setLayout(layout);
		setTitle("Combat Screen");
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
    	
    	// Attackable Players Window
    	addToFrame(this, targetPlayerLabel, layout, 5, 4, 1, 1);
    	addToFrame(this, playersCanAttack, layout, 6, 4, 3, 1);
    	
    	// More Buttons
    	addToFrame (this, nextButton, layout, 5, 5, 1, 1);
    	addToFrame(this, beginCombatButton, layout, 6, 5, 1, 1);
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
        alertWeaponButton = new JButton("Alert Weapon");
        beginCombatButton = new javax.swing.JButton("Start Combat");
        smashShield = new javax.swing.JButton("Smash");
        swingShield = new javax.swing.JButton("Swing");
        thrustShield = new javax.swing.JButton("Thrust");
        
        // Labels
        weaponStateLabel = new JLabel();
        movements = new JLabel("Movements:");
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
        textArea.setColumns(30);
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
            	enableDefenses();
                combatHandler.setCurrentAttack(Attacks.THRUST);
                println("Setting Current Attack To " + Attacks.THRUST);
            }
        });
        swingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                combatHandler.setCurrentAttack(Attacks.SWING);
                enableDefenses();
                println("Setting Current Attack To " + Attacks.SWING);
            }
        });
        smashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                combatHandler.setCurrentAttack(Attacks.SMASH);
                enableDefenses();
                println("Setting Current Attack To " + Attacks.SMASH);
            }
        });
        dodgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ChitSelectionView chitView = new ChitSelectionView(ourParent, combatHandler.getCurrentDefender());
            	combatHandler.setCurrentDefence(Defences.DODGE);
            	
            	// Display Things For Displaying
                println("Setting Current Defence To " + Defences.DODGE);
                nextButton.setEnabled(true);
                
                System.out.println("dodge pressed");
            }
        });
        duckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ChitSelectionView chitView = new ChitSelectionView(ourParent, combatHandler.getCurrentDefender());
            	combatHandler.setCurrentDefence(Defences.DUCK);
                println("Setting Current Defence To " + Defences.DUCK);
                nextButton.setEnabled(true);
            	System.out.println("duck pressed");
            }
        });
        chargeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ChitSelectionView chitView = new ChitSelectionView(ourParent, combatHandler.getCurrentDefender());
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
                
                // Set The Data The Combat Container, And Then Send It Across
                CombatDataContainer combatData = combatHandler.getCurrentAttacker().getCombatData();
                combatData.setThePlayer(combatHandler.getCurrentAttacker());
				combatData.setTheDefender(combatHandler.getCurrentDefender());
                ourParent.sendMessage(combatData);   
                
                // Go To The Next Attack
                combatHandler.setNextAttacker();
                
                nextButton.setEnabled(false);
                dodgeButton.setEnabled(false);
                duckButton.setEnabled(false);
                chargeButton.setEnabled(false);
                update();
            }
        });
        
        smashShield.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				combatHandler.getCurrentAttacker().getShield().setSecond(Attacks.SMASH);
				combatHandler.getCurrentAttacker().setShieldReady(true);
				println ("Setting Shield To SMASH");
			}
		});
        
        thrustShield.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				combatHandler.getCurrentAttacker().getShield().setSecond(Attacks.THRUST);
				combatHandler.getCurrentAttacker().setShieldReady(true);
				println ("Setting Shield To THRUST");
			}
		});
        
        swingShield.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				combatHandler.getCurrentAttacker().getShield().setSecond(Attacks.SWING);
				combatHandler.getCurrentAttacker().setShieldReady(true);
				println ("Setting Shield To SWING");
			}
		});
        
        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("end pressed");
            }
        });
        alertWeaponButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Alert weapon pressed");
                combatHandler.getCurrentAttacker().getWeapon().setAlerted(true);
                update();
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
        
        beginCombatButton.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				println("Begin Combat Button Has Been Pressed");
				startCombat();
			}
		});
	}

	// Start The Combat
	public void startCombat() {
		ourParent.sendMessage(MessageType.START_COMBAT);
		combatHandler.executeAttacks();
		update();
	}
	
	// Enables The Defense Buttons
	private void enableDefenses() {
		dodgeButton.setEnabled(true);
        duckButton.setEnabled(true);
        chargeButton.setEnabled(true);
	}
    
    // Updates This Window With Needed Material
    private void update () {
    	// Get The Combobox ready
    	targetPlayers = getPlayersToAttack();
        PlayerBase[] attackables = new PlayerBase[targetPlayers.size()];
        attackables = targetPlayers.toArray(attackables);
        DefaultComboBoxModel<PlayerBase> model = new DefaultComboBoxModel<>( attackables );
        playersCanAttack.setModel(model);
        
        // Set The Next Player To Disabled
        nextButton.setText("Move To Next Attacker");
        
        // Player Weapon Display
        WeaponChit equipWeapon = combatHandler.getCurrentAttacker().getWeapon();
        weaponLabel.setText("Equipped Weapon: " + equipWeapon.getWeaponName());
        weaponHarmLabel.setText("Harm Level: " + equipWeapon.getWeaponDamage());
        weaponStateLabel.setText((combatHandler.getCurrentAttacker().getWeapon().isAlerted()) ? "Alerted" : "Not Alerted"); 
        
        // Player Shield Display
        smashShield.setEnabled(combatHandler.getCurrentAttacker().getShield() != null);
        swingShield.setEnabled(combatHandler.getCurrentAttacker().getShield() != null);
        thrustShield.setEnabled(combatHandler.getCurrentAttacker().getShield() != null);
        
        // If We Are Full On Combat Then, Enable The Button
        beginCombatButton.setEnabled(combatHandler.getReadyPlayerNum() == combatingPlayers.size());
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
    
    // Used to print a line to the text area
    public void println(String theLine){
    	textArea.append(theLine + "\n");
    }
    
    // Sets up the window listener
    public void windowClosed(WindowEvent e) {
        System.out.println("WindowListener method called: windowClosed.");
        ourParent.setCurrentCombatWindow(null);
    }
    
	@Override
	public void windowClosing(WindowEvent arg0) {
		System.out.println("WindowListener method called: windowClosing.");
		ourParent.setCurrentCombatWindow(null);
	}
	
	/******************************* Getters And Setters *********************/
    public ArrayList<PlayerBase> getCombatingPlayers() {
		return combatingPlayers;
	}
	
    /******************************* Delgation Method ************************/
    public void sendMessage (Object obj) {
    	ourParent.sendMessage(obj);
    }

    public void addReadyPlayerPair (PlayerBase attacker, PlayerBase defender) {
    	combatHandler.addReadyPlayerSet(attacker, defender);
    	update();
    	
        // Display For Display Purposes
        println ("Attack Submitted:");
        println ("  --- Attacker: " + attacker.getName());
        println ("  --- Defender: " + defender.getName());
        println ("");
    }
    
	/****************************** Interface Methods That Don't Need Implementation ***********************/
    
	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
