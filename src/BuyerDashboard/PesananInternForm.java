
package BuyerDashboard;

import Database.DBNeeds;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class PesananInternForm extends javax.swing.JInternalFrame {
    private String username;
    private int idPointerPenjual;
    private int idPointerPesanan;
    private int idPointerPembeli;
    private int idPointerProduk;
    private int total;
    

    public PesananInternForm(String username) {
        this.username = username;
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        
        idPointerPembeli = DBNeeds.getIdPembeli(username);
        idPointerPesanan = DBNeeds.getLatestIdPesanan();
        fillDetailTable(idPointerPesanan);
        DefaultTableModel model2 = (DefaultTableModel) detailTable.getModel();
        int idPointerProduk = Integer.parseInt((String)model2.getValueAt(0, 0));
        idPointerPenjual = DBNeeds.getIdPenjual(idPointerProduk);
        
        total = hitungTotalHarga(detailTable);
        System.out.println(idPointerPesanan + " " +total+ " " +idPointerProduk+ " " +idPointerPenjual);
        setLabel(idPointerPesanan, total);
        
        ui.setNorthPane(null);
    }
    
    private void setLabel(int id, int total){
        IDLabel2.setText(String.valueOf(id));
        totalLabel2.setText(String.valueOf(total));
    }
    
    private int hitungTotalHarga(JTable jTable) {
        int totalHarga = 0;

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();

        int rowCount = model.getRowCount();
        
        for (int i = 0; i < rowCount; i++) {
            int hargaBaris = (Integer) model.getValueAt(i, 2);
            System.out.println(hargaBaris);
            totalHarga += hargaBaris;
        }

        return totalHarga;
    }
    private void fillDetailTable(int idPesanan){
        DefaultTableModel model2 = (DefaultTableModel) detailTable.getModel();
        model2.setRowCount(0);
        
        try (Connection connection = DBNeeds.getConnection()){
            String selectQuery = "SELECT * FROM detail WHERE id_Pesanan = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, idPesanan);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idProduk = resultSet.getString("id_Produk");
                int kuantitas = resultSet.getInt("Kuantitas");
                int subtotal = resultSet.getInt("subtotal");

                model2.addRow(new Object[]{idProduk, kuantitas, subtotal});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailTable = new javax.swing.JTable();
        subTitleLabel1 = new javax.swing.JLabel();
        bayarSkrgButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        metodPembCB = new javax.swing.JComboBox<>();
        IDLabel1 = new javax.swing.JLabel();
        IDLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        totalLabel = new javax.swing.JLabel();
        totalLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        detailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Produk", "Kuantitas", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(detailTable);

        subTitleLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        subTitleLabel1.setText("Detail Pesanan :");

        bayarSkrgButton.setText("Bayar Sekarang");
        bayarSkrgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarSkrgButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Pilih Metode Pembayaran :");

        metodPembCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transfer Bank", "OVO", "Gopay", "DANA","Tunai" }));

        IDLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        IDLabel1.setText("ID :");

        IDLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        totalLabel.setText("Total :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(totalLabel)
                .addGap(18, 18, 18)
                .addComponent(totalLabel2)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(totalLabel)
                .addComponent(totalLabel2))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(subTitleLabel1)
                        .addGap(259, 259, 259)
                        .addComponent(IDLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDLabel2)
                        .addGap(0, 549, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(metodPembCB, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bayarSkrgButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subTitleLabel1)
                    .addComponent(IDLabel1)
                    .addComponent(IDLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(metodPembCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bayarSkrgButton)))
                .addGap(0, 38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bayarSkrgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarSkrgButtonActionPerformed
        String metodePemb = (String) metodPembCB.getSelectedItem();
        DBNeeds.insertPembayaran(metodePemb, idPointerPesanan);
        DBNeeds.updatePesanan(total, idPointerPesanan, idPointerPenjual);
        DefaultTableModel model2 = (DefaultTableModel) detailTable.getModel();
        model2.setRowCount(0);
    }//GEN-LAST:event_bayarSkrgButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDLabel1;
    private javax.swing.JLabel IDLabel2;
    private javax.swing.JButton bayarSkrgButton;
    private javax.swing.JTable detailTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> metodPembCB;
    private javax.swing.JLabel subTitleLabel1;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalLabel2;
    // End of variables declaration//GEN-END:variables
}
