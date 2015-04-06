package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

import views.MainViews.GameView;

public class DialogBase extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -331601846460123149L;
	protected GridBagLayout layout = new GridBagLayout();
	protected GridBagConstraints layoutConstraints = new GridBagConstraints(); 
		
	public DialogBase (GameView parent, String displayName, boolean modal) {
		super(parent, displayName, modal);
	}
	
	//A method for adding other jFrames to this FrameBase
	protected void addToFrame (JDialog connectToFrame, JComponent theComponent, GridBagLayout layout, int x, int y, int gridWidth, int gridHeight){
		layoutConstraints.gridx = x;
		layoutConstraints.gridy = y;
		layoutConstraints.gridwidth = gridWidth;
		layoutConstraints.gridheight = gridHeight;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 5, 10, 5);
		layoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 1.0;
		layout.setConstraints(theComponent, layoutConstraints);
		add(theComponent);
	}
}
