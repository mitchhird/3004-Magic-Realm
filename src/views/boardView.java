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

	private JButton evalley1;
	private JButton evalley2;
	private JButton evalley3;
	private JButton evalley4;
	private JButton evalley5;
	
	private JButton hpass1;
	private JButton hpass2;
	private JButton hpass3;
	private JButton hpass4;
	private JButton hpass5;
	private JButton hpass6;
	
	private JButton ledges1;
	private JButton ledges2;
	private JButton ledges3;
	private JButton ledges4;
	private JButton ledges5;
	private JButton ledges6;
	
	private JButton bland1;
	private JButton bland2;
	private JButton bland3;
	private JButton bland4;
	private JButton bland5;
	private JButton bland6;
	
	private JButton cavern1;
	private JButton cavern2;
	private JButton cavern3;
	private JButton cavern4;
	private JButton cavern5;
	private JButton cavern6;
	
	private JButton carg1;
	private JButton carg2;
	private JButton carg3;
	private JButton carg4;
	private JButton carg5;
	private JButton carg6;
	
	private JButton owoods2;
	private JButton owoods4;
	private JButton owoods5;
	
	private JButton bvalley1;
	private JButton bvalley2;
	private JButton bvalley4;
	private JButton bvalley5;
	
	private JButton mountain1;
	private JButton mountain2;
	private JButton mountain3;
	private JButton mountain4;
	private JButton mountain5;
	private JButton mountain6;
	
	private JButton dvalley1;
	private JButton dvalley2;
	private JButton dvalley4;
	private JButton dvalley5;
	
	private JButton dwoods1;
	private JButton dwoods2;
	private JButton dwoods3;
	private JButton dwoods4;
	private JButton dwoods5;
	private JButton dwoods6;
	
	private JButton mwoods2;
	private JButton mwoods4;
	private JButton mwoods5;
	
	private JButton caves1;
	private JButton caves2;
	private JButton caves3;
	private JButton caves4;
	private JButton caves5;
	private JButton caves6;
	
	private JButton pwoods2;
	private JButton pwoods4;
	private JButton pwoods5;
	
	private JButton cvalley1;
	private JButton cvalley2;
	private JButton cvalley4;
	private JButton cvalley5;
	
	private JButton nwoods5;
	private JButton nwoods2;
	private JButton nwoods4;
	
	private JButton avalley1;
	private JButton avalley2;
	private JButton avalley4;
	private JButton avalley5;
	
	private JButton lwoods2;
	private JButton lwoods4;
	private JButton lwoods5;

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
		
		cliff1 = new JButton("");
		cliff2 = new JButton("");
		cliff3 = new JButton("");
		cliff4 = new JButton("");
		cliff5 = new JButton("");
		cliff6 = new JButton("");

		cliff1.setSize(30, 30);
		cliff2.setSize(30, 30);
		cliff3.setSize(30, 30);
		cliff4.setSize(30, 30);
		cliff5.setSize(30, 30);
		cliff6.setSize(30, 30);
		
		cliff1.setOpaque(false);
		cliff1.setContentAreaFilled(false);
		cliff2.setOpaque(false);
		cliff2.setContentAreaFilled(false);
		cliff3.setOpaque(false);
		cliff3.setContentAreaFilled(false);
		cliff4.setOpaque(false);
		cliff4.setContentAreaFilled(false);
		cliff5.setOpaque(false);
		cliff5.setContentAreaFilled(false);
		cliff6.setOpaque(false);
		cliff6.setContentAreaFilled(false);

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
