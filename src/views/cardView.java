package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class cardView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3724840708083857909L;
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Image img;

	public cardView(String valueAt) {
		
		setSize(600,600);
		setLocation(((int)tk.getScreenSize().getWidth()/2) - 300, ((int)tk.getScreenSize().getHeight()/2) - 300);
		setVisible(true);
		
		if(valueAt == "AMAZON"){
			try {
				img = ImageIO.read(new File(System.getProperty("user.dir")+"/images/characterdetail", "amazon.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(valueAt == "AMAZON"){
			try {
				img = ImageIO.read(new File(System.getProperty("user.dir")+"/images/characterdetail", "berzerker.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(valueAt == "BLACKNIGHT"){
			try {
				img = ImageIO.read(new File(System.getProperty("user.dir")+"/images/characterdetail", "black_knight.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(valueAt == "CAPTAIN"){
			try {
				img = ImageIO.read(new File(System.getProperty("user.dir")+"/images/characterdetail", "captain.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(valueAt == "DWARF"){
			try {
				img = ImageIO.read(new File(System.getProperty("user.dir")+"/images/characterdetail", "dwarf.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(valueAt == "ELF"){
			try {
				img = ImageIO.read(new File(System.getProperty("user.dir")+"/images/characterdetail", "elf.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(valueAt == "SWORDSMAN"){
			try {
				img = ImageIO.read(new File(System.getProperty("user.dir")+"/images/characterdetail", "swordsman.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics page)
	{
	    super.paintComponent(page);
	    page.drawImage(img, 0, 0, this);
	}
}
