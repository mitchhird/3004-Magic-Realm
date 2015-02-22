package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import models.characterModels.playerEnums.CharacterClass;

public class CardView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3724840708083857909L;
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Image img;

	//constructor for cardview, displays the detailed character stats of the currently selected players class
	public CardView(String valueAt) {
		setSize(600,600);
		setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		setVisible(true);
		CharacterClass charClass = CharacterClass.valueOf(valueAt);
		img = charClass.getDetailImage();
	}
	
	//Overrides the paintComponent method in JPanel
	@Override
	public void paintComponent(Graphics page)
	{
	    super.paintComponent(page);
	    page.drawImage(img, 0, 0, this);
	}
}
