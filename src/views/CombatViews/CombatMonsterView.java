package views.CombatViews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import controller.CombatPvMHandler;
import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.Attacks;
import models.characterModels.playerEnums.Defences;
import models.chitModels.ChitType;
import models.chitModels.WeaponChit;
import models.otherEntities.CombatDataContainer;
import models.otherEntities.monsterModels.MonsterBase;
import views.FrameBase;
import views.MainViews.GameView;
import views.PopupViews.ChitSelectionView;

public class CombatMonsterView extends CombatViewBlockingBase {

	private PlayerBase player;
	private ArrayList <MonsterBase> monseters;
	private CombatPvMHandler combatHandler;
	
	// Buttons For Luring
	private JLabel lureLabel;
	private JButton lureThrust;
	private JButton lureSwing;
	private JButton lureSmash;
	
	// Button For Selecting Monster To Attack
	private JButton attackSelected;
	
	// JComponents For the Monsters
	private JLabel monsterLabel;
	private JComboBox<MonsterBase> monsterDisplay;
	
	// Parent Window That Spawned This
	private GameView parent;
	
	private boolean movementPicked;
	private boolean attackMonsterPicked;
	
	// Combat Monster View Constructor
	public CombatMonsterView (GameView parent, PlayerBase p, ArrayList<MonsterBase> monsters) {
    	super(parent, "Monster Combat", true);
    	setLayout(layout);
		
		this.player = p;
    	this.parent = parent;
    	this.monseters = monsters;
    	
    	movementPicked = false;
    	attackMonsterPicked = false;
    	
    	// Initialize The Player With A Dummy Combat Container
    	combatHandler = new CombatPvMHandler(this, p, monsters);
    	
    	// Initialize Everything
		initComponents();
        initWindow();
        addAllComponents();
        setupListeners();
        update();
        
        // Set Size A Bit Larger
    	setSize(900, 450);
	}
	
	@Override
	protected void initComponents() {
		super.initComponents();
		
		monsterLabel = new JLabel("Monster: ");
		monsterDisplay = new JComboBox<MonsterBase>();
		
		lureLabel = new JLabel("Lure Monster:");
		lureSmash = new JButton("Lure Smash");
		lureSwing = new JButton("Lure Swing");
		lureThrust = new JButton("Lure Thrust");
		
		// Attack Selected Monster
		attackSelected = new JButton("Attack Curr. Monster");
	}
	
	// Set up all the action listeners
	private void setupListeners() {
		thrustButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
            	ChitSelectionView chitView = new ChitSelectionView(player, ChitType.FIGHT_CHIT);
            	setFightData(Attacks.THRUST);
			}
		});
		swingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	        	ChitSelectionView chitView = new ChitSelectionView(player, ChitType.FIGHT_CHIT);
            	setFightData(Attacks.SWING);
			}
		});
		smashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	        	ChitSelectionView chitView = new ChitSelectionView(player, ChitType.FIGHT_CHIT);
            	setFightData(Attacks.SMASH);
			}
		});
		dodgeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
            	ChitSelectionView chitView = new ChitSelectionView(player, ChitType.MOVE_CHIT);
            	setDefenseData(Defences.DODGE);
            	movementPicked = true;
            	update();
			}
		});
		duckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	          	ChitSelectionView chitView = new ChitSelectionView(player, ChitType.MOVE_CHIT);
            	setDefenseData(Defences.DUCK);
            	movementPicked = true;
            	update();
			}
		});
		
		chargeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	          	ChitSelectionView chitView = new ChitSelectionView(player, ChitType.MOVE_CHIT);
            	setDefenseData(Defences.CHARGE);
            	movementPicked = true;
            	update();
			}
		});
		
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("run pressed");
				dispose();
			}
		});

		smashShield.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.getShield().setSecond(Attacks.SMASH);
				player.setShieldReady(true);
				println("Setting Shield To SMASH");
			}
		});

		thrustShield.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.getShield().setSecond(Attacks.THRUST);
				player.setShieldReady(true);
				println("Setting Shield To THRUST");
			}
		});

		swingShield.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player.getShield().setSecond(Attacks.SWING);
				player.setShieldReady(true);
				println("Setting Shield To SWING");
			}
		});

		alertWeaponButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Alert weapon pressed");
				player.getWeapon().setAlerted(true);
			}
		});

		beginCombatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				println("Begin Combat Button Has Been Pressed");
				combatHandler.executeAttacks();
				
				// Combat Has Finished, So We Can Now Rest All Of The Buttons
                dodgeButton.setEnabled(false);
                duckButton.setEnabled(false);
                chargeButton.setEnabled(false);
                
                movementPicked = false;
                attackMonsterPicked = false;
                update();
			}
		});
		
		lureSmash.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				println("Smash Lure Pressed");
				monseters.get(monsterDisplay.getSelectedIndex()).setCombatDirection(Attacks.SMASH);
				update();
			}
		});
		
		lureThrust.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				println("Thrust Lure Pressed");
				monseters.get(monsterDisplay.getSelectedIndex()).setCombatDirection(Attacks.THRUST);
				update();
			}
		});
		
		lureSwing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				println("Swing Lure Pressed");
				monseters.get(monsterDisplay.getSelectedIndex()).setCombatDirection(Attacks.SWING);
				update();
			}
		});
		
		attackSelected.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				println("Setting Current Monster To Attack");
				combatHandler.setAttackingMonster(monsterDisplay.getSelectedIndex());
				beginCombatButton.setEnabled(true);
			}
		});
	}
	
	// Sets The Fight Data When Called
	private void setFightData(Attacks attackType) {
		player.getCombatData().setAttack(attackType);
        enableDefenses();
        println("Setting Current Attack To " + attackType);
        
        if (player.getCurrentFightChit() != null)
        	println("Setting Fight Chit To: " + player.getCurrentFightChit());
	}
	
	// Set The Defense Data When Called
	private void setDefenseData (Defences defenseType) {
		player.getCombatData().setDefense(defenseType);
        enableDefenses();
        
        // Display The Data To The Player
        println("Setting Current Defence To " + defenseType);
        if (player.getCurrentMovementChit() != null)
        	println("Setting Move Chit To: " + player.getCurrentMovementChit());
	}

	@Override
	// Add The Components In
	protected void addAllComponents () {
		super.addAllComponents();
		
    	// Attackable Players Window
    	addToFrame(this, monsterLabel, layout, 5, 4, 1, 1);
    	addToFrame(this, monsterDisplay, layout, 6, 4, 3, 1);
    	
    	// Luring Labels
    	addToFrame(this, lureLabel, layout, 5, 5, 1, 1);
    	addToFrame(this, lureSmash, layout, 6, 5, 1, 1);
    	addToFrame(this, lureThrust, layout, 7, 5, 1, 1);
    	addToFrame(this, lureSwing, layout, 8, 5, 1, 1);
    	
     	// First Is The Text Area
    	addToFrame(this, textContainer, layout, 0, 0, 5, 7);
    	
    	addToFrame (this, attackSelected, layout, 5, 6, 1, 1);
	}
	
	// Update The View With All The Options Needed
	protected void update () {
		
		// Setup The Monsters
        MonsterBase[] attackables = new MonsterBase[monseters.size()];
        attackables = monseters.toArray(attackables);
        DefaultComboBoxModel<MonsterBase> model = new DefaultComboBoxModel<>( attackables );
        monsterDisplay.setModel(model);
        
        // Text Area 
        textArea.setColumns(30);
        textArea.setRows(5);
		      
       // Player Weapon Display
       WeaponChit equipWeapon = player.getWeapon();
       weaponLabel.setText("Equipped Weapon: " + equipWeapon.getWeaponName());
       weaponHarmLabel.setText("Harm Level: " + equipWeapon.getWeaponDamage());
       weaponStateLabel.setText((player.getWeapon().isAlerted()) ? "Alerted" : "Not Alerted"); 
       
       // Player Shield Display
       smashShield.setEnabled(player.getShield() != null);
       swingShield.setEnabled(player.getShield() != null);
       thrustShield.setEnabled(player.getShield() != null);
       
       beginCombatButton.setEnabled(movementPicked && attackMonsterPicked); 
	}
	
	/************************************** Delegation So the Handler Can Write Message **************************/
	public void sendMessage (Object obj) {
		parent.sendMessage(obj);
	}
}
