package views.PopupViews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JDialog;

import views.MainViews.BoardView;
import views.MainViews.GameView;
import models.BoardModels.Tile;
import models.characterModels.PlayerBase;

@SuppressWarnings("rawtypes")
public class ChitPlacementView extends JDialog {
	
	private static final long serialVersionUID = 5579711826997490491L;
	
	private javax.swing.JButton placeButton;
    private javax.swing.JButton randomizeButton;
	private javax.swing.JComboBox locationList;
	private javax.swing.JComboBox itemList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;    
    private BoardView ourParent;
    private ArrayList<Tile> theTiles;
    
    @SuppressWarnings("unchecked")
	public ChitPlacementView(String[] theModel1, ArrayList<Tile> newTiles, BoardView theParent) {
    	super(theParent.getParentWindow(),true);
    	initComponents();
        itemList.setModel(new javax.swing.DefaultComboBoxModel(theModel1));
        locationList.setModel(new javax.swing.DefaultComboBoxModel(newTiles.toArray()));
        ourParent = theParent;
        theTiles = newTiles;
        itemList.setEnabled(false);
    }
                         
    @SuppressWarnings("unchecked")
	private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        locationList = new javax.swing.JComboBox();
        itemList = new javax.swing.JComboBox();
        placeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        randomizeButton = new javax.swing.JButton();

        placeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	placeItem();
            }
        });	
        
        randomizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	randomPlaceItem();
            }
        });	
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	dispose();
            }
        });
        
        jLabel1.setText("Item:");

        locationList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        itemList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        placeButton.setText("Place");

        jLabel2.setText("Location:");

        randomizeButton.setText("Randomize");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(locationList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(placeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(randomizeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(itemList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placeButton)
                    .addComponent(randomizeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                           
    
    private void randomPlaceItem() {
    	Random r = new Random();
    	ourParent.addCheatTile(theTiles.get(r.nextInt(20)));
		itemList.removeItemAt(itemList.getSelectedIndex());
		if(itemList.getItemCount()==0){
			ourParent.setCheatLocations();
			dispose();
		}
	}

	private void placeItem() {
    	ourParent.addCheatTile(theTiles.get(locationList.getSelectedIndex()));
		itemList.removeItemAt(itemList.getSelectedIndex());
		if(itemList.getItemCount()==0){
			ourParent.setCheatLocations();
			dispose();
		}
	}

	@SuppressWarnings("unchecked")
	public void setItems(String[] theModel){
        locationList.setModel(new javax.swing.DefaultComboBoxModel(theModel));
    }    
    @SuppressWarnings("unchecked")
	public void setLocations(String[] theModel){
        itemList.setModel(new javax.swing.DefaultComboBoxModel(theModel));
    }
}
