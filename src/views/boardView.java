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

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class boardView extends JFrame {

	private static final long serialVersionUID = -3255182183312639441L;
	public static JScrollPane pane;
	public JMenuBar menuBar = new JMenuBar();
	public Toolkit tk = Toolkit.getDefaultToolkit();
	public JFrame newGameMenu;
	public JPanel theBoard;
	public JPanel theGameButtons;

	public GridBagLayout layout = new GridBagLayout();
	public GridBagConstraints layoutConstraints = new GridBagConstraints();

	public static void main(String args[]){
		new boardView();
	}
	
	public boardView(){
		init();
	}
	
	public void init(){
		
		setLayout(layout);
		
		pane = new JScrollPane();
		add(pane);
		
		setSize((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight()-40);
		setVisible(true);
		setTitle("Magic Realm");
		
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		JMenuItem newAction = new JMenuItem("New Game");
        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem optionAction = new JMenuItem("Options");
        fileMenu.add(newAction);
        fileMenu.add(exitAction);
        editMenu.add(optionAction);
       
        
        newAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                newGame();
            }
        });
        
        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                exitGame();
            }
        });
        
        optionAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                options();
            }
        });
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	System.exit(0);
            }
        });
        
	}
	
	private void newGame(){
		//newGameMenu();
		showGameButtons();
		showBoard();
		repaint();
	}
	
	private void showGameButtons(){
		theGameButtons = new JPanel();
		theGameButtons.setBackground(Color.BLUE);
		layoutConstraints.gridx = 0;
		layoutConstraints.gridy = 0;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		layout.setConstraints(theGameButtons, layoutConstraints);
		theGameButtons.setSize((int)tk.getScreenSize().getWidth()/2, (int)tk.getScreenSize().getHeight()/2 - 40);
		theGameButtons.setVisible(true);
		add(theGameButtons);
	}
	
	private void showBoard(){
		theBoard = new JPanel();
		theBoard.setBackground(Color.RED);
		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 0;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		layout.setConstraints(theBoard, layoutConstraints);
		theBoard.setSize((int)tk.getScreenSize().getWidth()/2, (int)tk.getScreenSize().getHeight()/2 - 40);
		theBoard.setVisible(true);
		add(theBoard);
	}
	
	@SuppressWarnings("unused")
	private void newGameMenu(){
		System.out.println("Opening New Game Menu");
		newGameMenu = new JFrame();
		newGameMenu.setSize(600,600);
		newGameMenu.setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		newGameMenu.setVisible(true);
	}
	
	private void exitGame(){
		System.out.println("Exiting");
		System.exit(0);
	}
	
	private void options(){
		System.out.println("Unimplemented");
	}
}
