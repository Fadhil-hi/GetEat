
package CourierDashboard;

import SellerDashboard.*;
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

public class RiwayatInternForm extends javax.swing.JInternalFrame {
    private String username;
    private int idPointerKurir;

    public RiwayatInternForm(String username) {
        this.username = username;
        idPointerKurir = DBNeeds.getIdKurir(username);
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        fillPesananTable(idPointerKurir);
        fillPengirimanTable(idPointerKurir);
        selectRow();
    }
    private void fillPesananTable(int id){
        DefaultTableModel model2 = (DefaultTableModel) pesananTable.getModel();
        model2.setRowCount(0);
        String query = "SELECT * FROM pesanan WHERE id_Kurir = ?";

            try (Connection connection = DBNeeds.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idPesanan = resultSet.getString("id_Pesanan");
                String idPenjual = resultSet.getString("id_Penjual");
                String idPembeli = resultSet.getString("id_Pembeli");
                String tanggal = resultSet.getString("tgl_pesanan");
                String statusPsnn = resultSet.getString("status_Psnn");

                model2.addRow(new Object[]{idPesanan, tanggal, statusPsnn, idPenjual, idPembeli});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error: " + e.getMessage());
        }
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
    private void fillPengirimanTable(int id){
        DefaultTableModel model2 = (DefaultTableModel) pengirimanTable.getModel();
        model2.setRowCount(0);
        String query = "SELECT * FROM pengiriman WHERE id_Kurir = ?";

            try (Connection connection = DBNeeds.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idPengiriman = resultSet.getString("id_Pengiriman");
                String tgl_Pengiriman = resultSet.getString("tgl_Pengiriman");
                String status = resultSet.getString("status_Pngrmn");
                

                model2.addRow(new Object[]{idPengiriman, tgl_Pengiriman, status});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pesananTable = new javax.swing.JTable();
        subTitleLabel2 = new javax.swing.JLabel();
        subTitleLabel1 = new javax.swing.JLabel();
        subTitleLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        detailTable = new javax.swing.JTable();
        subTitleLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        pengirimanTable = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pesananTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pesanan", "Tanggal", "Status", "ID Penjual", "ID Pembeli"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(pesananTable);

        subTitleLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        subTitleLabel2.setText("Identitas Pesanan :");

        subTitleLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        subTitleLabel1.setText("Riwayat Pengiriman :");

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

        subTitleLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        subTitleLabel4.setText("Detail Pengiriman");

        pengirimanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pengiriman", "Tanggal", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(pengirimanTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subTitleLabel1)
                            .addComponent(subTitleLabel2)
                            .addComponent(subTitleLabel3)
                            .addComponent(subTitleLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTitleLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTitleLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable pengirimanTable;
    private javax.swing.JTable pesananTable;
    private javax.swing.JLabel subTitleLabel1;
    private javax.swing.JLabel subTitleLabel2;
    private javax.swing.JLabel subTitleLabel3;
    private javax.swing.JLabel subTitleLabel4;
    // End of variables declaration//GEN-END:variables
}
