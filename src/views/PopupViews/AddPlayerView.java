package views.PopupViews;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import views.FrameBase;
import views.MainViews.GameView;
import models.characterModels.playerEnums.CharacterClass;

public class AddPlayerView extends FrameBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1991225057723904889L;

	public GameView parent;
	
	protected JLabel nameLabel;
	protected JLabel chooseLabel;
	protected JTextField nameField;
	protected JComboBox<CharacterClass> classSelecter;
	
	protected JButton startButton;
	protected JButton cancelButton;
	
	private Toolkit tk = Toolkit.getDefaultToolkit();
	
	public AddPlayerView (GameView parent) {
		super ();
		this.parent = parent;
		
		initWindow();
		initComponents();
		initListeners();
	}
	
	// Init The Window
	public void initWindow () {
		setSize(300,200);
		setLocation(((int)tk.getScreenSize().getWidth()/2) - 150, ((int)tk.getScreenSize().getHeight()/2) - 75);
		setVisible(true);
		setLayout(layout);
		setTitle ("Add Player");
	}
	
	// Init All The Components
	public void initComponents () {
		nameField = new JTextField();
		nameField = new JTextField();
		nameLabel = new JLabel("Enter Player Name:");
		chooseLabel = new JLabel("Choose Your Class:");

		classSelecter = new JComboBox<CharacterClass>();
		classSelecter.setModel(new DefaultComboBoxModel<CharacterClass>(CharacterClass.values()));

		startButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		
		addToFrame(this, nameLabel, layout, 0, 0, 1, 1);
		addToFrame(this, nameField, layout, 1, 0, 1, 1);
		addToFrame(this, chooseLabel, layout, 0, 1, 1, 1);
		addToFrame(this, classSelecter, layout, 1, 1, 1, 1);
		addToFrame(this, startButton, layout, 0, 2, 1, 1);
		addToFrame(this, cancelButton, layout, 1, 2, 1, 1);
	}
	
	// Initialize The Listeners
	public void initListeners () {
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	closeWindow();
            }
        });		
        
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	start();
            }
        });
	}
	
	private void start() {
    	parent.setVPs(nameField.getText(), classSelecter.getItemAt(classSelecter.getSelectedIndex()));
        closeWindow();
	}

	// Closes The Window When Called
	public void closeWindow () {
		dispose();
	}
}
