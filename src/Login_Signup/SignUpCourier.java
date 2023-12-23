package Login_Signup;

import CourierDashboard.CourierDashboard;
import Database.DBNeeds;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
public class SignUpCourier extends javax.swing.JFrame {

    /**
     * Creates new form SignInCust
     */
    public SignUpCourier() {
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
        nameLabel = new javax.swing.JLabel();
        daftarButton = new javax.swing.JButton();
        noTelpLabel = new javax.swing.JLabel();
        noTelpField = new javax.swing.JTextField();
        vhclNameLabel = new javax.swing.JLabel();
        vhclNumberLabel = new javax.swing.JLabel();
        platNomorField = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        confirmLabel = new javax.swing.JLabel();
        confirmField = new javax.swing.JPasswordField();
        jkField = new javax.swing.JLabel();
        jkComboBox = new javax.swing.JComboBox<>();
        backButton = new javax.swing.JButton();
        namaField = new javax.swing.JTextField();
        namaKendaraanField = new javax.swing.JTextField();
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

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        nameLabel.setText("Nama");

        daftarButton.setBackground(new java.awt.Color(102, 204, 255));
        daftarButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        daftarButton.setText("Daftar");
        daftarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarButtonActionPerformed(evt);
            }
        });

        noTelpLabel.setText("Nomor Telepon");

        vhclNameLabel.setText("Nama Kendaraan");

        vhclNumberLabel.setText("Plat Nomor");

        passLabel.setText("Password");

        confirmLabel.setText("Konfirmasi Password");

        confirmField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmFieldActionPerformed(evt);
            }
        });

        jkField.setText("Jenis Kelamin");

        jkComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan", }));

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
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(daftarLabel))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(messageLabel)
                            .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(bodyPanelLayout.createSequentialGroup()
                                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(daftarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(usernameField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(noTelpField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(vhclNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(noTelpLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(platNomorField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(vhclNumberLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(confirmField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(confirmLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(passLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jkField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jkComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 392, Short.MAX_VALUE)
                                .addComponent(namaField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(namaKendaraanField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(passField, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(daftarLabel)
                .addGap(36, 36, 36)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nameLabel)
                .addGap(15, 15, 15)
                .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jkField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(noTelpLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noTelpField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vhclNameLabel)
                .addGap(11, 11, 11)
                .addComponent(namaKendaraanField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vhclNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(platNomorField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(30, 30, 30)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(daftarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(bodyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        setSize(new java.awt.Dimension(503, 962));
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

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void daftarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarButtonActionPerformed
        String nama = namaField.getText();
        String username = usernameField.getText();
        String noTelp = noTelpField.getText();
        String jk = (String) jkComboBox.getSelectedItem();
        String namaKendaraan = namaKendaraanField.getText();
        String platNomor = platNomorField.getText();
        char [] arrPass1 = passField.getPassword();
        String password1 = new String(arrPass1);
        char [] arrPass2 = confirmField.getPassword();
        String password2 = new String(arrPass2);
        if(password1.equals(password2)){
            DBNeeds.insertKurir(nama, noTelp, jk, namaKendaraan, platNomor, username, password1);
            CourierDashboard Dboard = new CourierDashboard(username);
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
    private javax.swing.JComboBox<String> jkComboBox;
    private javax.swing.JLabel jkField;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextField namaField;
    private javax.swing.JTextField namaKendaraanField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField noTelpField;
    private javax.swing.JLabel noTelpLabel;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTextField platNomorField;
    private javax.swing.JPanel taskbarPanel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel vhclNameLabel;
    private javax.swing.JLabel vhclNumberLabel;
    // End of variables declaration//GEN-END:variables
}