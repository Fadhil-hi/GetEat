
package BuyerDashboard;

import Database.DBNeeds;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class RiwayatInternForm extends javax.swing.JInternalFrame {
    private String username;
    private int idPembeli;

    public RiwayatInternForm(String username) {
        this.username = username;
        idPembeli = DBNeeds.getIdPembeli(username);
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        fillPesananTable(idPembeli);
        selectRow();
    }
    private void selectRow() {
        pesananTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = pesananTable.getSelectedRow();

                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) pesananTable.getModel();
                        String idPesanan = (String)model.getValueAt(selectedRow, 0);
                        System.out.println(idPesanan);
                        condFillDetailTable(Integer.parseInt(idPesanan));
                    }
                    
                }
            }

        });
    }
    private void fillPesananTable(int id){
        DefaultTableModel model2 = (DefaultTableModel) pesananTable.getModel();
        model2.setRowCount(0);
        String query = "SELECT * FROM pesanan s JOIN pembayaran p ON s.id_Pesanan = p.id_Pesanan WHERE s.id_Pembeli = ?";

            try (Connection connection = DBNeeds.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idPesanan = resultSet.getString("id_Pesanan");
                String idPenjual = resultSet.getString("id_Penjual");
                String idKurir = resultSet.getString("id_Kurir");
                String tanggal = resultSet.getString("tgl_pesanan");
                String statusPsnn = resultSet.getString("status_Psnn");
                int total = resultSet.getInt("total");
                String statusPemb = resultSet.getString("status_Pemb");
                String metodePemb = resultSet.getString("metode_Pemb");

                model2.addRow(new Object[]{idPesanan, idPenjual, idKurir, tanggal, statusPsnn, total, statusPemb, metodePemb});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
    private void condFillDetailTable(int id){
        DefaultTableModel model = (DefaultTableModel) detailTable.getModel();
        model.setRowCount(0);
        String query = "SELECT * FROM detail WHERE id_Pesanan = ?";

            try (Connection connection = DBNeeds.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idProduk = resultSet.getString("id_Produk");
                int kuantitas =resultSet.getInt("Kuantitas");
                int subtotal =resultSet.getInt("subtotal");

                model.addRow(new Object[]{idProduk, kuantitas, subtotal});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        subTitleLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pesananTable = new javax.swing.JTable();
        subTitleLabel2 = new javax.swing.JLabel();
        subTitleLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        detailTable = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        subTitleLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        subTitleLabel1.setText("Riwayat Pembelian :");

        pesananTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pesanan", "ID Penjual", "ID Kurir", "Tanggal", "Status Pesanan", "Total", "Status Pembayaran", "Metode Pembayaran"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(pesananTable);

        subTitleLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        subTitleLabel2.setText("Identitas Pesanan :");

        subTitleLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        subTitleLabel3.setText("Detail Pesanan :");

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
        jScrollPane3.setViewportView(detailTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subTitleLabel1)
                            .addComponent(subTitleLabel2)
                            .addComponent(subTitleLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subTitleLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTitleLabel2)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTitleLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable detailTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable pesananTable;
    private javax.swing.JLabel subTitleLabel1;
    private javax.swing.JLabel subTitleLabel2;
    private javax.swing.JLabel subTitleLabel3;
    // End of variables declaration//GEN-END:variables
}
