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
	
	private JButton crag1 = new JButton("");
	private JButton crag2 = new JButton("");
	private JButton crag3 = new JButton("");
	private JButton crag4 = new JButton("");
	private JButton crag5 = new JButton("");
	private JButton crag6 = new JButton("");
	
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
	
	private JButton ruins1 = new JButton("");
	private JButton ruins2 = new JButton("");
	private JButton ruins3 = new JButton("");
	private JButton ruins4 = new JButton("");
	private JButton ruins5 = new JButton("");
	private JButton ruins6 = new JButton("");
	
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
		
		theButtons.add(crag1);
		theButtons.add(crag2);
		theButtons.add(crag3);
		theButtons.add(crag4);
		theButtons.add(crag5);
		theButtons.add(crag6);
		
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
		
		theButtons.add(ruins1);
		theButtons.add(ruins2);
		theButtons.add(ruins3);
		theButtons.add(ruins4);
		theButtons.add(ruins5);
		theButtons.add(ruins6);
		
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

		cavern1.setLocation(290,742);
		cavern2.setLocation(262,665);
		cavern3.setLocation(222,708);
		cavern4.setLocation(155,786);
		cavern5.setLocation(185,655);
		cavern6.setLocation(210,768);
		
		crag1.setLocation(764,345);
		crag2.setLocation(800,500);
		crag3.setLocation(828,441);
		crag4.setLocation(730,403);
		crag5.setLocation(748,464);
		crag6.setLocation(816,382);
		
		owoods2.setLocation(561,565);
		owoods4.setLocation(681,621);
		owoods5.setLocation(596,668);
		
		bvalley1.setLocation(500,719);
		bvalley2.setLocation(470,851);
		bvalley4.setLocation(375,802);
		bvalley5.setLocation(423,709);
		
		mountain1.setLocation(248, 999);
		mountain2.setLocation(306, 1040);
		mountain3.setLocation(319, 973);
		mountain4.setLocation(200, 940);
		mountain5.setLocation(337, 900);
		mountain6.setLocation(263, 899);
		
		dvalley1.setLocation(1037, 560);
		dvalley2.setLocation(1091, 508);
		dvalley4.setLocation(1003, 450);
		dvalley5.setLocation(966, 543);
		
		dwoods1.setLocation(782,620);
		dwoods2.setLocation(918,646);
		dwoods3.setLocation(895,730);
		dwoods4.setLocation(760,691);
		dwoods5.setLocation(808,739);
		dwoods6.setLocation(846,680);
		
		mwoods2.setLocation(730,887);
		mwoods4.setLocation(634,898);
		mwoods5.setLocation(695,776);
		
		caves1.setLocation(460,1071);
		caves2.setLocation(493,945);
		caves3.setLocation(518,1004);
		caves4.setLocation(438,1012);
		caves5.setLocation(564,959);
		caves6.setLocation(577,1067);
		
		pwoods2.setLocation(274, 1203);
		pwoods4.setLocation(320, 1126);
		pwoods5.setLocation(412, 1175);

		cvalley1.setLocation(1063, 650);
		cvalley2.setLocation(1010, 700);
		cvalley4.setLocation(1094, 759);
		cvalley5.setLocation(1135, 667);
		
		nwoods2.setLocation(970,945);
		nwoods4.setLocation(876,959);
		nwoods5.setLocation(910,858);
		
		ruins1.setLocation(801,1031);
		ruins2.setLocation(815,1128);
		ruins3.setLocation(699,1129);
		ruins4.setLocation(730,1060);
		ruins5.setLocation(700,1000);
		ruins6.setLocation(760,1120);

		avalley1.setLocation(915,1112);
		avalley2.setLocation(930,1180);
		avalley4.setLocation(1028,1140);
		avalley5.setLocation(968,1058);
		
		lwoods2.setLocation(803,1330);
		lwoods4.setLocation(800,1235);
		lwoods5.setLocation(883,1286);
		
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
		
		evalley1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("evalley1");
            }
        });
		evalley2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("evalley2");
            }
        });	
		evalley4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("evalley4");
            }
        });	
		evalley5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("evalley5");
            }
        });	
		
		hpass1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("hpass1");
            }
        });	
		hpass2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("hpass2");
            }
        });	
		hpass3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("hpass3");
            }
        });	
		hpass4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("hpass4");
            }
        });	
		hpass5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("hpass5");
            }
        });	
		hpass6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("hpass6");
            }
        });	
		
		ledges1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ledges1");
            }
        });	
		ledges2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ledges2");
            }
        });	
		ledges3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ledges3");
            }
        });	
		ledges4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ledges4");
            }
        });	
		ledges5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ledges5");
            }
        });	
		ledges6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ledges6");
            }
        });	
		
		bland1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bland1");
            }
        });	
		bland2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bland2");
            }
        });	
		bland3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bland3");
            }
        });	
		bland4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bland4");
            }
        });	
		bland5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bland5");
            }
        });	
		bland6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bland6");
            }
        });	
		
		cavern1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cavern1");
            }
        });	
		cavern2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cavern2");
            }
        });	
		cavern3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cavern3");
            }
        });
		cavern4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cavern4");
            }
        });	
		cavern5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cavern5");
            }
        });	
		cavern6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cavern6");
            }
        });	
		
		crag1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("crag1");
            }
        });	
		crag2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("crag2");
            }
        });	
		crag3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("crag3");
            }
        });	
		crag4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("crag4");
            }
        });	
		crag5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("crag5");
            }
        });	
		crag6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("crag6");
            }
        });	
		
		owoods2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("owoods2");
            }
        });	
		owoods4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("owoods4");
            }
        });	
		owoods5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("owoods5");
            }
        });	
		
		bvalley1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bvalley1");
            }
        });	
		bvalley2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bvalley2");
            }
        });	
		bvalley4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bvalley4");
            }
        });	
		bvalley5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bvalley5");
            }
        });	
		
		mountain1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mountain1");
            }
        });	
		mountain2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mountain2");
            }
        });	
		mountain3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mountain3");
            }
        });	
		mountain4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mountain4");
            }
        });	
		mountain5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mountain5");
            }
        });	
		mountain6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mountain6");
            }
        });	
		
		dvalley1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dvalley1");
            }
        });	
		dvalley2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dvalley2");
            }
        });	
		dvalley4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dvalley4");
            }
        });	
		dvalley5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dvalley5");
            }
        });	
		
		dwoods1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dwoods1");
            }
        });	
		dwoods2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dwoods2");
            }
        });	
		dwoods3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dwoods3");
            }
        });	
		dwoods4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dwoods4");
            }
        });	
		dwoods5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dwoods5");
            }
        });	
		dwoods6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dwoods6");
            }
        });	
		
		mwoods2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mwoods2");
            }
        });	
		mwoods4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mwoods4");
            }
        });	
		mwoods5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mwoods5");
            }
        });	
		
		caves1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("caves1");
            }
        });	
		caves2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("caves2");
            }
        });	
		caves3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("caves3");
            }
        });	
		caves4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("caves4");
            }
        });	
		caves5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("caves5");
            }
        });	
		caves6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("caves6");
            }
        });	
		
		pwoods2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("pwoods2");
            }
        });	
		pwoods4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("pwoods4");
            }
        });	
		pwoods5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("pwoods5");
            }
        });	
		
		cvalley1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cvalley1");
            }
        });	
		cvalley2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cvalley2");
            }
        });	
		cvalley4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cvalley4");
            }
        });	
		cvalley5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cvalley5");
            }
        });	
		
		nwoods2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("nwoods2");
            }
        });	
		nwoods4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("nwoods4");
            }
        });	
		nwoods5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("nwoods5");
            }
        });	
		
		ruins1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ruins1");
            }
        });	
		ruins2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ruins2");
            }
        });	
		ruins3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ruins3");
            }
        });	
		ruins4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ruins4");
            }
        });	
		ruins5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ruins5");
            }
        });	
		ruins6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ruins6");
            }
        });	
		
		avalley1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("avalley1");
            }
        });	
		avalley2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("avalley2");
            }
        });	
		avalley4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("avalley4");
            }
        });	
		avalley5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("avalley5");
            }
        });	
		
		lwoods2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("lwoods2");
            }
        });	
		lwoods4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("lwoods4");
            }
        });	
		lwoods5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("lwoods5");
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
