package Login_Signup;


import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;


public class RolePage extends javax.swing.JFrame {

    /**
     * Creates new form RolePage
     */
    public RolePage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        taskbarPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JLabel();
        bodyPanel = new javax.swing.JPanel();
        courierIcon = new javax.swing.JLabel();
        sebagaiLabel = new javax.swing.JLabel();
        daftarLabel = new javax.swing.JLabel();
        pembeliIcon = new javax.swing.JLabel();
        penjualIcon = new javax.swing.JLabel();
        KurirButton = new javax.swing.JButton();
        pembeliButton = new javax.swing.JButton();
        penjualButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        taskbarPanel.setBackground(new java.awt.Color(255, 255, 255));

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close_35px.png"))); // NOI18N
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout taskbarPanelLayout = new javax.swing.GroupLayout(taskbarPanel);
        taskbarPanel.setLayout(taskbarPanelLayout);
        taskbarPanelLayout.setHorizontalGroup(
            taskbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, taskbarPanelLayout.createSequentialGroup()
                .addContainerGap(680, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );
        taskbarPanelLayout.setVerticalGroup(
            taskbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskbarPanelLayout.createSequentialGroup()
                .addComponent(closeButton)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        getContentPane().add(taskbarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, -1));

        bodyPanel.setBackground(new java.awt.Color(255, 255, 255));

        courierIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/motorcycle_delivery_multiple_boxes_96px.png"))); // NOI18N

        sebagaiLabel.setFont(new java.awt.Font("Cambria Math", 0, 24)); // NOI18N
        sebagaiLabel.setText("Sebagai?");

        daftarLabel.setFont(new java.awt.Font("Cambria Math", 0, 48)); // NOI18N
        daftarLabel.setText("Daftar");

        pembeliIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/budget_96px.png"))); // NOI18N

        penjualIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shop_location_96px.png"))); // NOI18N

        KurirButton.setText("Kurir");
        KurirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KurirButtonActionPerformed(evt);
            }
        });

        pembeliButton.setText("Pembeli");
        pembeliButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pembeliButtonActionPerformed(evt);
            }
        });

        penjualButton.setText("Penjual");
        penjualButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penjualButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(102, 204, 255));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        backButton.setText("Kembali");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(penjualIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(penjualButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                        .addComponent(sebagaiLabel)
                        .addGap(304, 304, 304))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pembeliIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pembeliButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(KurirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(courierIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(77, 77, 77))))
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                    .addContainerGap(309, Short.MAX_VALUE)
                    .addComponent(daftarLabel)
                    .addGap(282, 282, 282)))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(sebagaiLabel)
                .addGap(36, 36, 36)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courierIcon)
                    .addComponent(pembeliIcon)
                    .addComponent(penjualIcon))
                .addGap(18, 18, 18)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(penjualButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KurirButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pembeliButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bodyPanelLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(daftarLabel)
                    .addContainerGap(396, Short.MAX_VALUE)))
        );

        getContentPane().add(bodyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 34, -1, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void penjualButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penjualButtonActionPerformed
        SignUpSeller jf2 = new SignUpSeller();
        jf2.show();
        
        dispose();
    }//GEN-LAST:event_penjualButtonActionPerformed

    private void pembeliButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pembeliButtonActionPerformed
        SignUpCust jf2 = new SignUpCust();
        jf2.show();
        
        dispose();
    }//GEN-LAST:event_pembeliButtonActionPerformed

    private void KurirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KurirButtonActionPerformed
        SignUpCourier jf2 = new SignUpCourier();
        jf2.show();
        
        dispose();
    }//GEN-LAST:event_KurirButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        LoginPage jf2 = new LoginPage();
        jf2.show();

        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RolePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KurirButton;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel closeButton;
    private javax.swing.JLabel courierIcon;
    private javax.swing.JLabel daftarLabel;
    private javax.swing.JButton pembeliButton;
    private javax.swing.JLabel pembeliIcon;
    private javax.swing.JButton penjualButton;
    private javax.swing.JLabel penjualIcon;
    private javax.swing.JLabel sebagaiLabel;
    private javax.swing.JPanel taskbarPanel;
    // End of variables declaration//GEN-END:variables
}