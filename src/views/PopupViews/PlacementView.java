package views.PopupViews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import views.MainViews.BoardView;
import models.BoardModels.Clearing;

@SuppressWarnings("rawtypes")
public class PlacementView extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 5579711826997490491L;
	
	private javax.swing.JButton placeButton;
    private javax.swing.JButton randomizeButton;
	private javax.swing.JComboBox locationList;
	private javax.swing.JComboBox itemList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;    
    private BoardView ourParent;
    private ArrayList<Clearing> theClearings;
    
    @SuppressWarnings("unchecked")
	public PlacementView(String[] theModel1, ArrayList<Clearing> newClearings, BoardView theParent) {
        initComponents();
        itemList.setModel(new javax.swing.DefaultComboBoxModel(theModel1));
        locationList.setModel(new javax.swing.DefaultComboBoxModel(newClearings.toArray()));
        ourParent = theParent;
        theClearings = newClearings;
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
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	dispose();
            }
        });
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
    
    private void placeItem() {
		ourParent.addCheatClearing(theClearings.get(locationList.getSelectedIndex()));
		itemList.removeItemAt(itemList.getSelectedIndex());
		if(itemList.getItemCount()==0){
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
