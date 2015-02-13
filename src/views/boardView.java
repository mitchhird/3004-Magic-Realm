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
import javax.swing.JPanel;

import models.BoardModels.Clearing;
import models.characterModels.PlayerBase;

public class boardView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3255182183312639441L;
	private Image img;
	
	private ArrayList<Clearing> theButtons = new ArrayList<Clearing>();
	
	private Clearing cliff1 = new Clearing();
	private Clearing cliff2 = new Clearing();
	private Clearing cliff3 = new Clearing();
	private Clearing cliff4 = new Clearing();
	private Clearing cliff5 = new Clearing();
	private Clearing cliff6 = new Clearing();

	private Clearing evalley1 = new Clearing();
	private Clearing evalley2 = new Clearing();
	private Clearing evalley4 = new Clearing();
	private Clearing evalley5 = new Clearing();
	
	private Clearing hpass1 = new Clearing();
	private Clearing hpass2 = new Clearing();
	private Clearing hpass3 = new Clearing();
	private Clearing hpass4 = new Clearing();
	private Clearing hpass5 = new Clearing();
	private Clearing hpass6 = new Clearing();
	
	private Clearing ledges1 = new Clearing();
	private Clearing ledges2 = new Clearing();
	private Clearing ledges3 = new Clearing();
	private Clearing ledges4 = new Clearing();
	private Clearing ledges5 = new Clearing();
	private Clearing ledges6 = new Clearing();
	
	private Clearing bland1 = new Clearing();
	private Clearing bland2 = new Clearing();
	private Clearing bland3 = new Clearing();
	private Clearing bland4 = new Clearing();
	private Clearing bland5 = new Clearing();
	private Clearing bland6 = new Clearing();
	
	private Clearing cavern1 = new Clearing();
	private Clearing cavern2 = new Clearing();
	private Clearing cavern3 = new Clearing();
	private Clearing cavern4 = new Clearing();
	private Clearing cavern5 = new Clearing();
	private Clearing cavern6 = new Clearing();
	
	private Clearing crag1 = new Clearing();
	private Clearing crag2 = new Clearing();
	private Clearing crag3 = new Clearing();
	private Clearing crag4 = new Clearing();
	private Clearing crag5 = new Clearing();
	private Clearing crag6 = new Clearing();
	
	private Clearing owoods2 = new Clearing();
	private Clearing owoods4 = new Clearing();
	private Clearing owoods5 = new Clearing();
	
	private Clearing bvalley1 = new Clearing();
	private Clearing bvalley2 = new Clearing();
	private Clearing bvalley4 = new Clearing();
	private Clearing bvalley5 = new Clearing();
	
	private Clearing mountain1 = new Clearing();
	private Clearing mountain2 = new Clearing();
	private Clearing mountain3 = new Clearing();
	private Clearing mountain4 = new Clearing();
	private Clearing mountain5 = new Clearing();
	private Clearing mountain6 = new Clearing();
	
	private Clearing dvalley1 = new Clearing();
	private Clearing dvalley2 = new Clearing();
	private Clearing dvalley4 = new Clearing();
	private Clearing dvalley5 = new Clearing();
	
	private Clearing dwoods1 = new Clearing();
	private Clearing dwoods2 = new Clearing();
	private Clearing dwoods3 = new Clearing();
	private Clearing dwoods4 = new Clearing();
	private Clearing dwoods5 = new Clearing();
	private Clearing dwoods6 = new Clearing();
	
	private Clearing mwoods2 = new Clearing();
	private Clearing mwoods4 = new Clearing();
	private Clearing mwoods5 = new Clearing();
	
	private Clearing caves1 = new Clearing();
	private Clearing caves2 = new Clearing();
	private Clearing caves3 = new Clearing();
	private Clearing caves4 = new Clearing();
	private Clearing caves5 = new Clearing();
	private Clearing caves6 = new Clearing();
	
	private Clearing pwoods2 = new Clearing();
	private Clearing pwoods4 = new Clearing();
	private Clearing pwoods5 = new Clearing();
	
	private Clearing cvalley1 = new Clearing();
	private Clearing cvalley2 = new Clearing();
	private Clearing cvalley4 = new Clearing();
	private Clearing cvalley5 = new Clearing();
	
	private Clearing nwoods5 = new Clearing();
	private Clearing nwoods2 = new Clearing();
	private Clearing nwoods4 = new Clearing();
	
	private Clearing ruins1 = new Clearing();
	private Clearing ruins2 = new Clearing();
	private Clearing ruins3 = new Clearing();
	private Clearing ruins4 = new Clearing();
	private Clearing ruins5 = new Clearing();
	private Clearing ruins6 = new Clearing();
	
	private Clearing avalley1 = new Clearing();
	private Clearing avalley2 = new Clearing();
	private Clearing avalley4 = new Clearing();
	private Clearing avalley5 = new Clearing();
	
	private Clearing lwoods2 = new Clearing();
	private Clearing lwoods4 = new Clearing();
	private Clearing lwoods5 = new Clearing();

	private PlayerBase test;
	
	public boardView(){
		init();
		test = new PlayerBase();
		test.setCurrentClearing(cliff4);
		cliff4.playerMovedToThis(test);
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
			add(theButtons.get(i).getButtonTiedToClearing());
		}
		
		initClearings();
		addClearingListeners();	
	}

	// Adds All Of The Clearing Listeners
	private void addClearingListeners() {
		cliff1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cliff1");
            }
        });	
		cliff2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cliff2");
            }
        });	
		cliff3.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cliff3");
            }
        });	
		cliff4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cliff4");
            }
        });	
		cliff5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cliff5");
            }
        });	
		cliff6.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cliff6");
            	test.moveToClearing(cliff6);
            }
        });	
		
		evalley1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("evalley1");
            }
        });
		evalley2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("evalley2");
            }
        });	
		evalley4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("evalley4");
            }
        });	
		evalley5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("evalley5");
            }
        });	
		
		hpass1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("hpass1");
            }
        });	
		hpass2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("hpass2");
            }
        });	
		hpass3.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("hpass3");
            }
        });	
		hpass4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("hpass4");
            }
        });	
		hpass5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("hpass5");
            }
        });	
		hpass6.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("hpass6");
            }
        });	
		
		ledges1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ledges1");
            }
        });	
		ledges2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ledges2");
            }
        });	
		ledges3.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ledges3");
            }
        });	
		ledges4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ledges4");
            }
        });	
		ledges5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ledges5");
            }
        });	
		ledges6.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ledges6");
            }
        });	
		
		bland1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bland1");
            }
        });	
		bland2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bland2");
            }
        });	
		bland3.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bland3");
            }
        });	
		bland4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bland4");
            }
        });	
		bland5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bland5");
            }
        });	
		bland6.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bland6");
            }
        });	
		
		cavern1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cavern1");
            }
        });	
		cavern2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cavern2");
            }
        });	
		cavern3.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cavern3");
            }
        });
		cavern4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cavern4");
            }
        });	
		cavern5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cavern5");
            }
        });	
		cavern6.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cavern6");
            }
        });	
		
		crag1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("crag1");
            }
        });	
		crag2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("crag2");
            }
        });	
		crag3.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("crag3");
            }
        });	
		crag4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("crag4");
            }
        });	
		crag5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("crag5");
            }
        });	
		crag6.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("crag6");
            }
        });	
		
		owoods2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("owoods2");
            }
        });	
		owoods4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("owoods4");
            }
        });	
		owoods5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("owoods5");
            }
        });	
		
		bvalley1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bvalley1");
            }
        });	
		bvalley2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bvalley2");
            }
        });	
		bvalley4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bvalley4");
            }
        });	
		bvalley5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("bvalley5");
            }
        });	
		
		mountain1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mountain1");
            }
        });	
		mountain2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mountain2");
            }
        });	
		mountain3.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mountain3");
            }
        });	
		mountain4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mountain4");
            }
        });	
		mountain5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mountain5");
            }
        });	
		mountain6.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mountain6");
            }
        });	
		
		dvalley1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dvalley1");
            }
        });	
		dvalley2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dvalley2");
            }
        });	
		dvalley4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dvalley4");
            }
        });	
		dvalley5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dvalley5");
            }
        });	
		
		dwoods1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dwoods1");
            }
        });	
		dwoods2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dwoods2");
            }
        });	
		dwoods3.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dwoods3");
            }
        });	
		dwoods4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dwoods4");
            }
        });	
		dwoods5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dwoods5");
            }
        });	
		dwoods6.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("dwoods6");
            }
        });	
		
		mwoods2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mwoods2");
            }
        });	
		mwoods4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mwoods4");
            }
        });	
		mwoods5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("mwoods5");
            }
        });	
		
		caves1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("caves1");
            }
        });	
		caves2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("caves2");
            }
        });	
		caves3.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("caves3");
            }
        });	
		caves4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("caves4");
            }
        });	
		caves5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("caves5");
            }
        });	
		caves6.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("caves6");
            }
        });	
		
		pwoods2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("pwoods2");
            }
        });	
		pwoods4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("pwoods4");
            }
        });	
		pwoods5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("pwoods5");
            }
        });	
		
		cvalley1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cvalley1");
            }
        });	
		cvalley2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cvalley2");
            }
        });	
		cvalley4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cvalley4");
            }
        });	
		cvalley5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("cvalley5");
            }
        });	
		
		nwoods2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("nwoods2");
            }
        });	
		nwoods4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("nwoods4");
            }
        });	
		nwoods5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("nwoods5");
            }
        });	
		
		ruins1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ruins1");
            }
        });	
		ruins2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ruins2");
            }
        });	
		ruins3.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ruins3");
            }
        });	
		ruins4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ruins4");
            }
        });	
		ruins5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ruins5");
            }
        });	
		ruins6.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("ruins6");
            }
        });	
		
		avalley1.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("avalley1");
            }
        });	
		avalley2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("avalley2");
            }
        });	
		avalley4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("avalley4");
            }
        });	
		avalley5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("avalley5");
            }
        });	
		
		lwoods2.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("lwoods2");
            }
        });	
		lwoods4.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("lwoods4");
            }
        });	
		lwoods5.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	selectLocation("lwoods5");
            }
        });
	}

	private void initClearings() {
		cliff1.setLocation(419, 188);
		cliff2.setLocation(496, 204);
		cliff3.setLocation(473, 134);
		cliff4.setLocation(449, 62);
		cliff5.setLocation(527, 78);
		cliff6.setLocation(400, 120);
		
		cliff1.addToConnectedClearings(cliff1, evalley2);
		cliff2.addToConnectedClearings(ledges3, cliff3);
		cliff3.addToConnectedClearings(cliff6, cliff5, cliff2);
		cliff4.addConnectedClearing(cliff6);
		cliff5.addToConnectedClearings(cliff3, cliff2);		
		cliff6.addToConnectedClearings(cliff1, cliff4, cliff3);
		
		evalley1.setLocation(255,267);
		evalley2.setLocation(355,260);
		evalley4.setLocation(350,355);
		evalley5.setLocation(250,370);
		
		evalley1.addConnectedClearing(evalley4);
		evalley2.addToConnectedClearings(cliff1, evalley5);
		evalley4.addToConnectedClearings(ledges2, evalley1, bland2);
		evalley5.addToConnectedClearings(hpass6, evalley2);
		
		hpass1.setLocation(105,540);
		hpass2.setLocation(210,510);
		hpass3.setLocation(160,555);
		hpass4.setLocation(130,475);
		hpass5.setLocation(65,475);
		hpass6.setLocation(188,435);

		hpass1.addToConnectedClearings(hpass5, hpass4);
		hpass2.addToConnectedClearings(hpass4, bland1);
		hpass3.addToConnectedClearings(hpass6, cavern5);
		hpass4.addToConnectedClearings(hpass1, hpass2);
		hpass5.addConnectedClearing(hpass1);
		hpass6.addToConnectedClearings(hpass3, evalley5);

		ledges1.setLocation(572,321);
		ledges2.setLocation(470,350);
		ledges3.setLocation(515,300);
		ledges4.setLocation(540,372);
		ledges5.setLocation(545,445);
		ledges6.setLocation(628,342);
		
		ledges1.addToConnectedClearings(ledges6, ledges3, ledges4);
		ledges2.addToConnectedClearings(evalley4, ledges5);
		ledges3.addToConnectedClearings(ledges6, ledges1, cliff2);
		ledges4.addToConnectedClearings(bland4, ledges1, ledges6);
		ledges5.addToConnectedClearings(ledges2, owoods2);
		ledges6.addToConnectedClearings(ledges1, ledges3, ledges4);	
		
		bland1.setLocation(285,570);
		bland2.setLocation(385,470);
		bland3.setLocation(315,500);	
		bland4.setLocation(445,613);
		bland5.setLocation(395,590);
		bland6.setLocation(350,558);

		bland1.addToConnectedClearings(hpass2, bland6, bvalley5);
		bland2.addToConnectedClearings(owoods2, bland3, evalley4);
		bland3.addToConnectedClearings(bland2, bland6, bland5);
		bland4.addToConnectedClearings(ledges4, bland5, bland6);
		bland5.addToConnectedClearings(bland3, bland4, cavern2);
		bland6.addToConnectedClearings(bland1, bland3, bland4);
					
		cavern1.setLocation(290,742);		
		cavern2.setLocation(262,665);
		cavern3.setLocation(222,708);
		cavern4.setLocation(155,786);
		cavern5.setLocation(185,655);
		cavern6.setLocation(210,768);
		
		cavern1.addToConnectedClearings(cavern3, cavern4, bvalley4);
		cavern2.addToConnectedClearings(cavern3, bland5);
		cavern3.addToConnectedClearings(cavern1, cavern2, cavern5, cavern6);
		cavern4.addToConnectedClearings(cavern1, cavern5, cavern6);
		cavern5.addToConnectedClearings(cavern3, cavern4, hpass3);
		cavern6.addToConnectedClearings(cavern3, cavern4);
		
		crag1.setLocation(764,345);
		crag2.setLocation(800,500);
		crag3.setLocation(828,441);
		crag4.setLocation(730,403);
		crag5.setLocation(748,464);
		crag6.setLocation(816,382);

		crag1.addToConnectedClearings(crag4, crag6);
		crag2.addToConnectedClearings(crag5, crag3, dwoods1);
		crag3.addToConnectedClearings(crag2, crag5, crag6);
		crag4.addToConnectedClearings(crag1, crag4);
		crag5.addToConnectedClearings(crag3, crag2);
		crag6.addToConnectedClearings(crag3, crag4, crag1);
	
		owoods2.setLocation(561,565);
		owoods4.setLocation(681,621);
		owoods5.setLocation(596,668);
		
		owoods2.addToConnectedClearings(owoods4, bland2, ledges5);
		owoods4.addToConnectedClearings(owoods2, dwoods1);
		owoods5.addToConnectedClearings(bvalley1, mwoods5);
		
		bvalley1.setLocation(500,719);
		bvalley2.setLocation(470,851);
		bvalley4.setLocation(375,802);
		bvalley5.setLocation(423,709);
		
		bvalley1.addToConnectedClearings(bvalley4, owoods5);
		bvalley2.addToConnectedClearings(bvalley5, caves2);
		bvalley4.addToConnectedClearings(cavern1, mountain5);
		bvalley5.addToConnectedClearings(bland1, bland2);
		
		mountain1.setLocation(248, 999);
		mountain2.setLocation(306, 1040);
		mountain3.setLocation(319, 973);
		mountain4.setLocation(200, 940);
		mountain5.setLocation(337, 900);
		mountain6.setLocation(263, 899);
		
		mountain1.addConnectedClearing(mountain3);
		mountain2.addToConnectedClearings(mountain4, mountain5, pwoods4);		
		mountain3.addToConnectedClearings(mountain1, mountain6);
		mountain4.addToConnectedClearings(mountain6, mountain2);
		mountain5.addToConnectedClearings(mountain6, mountain2, bvalley4);
		mountain6.addToConnectedClearings(mountain4, mountain5, mountain3);
		
		dvalley1.setLocation(1037, 560);
		dvalley2.setLocation(1091, 508);
		dvalley4.setLocation(1003, 450);
		dvalley5.setLocation(966, 543);
		
		dvalley1.addToConnectedClearings(cvalley1, dvalley4);
		dvalley2.addToConnectedClearings(dvalley5);
		dvalley4.addToConnectedClearings(dvalley1);
		
		dwoods1.setLocation(782,620);
		dwoods2.setLocation(918,646);
		dwoods3.setLocation(895,730);
		dwoods4.setLocation(760,691);
		dwoods5.setLocation(808,739);
		dwoods6.setLocation(846,680);

		dwoods1.addToConnectedClearings(owoods4, crag2, dwoods6, dwoods4);
		dwoods2.addToConnectedClearings(dwoods3, cvalley2, dvalley5);
		dwoods3.addToConnectedClearings(dwoods6, dwoods5, dwoods2);
		dwoods4.addToConnectedClearings(dwoods1, dwoods5, dwoods6);
		dwoods5.addToConnectedClearings(mwoods5, dwoods4, dwoods3);
		dwoods6.addToConnectedClearings(dwoods1, dwoods4, dwoods3);
	
		mwoods2.setLocation(730,887);
		mwoods4.setLocation(634,898);
		mwoods5.setLocation(695,776);
		
		mwoods2.addToConnectedClearings(nwoods5, mwoods4, ruins5);
		mwoods4.addToConnectedClearings(caves5, mwoods2);
		mwoods5.addToConnectedClearings(owoods5, dwoods5);
			
		caves1.setLocation(460,1071);
		caves2.setLocation(493,945);
		caves3.setLocation(518,1004);
		caves4.setLocation(438,1012);
		caves5.setLocation(564,959);
		caves6.setLocation(577,1067);
		
		caves1.addToConnectedClearings(caves6, pwoods5);
		caves2.addToConnectedClearings(caves3, caves4, bvalley2);
		caves3.addToConnectedClearings(caves2, caves5);
		caves4.addToConnectedClearings(caves2, caves6);
		caves5.addToConnectedClearings(mwoods5, caves3);
		caves6.addToConnectedClearings(caves4, caves1);
		
		pwoods2.setLocation(274, 1203);
		pwoods4.setLocation(320, 1126);
		pwoods5.setLocation(412, 1175);
		
		pwoods2.addToConnectedClearings(pwoods4);
		pwoods4.addToConnectedClearings(pwoods2, mountain2);
		pwoods5.addToConnectedClearings(caves1);		

		cvalley1.setLocation(1063, 650);
		cvalley2.setLocation(1010, 700);
		cvalley4.setLocation(1094, 759);
		cvalley5.setLocation(1135, 667);
		
		cvalley1.addToConnectedClearings(dvalley1, cvalley4);
		cvalley2.addToConnectedClearings(dwoods2, cvalley5);
		cvalley4.addToConnectedClearings(nwoods5, cvalley1);
		cvalley5.addConnectedClearing(cvalley2);
				
		nwoods2.setLocation(970,945);
		nwoods4.setLocation(876,959);
		nwoods5.setLocation(910,858);
		
		nwoods2.addToConnectedClearings(nwoods4, avalley5);
		nwoods4.addToConnectedClearings(ruins1, nwoods2);
		nwoods5.addToConnectedClearings(cvalley4, mwoods2);
				
		ruins1.setLocation(801,1031);
		ruins2.setLocation(815,1128);
		ruins3.setLocation(699,1129);
		ruins4.setLocation(730,1060);
		ruins5.setLocation(700,1000);
		ruins6.setLocation(760,1120);
		
		ruins1.addToConnectedClearings(ruins5, nwoods4, ruins2, ruins4);
		ruins2.addToConnectedClearings(ruins1, lwoods4, avalley1);
		ruins3.addToConnectedClearings(ruins6, ruins5);
		ruins4.addToConnectedClearings(ruins1, ruins6);
		ruins5.addToConnectedClearings(ruins3, mwoods2, ruins1);
		ruins6.addToConnectedClearings(ruins3, ruins4);
		
		avalley1.setLocation(915,1112);
		avalley2.setLocation(930,1180);
		avalley4.setLocation(1028,1140);
		avalley5.setLocation(968,1058);

		avalley1.addToConnectedClearings(ruins2, avalley4);
		avalley2.addToConnectedClearings(lwoods5, avalley5);
		avalley4.addConnectedClearing(avalley1);
		avalley5.addToConnectedClearings(avalley2, nwoods2);
		
		lwoods2.setLocation(803,1330);
		lwoods4.setLocation(800,1235);
		lwoods5.setLocation(883,1286);

		lwoods2.addConnectedClearing(lwoods4);
		lwoods4.addToConnectedClearings(lwoods2, ruins2);		
		lwoods5.addConnectedClearing(avalley2);
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
