package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class frameBase extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -331601846460123149L;
	protected GridBagLayout layout = new GridBagLayout();
	protected GridBagConstraints layoutConstraints = new GridBagConstraints(); 
		
	protected void addToFrame (JFrame connectToFrame, JComponent theComponent, GridBagLayout layout, int x, int y, int gridWidth, int gridHeight){
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
		connectToFrame.add(theComponent);
	}
}
