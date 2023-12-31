package SellerDashboard;


import Login_Signup.LoginPage;
import AdminDashboard.CRUDPenjual;
import AdminDashboard.AdminDashboardMenu;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.UIManager;

public class SellerDashboard extends javax.swing.JFrame {

    Color defaultColor, clickedColor;
    private static String username;
    
    public SellerDashboard(String username) {
        this.username = username;
        initComponents();
        defaultColor = new Color(13,16,51);
        clickedColor = new Color(240,151,57);
        
        menuPanel2.setBackground(defaultColor);
        menuPanel3.setBackground(defaultColor);
        menuPanel4.setBackground(defaultColor);
        menuPanel1.setBackground(defaultColor);
        subTitleLabel.setText("Selamat Datang!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orangeTitleBar = new javax.swing.JPanel();
        closeButton = new javax.swing.JLabel();
        menuIcon = new javax.swing.JLabel();
        subTitleLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dashBoardPanel = new javax.swing.JPanel();
        menuPanel2 = new javax.swing.JPanel();
        CRUDLabel1 = new javax.swing.JLabel();
        menuPanel3 = new javax.swing.JPanel();
        menuLabel2 = new javax.swing.JLabel();
        menuPanel4 = new javax.swing.JPanel();
        CrudLabel3 = new javax.swing.JLabel();
        menuPanel1 = new javax.swing.JPanel();
        CRUDLabel4 = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        whitePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orangeTitleBar.setBackground(new java.awt.Color(240, 151, 57));
        orangeTitleBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close_35px.png"))); // NOI18N
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });
        orangeTitleBar.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, -1, -1));

        menuIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xbox_menu_50px.png"))); // NOI18N
        orangeTitleBar.add(menuIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, 50));

        subTitleLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        subTitleLabel.setText("CRUD Penjual");
        orangeTitleBar.add(subTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgonline-com-ua-resize-0pocG7FZKpHe7c.png"))); // NOI18N
        orangeTitleBar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Dashboard Penjual");
        orangeTitleBar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, -1, -1));

        getContentPane().add(orangeTitleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 110));

        dashBoardPanel.setBackground(new java.awt.Color(13, 16, 51));

        menuPanel2.setBackground(new java.awt.Color(13, 16, 51));
        menuPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPanel2MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPanel2MouseClicked(evt);
            }
        });

        CRUDLabel1.setBackground(new java.awt.Color(13, 16, 51));
        CRUDLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CRUDLabel1.setForeground(new java.awt.Color(255, 255, 255));
        CRUDLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add_50px.png"))); // NOI18N
        CRUDLabel1.setText("Tambah Produk");

        javax.swing.GroupLayout menuPanel2Layout = new javax.swing.GroupLayout(menuPanel2);
        menuPanel2.setLayout(menuPanel2Layout);
        menuPanel2Layout.setHorizontalGroup(
            menuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CRUDLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        menuPanel2Layout.setVerticalGroup(
            menuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CRUDLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        menuPanel3.setBackground(new java.awt.Color(13, 16, 51));
        menuPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPanel3MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPanel3MouseClicked(evt);
            }
        });

        menuLabel2.setBackground(new java.awt.Color(13, 16, 51));
        menuLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        menuLabel2.setForeground(new java.awt.Color(255, 255, 255));
        menuLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/purchase_order_50px.png"))); // NOI18N
        menuLabel2.setText("Pesanan");

        javax.swing.GroupLayout menuPanel3Layout = new javax.swing.GroupLayout(menuPanel3);
        menuPanel3.setLayout(menuPanel3Layout);
        menuPanel3Layout.setHorizontalGroup(
            menuPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        menuPanel3Layout.setVerticalGroup(
            menuPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        menuPanel4.setBackground(new java.awt.Color(13, 16, 51));
        menuPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPanel4MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPanel4MouseClicked(evt);
            }
        });

        CrudLabel3.setBackground(new java.awt.Color(13, 16, 51));
        CrudLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CrudLabel3.setForeground(new java.awt.Color(255, 255, 255));
        CrudLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SellerDashboard/order_history_50px.png"))); // NOI18N
        CrudLabel3.setText("Riwayat Pesanan");

        javax.swing.GroupLayout menuPanel4Layout = new javax.swing.GroupLayout(menuPanel4);
        menuPanel4.setLayout(menuPanel4Layout);
        menuPanel4Layout.setHorizontalGroup(
            menuPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CrudLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        menuPanel4Layout.setVerticalGroup(
            menuPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CrudLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        menuPanel1.setBackground(new java.awt.Color(13, 16, 51));
        menuPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPanel1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPanel1MouseClicked(evt);
            }
        });

        CRUDLabel4.setBackground(new java.awt.Color(13, 16, 51));
        CRUDLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CRUDLabel4.setForeground(new java.awt.Color(255, 255, 255));
        CRUDLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer_50px.png"))); // NOI18N
        CRUDLabel4.setText("Profil");

        javax.swing.GroupLayout menuPanel1Layout = new javax.swing.GroupLayout(menuPanel1);
        menuPanel1.setLayout(menuPanel1Layout);
        menuPanel1Layout.setHorizontalGroup(
            menuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CRUDLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        menuPanel1Layout.setVerticalGroup(
            menuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CRUDLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
        );

        logoutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/log-out_35px.png"))); // NOI18N
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dashBoardPanelLayout = new javax.swing.GroupLayout(dashBoardPanel);
        dashBoardPanel.setLayout(dashBoardPanelLayout);
        dashBoardPanelLayout.setHorizontalGroup(
            dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashBoardPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dashBoardPanelLayout.setVerticalGroup(
            dashBoardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(logoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(dashBoardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 620));

        whitePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout whitePanelLayout = new javax.swing.GroupLayout(whitePanel);
        whitePanel.setLayout(whitePanelLayout);
        whitePanelLayout.setHorizontalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        whitePanelLayout.setVerticalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        getContentPane().add(whitePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 1050, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void menuPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel2MousePressed
        menuPanel2.setBackground(clickedColor);
        menuPanel3.setBackground(defaultColor);
        menuPanel4.setBackground(defaultColor);
        menuPanel1.setBackground(defaultColor);
    }//GEN-LAST:event_menuPanel2MousePressed

    private void menuPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel2MouseClicked
        menuPanel2.setBackground(clickedColor);
        menuPanel3.setBackground(defaultColor);
        menuPanel4.setBackground(defaultColor);
        menuPanel1.setBackground(defaultColor);
        subTitleLabel.setText("Tambah Produk");
        
        ProductInternForm menu1 = new ProductInternForm(username);
        whitePanel.removeAll();
        whitePanel.add(menu1).setVisible(true);
    }//GEN-LAST:event_menuPanel2MouseClicked

    private void menuPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel3MouseClicked
        menuPanel2.setBackground(defaultColor);
        menuPanel3.setBackground(clickedColor);
        menuPanel4.setBackground(defaultColor);
        menuPanel1.setBackground(defaultColor);
        subTitleLabel.setText("Pesanan");
        
        PesananInternForm menu1 = new PesananInternForm(username);
        whitePanel.removeAll();
        whitePanel.add(menu1).setVisible(true);
    }//GEN-LAST:event_menuPanel3MouseClicked

    private void menuPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel3MousePressed
        menuPanel2.setBackground(defaultColor);
        menuPanel3.setBackground(clickedColor);
        menuPanel4.setBackground(defaultColor);
        menuPanel1.setBackground(defaultColor);
    }//GEN-LAST:event_menuPanel3MousePressed

    private void menuPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel4MouseClicked
        menuPanel2.setBackground(defaultColor);
        menuPanel3.setBackground(defaultColor);
        menuPanel4.setBackground(clickedColor);
        menuPanel1.setBackground(defaultColor);
        subTitleLabel.setText("Riwayat Pesanan");
        
        RiwayatInternForm menu1 = new RiwayatInternForm(username);
        whitePanel.removeAll();
        whitePanel.add(menu1).setVisible(true);
    }//GEN-LAST:event_menuPanel4MouseClicked

    private void menuPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel4MousePressed
        menuPanel2.setBackground(defaultColor);
        menuPanel3.setBackground(defaultColor);
        menuPanel4.setBackground(clickedColor);
        menuPanel1.setBackground(defaultColor);
    }//GEN-LAST:event_menuPanel4MousePressed

    private void menuPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel1MouseClicked
        menuPanel2.setBackground(defaultColor);
        menuPanel3.setBackground(defaultColor);
        menuPanel4.setBackground(defaultColor);
        menuPanel1.setBackground(clickedColor);
        subTitleLabel.setText("Profil");
        
        ProfileInternForm menu1 = new ProfileInternForm(username);
        whitePanel.removeAll();
        whitePanel.add(menu1).setVisible(true);
    }//GEN-LAST:event_menuPanel1MouseClicked

    private void menuPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPanel1MousePressed
        menuPanel2.setBackground(defaultColor);
        menuPanel3.setBackground(defaultColor);
        menuPanel4.setBackground(defaultColor);
        menuPanel1.setBackground(clickedColor);
    }//GEN-LAST:event_menuPanel1MousePressed

    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        LoginPage login1 = new LoginPage();
        login1.show();

        dispose();
    }//GEN-LAST:event_logoutLabelMouseClicked

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
                new SellerDashboard(username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CRUDLabel1;
    private javax.swing.JLabel CRUDLabel4;
    private javax.swing.JLabel CrudLabel3;
    private javax.swing.JLabel closeButton;
    private javax.swing.JPanel dashBoardPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JLabel menuIcon;
    private javax.swing.JLabel menuLabel2;
    private javax.swing.JPanel menuPanel1;
    private javax.swing.JPanel menuPanel2;
    private javax.swing.JPanel menuPanel3;
    private javax.swing.JPanel menuPanel4;
    private javax.swing.JPanel orangeTitleBar;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JPanel whitePanel;
    // End of variables declaration//GEN-END:variables
}
