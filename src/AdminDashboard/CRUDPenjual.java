package AdminDashboard;


import Database.DBNeeds;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class CRUDPenjual extends javax.swing.JInternalFrame {
    private int currentRow = 0;
    private int idPointer = 0;

    public CRUDPenjual() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        refreshTable();
        selectRow();
    }
    
    private void refreshTextField(){
        namaTokoField.setText("");
        noTelpField.setText("");
        jalanField.setText("");
        kelurahanField.setText("");
        kecamatanField.setText("");
        usernameField.setText("");
        passField.setText("");
    }
    
    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) penjualTbl.getModel();

        model.setRowCount(0);

        try (Connection connection = DBNeeds.getConnection()) {
            String selectQuery = "SELECT * FROM penjual";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id_Penjual");
                String nama_Toko = resultSet.getString("nama_Toko");
                String no_Telp = resultSet.getString("no_Telp");
                String jalan = resultSet.getString("jalan");
                String kelurahan = resultSet.getString("kelurahan");
                String kecamatan = resultSet.getString("kecamatan");
                String username = resultSet.getString("username");

                // Tambahkan data siswa ke tabel
                model.addRow(new Object[]{id, nama_Toko, no_Telp, jalan, kelurahan, kecamatan, username});
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                        String id = (String) model.getValueAt(selectedRow, 0);
                        String nama_Toko = (String) model.getValueAt(selectedRow, 1);
                        String no_Telp = (String) model.getValueAt(selectedRow, 2);
                        String jalan = (String) model.getValueAt(selectedRow, 3);
                        String kelurahan = (String) model.getValueAt(selectedRow, 4);
                        String kecamatan = (String) model.getValueAt(selectedRow, 5);
                        String username = (String) model.getValueAt(selectedRow, 6);
                        idPointer = Integer.parseInt(id);

                        setFields(nama_Toko, no_Telp, jalan, kelurahan, kecamatan, username);
                    }
                }
            }

        });
    }
    private void setFields(String namaToko, String noTelp, String jalan, String kelurahan, String kecamatan, String username) {
        namaTokoField.setText(namaToko);
        noTelpField.setText(noTelp);
        jalanField.setText(jalan);
        kelurahanField.setText(kelurahan);
        kecamatanField.setText(kecamatan);
        usernameField.setText(username);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        penjualTbl = new javax.swing.JTable();
        namaTokoLabel = new javax.swing.JLabel();
        namaTokoField = new javax.swing.JTextField();
        noTelpLabel = new javax.swing.JLabel();
        noTelpField = new javax.swing.JTextField();
        jalanLabel = new javax.swing.JLabel();
        jalanField = new javax.swing.JTextField();
        kelurahanLabel = new javax.swing.JLabel();
        kelurahanField = new javax.swing.JTextField();
        kecamatanField = new javax.swing.JTextField();
        kecamatanLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        passLabel = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();

        penjualTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Penjual", "Nama Toko", "NoTelp", "Jalan", "Kelurahan", "Kecamatan", "Username"
            }
        ));
        jScrollPane1.setViewportView(penjualTbl);

        namaTokoLabel.setText("Nama Toko");

        noTelpLabel.setText("Nomor Telepon");

        jalanLabel.setText("Jalan");

        kelurahanLabel.setText("Kelurahan");

        kecamatanLabel.setText("Kecamatan");

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

        usernameLabel.setText("Username");

        passLabel.setText("Password");

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(namaTokoLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(noTelpField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jalanLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jalanField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(kelurahanLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(kelurahanField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(kecamatanLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(kecamatanField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(usernameLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(namaTokoField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(passLabel))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(noTelpLabel)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prevButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addButton)
                                    .addComponent(updateButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(deleteButton)
                                    .addComponent(clearButton)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nextButton)
                                .addComponent(prevButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(namaTokoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaTokoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noTelpLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noTelpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jalanLabel)
                        .addGap(4, 4, 4)
                        .addComponent(jalanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kelurahanLabel)
                        .addGap(5, 5, 5)
                        .addComponent(kelurahanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kecamatanLabel)
                        .addGap(1, 1, 1)
                        .addComponent(kecamatanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameLabel)
                        .addGap(2, 2, 2)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passLabel)
                        .addGap(1, 1, 1)
                        .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       
        String namaToko = namaTokoField.getText();
        String noTelp = noTelpField.getText();
        String jalan = jalanField.getText();
        String kelurahan = kelurahanField.getText();
        String kecamatan = kecamatanField.getText();
        String username = usernameField.getText();
        char [] arrPass = passField.getPassword();
        String password = new String(arrPass);
        DBNeeds.insertPenjual(namaToko, noTelp, jalan, kelurahan, kecamatan, username, password);
        refreshTextField();
        refreshTable();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String namaToko = namaTokoField.getText();
        String noTelp = noTelpField.getText();
        String jalan = jalanField.getText();
        String kelurahan = kelurahanField.getText();
        String kecamatan = kecamatanField.getText();
        String username = usernameField.getText();
        char [] arrPass = passField.getPassword();
        String password = new String(arrPass);
        DBNeeds.updatePenjual(idPointer, namaToko, noTelp, jalan, kelurahan, kecamatan, username, password);
        refreshTextField();
        refreshTable();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String namaToko = namaTokoField.getText();
        DBNeeds.deletePenjual(namaToko);
        refreshTextField();
        refreshTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) penjualTbl.getModel();
        int rowCount = model.getRowCount();

        try{
            if (rowCount > 0) {
                currentRow = (currentRow - 1) % rowCount;
                String namaToko = (String) model.getValueAt(currentRow, 1);
                String noTelp = (String) model.getValueAt(currentRow, 2);
                String jalan = (String) model.getValueAt(currentRow, 3);
                String kelurahan = (String) model.getValueAt(currentRow, 4);
                String kecamatan = (String) model.getValueAt(currentRow, 5);
                String username = (String) model.getValueAt(currentRow, 5);
                setFields(namaToko, noTelp, jalan, kelurahan, kecamatan, username);

                penjualTbl.setRowSelectionInterval(currentRow, currentRow);
                if (rowCount < 0){
                    currentRow = 0;
                }
            } 
        } catch (IndexOutOfBoundsException e){
            System.err.println("This is First Index, Please press the Next Button");
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) penjualTbl.getModel();
        int rowCount = model.getRowCount();

        try {
            if (rowCount > 0 && currentRow < rowCount - 1) {
                currentRow++;
                String namaToko = (String) model.getValueAt(currentRow, 1);
                String noTelp = (String) model.getValueAt(currentRow, 2);
                String jalan = (String) model.getValueAt(currentRow, 3);
                String kelurahan = (String) model.getValueAt(currentRow, 4);
                String kecamatan = (String) model.getValueAt(currentRow, 5);
                String username = (String) model.getValueAt(currentRow, 5);
                setFields(namaToko, noTelp, jalan, kelurahan, kecamatan, username);

                penjualTbl.setRowSelectionInterval(currentRow, currentRow);
            }
            if (currentRow <= rowCount - 1){
                System.err.println("This is Last Index, Please press the Previous Button");
            }
        } catch (IndexOutOfBoundsException e){
            System.err.println("This is Last Index, Please press the Previous Button");
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        refreshTextField();
    }//GEN-LAST:event_clearButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jalanField;
    private javax.swing.JLabel jalanLabel;
    private javax.swing.JTextField kecamatanField;
    private javax.swing.JLabel kecamatanLabel;
    private javax.swing.JTextField kelurahanField;
    private javax.swing.JLabel kelurahanLabel;
    private javax.swing.JTextField namaTokoField;
    private javax.swing.JLabel namaTokoLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField noTelpField;
    private javax.swing.JLabel noTelpLabel;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTable penjualTbl;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
