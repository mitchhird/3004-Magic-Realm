package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.BoardModels.Clearing;
import models.BoardModels.Dwelling;
import models.characterModels.playerEnums.CharacterClass;
import models.otherEntities.TreasureModel;

public class BoardView extends JPanel {

	private static final long serialVersionUID = -3255182183312639441L;
	
	//Field declarations
	private BufferedImage img;
	private Toolkit tk = Toolkit.getDefaultToolkit();
	
	private float scale = 1;

	private ArrayList<Clearing> clearings = new ArrayList<Clearing>();
	
	private Clearing cliff1 = new Clearing("cl1");
	private Clearing cliff2 = new Clearing("cl2");
	private Clearing cliff3 = new Clearing("cl3");
	private Clearing cliff4 = new Clearing("cl4");
	private Clearing cliff5 = new Clearing("cl5");
	private Clearing cliff6 = new Clearing("cl6");

	private Clearing evalley1 = new Clearing("ev1");
	private Clearing evalley2 = new Clearing("ev2");
	private Clearing evalley4 = new Clearing("ev4");
	private Clearing evalley5 = new Clearing("ev5");
	
	private Clearing hpass1 = new Clearing("hp1");
	private Clearing hpass2 = new Clearing("hp2");
	private Clearing hpass3 = new Clearing("hp3");
	private Clearing hpass4 = new Clearing("hp4");
	private Clearing hpass5 = new Clearing("hp5");
	private Clearing hpass6 = new Clearing("hp6");
	
	private Clearing ledges1 = new Clearing("le1");
	private Clearing ledges2 = new Clearing("le2");
	private Clearing ledges3 = new Clearing("le3");
	private Clearing ledges4 = new Clearing("le4");
	private Clearing ledges5 = new Clearing("le5");
	private Clearing ledges6 = new Clearing("le6");
	
	private Clearing bland1 = new Clearing("bl1");
	private Clearing bland2 = new Clearing("bl2");
	private Clearing bland3 = new Clearing("bl3");
	private Clearing bland4 = new Clearing("bl4");
	private Clearing bland5 = new Clearing("bl5");
	private Clearing bland6 = new Clearing("bl6");
	
	private Clearing cavern1 = new Clearing("ca1");
	private Clearing cavern2 = new Clearing("ca2");
	private Clearing cavern3 = new Clearing("ca3");
	private Clearing cavern4 = new Clearing("ca4");
	private Clearing cavern5 = new Clearing("ca5");
	private Clearing cavern6 = new Clearing("ca6");
	
	private Clearing crag1 = new Clearing("cr1");
	private Clearing crag2 = new Clearing("cr2");
	private Clearing crag3 = new Clearing("cr3");
	private Clearing crag4 = new Clearing("cr4");
	private Clearing crag5 = new Clearing("cr5");
	private Clearing crag6 = new Clearing("cr6");
	
	private Clearing owoods2 = new Clearing("ow2");
	private Clearing owoods4 = new Clearing("ow4");
	private Clearing owoods5 = new Clearing("ow5");
	
	private Clearing bvalley1 = new Clearing("bv1");
	private Clearing bvalley2 = new Clearing("bv2");
	private Clearing bvalley4 = new Clearing("bv4");
	private Clearing bvalley5 = new Clearing("bv5");
	
	private Clearing mountain1 = new Clearing("mo1");
	private Clearing mountain2 = new Clearing("mo2");
	private Clearing mountain3 = new Clearing("mo3");
	private Clearing mountain4 = new Clearing("mo4");
	private Clearing mountain5 = new Clearing("mo5");
	private Clearing mountain6 = new Clearing("mo6");
	
	private Clearing dvalley1 = new Clearing("dv1");
	private Clearing dvalley2 = new Clearing("dv2");
	private Clearing dvalley4 = new Clearing("dv4");
	private Clearing dvalley5 = new Clearing("dv5");
	
	private Clearing dwoods1 = new Clearing("dw1");
	private Clearing dwoods2 = new Clearing("dw2");
	private Clearing dwoods3 = new Clearing("dw3");
	private Clearing dwoods4 = new Clearing("dw4");
	private Clearing dwoods5 = new Clearing("dw5");
	private Clearing dwoods6 = new Clearing("dw6");
	
	private Clearing mwoods2 = new Clearing("mw2");
	private Clearing mwoods4 = new Clearing("mw4");
	private Clearing mwoods5 = new Clearing("mw5");
	
	private Clearing caves1 = new Clearing("cav1");
	private Clearing caves2 = new Clearing("cav2");
	private Clearing caves3 = new Clearing("cav3");
	private Clearing caves4 = new Clearing("cav4");
	private Clearing caves5 = new Clearing("cav5");
	private Clearing caves6 = new Clearing("cav6");
	
	private Clearing pwoods2 = new Clearing("pw2");
	private Clearing pwoods4 = new Clearing("pw4");
	private Clearing pwoods5 = new Clearing("pw5");
	
	private Clearing cvalley1 = new Clearing("cv1");
	private Clearing cvalley2 = new Clearing("cv2");
	private Clearing cvalley4 = new Clearing("cv4");
	private Clearing cvalley5 = new Clearing("cv5");
	
	private Clearing nwoods5 = new Clearing("nw5");
	private Clearing nwoods2 = new Clearing("nw2");
	private Clearing nwoods4 = new Clearing("nw4");
	
	private Clearing ruins1 = new Clearing("ru1");
	private Clearing ruins2 = new Clearing("ru2");
	private Clearing ruins3 = new Clearing("ru3");
	private Clearing ruins4 = new Clearing("ru4");
	private Clearing ruins5 = new Clearing("ru5");
	private Clearing ruins6 = new Clearing("ru6");
	
	private Clearing avalley1 = new Clearing("av1");
	private Clearing avalley2 = new Clearing("av2");
	private Clearing avalley4 = new Clearing("av4");
	private Clearing avalley5 = new Clearing("av5");
	
	private Clearing lwoods2 = new Clearing("lw2");
	private Clearing lwoods4 = new Clearing("lw4");
	private Clearing lwoods5 = new Clearing("lw5");
	
	private Dwelling inn;

	private GameView parent;
	private JFrame hoverFrame = null;
	private HoverView hoverPanel;
	
	//Constructor for the BoardView
	public BoardView (GameView parent){
		init();
		this.parent = parent;
		
		// Now For The Inn
		try {
			Image innImage = ImageIO.read(getClass().getResource("/dwellings_c/inn.gif"));
			inn = new Dwelling(dvalley4, innImage);
			inn.getClearingThisOn().addImageToList(inn.getImageRepresentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Initialization method, sets up the board
	private void init(){
		try {
			img = ImageIO.read(getClass().getResource("/theMap3.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setPreferredSize( new Dimension(1300,1486));
		setLayout(null);
		
		clearings.add(cliff1);
		clearings.add(cliff2);
		clearings.add(cliff3);
		clearings.add(cliff4);
		clearings.add(cliff5);
		clearings.add(cliff6);
		
		clearings.add(evalley1);
		clearings.add(evalley2);
		clearings.add(evalley4);
		clearings.add(evalley5);
		
		clearings.add(hpass1);
		clearings.add(hpass2);
		clearings.add(hpass3);
		clearings.add(hpass4);
		clearings.add(hpass5);
		clearings.add(hpass6);
		
		clearings.add(ledges1);
		clearings.add(ledges2);
		clearings.add(ledges3);
		clearings.add(ledges4);
		clearings.add(ledges5);
		clearings.add(ledges6);
		
		clearings.add(bland1);
		clearings.add(bland2);
		clearings.add(bland3);
		clearings.add(bland4);
		clearings.add(bland5);
		clearings.add(bland6);
		
		clearings.add(cavern1);
		clearings.add(cavern2);
		clearings.add(cavern3);
		clearings.add(cavern4);
		clearings.add(cavern5);
		clearings.add(cavern6);
		
		clearings.add(crag1);
		clearings.add(crag2);
		clearings.add(crag3);
		clearings.add(crag4);
		clearings.add(crag5);
		clearings.add(crag6);
		
		clearings.add(owoods2);
		clearings.add(owoods4);
		clearings.add(owoods5);
		
		clearings.add(bvalley1);
		clearings.add(bvalley2);
		clearings.add(bvalley4);
		clearings.add(bvalley5);
		
		clearings.add(mountain1);
		clearings.add(mountain2);
		clearings.add(mountain3);
		clearings.add(mountain4);
		clearings.add(mountain5);
		clearings.add(mountain6);
		
		clearings.add(dvalley1);
		clearings.add(dvalley2);
		clearings.add(dvalley4);
		clearings.add(dvalley5);
		
		clearings.add(dwoods1);
		clearings.add(dwoods2);
		clearings.add(dwoods3);
		clearings.add(dwoods4);
		clearings.add(dwoods5);
		clearings.add(dwoods6);
		
		clearings.add(mwoods2);
		clearings.add(mwoods4);
		clearings.add(mwoods5);
		
		clearings.add(caves1);
		clearings.add(caves2);
		clearings.add(caves3);
		clearings.add(caves4);
		clearings.add(caves5);
		clearings.add(caves6);
		
		clearings.add(pwoods2);
		clearings.add(pwoods4);
		clearings.add(pwoods5);
		
		clearings.add(cvalley1);
		clearings.add(cvalley2);
		clearings.add(cvalley4);
		clearings.add(cvalley5);
		
		clearings.add(nwoods5);
		clearings.add(nwoods2);
		clearings.add(nwoods4);
		
		clearings.add(ruins1);
		clearings.add(ruins2);
		clearings.add(ruins3);
		clearings.add(ruins4);
		clearings.add(ruins5);
		clearings.add(ruins6);
		
		clearings.add(avalley1);
		clearings.add(avalley2);
		clearings.add(avalley4);
		clearings.add(avalley5);
		
		clearings.add(lwoods2);
		clearings.add(lwoods4);
		clearings.add(lwoods5);
		
		//Adds the components to the board
		for(int i = 0; i < clearings.size(); i++){
			add(clearings.get(i).getButtonTiedToClearing());
		}
		
		initClearings();
		addClearingListeners();	
		addZoomScroller();
	}

	// Adds All Of The Clearing Listeners
	private void addClearingListeners() {
		for (Clearing c: clearings) {
			addListener(c);
		}
	}

	//Initializes the clearings
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

		bland1.addToConnectedClearings(hpass2, bland6);
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
		
		// Temp
		cavern1.addTreasures(new TreasureModel(true), new TreasureModel(false));
	}
	
	//Adds a listener to the clearing that is passed to this function
	private void addListener (final Clearing c) {
		c.getButtonTiedToClearing().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if(parent.getCurrentPlayer() == null){
            		return;
            	}
            	if (parent.getCurrentPlayer().isMoving() && parent.getCurrentPlayer().getCurrentClearing().isVaildMove(c)){
            		parent.getCurrentPlayer().moveToClearing(c);
            		parent.sendMessage(c);
            		
            		// If Player Has No More Movements Then Stop Them
            		if (parent.getCurrentPlayer().getAvailableActions() > 0) {
            			c.highlightConnectedClearings();
            		} else {
            			parent.getCurrentPlayer().setMoving(false);
            		}
            	}
            }
        });
		
		// Display The Images Here
		c.getButtonTiedToClearing().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				handleImageEnter(c);
			}
		});
	}
	
	private void addZoomScroller() {
		addMouseWheelListener(new MouseAdapter() {

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
            	System.out.println(e.getPreciseWheelRotation());
                double delta = 0.057f * e.getPreciseWheelRotation();
                scale += delta;
                scaleButtons();
                revalidate();
                repaint();
            }

        });
	}
	
	private void scaleButtons(){
		int new1;
		int new2;
		for(int i = 0; i < clearings.size();i++){
			new1 = (int) (clearings.get(i).getButtonTiedToClearing().getSize().getWidth()*scale);
			new2 = (int) (clearings.get(i).getButtonTiedToClearing().getSize().getHeight()*scale);
			clearings.get(i).setSize(new1,new2);
			new1 = (int) (clearings.get(i).getButtonTiedToClearing().getLocation().getX()*scale);
			new2 = (int) (clearings.get(i).getButtonTiedToClearing().getLocation().getY()*scale);
			clearings.get(i).setLocation(new1,new2);
		}
	}
	
	// Handles The Mouse Entering The Image
	private void handleImageEnter (Clearing c) {
		
		if(c.getImageEnitiesOnThis().isEmpty() || c.getImageEnitiesOnThis().size() == 1){
			return;
		}
		if(hoverFrame!=null){
			hoverFrame.dispose();
		}
		hoverFrame = new JFrame();
		hoverPanel = new HoverView(c);
		hoverFrame.setSize(160, 250);
		hoverFrame.setLocation(tk.getScreenSize().width/2 - 300, 300);
		hoverFrame.setVisible(true);
		hoverFrame.add(hoverPanel);
	}

	//Overrides the paint component method of jPanel
	@Override
	
	public void paintComponent(Graphics page)
	{
	    super.paintComponent(page);
	    Graphics2D g2d = (Graphics2D) page.create();
        AffineTransform at = new AffineTransform();
        at.scale(scale, scale);
        g2d.drawImage(img, at, this);
        g2d.dispose();
	}
	
	@Override
    public Dimension getPreferredSize() {            
        Dimension size = new Dimension(200, 200);
        if (img != null) {            
            size.width = Math.round(img.getWidth() * scale);
            size.height = Math.round(img.getHeight() * scale);                
        }        
        return size;
    }
	
	//returns the default clearing of a class (always the inn)
	public Clearing getDefaultClearingForClass (CharacterClass c) {
		switch (c) {
		case SWORDSMAN: return inn.getClearingThisOn();
		case AMAZON: return inn.getClearingThisOn();
		case BLACKNIGHT: return inn.getClearingThisOn();
		case CAPTAIN: return inn.getClearingThisOn();
		case DWARF: return inn.getClearingThisOn();
		case ELF: return inn.getClearingThisOn();
		default: return avalley2;
		}
	}
	
	/************************** Getters And Setters **********************/
	public Clearing getClearingByName(String clearingName) {
		// Loop Over The Clearings And Return The One Want To Move To
		for (Clearing c: clearings) {
			if (c.getClearingName().equals(clearingName)) {
				return c;
			}
		}
		return null;
	}
}
