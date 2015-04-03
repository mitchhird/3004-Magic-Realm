package views.PopupViews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.GameUtils;

public class RollView extends javax.swing.JDialog {

	private static final long serialVersionUID = 6220875929681965271L;
	private javax.swing.JButton setButton;
    private javax.swing.JButton randomizeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel maxRollLabel;
    private javax.swing.JTextField desiredRollField;    
    
    private int maxRollValue;
	private int minRollValue;
    
    public RollView(int minRoll,int maxRoll) {
    	super(new JFrame(), "Roll View", true);
        maxRollValue = maxRoll;
        minRollValue = minRoll;
    	initComponents();
    	addListeners();
    }
    
    private void initComponents() {

        setButton = new javax.swing.JButton();
        randomizeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        desiredRollField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        maxRollLabel = new javax.swing.JLabel();
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	dispose();
            }
        });

        setButton.setText("Set");

        randomizeButton.setText("Randomize");

        jLabel1.setText("Desired Roll Value:");

        desiredRollField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        desiredRollField.setText("0");

        jLabel2.setText("Maximum Roll Value:");
       
        maxRollLabel.setText(Integer.toString(maxRollValue));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desiredRollField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(setButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(randomizeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxRollLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(maxRollLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desiredRollField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setButton)
                    .addComponent(randomizeButton))
                .addContainerGap())
        );
        pack();
    }   
    
    private void addListeners() {
    	randomizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handleRandomizeButton();
			}
		});
    	
    	setButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handleSetButton();
			}
		});
    }
    
    public JButton getSetButton(){
    	return setButton;
    }

	private void handleSetButton() {
		if(!(Integer.parseInt(desiredRollField.getText())>Integer.parseInt(maxRollLabel.getText()))){
			GameUtils.setCheatRoll(Integer.parseInt(desiredRollField.getText()));
			dispose();
		}
	}

	private void handleRandomizeButton() {
		Random rand = new Random();
		int randomNum = rand.nextInt((maxRollValue - minRollValue) + 1) + minRollValue;
		desiredRollField.setText(Integer.toString(randomNum));
	}
}