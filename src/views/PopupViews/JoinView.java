package views.PopupViews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import views.MainViews.GameView;
import networking.threads.ProcessingThreads.ClientReadThread;
import networking.threads.ProcessingThreads.ClientWriterThread;

public class JoinView extends javax.swing.JFrame {

    private javax.swing.JButton connectButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField ipAddressField;
    private javax.swing.JTextField portAddressField;
    
	private String hostAddress;
	private JPanel theView;
	private static final long serialVersionUID = 1166000215438136225L;
	
	private GameView parent;
	
	// Constructor For This Class
	public JoinView(GameView parent) {
        try {
        	this.parent = parent;
			hostAddress = InetAddress.getLocalHost().getHostAddress();
			setTitle("Join Game");
			
			// Initialize Everything
			initComponents();
			addListeners();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }       
	
	// Initialize The Components
    private void initComponents() {

        theView = new JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ipAddressField = new javax.swing.JTextField();
        portAddressField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jLabel1.setText("Server Address:");

        jLabel2.setText("Port:");

        ipAddressField.setText(hostAddress);

        portAddressField.setText("100");

        connectButton.setText("Connect");

        cancelButton.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(theView);
        theView.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ipAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(connectButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ipAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(portAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        add(theView);
    }// </editor-fold>                        
    
    // Add In The Listeners To This View
    private void addListeners () {
    	connectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handleConnectButton();
				dispose();
			}
		});
    	
    	cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handleCancelButton();
			}
		});
    }
    
    // Handles The Connect Button
    private void handleConnectButton () {
    	System.out.println("Connect Button Has Been Pressed");
    	try {
    		int portNum = Integer.parseInt(portAddressField.getText());
    	
    		// Start The Client Thread Up
    		ClientWriterThread test = new ClientWriterThread(ipAddressField.getText(), portNum, parent);
    		ClientReadThread reader = new ClientReadThread(test.getInStream(), ipAddressField.getText(), parent);
    		test.start();
    		reader.start();
    	
    		parent.setClientThread(test);
    		parent.setClientReaderThread(reader);

    		parent.setcheatAction(false);	
    		parent.setCheatMode(false);
    		
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(this, "Invalid Input. Please Enter A Number For The Port");
    	}
    }
    
    private void handleCancelButton(){
    	dispose();
    }
}
