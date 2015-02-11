package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class boardView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3255182183312639441L;
	private Image img;
	
	private ArrayList<JButton> theButtons = new ArrayList<JButton>();
	
	private JButton cliff1 = new JButton("");
	private JButton cliff2 = new JButton("");
	private JButton cliff3 = new JButton("");
	private JButton cliff4 = new JButton("");
	private JButton cliff5 = new JButton("");
	private JButton cliff6 = new JButton("");

	private JButton evalley1 = new JButton("");
	private JButton evalley2 = new JButton("");
	private JButton evalley4 = new JButton("");
	private JButton evalley5 = new JButton("");
	
	private JButton hpass1 = new JButton("");
	private JButton hpass2 = new JButton("");
	private JButton hpass3 = new JButton("");
	private JButton hpass4 = new JButton("");
	private JButton hpass5 = new JButton("");
	private JButton hpass6 = new JButton("");
	
	private JButton ledges1 = new JButton("");
	private JButton ledges2 = new JButton("");
	private JButton ledges3 = new JButton("");
	private JButton ledges4 = new JButton("");
	private JButton ledges5 = new JButton("");
	private JButton ledges6 = new JButton("");
	
	private JButton bland1 = new JButton("");
	private JButton bland2 = new JButton("");
	private JButton bland3 = new JButton("");
	private JButton bland4 = new JButton("");
	private JButton bland5 = new JButton("");
	private JButton bland6 = new JButton("");
	
	private JButton cavern1 = new JButton("");
	private JButton cavern2 = new JButton("");
	private JButton cavern3 = new JButton("");
	private JButton cavern4 = new JButton("");
	private JButton cavern5 = new JButton("");
	private JButton cavern6 = new JButton("");
	
	private JButton carg1 = new JButton("");
	private JButton carg2 = new JButton("");
	private JButton carg3 = new JButton("");
	private JButton carg4 = new JButton("");
	private JButton carg5 = new JButton("");
	private JButton carg6 = new JButton("");
	
	private JButton owoods2 = new JButton("");
	private JButton owoods4 = new JButton("");
	private JButton owoods5 = new JButton("");
	
	private JButton bvalley1 = new JButton("");
	private JButton bvalley2 = new JButton("");
	private JButton bvalley4 = new JButton("");
	private JButton bvalley5 = new JButton("");
	
	private JButton mountain1 = new JButton("");
	private JButton mountain2 = new JButton("");
	private JButton mountain3 = new JButton("");
	private JButton mountain4 = new JButton("");
	private JButton mountain5 = new JButton("");
	private JButton mountain6 = new JButton("");
	
	private JButton dvalley1 = new JButton("");
	private JButton dvalley2 = new JButton("");
	private JButton dvalley4 = new JButton("");
	private JButton dvalley5 = new JButton("");
	
	private JButton dwoods1 = new JButton("");
	private JButton dwoods2 = new JButton("");
	private JButton dwoods3 = new JButton("");
	private JButton dwoods4 = new JButton("");
	private JButton dwoods5 = new JButton("");
	private JButton dwoods6 = new JButton("");
	
	private JButton mwoods2 = new JButton("");
	private JButton mwoods4 = new JButton("");
	private JButton mwoods5 = new JButton("");
	
	private JButton caves1 = new JButton("");
	private JButton caves2 = new JButton("");
	private JButton caves3 = new JButton("");
	private JButton caves4 = new JButton("");
	private JButton caves5 = new JButton("");
	private JButton caves6 = new JButton("");
	
	private JButton pwoods2 = new JButton("");
	private JButton pwoods4 = new JButton("");
	private JButton pwoods5 = new JButton("");
	
	private JButton cvalley1 = new JButton("");
	private JButton cvalley2 = new JButton("");
	private JButton cvalley4 = new JButton("");
	private JButton cvalley5 = new JButton("");
	
	private JButton nwoods5 = new JButton("");
	private JButton nwoods2 = new JButton("");
	private JButton nwoods4 = new JButton("");
	
	private JButton avalley1 = new JButton("");
	private JButton avalley2 = new JButton("");
	private JButton avalley4 = new JButton("");
	private JButton avalley5 = new JButton("");
	
	private JButton lwoods2 = new JButton("");
	private JButton lwoods4 = new JButton("");
	private JButton lwoods5 = new JButton("");

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
		
		theButtons.add(cliff1);
		theButtons.add(cliff2);
		theButtons.add(cliff3);
		theButtons.add(cliff4);
		theButtons.add(cliff5);
		theButtons.add(cliff6);
		
		theButtons.add(evalley1);
		theButtons.add(evalley2);
		theButtons.add(evalley4);
		theButtons.add(evalley5);
		
		theButtons.add(hpass1);
		theButtons.add(hpass2);
		theButtons.add(hpass3);
		theButtons.add(hpass4);
		theButtons.add(hpass5);
		theButtons.add(hpass6);
		
		theButtons.add(ledges1);
		theButtons.add(ledges2);
		theButtons.add(ledges3);
		theButtons.add(ledges4);
		theButtons.add(ledges5);
		theButtons.add(ledges6);
		
		theButtons.add(bland1);
		theButtons.add(bland2);
		theButtons.add(bland3);
		theButtons.add(bland4);
		theButtons.add(bland5);
		theButtons.add(bland6);
		
		theButtons.add(cavern1);
		theButtons.add(cavern2);
		theButtons.add(cavern3);
		theButtons.add(cavern4);
		theButtons.add(cavern5);
		theButtons.add(cavern6);
		
		theButtons.add(carg1);
		theButtons.add(carg2);
		theButtons.add(carg3);
		theButtons.add(carg4);
		theButtons.add(carg5);
		theButtons.add(carg6);
		
		theButtons.add(owoods2);
		theButtons.add(owoods4);
		theButtons.add(owoods5);
		
		theButtons.add(bvalley1);
		theButtons.add(bvalley2);
		theButtons.add(bvalley4);
		theButtons.add(bvalley5);
		
		theButtons.add(mountain1);
		theButtons.add(mountain2);
		theButtons.add(mountain3);
		theButtons.add(mountain4);
		theButtons.add(mountain5);
		theButtons.add(mountain6);
		
		theButtons.add(dvalley1);
		theButtons.add(dvalley2);
		theButtons.add(dvalley4);
		theButtons.add(dvalley5);
		
		theButtons.add(dwoods1);
		theButtons.add(dwoods2);
		theButtons.add(dwoods3);
		theButtons.add(dwoods4);
		theButtons.add(dwoods5);
		theButtons.add(dwoods6);
		
		theButtons.add(mwoods2);
		theButtons.add(mwoods4);
		theButtons.add(mwoods5);
		
		theButtons.add(caves1);
		theButtons.add(caves2);
		theButtons.add(caves3);
		theButtons.add(caves4);
		theButtons.add(caves5);
		theButtons.add(caves6);
		
		theButtons.add(pwoods2);
		theButtons.add(pwoods4);
		theButtons.add(pwoods5);
		
		theButtons.add(cvalley1);
		theButtons.add(cvalley2);
		theButtons.add(cvalley4);
		theButtons.add(cvalley5);
		
		theButtons.add(nwoods5);
		theButtons.add(nwoods2);
		theButtons.add(nwoods4);
		
		theButtons.add(avalley1);
		theButtons.add(avalley2);
		theButtons.add(avalley4);
		theButtons.add(avalley5);
		
		theButtons.add(lwoods2);
		theButtons.add(lwoods4);
		theButtons.add(lwoods5);

		for(int i = 0; i < theButtons.size(); i++){
			theButtons.get(i).setSize(30, 30);
			theButtons.get(i).setOpaque(false);
			theButtons.get(i).setContentAreaFilled(false);
			add(theButtons.get(i));
		}
		
		cliff1.setLocation(419, 188);
		cliff2.setLocation(496, 204);
		cliff3.setLocation(473, 134);
		cliff4.setLocation(449, 62);
		cliff5.setLocation(527, 78);
		cliff6.setLocation(400, 120);
	
		evalley1.setLocation(255,267);
		evalley2.setLocation(355,260);
		evalley4.setLocation(350,355);
		evalley5.setLocation(250,370);
		
		hpass1.setLocation(105,540);
		hpass2.setLocation(210,510);
		hpass3.setLocation(160,555);
		hpass4.setLocation(130,475);
		hpass5.setLocation(65,475);
		hpass6.setLocation(188,435);
		
		ledges1.setLocation(572,321);
		ledges2.setLocation(470,350);
		ledges3.setLocation(515,300);
		ledges4.setLocation(540,372);
		ledges5.setLocation(545,445);
		ledges6.setLocation(628,342);
		
		bland1.setLocation(285,570);
		bland2.setLocation(385,470);
		bland3.setLocation(315,500);	
		bland4.setLocation(445,613);
		bland5.setLocation(395,590);
		bland6.setLocation(350,558);

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
