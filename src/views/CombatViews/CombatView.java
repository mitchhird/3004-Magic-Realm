package views.CombatViews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.Defences;
import models.chitModels.ChitType;
import models.chitModels.WeaponChit;
import models.otherEntities.CombatDataContainer;
import networking.sendables.MessageType;
import views.MainViews.GameView;
import views.PopupViews.ChitSelectionView;
import controller.CombatPVPHandler;

public class CombatView extends CombatViewBase implements WindowListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -611514956127664758L;

    private JLabel targetPlayerLabel;
    protected javax.swing.JButton nextButton;
    private JComboBox<PlayerBase> playersCanAttack;
    
    // Setup The Combat Handler For The View
    private CombatPVPHandler combatHandler;
    private ArrayList<PlayerBase> combatingPlayers;
    private ArrayList<PlayerBase> targetPlayers;
    
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
        
        // Setup The Listeners For This View
        setupListeners();
        
        setTitle("Combat PVP");
        addWindowListener(this);
        ourParent.setCurrentCombatWindow(this);
    }
    
    // Adds All Of The Components To The Window
    public void addAllComponents () {
    
    	super.addAllComponents();

    	// Attackable Players Window
    	addToFrame(this, targetPlayerLabel, layout, 5, 4, 1, 1);
    	addToFrame(this, playersCanAttack, layout, 6, 4, 3, 1);
    	addToFrame(this, textContainer, layout, 0, 0, 5, 7);
    	
    	addToFrame (this, nextButton, layout, 5, 6, 1, 1);
    }
                     
    protected void initComponents() {
    	super.initComponents();
        
        targetPlayerLabel = new JLabel("Target:");
        playersCanAttack = new JComboBox<>();
        
        // Next Button
        nextButton = new javax.swing.JButton();
        nextButton.setText("Move To Next Attacker");
        nextButton.setEnabled(false);
    }

    // Set up all the action listeners
	private void setupListeners() {
		thrustButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ChitSelectionView chitView = new ChitSelectionView(combatHandler.getCurrentAttacker(), ChitType.FIGHT_CHIT);
            	setFightData(Attacks.THRUST);
            }
        });
        swingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ChitSelectionView chitView = new ChitSelectionView(combatHandler.getCurrentAttacker(), ChitType.FIGHT_CHIT);
            	setFightData(Attacks.SWING);
            }
        });
        smashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ChitSelectionView chitView = new ChitSelectionView(combatHandler.getCurrentAttacker(), ChitType.FIGHT_CHIT);
                setFightData(Attacks.SMASH);
            }
        });
        dodgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ChitSelectionView chitView = new ChitSelectionView(combatHandler.getCurrentAttacker(), ChitType.MOVE_CHIT);
            	setDefenseData(Defences.DODGE);
            }
        });
        duckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ChitSelectionView chitView = new ChitSelectionView(combatHandler.getCurrentAttacker(), ChitType.MOVE_CHIT);
            	setDefenseData(Defences.DUCK);
            }
        });
        chargeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	ChitSelectionView chitView = new ChitSelectionView(combatHandler.getCurrentAttacker(), ChitType.MOVE_CHIT);
            	setDefenseData(Defences.CHARGE);
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
        
        alertWeaponButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Alert weapon pressed");
                combatHandler.getCurrentAttacker().getWeapon().setAlerted(true);
                update();
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
	
	// Sets The Fight Data When Called
	private void setFightData(Attacks attackType) {
		combatHandler.setCurrentAttack(attackType);
        enableDefenses();
        println("Setting Current Attack To " + attackType);
        
        if (combatHandler.getCurrentAttacker().getCurrentFightChit() != null)
        	println("Setting Fight Chit To: " + combatHandler.getCurrentAttacker().getCurrentFightChit());
	}
	
	// Set The Defense Data When Called
	private void setDefenseData (Defences defenseType) {
		combatHandler.setCurrentDefence(defenseType);
        enableDefenses();
        nextButton.setEnabled(true);
        
        // Display The Data To The Player
        println("Setting Current Defence To " + defenseType);
        if (combatHandler.getCurrentAttacker().getCurrentMovementChit() != null)
        	println("Setting Move Chit To: " + combatHandler.getCurrentAttacker().getCurrentMovementChit());
	}

	// Start The Combat
	public void startCombat() {
		ourParent.sendMessage(MessageType.START_COMBAT);
		combatHandler.executeAttacks();
		update();
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
