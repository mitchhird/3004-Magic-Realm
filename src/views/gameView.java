package views;

import java.awt.Color;
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
	
	private JButton addPlayerButton;
	@SuppressWarnings("rawtypes")
	private JComboBox classSelecter;
	private JTextField nameField;
	private JTextArea currentPlayers;
	private JScrollPane playersScroller;


	public static void main(String args[]){
		new gameView();
	}
	
	public gameView(){
		init();
	}
	
	public void init(){
		
		theClient = new clientController();

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
            	System.exit(0);
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
		theBoardScroller.repaint();
		theBoard.repaint();
		scrollPane.repaint();
		mainPanel.repaint();
		repaint();
	}
	
	private void infoPanel(){
		infoMenu = new JFrame();
		infoMenu.setSize(600,600);
		infoMenu.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		infoMenu.setVisible(true);
	}
	
	private void showGameButtons(){
		
		addPlayerButton = new JButton("Add Player");
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 0;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		layout.setConstraints(addPlayerButton, layoutConstraints);
		mainPanel.add(addPlayerButton);
		addPlayerButton.setVisible(true);
		
		currentPlayers = new JTextArea();
		playersScroller = new JScrollPane(currentPlayers);
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 1;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		layout.setConstraints(playersScroller, layoutConstraints);
		mainPanel.add(playersScroller);
		
        addPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	addPlayerMenu();
            }
        });		
	}
	
	private void showBoard(){
		theBoard = new boardView();
		theBoardScroller = new JScrollPane(theBoard);
		theBoardScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		theBoardScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 0;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 2;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		layout.setConstraints(theBoardScroller, layoutConstraints);
		mainPanel.add(theBoardScroller);
		theBoardScroller.setVisible(true);
		theBoard.setVisible(true);
		theBoard.setBackground(Color.RED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addPlayerMenu(){
		
		GridBagLayout gameMenuLayout = new GridBagLayout();
		newPlayerMenu = new JFrame();
		newPlayerMenu.setSize(300,200);
		newPlayerMenu.setLocation(((int)tk.getScreenSize().getWidth()/2) - 150, ((int)tk.getScreenSize().getHeight()/2) - 75);
		newPlayerMenu.setVisible(true);
		newPlayerMenu.setLayout(gameMenuLayout);
		
		JLabel nameLabel = new JLabel("Enter Player Name:");
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 0;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		gameMenuLayout.setConstraints(nameLabel, layoutConstraints);
		newPlayerMenu.add(nameLabel);
		
		nameField = new JTextField();
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 0;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		gameMenuLayout.setConstraints(nameField, layoutConstraints);
		newPlayerMenu.add(nameField);
		
		JLabel chooseLabel = new JLabel("Choose Your Class:");
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 1;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		gameMenuLayout.setConstraints(chooseLabel, layoutConstraints);
		newPlayerMenu.add(chooseLabel);
		
		classSelecter = new JComboBox();
		classSelecter.setModel( new DefaultComboBoxModel(new String[] {"Amazon","Black Knight","Captain","Dwarf","Elf","Swordsman"}));
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 1;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		gameMenuLayout.setConstraints(classSelecter, layoutConstraints);
		newPlayerMenu.add(classSelecter);
		
		JButton startButton = new JButton("OK");
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 2;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		gameMenuLayout.setConstraints(startButton, layoutConstraints);
		newPlayerMenu.add(startButton);
		
		JButton cancelButton = new JButton("Cancel");
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 2;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		gameMenuLayout.setConstraints(cancelButton, layoutConstraints);
		newPlayerMenu.add(cancelButton);
		
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
	
	private void startGame(){
		showGameButtons();
		showBoard();
		update();
	}
	
	private void options(){
		optionsMenu = new JFrame();
		optionsMenu.setSize(600,600);
		optionsMenu.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		optionsMenu.setVisible(true);
	}
}
