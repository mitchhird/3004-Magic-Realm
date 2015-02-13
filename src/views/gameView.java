package views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import controller.clientController;

public class gameView extends JFrame {

	private static final long serialVersionUID = 1789113344181363284L;

	private Toolkit tk = Toolkit.getDefaultToolkit();
	
	private clientController theClient;
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JFrame hostMenu;
	private JFrame joinMenu;
	private JFrame optionsMenu;
	private JFrame newPlayerMenu;
	private JFrame infoMenu;

	private JScrollPane scrollPane;

	private JPanel mainPanel;
	private boardView theBoard;
	
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints layoutConstraints = new GridBagConstraints();

	private JScrollPane theBoardScroller;
	
	@SuppressWarnings("rawtypes")
	private JComboBox classSelecter;
	private JTextField nameField;
	private JTextArea currentPlayers;

	private playerControllView thePlayerButtons;

	private playerListView thePlayerList;


	public static void main(String args[]){
		new gameView();
	}
	
	public gameView(){
		init();
	}
	
	// Initialization Method 
	public void init(){
		
		theClient = new clientController(this);

		mainPanel = new JPanel();
		scrollPane = new JScrollPane(mainPanel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mainPanel.setLayout(layout);
		setSize((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight()-40);
		setVisible(true);
		setTitle("Magic Realm");
		setJMenuBar(menuBar);
		add(scrollPane);
		
		JMenu fileMenu = new JMenu("File");
		JMenu networkMenu = new JMenu("Network");
		JMenu helpMenu = new JMenu("Help");
		
		menuBar.add(fileMenu);
		menuBar.add(networkMenu);
		menuBar.add(helpMenu);
		
		JMenuItem newAction = new JMenuItem("New Game");
        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem optionAction = new JMenuItem("Options");
        JMenuItem infoAction = new JMenuItem("Information");
        JMenuItem joinAction = new JMenuItem("Join Game");
        JMenuItem hostAction = new JMenuItem("Host Game");

        fileMenu.add(newAction);
        fileMenu.add(optionAction);
        fileMenu.add(exitAction);
        networkMenu.add(joinAction);
        networkMenu.add(hostAction);
        helpMenu.add(infoAction);
        
        newAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                startGame();
            }
        });
        
        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                exitGame();
            }
        });
        
        joinAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                joinGame();
            }
        });
        
        hostAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                hostGame();
            }
        });
        
        optionAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                options();
            }
        });
        
        infoAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                infoPanel();
            }
        });
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	exitGame();
            }
        });
	}
	
	private void hostGame(){
		hostMenu = new JFrame();
		hostMenu.setSize(600,600);
		hostMenu.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		hostMenu.setVisible(true);
	}
	
	private void joinGame(){
		joinMenu = new JFrame();
		joinMenu.setSize(600,600);
		joinMenu.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		joinMenu.setVisible(true);
	}
	
	private void update(){
		setSize((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight()-20);
		setSize((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight()-40);
	}
	
	private void infoPanel(){
		infoMenu = new JFrame();
		infoMenu.setSize(600,600);
		infoMenu.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		infoMenu.setVisible(true);
	}
	
	private void showGameButtons(){
	
		thePlayerList = new playerListView();
		addToGrid(thePlayerList, 0, 0, 1, 1);
		
		thePlayerButtons = new playerControllView();
		addToGrid(thePlayerButtons, 0, 1, 1, 2);
		
	}

	private void showBoard(){
		theBoard = new boardView();
		theBoardScroller = new JScrollPane(theBoard);
		theBoardScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		theBoardScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		addToGrid(theBoardScroller, 1, 0, 4, 4);
		theBoardScroller.setPreferredSize(new Dimension(((int)tk.getScreenSize().getWidth()/2), ((int)tk.getScreenSize().getHeight()/2)));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private void addPlayerMenu(){
		
		GridBagLayout gameMenuLayout = new GridBagLayout();
		newPlayerMenu = new JFrame();
		newPlayerMenu.setSize(300,200);
		newPlayerMenu.setLocation(((int)tk.getScreenSize().getWidth()/2) - 150, ((int)tk.getScreenSize().getHeight()/2) - 75);
		newPlayerMenu.setVisible(true);
		newPlayerMenu.setLayout(gameMenuLayout);
		
		JLabel nameLabel = new JLabel("Enter Player Name:");
		nameField = new JTextField();
		
		JLabel chooseLabel = new JLabel("Choose Your Class:");
		classSelecter = new JComboBox();
		classSelecter.setModel( new DefaultComboBoxModel(new String[] {"Amazon","Black Knight","Captain","Dwarf","Elf","Swordsman"}));
		
		JButton startButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");
		
		// Add Everything To The Frame
		addToFrame(newPlayerMenu, nameLabel, gameMenuLayout, 0, 0, 1, 1);
		addToFrame(newPlayerMenu, nameField, gameMenuLayout, 1, 0, 1, 1);
		addToFrame(newPlayerMenu, chooseLabel, gameMenuLayout, 0, 1, 1, 1);
		addToFrame(newPlayerMenu, classSelecter, gameMenuLayout, 1, 1, 1, 1);
		addToFrame(newPlayerMenu, startButton, gameMenuLayout, 0, 2, 1, 1);
		addToFrame(newPlayerMenu, cancelButton, gameMenuLayout, 1, 2, 1, 1);
		
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	newPlayerMenu.dispose();
            }
        });		
        
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                addPlayer();
                newPlayerMenu.dispose();
            }
        });
	}
	
	
	private void addPlayer(){
		theClient.addPlayer((String) classSelecter.getSelectedItem(), nameField.getText());
		currentPlayers.append("Name: " + nameField.getText() + " || Class: " + (String) classSelecter.getSelectedItem() + "\n");
	}
	
	private void exitGame(){
		System.out.println("Exiting");
		dispose();
		System.exit(0);
	}
	
	// Starts The Game
	private void startGame(){
		showGameButtons();
		showBoard();
		update();
	}
	
	// Displays The Options Window
	private void options(){
		optionsMenu = new JFrame();
		optionsMenu.setSize(600,600);
		optionsMenu.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		optionsMenu.setVisible(true);
	}
	
	// Sets The Grid Location Based On The Paramenters Given
	private void addToGrid(JComponent theComponent, int x, int y, int gridWidth, int gridHeight) {
		addToGrid(mainPanel, theComponent, x, y, gridWidth, gridHeight);
	}
		
	private void addToGrid(JPanel connectToFrame, JComponent theComponent, int x, int y, int gridWidth, int gridHeight) {
		layoutConstraints.gridx = x;
		layoutConstraints.gridy = y;
		layoutConstraints.gridwidth = gridWidth;
		layoutConstraints.gridheight = gridHeight;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		layout.setConstraints(theComponent, layoutConstraints);
		mainPanel.add(theComponent);
	}
		
	private void addToFrame (JFrame connectToFrame, JComponent theComponent, GridBagLayout layout, int x, int y, int gridWidth, int gridHeight){
		layoutConstraints.gridx = x;
		layoutConstraints.gridy = y;
		layoutConstraints.gridwidth = gridWidth;
		layoutConstraints.gridheight = gridHeight;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		layout.setConstraints(theComponent, layoutConstraints);
		connectToFrame.add(theComponent);
	}
		
}
