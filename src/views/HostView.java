package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import networking.ServerMainThread;

public class HostView extends javax.swing.JFrame {

	private String hostAddress;
	private static final long serialVersionUID = -1426060840272234842L;

    // Variables declaration - do not modify                     
    private javax.swing.JButton hostButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField portField;
    private JPanel theView;
    
	// Constructor For This view
	public HostView() {
        try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
			initComponents();
			addListeners();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
               
	
	// Initialize All of The Components
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        portField = new javax.swing.JTextField();
        hostButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        theView = new JPanel();

        jLabel1.setText("Select Port:");

        jLabel2.setText("Server Address:");

		jLabel3.setText(hostAddress);

        portField.setText("100");

        hostButton.setText("Host");

        cancelButton.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(theView);
        theView.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hostButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hostButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        this.add(theView);
    }// </editor-fold>                        
                 
    // Adds The Listeners To The Game When It Is Called
    private void addListeners () {
    	hostButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handleHostButton();
			}
		});
    	
    	cancelButton.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCancelButton();
			}
    	});
    }
    
    // Handles The Host Button Press
    private void handleHostButton () {
    	
    	System.out.println("Host Button Has Been Pressed");
    	
		// Kick Up The Server Runnable, And Connect This Machine To It
		try {
			int serverPort = Integer.parseInt(portField.getText());
			ServerMainThread test = new ServerMainThread(serverPort);
			test.start();
			
			JOptionPane.showMessageDialog(this, "Server Started On Port " + serverPort);
		} catch (Exception e) {	
			JOptionPane.showMessageDialog(this, "Invalid Port Specified Please Enter A Number");
		}
    }
    
    private void handleCancelButton () {
    	System.out.println("Cancel Button Has Been Pressed");
    }
}
