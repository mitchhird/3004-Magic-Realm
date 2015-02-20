package views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import models.BoardModels.Clearing;

public class HoverView extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3848876528704176024L;
	
	private ArrayList<Image> imageList;

	private int currentSelection;
	
    // Variables declaration                     
    private javax.swing.JButton backButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel counterLabel;
    // End of variables declaration      
    
	public HoverView(Clearing c) {
		initComponents();
		imageList = c.getImageEnitiesOnThis();
		currentSelection = 1;
		if(imageList!=null && imageList.size()>0){
			setLabel(imageList.get(0));
			setCounter(imageList.size(), currentSelection);
		}
	}
	
	private void setCounter(int size, int current){
		counterLabel.setText(current + "/" + size);
	}
	
	private void setLabel(Image image){
		ImageIcon icon = new ImageIcon(image); 
		imageLabel.setIcon(icon);
	}
	
	private void initComponents() {

        imageLabel = new javax.swing.JLabel();
        counterLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                back();
            }
        });
        
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	next();
            }
        });
        
        imageLabel.setText("");

        counterLabel.setText("");

        backButton.setText("Back");

        nextButton.setText("Next");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextButton))
                            .addComponent(counterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(counterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(nextButton)))
        );
    }

	private void next() {
		if(currentSelection < imageList.size()){
			currentSelection++;
			setLabel(imageList.get(currentSelection-1));
			setCounter(imageList.size(),currentSelection);
		}
	}

	private void back() {
		if(currentSelection > 1){
			currentSelection--;
			setLabel(imageList.get(currentSelection-1));
			setCounter(imageList.size(),currentSelection);
		}
	}                   
             
}
