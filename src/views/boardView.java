package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class boardView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3255182183312639441L;
	private Image img;
	
	private JButton cliff1;
	private JButton cliff2;
	private JButton cliff3;
	private JButton cliff4;
	private JButton cliff5;
	private JButton cliff6;

	public boardView(){
		init();
	}
	
	private void init(){
		try {
			img = ImageIO.read(new File(System.getProperty("user.dir")+"/images", "theMap3.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setPreferredSize( new Dimension(1300,1486));
		setLayout(null);
		
		cliff1 = new JButton("1");
		cliff2 = new JButton("2");
		cliff3 = new JButton("3");
		cliff4 = new JButton("4");
		cliff5 = new JButton("5");
		cliff6 = new JButton("6");

		cliff1.setSize(30, 30);
		cliff2.setSize(30, 30);
		cliff3.setSize(30, 30);
		cliff4.setSize(30, 30);
		cliff5.setSize(30, 30);
		cliff6.setSize(30, 30);

		cliff1.setLocation(419, 188);
		cliff2.setLocation(496, 204);
		cliff3.setLocation(473, 134);
		cliff4.setLocation(449, 62);
		cliff5.setLocation(527, 78);
		cliff6.setLocation(400, 120);
		
		add(cliff1);
		add(cliff2);
		add(cliff3);
		add(cliff4);
		add(cliff5);
		add(cliff6);

		cliff1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cliff1");
            }
        });	
		cliff2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cliff2");
            }
        });	
		cliff3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cliff3");
            }
        });	
		cliff4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cliff4");
            }
        });	
		cliff5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cliff5");
            }
        });	
		cliff6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cliff6");
            }
        });	
        
	}
	
	private void selectLocation(String theLocation){
		System.out.println(theLocation + " selected");
	}
	
	@Override
	public void paintComponent(Graphics page)
	{
	    super.paintComponent(page);
	    page.drawImage(img, 0, 0, this);
	}
}
