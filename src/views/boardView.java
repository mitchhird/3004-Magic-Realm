package views;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class boardView extends JFrame {

	private static final long serialVersionUID = -3255182183312639441L;
	public static JScrollPane pane;
	public JMenuBar menuBar = new JMenuBar();
	public Toolkit tk = Toolkit.getDefaultToolkit();

	public static void main(String args[]){
		new boardView();
	}
	
	public boardView(){
		init();
	}
	
	public void init(){
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
        fileMenu.add(newAction);
        fileMenu.add(exitAction);
        
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
        
	}
	
	private void newGame(){
		System.out.println("Unimplemented");
	}
	
	private void exitGame(){
		System.out.println("Bye");
		System.exit(0);
	}
}
