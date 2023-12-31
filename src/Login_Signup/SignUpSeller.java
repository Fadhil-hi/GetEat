package Login_Signup;

import SellerDashboard.SellerDashboard;
import Database.DBNeeds;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
public class SignUpSeller extends javax.swing.JFrame {

    /**
     * Creates new form SignInCust
     */
    public SignUpSeller() {
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
        daftarLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        namaTokoLabel = new javax.swing.JLabel();
        daftarButton = new javax.swing.JButton();
        noTelpLabel = new javax.swing.JLabel();
        noTelpField = new javax.swing.JTextField();
        jalanLabel = new javax.swing.JLabel();
        kelurahanLabel = new javax.swing.JLabel();
        kelurahanField = new javax.swing.JTextField();
        kecamatanLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        confirmLabel = new javax.swing.JLabel();
        confirmField = new javax.swing.JPasswordField();
        backButton = new javax.swing.JButton();
        namaTokoField = new javax.swing.JTextField();
        jalanField = new javax.swing.JTextField();
        kecamatanField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        messageLabel = new javax.swing.JLabel();

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
                .addGap(0, 1007, Short.MAX_VALUE)
                .addComponent(closeButton))
        );
        taskbarPanelLayout.setVerticalGroup(
            taskbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taskbarPanelLayout.createSequentialGroup()
                .addComponent(closeButton)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        getContentPane().add(taskbarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 503, -1));

        bodyPanel.setBackground(new java.awt.Color(255, 255, 255));
        bodyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        daftarLabel.setFont(new java.awt.Font("Cambria Math", 0, 48)); // NOI18N
        daftarLabel.setText("Daftar");

        usernameLabel.setText("Username");

        namaTokoLabel.setText("Nama Toko");

        daftarButton.setBackground(new java.awt.Color(102, 204, 255));
        daftarButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        daftarButton.setText("Daftar");
        daftarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarButtonActionPerformed(evt);
            }
        });

        noTelpLabel.setText("Nomor Telepon");

        jalanLabel.setText("Jalan");

        kelurahanLabel.setText("Kelurahan");

        kecamatanLabel.setText("Kecamatan");

        passLabel.setText("Password");

        confirmLabel.setText("Konfirmasi Password");

        confirmField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmFieldActionPerformed(evt);
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

        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });

        messageLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addComponent(daftarLabel)
                .addGap(176, 176, 176))
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageLabel)
                    .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                            .addComponent(daftarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(usernameField)
                        .addComponent(namaTokoLabel)
                        .addComponent(usernameLabel)
                        .addComponent(noTelpField)
                        .addComponent(jalanLabel)
                        .addComponent(noTelpLabel)
                        .addComponent(kelurahanField)
                        .addComponent(kecamatanLabel)
                        .addComponent(kelurahanLabel)
                        .addComponent(confirmField)
                        .addComponent(confirmLabel)
                        .addComponent(passLabel)
                        .addComponent(namaTokoField)
                        .addComponent(jalanField)
                        .addComponent(kecamatanField)
                        .addComponent(passField)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(daftarLabel)
                .addGap(37, 37, 37)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(namaTokoLabel)
                .addGap(15, 15, 15)
                .addComponent(namaTokoField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(noTelpLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noTelpField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jalanLabel)
                .addGap(11, 11, 11)
                .addComponent(jalanField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kelurahanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kelurahanField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kecamatanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kecamatanField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passLabel)
                .addGap(11, 11, 11)
                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageLabel)
                .addGap(47, 47, 47)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(daftarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        getContentPane().add(bodyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 950));

        setSize(new java.awt.Dimension(503, 978));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void confirmFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        RolePage jf2 = new RolePage();
        jf2.show();
        
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private void daftarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarButtonActionPerformed
        String username = usernameField.getText();
        String namaToko = namaTokoField.getText();
        String noTelp = noTelpField.getText();
        String jalan = jalanField.getText();
        String kelurahan = kelurahanField.getText();
        String kecamatan = kecamatanField.getText();
        char [] arrPass1 = passField.getPassword();
        String password1 = new String(arrPass1);
        char [] arrPass2 = confirmField.getPassword();
        String password2 = new String(arrPass2);
        if(password1.equals(password2)){
            DBNeeds.insertPenjual(namaToko, noTelp, jalan, kelurahan, kecamatan, username, password1);
            SellerDashboard Dboard = new SellerDashboard(username);
            Dboard.show();
            dispose();
        } else{
            messageLabel.setText("Password Tidak Cocok");
        }
    }//GEN-LAST:event_daftarButtonActionPerformed

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
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel closeButton;
    private javax.swing.JPasswordField confirmField;
    private javax.swing.JLabel confirmLabel;
    private javax.swing.JButton daftarButton;
    private javax.swing.JLabel daftarLabel;
    private javax.swing.JTextField jalanField;
    private javax.swing.JLabel jalanLabel;
    private javax.swing.JTextField kecamatanField;
    private javax.swing.JLabel kecamatanLabel;
    private javax.swing.JTextField kelurahanField;
    private javax.swing.JLabel kelurahanLabel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextField namaTokoField;
    private javax.swing.JLabel namaTokoLabel;
    private javax.swing.JTextField noTelpField;
    private javax.swing.JLabel noTelpLabel;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPanel taskbarPanel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
