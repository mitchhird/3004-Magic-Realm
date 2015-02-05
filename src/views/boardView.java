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
import javax.swing.ScrollPaneConstants;

public class boardView extends JFrame {

	private static final long serialVersionUID = 1789113344181363284L;

	private Toolkit tk = Toolkit.getDefaultToolkit();
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JFrame hostMenu;
	private JFrame joinMenu;
	private JFrame optionsMenu;
	private JFrame newGameMenu;
	private JFrame infoMenu;

	private JPanel pane;
	private JScrollPane scrollPane;
	
	private JPanel theBoard;
	private JPanel theGameButtons;

	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints layoutConstraints = new GridBagConstraints();

	private JScrollPane theBoardScroller;
	private JScrollPane theButtonsScroller;


	public static void main(String args[]){
		new boardView();
	}
	
	public boardView(){
		init();
	}
	
	public void init(){

		pane = new JPanel();
		scrollPane = new JScrollPane(pane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.setLayout(layout);
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
                newGameMenu();
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
		theGameButtons.repaint();
		theBoard.repaint();
		scrollPane.repaint();
		repaint();
	}
	
	private void infoPanel(){
		infoMenu = new JFrame();
		infoMenu.setSize(600,600);
		infoMenu.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		infoMenu.setVisible(true);
	}
	
	private void showGameButtons(){
		GridBagLayout gameButtonsLayout = new GridBagLayout();
		theGameButtons = new JPanel();		
		theButtonsScroller = new JScrollPane(theGameButtons);
		theButtonsScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		theButtonsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 0;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		layout.setConstraints(theButtonsScroller, layoutConstraints);
		pane.add(theButtonsScroller);
		theGameButtons.setBackground(Color.BLUE);
		theGameButtons.setVisible(true);
		theGameButtons.setLayout(gameButtonsLayout);
	}
	
	private void showBoard(){
		theBoard = new JPanel();
		theBoardScroller = new JScrollPane(theBoard);
		theBoardScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		theBoardScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 0;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		layout.setConstraints(theBoardScroller, layoutConstraints);
		pane.add(theBoardScroller);
		theBoardScroller.setVisible(true);
		
		theBoard.setVisible(true);
		theBoard.setBackground(Color.RED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void newGameMenu(){
		GridBagLayout gameMenuLayout = new GridBagLayout();
		newGameMenu = new JFrame();
		newGameMenu.setSize(300,150);
		newGameMenu.setLocation(((int)tk.getScreenSize().getWidth()/2) - 150, ((int)tk.getScreenSize().getHeight()/2) - 75);
		newGameMenu.setVisible(true);
		newGameMenu.setLayout(gameMenuLayout);
		
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
		newGameMenu.add(chooseLabel);
		
		JComboBox classSelecter = new JComboBox();
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
		newGameMenu.add(classSelecter);
		
		JButton startButton = new JButton("Start");
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
		newGameMenu.add(startButton);
		
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
		newGameMenu.add(cancelButton);
		
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                newGameMenu.dispose();
            }
        });		
        
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                startGame();
                newGameMenu.dispose();
            }
        });
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
