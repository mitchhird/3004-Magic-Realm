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

public class gameView extends FrameBase {

	private static final long serialVersionUID = 1789113344181363284L;

	private Toolkit tk = Toolkit.getDefaultToolkit();
	
	private clientController theClient;
	
	private JMenuBar menuBar = new JMenuBar();

	private JScrollPane scrollPane;

	private JPanel mainPanel;
	private boardView theBoard;
	
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints layoutConstraints = new GridBagConstraints();

	private JScrollPane theBoardScroller;

	private playerListView thePlayerList;
	private playerControllView thePlayerButtons;

	private cardView theCard;

	private JFrame cardViewer;

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
		
		menuBar.add(fileMenu);
		
		JMenuItem newAction = new JMenuItem("New Game");
        JMenuItem exitAction = new JMenuItem("Exit");

        fileMenu.add(newAction);
        fileMenu.add(exitAction);
        
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
 
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	exitGame();
            }
        });
	}
	
	private void update(){
		setSize((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight()-20);
		setSize((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight()-40);
	}
	
	private void showGameButtons(){
	
		thePlayerList = new playerListView(this);
		addToGrid(thePlayerList, 0, 0, 1, 1);
		
		thePlayerButtons = new playerControllView(this);
		addToGrid(thePlayerButtons, 0, 1, 1, 2);
		
        thePlayerList.getjButton1().addActionListener(new java.awt.event.ActionListener() {
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
        		theClient.startGame();
        		System.out.println("Start Game Pressed");
			}
		});
	}

	private void showCard() {
		if(thePlayerList.getjTable2().getSelectedRow() == -1){
			return;
		}
		cardViewer = new JFrame();
		cardViewer.setSize(760,630);
		cardViewer.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		cardViewer.setVisible(true);
		theCard = new cardView((String) thePlayerList.getjTable2().getValueAt(thePlayerList.getjTable2().getSelectedRow(), 0));
		cardViewer.add(theCard);
	}

	private void setPlayerInterface(int selectedRow) {
		thePlayerButtons.getPlayerClassLabel().setText((String) thePlayerList.getjTable2().getValueAt(selectedRow, 0));
		thePlayerButtons.getPlayerDisplayLabel().setText((String) thePlayerList.getjTable2().getValueAt(selectedRow, 1));
	}

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
	}

	private void showBoard(){
		theBoard = new boardView(this);
		theBoardScroller = new JScrollPane(theBoard);
		theBoardScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		theBoardScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		theBoardScroller.getVerticalScrollBar().setUnitIncrement(20);
		addToGrid(theBoardScroller, 1, 0, 4, 4);
		theBoardScroller.setPreferredSize(new Dimension(((int)tk.getScreenSize().getWidth()/2), ((int)tk.getScreenSize().getHeight()/2)));
	}
	
	private void addPlayerMenu(){
		new AddPlayerView(this);
	}
	
	public void addPlayer(String playerName, CharacterClass playerClass){
		theClient.addPlayer(playerClass, playerName);
		thePlayerList.addPlayer(playerName, playerClass.name());
		setPlayerInterface(thePlayerList.getjTable2().getRowCount()-1);
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
	
	public boardView getBoardView () {
		return theBoard;
	}
	
	public PlayerBase getCurrentPlayer () {
		return theClient.getCurrentPlayer();
	}
	
	public void updatePlayerByName (String name) {
		PlayerBase p = theClient.getPlayerByName(name);
		
		if (p != null)
			thePlayerButtons.update(p);
	}
	
	public clientController getGameController () {
		return theClient;
	}
	
	public playerListView getPlayerList() {
		return thePlayerList;
	}
	
	public boolean hasGameStarted() {
		return theClient.isGameStarted();
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
}
