
package SellerDashboard;

import BuyerDashboard.*;
import Database.DBNeeds;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class PesananInternForm extends javax.swing.JInternalFrame {
    private String username;
    private int idPointerPesanan;
    private int idPointerPenjual;

    public PesananInternForm(String username) {
        this.username = username;
        idPointerPenjual = DBNeeds.getIdPenjual(username);
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        fillPesananTable();
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
                        int idPesanan = (Integer)model.getValueAt(selectedRow, 0);
                        System.out.println(idPesanan);
                        idPointerPesanan = idPesanan;
                        condFillDetailTable(idPesanan);
                    }
                    
                }
            }
        });
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

    private void fillPesananTable(){
        DefaultTableModel model = (DefaultTableModel) pesananTable.getModel();

        model.setRowCount(0);
        
        String query = "SELECT * FROM pesanan WHERE id_Penjual = ? and status_Psnn = 'Sedang diproses'";
        try(Connection connection = DBNeeds.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, idPointerPenjual);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idPesanan = resultSet.getInt("id_Pesanan");
                String tgl = resultSet.getString("tgl_pesanan");
                String status = resultSet.getString("status_Psnn");
                int idPembeli = resultSet.getInt("id_Pembeli");

                model.addRow(new Object[]{idPesanan, tgl, status, idPembeli});
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pesananTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        detailTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        updateButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pesananTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pesanan", "Tanggal", "Status", "ID Pembeli"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(pesananTable);

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

        jLabel1.setText("Status Pesanan");

        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sedang diproses", "Selesai diproses"}));

        updateButton.setText("Ok");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(statusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
                .addContainerGap())
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

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String status = (String)statusComboBox.getSelectedItem();
        DBNeeds.updateStatusPesanan(idPointerPesanan, status);
        fillPesananTable();
        statusComboBox.setSelectedIndex(0);
//        
//        DefaultTableModel model = (DefaultTableModel) pesananTable.getModel();
//        int selectedRow = pesananTable.getSelectedRow();
//                if (selectedRow != -1) {
//                    model.removeRow(selectedRow);
//                } else {
//                    System.err.print("Tidak ada data yang dipilih");
//                }
    }//GEN-LAST:event_updateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable detailTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable pesananTable;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
