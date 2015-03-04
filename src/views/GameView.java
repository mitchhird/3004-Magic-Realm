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

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.characterModels.PlayerBase;
import models.characterModels.playerEnums.CharacterClass;
import controller.clientController;

public class GameView extends FrameBase {

	private static final long serialVersionUID = 1789113344181363284L;

	//Field declarations
	private Toolkit tk = Toolkit.getDefaultToolkit();
	
	private clientController theClient;
	
	private JMenuBar menuBar = new JMenuBar();

	private JScrollPane scrollPane;

	private JPanel mainPanel;
	private BoardView theBoard;
	
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints layoutConstraints = new GridBagConstraints();

	private JScrollPane theBoardScroller;

	private PlayerListView thePlayerList;
	private PlayerControllView thePlayerButtons;

	private CardView theCard;

	private JFrame cardViewer;

	private JFrame cheatModeFrame;

	private JFrame joinViewer;

	private JFrame hostViewer;

	private HostView theHostView;

	private JoinView theJoinView;
	
	//Constructor for gameView
	public GameView(){
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
		JMenu netMenu = new JMenu("Netwokring");
		JMenu optMenu = new JMenu("Options");
		
		menuBar.add(fileMenu);
		menuBar.add(netMenu);
		menuBar.add(optMenu);
		
		JMenuItem newAction = new JMenuItem("New Game");
        JMenuItem exitAction = new JMenuItem("Exit");
		JMenuItem joinAction = new JMenuItem("Join Game");
        JMenuItem hostAction = new JMenuItem("Host Game");
		JMenuItem cheatAction = new JMenuItem("Cheat Mode");

        fileMenu.add(newAction);
        fileMenu.add(exitAction);
        
        netMenu.add(joinAction);
        netMenu.add(hostAction);
        optMenu.add(cheatAction);
        
        //Action listeners
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
        
        hostAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                hostGame();
            }
        });
 
        joinAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                joinGame();
            }
        });
        
        cheatAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cheatMode();
            }
        });
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	exitGame();
            }
        });
        
	}
	
	private void cheatMode() {
		cheatModeFrame = new JFrame();
		cheatModeFrame.setSize(760,630);
		cheatModeFrame.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		cheatModeFrame.setVisible(true);
	}

	private void joinGame() {
		joinViewer = new JFrame();
		joinViewer.setSize(235,140);
		joinViewer.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		joinViewer.setVisible(true);
		theJoinView = new JoinView();
		joinViewer.add(theJoinView);
	}

	private void hostGame() {
		hostViewer = new JFrame();
		hostViewer.setSize(225,135);
		hostViewer.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		hostViewer.setVisible(true);
		theHostView = new HostView();
		hostViewer.add(theHostView);
	}

	//update method resizes the screen to get it to repaint
	private void update(){
		setSize((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight()-20);
		setSize((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight()-40);
	}
	
	//Displays the gameButtons and user interface
	private void showGameButtons(){
	
		thePlayerList = new PlayerListView(this);
		addToGrid(thePlayerList, 0, 0, 1, 1);
		
		thePlayerButtons = new PlayerControllView(this);
		addToGrid(thePlayerButtons, 0, 1, 1, 2);
		
		//Action listeners
        thePlayerList.getAddPlayerButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerMenu();
            }
        });
        
        thePlayerList.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlayer();
            }
        });
        
        thePlayerList.getjTable2().getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        	@Override
        	public void valueChanged(ListSelectionEvent event){
        		if(thePlayerList.getjTable2().getSelectedRow()>-1){
        			setPlayerInterface(thePlayerList.getjTable2().getSelectedRow());
        		}
        	}
        });
      
        thePlayerButtons.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCard();
            }
        });
        
        thePlayerList.getStartGameButton().addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent arg0) {
        		handleStartGame();
			}
		});
	}
	
	//happens when you press the start game button, initlizes the game
	private void handleStartGame () {
		System.out.println("Start Game Pressed");
		
		theClient.startGame();
		thePlayerList.updateTable();
		thePlayerButtons.massSetButtonState(true);
		thePlayerList.getjButton2().setEnabled(false);
		thePlayerList.getAddPlayerButton().setEnabled(false);
		thePlayerList.getStartGameButton().setEnabled(false);
		JOptionPane.showMessageDialog(this, "The Game Has Started!");
	}

	//Shows the player's detailed character sheet
	private void showCard() {
		if(thePlayerList.getjTable2().getSelectedRow() == -1){
			return;
		}
		cardViewer = new JFrame();
		cardViewer.setSize(760,630);
		cardViewer.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		cardViewer.setVisible(true);
		theCard = new CardView((String) thePlayerList.getjTable2().getValueAt(thePlayerList.getjTable2().getSelectedRow(), 0));
		cardViewer.add(theCard);
	}

	//changes the ui to show details of the selected player
	private void setPlayerInterface(int selectedRow) {
		thePlayerButtons.getPlayerClassLabel().setText((String) thePlayerList.getjTable2().getValueAt(selectedRow, 0));
		thePlayerButtons.getPlayerDisplayLabel().setText((String) thePlayerList.getjTable2().getValueAt(selectedRow, 1));
	}

	//removes the selected player for the player list and from the controller class
	private void removePlayer() {
		
		if(thePlayerList.getjTable2().getSelectedRow()==-1){
			return;
		}
		
		int selectedOption = JOptionPane.showConfirmDialog(null, 
                "Are you sure that you want to remove this player?", 
                "Choose", 
                JOptionPane.YES_NO_OPTION); 
		if (selectedOption == JOptionPane.NO_OPTION) {
			return;
		}
	
		String playerToRemoveName = (String) thePlayerList.getjTable2().getModel().getValueAt(thePlayerList.getjTable2().getSelectedRow(),1);

		thePlayerList.removePlayer();
		theClient.removePlayer(playerToRemoveName);
		thePlayerList.update();
	}

	//Displays and initializes the board in the game view
	private void showBoard(){
		theBoard = new BoardView(this);
		theBoardScroller = new JScrollPane(theBoard);
		theBoardScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		theBoardScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		theBoardScroller.getVerticalScrollBar().setUnitIncrement(20);
		addToGrid(theBoardScroller, 1, 0, 4, 4);
		theBoardScroller.setPreferredSize(new Dimension(((int)tk.getScreenSize().getWidth()/2), ((int)tk.getScreenSize().getHeight()/2)));
	}
	
	//opens the addplayer menu that letss the user select their name and class
	private void addPlayerMenu(){
		new AddPlayerView(this);
	}
	
	//Adds the new palyer to the controller and the UI list
	public void addPlayer(String playerName, CharacterClass playerClass){
		theClient.addPlayer(playerClass, playerName);
		thePlayerList.addPlayer(playerName, playerClass.name());
		setPlayerInterface(thePlayerList.getjTable2().getRowCount()-1);
	}
	
	//closes the game and disposes of all components
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
	
	//updates a player given their name
	public void updatePlayer (String name, CharacterClass charClass) {
		PlayerBase p = theClient.getPlayer(name, charClass);
		
		if (p != null)
			thePlayerButtons.update(p);
	}
	
	// Update The Table On Call
	public void updateRecordTable () {
		thePlayerButtons.update(getCurrentPlayer());
	}
	
	/*------------------------------- Getters And Setters ---------------------------*/
	public BoardView getBoardView () {
		return theBoard;
	}
	
	public PlayerBase getCurrentPlayer () {
		return theClient.getCurrentPlayer();
	}
	
	public clientController getGameController () {
		return theClient;
	}
	
	public PlayerListView getPlayerList() {
		return thePlayerList;
	}
	
	//checks if the game has started or not
	public boolean hasGameStarted() {
		return theClient.isGameStarted();
	}
	
	// Sets The Grid Location Based On The Paramenters Given
	private void addToGrid(JComponent theComponent, int x, int y, int gridWidth, int gridHeight) {
		addToGrid(mainPanel, theComponent, x, y, gridWidth, gridHeight);
	}
	
	//used to add components to this frame in specified locations
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

	public void displayWinner(String winner) {
		int selectedOption = JOptionPane.showConfirmDialog(null, 
                "The game is over and " + winner + " has won!", 
                "End", 
                JOptionPane.YES_OPTION); 
		if (selectedOption == JOptionPane.YES_OPTION) {
			return;
		}
	}
}
