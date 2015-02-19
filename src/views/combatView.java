package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class combatView extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -611514956127664758L;
    // Variables declaration - do not modify                     
    private javax.swing.JButton enemy1Button;
    private javax.swing.JButton chargeButton;
    private javax.swing.JButton dodgeButton;
    private javax.swing.JButton duckButton;
    private javax.swing.JButton runButton;
    private javax.swing.JButton alertButton;
    private javax.swing.JButton activateButton;
    private javax.swing.JButton abandonButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton endButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton enemy2Button;
    private javax.swing.JButton enemy3Button;
    private javax.swing.JButton enemy4Button;
    private javax.swing.JButton enemy5Button;
    private javax.swing.JButton enemy6Button;
    private javax.swing.JButton thrustButton;
    private javax.swing.JButton swingButton;
    private javax.swing.JButton smashButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel smashShield;
    private javax.swing.JLabel swindShield;
    private javax.swing.JLabel thrustShield;
    private javax.swing.JLabel suitOfArmor;
    private javax.swing.JLabel breastPlate;
    private javax.swing.JLabel helmet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;  
    
    public combatView() {
        initComponents();
    }
                     
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        enemy1Button = new javax.swing.JButton();
        enemy2Button = new javax.swing.JButton();
        enemy3Button = new javax.swing.JButton();
        enemy4Button = new javax.swing.JButton();
        enemy5Button = new javax.swing.JButton();
        enemy6Button = new javax.swing.JButton();
        thrustButton = new javax.swing.JButton();
        swingButton = new javax.swing.JButton();
        smashButton = new javax.swing.JButton();
        chargeButton = new javax.swing.JButton();
        dodgeButton = new javax.swing.JButton();
        duckButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        runButton = new javax.swing.JButton();
        alertButton = new javax.swing.JButton();
        activateButton = new javax.swing.JButton();
        abandonButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        endButton = new javax.swing.JButton();
        smashShield = new javax.swing.JLabel();
        swindShield = new javax.swing.JLabel();
        thrustShield = new javax.swing.JLabel();
        suitOfArmor = new javax.swing.JLabel();
        breastPlate = new javax.swing.JLabel();
        helmet = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        
        enemy1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("enemy1 pressed");
            }
        });
        enemy2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("enemy2 pressed");
            }
        });
        enemy3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("enemy3 pressed");
            }
        });
        enemy4Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("enemy4 pressed");
            }
        });
        enemy5Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("enemy5 pressed");
            }
        });
        enemy6Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("enemy6 pressed");
            }
        });
        
        thrustButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("thrust pressed");
            }
        });
        swingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("swing pressed");
            }
        });
        smashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("smash pressed");
            }
        });
        dodgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("dodge pressed");
            }
        });
        duckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("duck pressed");
            }
        });
        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("run pressed");
            }
        });
        
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("next pressed");
            }
        });
        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("end pressed");
            }
        });
        alertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("alert pressed");
            }
        });
        activateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("activate pressed");
            }
        });
        abandonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("abandon pressed");
            }
        });
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("reset pressed");
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        enemy1Button.setText("Enemy 1");

        enemy2Button.setText("Enemy 2");

        enemy3Button.setText("Enemy 3");

        enemy4Button.setText("Enemy 4");

        enemy5Button.setText("Enemy 5");

        enemy6Button.setText("Enemy 6");

        thrustButton.setText("Thrust");

        swingButton.setText("Swing");

        smashButton.setText("Smash");

        chargeButton.setText("Charge");

        dodgeButton.setText("Dodge");

        duckButton.setText("Duck");

        jLabel1.setText("Defences:");

        jLabel2.setText("Attacks:");

        runButton.setText("Run");

        alertButton.setText("Alert Wepon/Chit");

        activateButton.setText("Activate/Inactivate");

        abandonButton.setText("Abandon Belongings");

        nextButton.setText("Next");

        endButton.setText("End");

        smashShield.setText("Smash Shield");

        swindShield.setText("Swing Shield");

        thrustShield.setText("Thrust Shield");

        suitOfArmor.setText("Suit of Armor");

        breastPlate.setText("Breastplate");

        helmet.setText("Helmet");

        resetButton.setText("Reset");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enemy5Button)
                            .addComponent(enemy4Button)
                            .addComponent(enemy3Button)
                            .addComponent(enemy6Button)
                            .addComponent(enemy1Button)
                            .addComponent(enemy2Button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(duckButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(thrustButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(smashButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(swingButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(activateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(alertButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(endButton))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(thrustShield)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chargeButton))))
                            .addComponent(suitOfArmor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(breastPlate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(helmet, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(resetButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(runButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(smashShield)
                                    .addComponent(abandonButton)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(swindShield)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dodgeButton)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(enemy1Button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enemy2Button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enemy3Button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enemy4Button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enemy5Button))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(swingButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(smashButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thrustButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enemy6Button)
                            .addComponent(duckButton)
                            .addComponent(smashShield))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dodgeButton)
                            .addComponent(swindShield))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chargeButton)
                            .addComponent(thrustShield))
                        .addGap(26, 26, 26)
                        .addComponent(helmet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(breastPlate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suitOfArmor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(abandonButton)
                            .addComponent(runButton)
                            .addComponent(resetButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(activateButton)
                            .addComponent(endButton)
                            .addComponent(nextButton)
                            .addComponent(alertButton)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        
    }
    
    public void setEnemies(String enemy1, String enemy2, String enemy3, String enemy4, String enemy5, String enemy6){
    	if(enemy1==""){
    		enemy1Button.setVisible(false);
    	}
    	enemy1Button.setText(enemy1);
    	if(enemy2==""){
       		enemy2Button.setVisible(false);
    	}
    	enemy2Button.setText(enemy2);
    	if(enemy3==""){
    		enemy3Button.setVisible(false);
    	}
    	enemy3Button.setText(enemy3);
    	if(enemy4==""){
    		enemy4Button.setVisible(false);
    	}
    	enemy4Button.setText(enemy4);
    	if(enemy5==""){
    		enemy5Button.setVisible(false);
    	}
    	enemy5Button.setText(enemy5);
    	if(enemy6==""){
    		enemy6Button.setVisible(false);
    	}
    	enemy6Button.setText(enemy6);
    }
    
    public void setArmor(String suit, String breast, String newHelmet){
    	suitOfArmor.setText(suit);
    	breastPlate.setText(breast);
    	helmet.setText(newHelmet);
    }
    
    public void println(String theLine){
    	textArea.append(theLine + "\n");
    }
    
}
