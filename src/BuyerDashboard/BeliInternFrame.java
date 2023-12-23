
package BuyerDashboard;

import Entity.Pembeli;
import Entity.Produk;
import Database.DBNeeds;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class BeliInternFrame extends javax.swing.JInternalFrame {
    private Pembeli pembeli;
    private String username;
    private int idPointerPenjual;
    private int idPointerPesanan;
    private int idPointerPembeli;
    private int currentRow = 0;
    private int currentCount = 0;
    int idKurir = 30000;
    Produk produk;
    LocalDate today = LocalDate.now();
    Date date = java.sql.Date.valueOf(today);
    String dateString = today.toString();
    String status = "Belum diproses";

    public BeliInternFrame(String username) {
        this.username = username;
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        fillPenjualTable();
        fillProdukTable();
        selectRow();
        ui.setNorthPane(null);
        
        pesananButton1.setEnabled(true);
        idProdukField2.setEnabled(false);
        namaProdukField2.setEnabled(false);
        jumlahField2.setEnabled(false);
        keranjangButton2.setEnabled(false);
        plusButton1.setEnabled(false);
        minusButton1.setEnabled(false);
        
        pesananButton.setEnabled(true);
        idProdukField.setEnabled(false);
        namaProdukField.setEnabled(false);
        jumlahField.setEnabled(false);
        keranjangButton.setEnabled(false);
        plusButton.setEnabled(false);
        minusButton.setEnabled(false);
        nextButton.setEnabled(false);
        prevButton.setEnabled(false);
    }
    
    private void fillPenjualTable() {
        DefaultTableModel model = (DefaultTableModel) penjualTbl.getModel();

        model.setRowCount(0); // Menghapus semua baris dari tabel

        try (Connection connection = DBNeeds.getConnection()) {
            String selectQuery = "SELECT * FROM penjual";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id_Penjual");
                String nama_Toko = resultSet.getString("nama_Toko");
                String jalan = resultSet.getString("jalan");
                String kelurahan = resultSet.getString("kelurahan");
                String kecamatan = resultSet.getString("kecamatan");

                model.addRow(new Object[]{id, nama_Toko, jalan, kelurahan, kecamatan});
                
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    private void condFillProdukTable1(int id){
        DefaultTableModel model2 = (DefaultTableModel) produkTbl.getModel();
        model2.setRowCount(0);
        
        try (Connection connection = DBNeeds.getConnection()){
            String selectQuery = "SELECT * FROM produk WHERE id_Penjual = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idProduk = resultSet.getString("id_Produk");
                String namaProduk = resultSet.getString("nama");
                int harga = resultSet.getInt("harga");
                int stok = resultSet.getInt("stok");
                String kategori = resultSet.getString("kategori");

                model2.addRow(new Object[]{idProduk, namaProduk, harga, stok, kategori});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
    private void condFillProdukTable2(String nama){
        DefaultTableModel model2 = (DefaultTableModel) produkTbl2.getModel();
        model2.setRowCount(0);
        
        try (Connection connection = DBNeeds.getConnection()){
            String selectQuery = "SELECT * FROM produk WHERE nama LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, "%" + nama + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idProduk = resultSet.getString("id_Produk");
                String namaProduk = resultSet.getString("nama");
                int harga = resultSet.getInt("harga");
                int stok = resultSet.getInt("stok");
                String kategori = resultSet.getString("kategori");
                String idPenjual = resultSet.getString("id_Penjual");

                model2.addRow(new Object[]{idProduk, namaProduk, harga, stok, kategori, idPenjual});
            }
            selectRow();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
    
    
    private void selectRow() {
        penjualTbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = penjualTbl.getSelectedRow();

                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) penjualTbl.getModel();
                        String id = (String)model.getValueAt(selectedRow, 0); 
                        String namaToko = (String)model.getValueAt(selectedRow, 1); 
                        String jalan = (String)model.getValueAt(selectedRow, 2); 
                        String kelurahan = (String)model.getValueAt(selectedRow, 3); 
                        String kecamatan = (String)model.getValueAt(selectedRow, 4);
                        idPointerPenjual = Integer.parseInt(id);
                        condFillProdukTable1(Integer.parseInt(id));
                        setIDPenjual(id);
                    }
                    
                }
            }

        });
        produkTbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = produkTbl.getSelectedRow();

                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) produkTbl.getModel();
                        String idProduk = (String)model.getValueAt(selectedRow, 0);
                        String namaProduk = (String)model.getValueAt(selectedRow, 1);
                        int harga = (Integer)model.getValueAt(selectedRow, 2);
                        int stok = (Integer)model.getValueAt(selectedRow, 3);
                        String kategori = (String)model.getValueAt(selectedRow, 4);
                        produk = new Produk(idProduk, namaProduk, kategori, harga, stok);
                        setFields1(idProduk, namaProduk);
                    }
                    
                }
            }

        });
        produkTbl2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = produkTbl2.getSelectedRow();

                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) produkTbl2.getModel();
                        String idProduk = (String)model.getValueAt(selectedRow, 0);
                        String namaProduk = (String)model.getValueAt(selectedRow, 1);
                        int harga = (Integer)model.getValueAt(selectedRow, 2);
                        int stok = (Integer)model.getValueAt(selectedRow, 3);
                        String kategori = (String)model.getValueAt(selectedRow, 4);
                        String idPenjual = (String)model.getValueAt(selectedRow, 5);
                        idPointerPenjual = Integer.parseInt(idPenjual);
                        String idProdukString = String.valueOf(idProduk);
                        produk = new Produk(idProdukString, namaProduk, kategori, harga, stok);
                        setFields2(idProdukString, namaProduk);
                    }
                    
                }
            }
        });
    }
    private void setIDPenjual(String id){
        idPenjualField.setText(id);
    }

    
    private void setFields1(String id, String namaProduk) {
        idProdukField.setText(id);
        namaProdukField.setText(namaProduk);
        jumlahField.setText("0");
        subTotalLabel2.setText("0");
    }
    private void setFields2(String id, String namaProduk) {
        idProdukField2.setText(id);
        namaProdukField2.setText(namaProduk);
        jumlahField2.setText("0");
        subTotalLabel4.setText("0");
    }
    private int setSubTotal(int harga, int kuantitas){
        return harga * kuantitas;
    }
    private void fillProdukTable(){
        DefaultTableModel model2 = (DefaultTableModel) produkTbl2.getModel();
        model2.setRowCount(0);
        
        try (Connection connection = DBNeeds.getConnection()){
            String selectQuery = "SELECT * FROM produk";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idProduk = resultSet.getString("id_Produk");
                String namaProduk = resultSet.getString("nama");
                int harga = resultSet.getInt("harga");
                int stok = resultSet.getInt("stok");
                String kategori = resultSet.getString("kategori");
                String idPenjual = resultSet.getString("id_Penjual");

                model2.addRow(new Object[]{idProduk, namaProduk, harga, stok, kategori, idPenjual});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
    private int getID(String username){
        int id=0;
        try (Connection connection = DBNeeds.getConnection()) {
            String selectQuery = "SELECT id_Pembeli FROM pembeli WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
            id = resultSet.getInt("id_Pembeli");
            }
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        cariLabel = new javax.swing.JLabel();
        cariField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        subTotalLabel3 = new javax.swing.JLabel();
        subTotalLabel4 = new javax.swing.JLabel();
        plusButton1 = new javax.swing.JButton();
        minusButton1 = new javax.swing.JButton();
        namaProdukLabel4 = new javax.swing.JLabel();
        namaProdukField2 = new javax.swing.JTextField();
        namaProdukLabel5 = new javax.swing.JLabel();
        jumlahField2 = new javax.swing.JTextField();
        pesananButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        produkTbl2 = new javax.swing.JTable();
        namaProdukLabel7 = new javax.swing.JLabel();
        idProdukField2 = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        keranjangButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        penjualTbl = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        produkTbl = new javax.swing.JTable();
        namaProdukLabel1 = new javax.swing.JLabel();
        jumlahLabel = new javax.swing.JLabel();
        jumlahField = new javax.swing.JTextField();
        minusButton = new javax.swing.JButton();
        keranjangButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        subTotalLabel1 = new javax.swing.JLabel();
        subTotalLabel2 = new javax.swing.JLabel();
        pesananButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        idPenjualField = new javax.swing.JTextField();
        namaProdukField = new javax.swing.JTextField();
        messageLabel = new javax.swing.JLabel();
        namaProdukLabel2 = new javax.swing.JLabel();
        idProdukField = new javax.swing.JTextField();
        plusButton = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        cariLabel.setText("Cari :");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        subTotalLabel3.setText("Subtotal :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(subTotalLabel3)
                .addGap(18, 18, 18)
                .addComponent(subTotalLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(subTotalLabel3)
                .addComponent(subTotalLabel4))
        );

        plusButton1.setText("+");
        plusButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusButton1ActionPerformed(evt);
            }
        });

        minusButton1.setText("-");
        minusButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusButton1ActionPerformed(evt);
            }
        });

        namaProdukLabel4.setText("Nama Produk");

        namaProdukLabel5.setText("Jumlah");

        pesananButton1.setText("Buat Pesanan");
        pesananButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesananButton1ActionPerformed(evt);
            }
        });

        produkTbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Produk", "Nama Produk", "Harga", "Stok", "Kategori", "ID Penjual"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(produkTbl2);

        namaProdukLabel7.setText("ID Produk");

        searchButton.setText("Go");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        keranjangButton2.setText("Tambah ke Keranjang");
        keranjangButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keranjangButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cariLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cariField, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchButton))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(552, 552, 552)
                                .addComponent(minusButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(plusButton1)))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(namaProdukLabel4)
                    .addComponent(namaProdukLabel7)
                    .addComponent(idProdukField2)
                    .addComponent(namaProdukField2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(namaProdukLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jumlahField2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(keranjangButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(pesananButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cariLabel)
                            .addComponent(cariField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton)
                            .addComponent(pesananButton1))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minusButton1)
                            .addComponent(plusButton1)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(namaProdukLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idProdukField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaProdukLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaProdukField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaProdukLabel5)
                            .addComponent(jumlahField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(keranjangButton2)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tabPane.addTab("Cari Berdasarkan Nama Makanan", jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        penjualTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Penjual", "Nama Toko", "Jalan", "Kelurahan", "Kecamatan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(penjualTbl);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 16, 461, 510));

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

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(produkTbl);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 16, 512, 224));

        namaProdukLabel1.setText("Nama Produk :");
        jPanel4.add(namaProdukLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, -1, -1));

        jumlahLabel.setText("Jumlah :");
        jPanel4.add(jumlahLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, -1, -1));
        jPanel4.add(jumlahField, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 49, -1));

        minusButton.setText("-");
        minusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusButtonActionPerformed(evt);
            }
        });
        jPanel4.add(minusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 290, 50, -1));

        keranjangButton.setText("Tambah ke Keranjang");
        keranjangButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keranjangButtonActionPerformed(evt);
            }
        });
        jPanel4.add(keranjangButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, 510, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        subTotalLabel1.setText("Subtotal :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(subTotalLabel1)
                .addGap(18, 18, 18)
                .addComponent(subTotalLabel2)
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(subTotalLabel1)
                .addComponent(subTotalLabel2))
        );

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, -1, -1));

        pesananButton.setText("Buat Pesanan");
        pesananButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesananButtonActionPerformed(evt);
            }
        });
        jPanel4.add(pesananButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 510, -1));

        nextButton.setText(">");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jPanel4.add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 250, 50, -1));

        prevButton.setText("<");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });
        jPanel4.add(prevButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 250, 50, -1));
        jPanel4.add(idPenjualField, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 250, 72, -1));
        jPanel4.add(namaProdukField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 239, -1));

        messageLabel.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(messageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 448, 12, 11));

        namaProdukLabel2.setText("ID Produk :");
        jPanel4.add(namaProdukLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));
        jPanel4.add(idProdukField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 239, -1));

        plusButton.setText("+");
        plusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusButtonActionPerformed(evt);
            }
        });
        jPanel4.add(plusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 290, 50, -1));

        tabPane.addTab("Cari Berdasarkan Toko", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) produkTbl.getModel();
        int rowCount = model.getRowCount();

        try{
            if (rowCount > 0) {
                currentRow = (currentRow - 1) % rowCount;
                String idProduk = (String) model.getValueAt(currentRow, 0);
                String namaProduk = (String) model.getValueAt(currentRow, 1);
                setFields1(idProduk, namaProduk);
                produkTbl.setRowSelectionInterval(currentRow, currentRow);
                if (rowCount < 0){
                    currentRow = 0;
                }
            } 
        } catch (IndexOutOfBoundsException e){
            messageLabel.setText("Ini adalah produk pertama");
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) produkTbl.getModel();
        int rowCount = model.getRowCount();

        try {
            if (rowCount > 0 && currentRow < rowCount - 1) {
                currentRow++;
                String idProduk = (String) model.getValueAt(currentRow, 0);
                String namaProduk = (String) model.getValueAt(currentRow, 1);
                setFields1(idProduk, namaProduk);
                produkTbl.setRowSelectionInterval(currentRow, currentRow);
            }
            }catch (IndexOutOfBoundsException e){
            messageLabel.setText("Ini adalah produk pertama");
            }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void keranjangButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keranjangButtonActionPerformed
        int idProduk = Integer.parseInt(idProdukField.getText());
        int jumlah = Integer.parseInt(jumlahField.getText());
        int subTotal = Integer.parseInt(subTotalLabel2.getText());
        System.out.println(idPointerPesanan);
        DBNeeds.insertDetail(idProduk, jumlah, subTotal, idPointerPesanan);
    }//GEN-LAST:event_keranjangButtonActionPerformed

    private void minusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusButtonActionPerformed
        this.currentCount = currentCount;
        if(currentCount > 0){
            currentCount--;
            jumlahField.setText(String.valueOf(currentCount));
        }
        this.currentCount = currentCount;
        int subTotal = setSubTotal(produk.getHarga(),currentCount);
        String subTotal2 = String.valueOf(subTotal);
        subTotalLabel2.setText(subTotal2);
    }//GEN-LAST:event_minusButtonActionPerformed

    private void pesananButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesananButtonActionPerformed
        pesananButton.setEnabled(false);
        jumlahField.setEnabled(true);
        keranjangButton.setEnabled(true);
        plusButton.setEnabled(true);
        minusButton.setEnabled(true);
        nextButton.setEnabled(true);
        prevButton.setEnabled(true);
        
        int subTotal2 = 0;
        int id = 0;
        idPointerPembeli = getID(username);
        idPointerPesanan = DBNeeds.insertPesanan(date, status, subTotal2, idPointerPembeli);
         
    }//GEN-LAST:event_pesananButtonActionPerformed

    private void plusButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusButton1ActionPerformed
        if(currentCount<produk.getStok()){
            currentCount = Integer.parseInt(jumlahField2.getText());
            this.currentCount++;
            jumlahField2.setText(String.valueOf(currentCount));
        }
        this.currentCount = currentCount;
        
        int subTotal = setSubTotal(produk.getHarga(),currentCount );
        String subTotal2 = String.valueOf(subTotal);
        subTotalLabel4.setText(subTotal2);
    }//GEN-LAST:event_plusButton1ActionPerformed

    private void minusButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusButton1ActionPerformed
        this.currentCount = currentCount;
        if(currentCount > 0){
            currentCount--;
            jumlahField2.setText(String.valueOf(currentCount));
        }
        this.currentCount = currentCount;
        int subTotal = setSubTotal(produk.getHarga(),currentCount );
        String subTotal2 = String.valueOf(subTotal);
        subTotalLabel4.setText(subTotal2);
    }//GEN-LAST:event_minusButton1ActionPerformed

    private void pesananButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesananButton1ActionPerformed
        pesananButton1.setEnabled(false);
        
        jumlahField2.setEnabled(true);
        keranjangButton2.setEnabled(true);
        plusButton1.setEnabled(true);
        minusButton1.setEnabled(true);
        String subTotal = subTotalLabel4.getText();
        int subTotal2 = Integer.parseInt(subTotal);
        int id = 0;
        idPointerPembeli = getID(username);
        idPointerPesanan = DBNeeds.insertPesanan(date, status, subTotal2, idPointerPembeli);
        System.out.println(idPointerPesanan);
    }//GEN-LAST:event_pesananButton1ActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
            if(cariField.getText().equals("")){
                fillProdukTable();
            }else{
               String keySearch = cariField.getText();
               condFillProdukTable2(keySearch);
            }
            selectRow();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void plusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusButtonActionPerformed
        if(currentCount<produk.getStok()){
            currentCount = Integer.parseInt(jumlahField.getText());
            this.currentCount++;
            jumlahField.setText(String.valueOf(currentCount));
        }
        this.currentCount = currentCount;
        
        int subTotal = setSubTotal(produk.getHarga(),currentCount );
        String subTotal2 = String.valueOf(subTotal);
        subTotalLabel2.setText(subTotal2);
    }//GEN-LAST:event_plusButtonActionPerformed

    private void keranjangButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keranjangButton2ActionPerformed
        int idProduk = Integer.parseInt(idProdukField2.getText());
        int jumlah = Integer.parseInt(jumlahField2.getText());
        int subTotal = Integer.parseInt(subTotalLabel4.getText());
        DBNeeds.insertDetail(idProduk, jumlah, subTotal, idPointerPesanan);
    }//GEN-LAST:event_keranjangButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cariField;
    private javax.swing.JLabel cariLabel;
    private javax.swing.JTextField idPenjualField;
    private javax.swing.JTextField idProdukField;
    private javax.swing.JTextField idProdukField2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jumlahField;
    private javax.swing.JTextField jumlahField2;
    private javax.swing.JLabel jumlahLabel;
    private javax.swing.JButton keranjangButton;
    private javax.swing.JButton keranjangButton2;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton minusButton;
    private javax.swing.JButton minusButton1;
    private javax.swing.JTextField namaProdukField;
    private javax.swing.JTextField namaProdukField2;
    private javax.swing.JLabel namaProdukLabel1;
    private javax.swing.JLabel namaProdukLabel2;
    private javax.swing.JLabel namaProdukLabel4;
    private javax.swing.JLabel namaProdukLabel5;
    private javax.swing.JLabel namaProdukLabel7;
    private javax.swing.JButton nextButton;
    private javax.swing.JTable penjualTbl;
    private javax.swing.JButton pesananButton;
    private javax.swing.JButton pesananButton1;
    private javax.swing.JButton plusButton;
    private javax.swing.JButton plusButton1;
    private javax.swing.JButton prevButton;
    private javax.swing.JTable produkTbl;
    private javax.swing.JTable produkTbl2;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel subTotalLabel1;
    private javax.swing.JLabel subTotalLabel2;
    private javax.swing.JLabel subTotalLabel3;
    private javax.swing.JLabel subTotalLabel4;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}
