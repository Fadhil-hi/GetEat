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

public class ProductInternForm extends javax.swing.JInternalFrame {
    private String username;
    private int idPointerPenjual;
    private int idPointerProduk;
    private int currentRow;

    public ProductInternForm(String username) {
        this.username = username;
        idPointerPenjual = DBNeeds.getIdPenjual(username);
        System.out.println(idPointerPenjual);
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        fillProdukTable(idPointerPenjual);
        selectRow();
    }

    private void fillProdukTable(int idPenjual) {
        DefaultTableModel model = (DefaultTableModel) produkTbl.getModel();

        model.setRowCount(0);

        try (Connection connection = DBNeeds.getConnection()) {
            String selectQuery = "SELECT * FROM produk WHERE id_Penjual = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, idPenjual);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id_Produk");
                String namaProduk = resultSet.getString("nama");
                int harga = resultSet.getInt("harga");
                int stok = resultSet.getInt("stok");
                String kategori = resultSet.getString("kategori");

                model.addRow(new Object[]{id, namaProduk, harga, stok, kategori});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void selectRow() {
        produkTbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = produkTbl.getSelectedRow();

                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) produkTbl.getModel();
                        String id = (String) model.getValueAt(selectedRow, 0);
                        String namaProduk = (String) model.getValueAt(selectedRow, 1);
                        int harga = (Integer) model.getValueAt(selectedRow, 2);
                        int stok = (Integer) model.getValueAt(selectedRow, 3);
                        String kategori = (String) model.getValueAt(selectedRow, 4);
                        idPointerProduk = Integer.parseInt(id);
                        setFields(namaProduk, harga, stok, kategori);
                    }
                }
            }

        });
    }
    private void setFields(String namaProduk, int harga, int stok, String kategori){
        namaProdukField.setText(namaProduk);
        hargaField.setText(String.valueOf(harga));
        stokField.setText(String.valueOf(stok));
        kategoriField.setText(kategori);
    }
    private void clearFields(){
        namaProdukField.setText("");
        hargaField.setText(String.valueOf(""));
        stokField.setText(String.valueOf(""));
        kategoriField.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        namaLabel = new javax.swing.JLabel();
        namaProdukField = new javax.swing.JTextField();
        noTelpLabel = new javax.swing.JLabel();
        kategoriField = new javax.swing.JTextField();
        noTelpLabel1 = new javax.swing.JLabel();
        hargaField = new javax.swing.JTextField();
        hargaLabel = new javax.swing.JLabel();
        stokField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        produkTbl = new javax.swing.JTable();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        namaLabel.setText("Nama Produk");

        noTelpLabel.setText("Kategori");

        noTelpLabel1.setText("Harga");

        hargaLabel.setText("Stok");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        produkTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Produk", "Nama Produk", "Harga", "Stok", "Kategori"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(produkTbl);

        nextButton.setText(">");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        prevButton.setText("<");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaLabel)
                    .addComponent(namaProdukField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noTelpLabel)
                    .addComponent(kategoriField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noTelpLabel1)
                    .addComponent(hargaField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaLabel)
                    .addComponent(stokField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prevButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nextButton)
                                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(messageLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(messageLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(namaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaProdukField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noTelpLabel)
                        .addGap(5, 5, 5)
                        .addComponent(kategoriField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noTelpLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(hargaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hargaLabel)
                        .addGap(5, 5, 5)
                        .addComponent(stokField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(updateButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteButton)
                            .addComponent(clearButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextButton)
                            .addComponent(prevButton))))
                .addContainerGap(72, Short.MAX_VALUE))
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

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearFields();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String nama = namaProdukField.getText();
        int harga = Integer.parseInt(hargaField.getText());
        int stok = Integer.parseInt(stokField.getText());
        String kategori = kategoriField.getText();
        DBNeeds.insertProduk(nama, harga, stok, kategori, idPointerPenjual);
        fillProdukTable(idPointerPenjual);
        clearFields();
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String nama = namaProdukField.getText();
        DBNeeds.deleteProduk(idPointerProduk);
        fillProdukTable(idPointerPenjual);
        clearFields();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String nama = namaProdukField.getText();
        int harga = Integer.parseInt(hargaField.getText());
        int stok = Integer.parseInt(stokField.getText());
        String kategori = kategoriField.getText();
        DBNeeds.updateProduk(idPointerProduk, nama, harga, stok, kategori, idPointerPenjual);
        fillProdukTable(idPointerPenjual);
        clearFields();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) produkTbl.getModel();
        int rowCount = model.getRowCount();

        try {
            if (rowCount > 0 && currentRow < rowCount - 1) {
                currentRow++;
                String namaProduk = (String) model.getValueAt(currentRow, 1);
                int harga = (Integer) model.getValueAt(currentRow, 2);
                int stok = (Integer) model.getValueAt(currentRow, 3);
                String kategori = (String) model.getValueAt(currentRow, 4);
                setFields(namaProduk, harga, stok, kategori);
                produkTbl.setRowSelectionInterval(currentRow, currentRow);
            }
            }catch (IndexOutOfBoundsException e){
            messageLabel.setText("Ini adalah produk pertama");
            }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) produkTbl.getModel();
        int rowCount = model.getRowCount();

        try{
            if (rowCount > 0) {
                currentRow = (currentRow - 1) % rowCount;
                String namaProduk = (String) model.getValueAt(currentRow, 1);
                int harga = (Integer) model.getValueAt(currentRow, 2);
                int stok = (Integer) model.getValueAt(currentRow, 3);
                String kategori = (String) model.getValueAt(currentRow, 4);
                setFields(namaProduk, harga, stok, kategori);
                produkTbl.setRowSelectionInterval(currentRow, currentRow);
                if (rowCount < 0){
                    currentRow = 0;
                }
            } 
        } catch (IndexOutOfBoundsException e){
            messageLabel.setText("Ini adalah produk pertama");
        }
    }//GEN-LAST:event_prevButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField hargaField;
    private javax.swing.JLabel hargaLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kategoriField;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JTextField namaProdukField;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel noTelpLabel;
    private javax.swing.JLabel noTelpLabel1;
    private javax.swing.JButton prevButton;
    private javax.swing.JTable produkTbl;
    private javax.swing.JTextField stokField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
