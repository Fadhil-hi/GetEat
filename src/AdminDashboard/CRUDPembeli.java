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

public class CRUDPembeli extends javax.swing.JInternalFrame {
    private int currentRow = 0;
    private int idPointer = 0;

    public CRUDPembeli() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        refreshTable();
        selectRow();
    }
    private void refreshTextField(){
        namaField.setText("");
        noTelpField.setText("");
        jkComboBox.setSelectedItem("Laki-laki");
        kelurahanField.setText("");
        kecamatanField.setText("");
        usernameField.setText("");
        passField.setText("");
    }
    
    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) pembeliTbl.getModel();

        model.setRowCount(0); // Menghapus semua baris dari tabel

        try (Connection connection = DBNeeds.getConnection()) {
            String selectQuery = "SELECT * FROM pembeli";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id_Pembeli");
                String nama_Toko = resultSet.getString("nama");
                String no_Telp = resultSet.getString("no_Telp");
                String jk = resultSet.getString("jenis_Kelamin");
                String jalan = resultSet.getString("jalan");
                String kelurahan = resultSet.getString("kelurahan");
                String kecamatan = resultSet.getString("kecamatan");
                String username = resultSet.getString("username");

                // Tambahkan data siswa ke tabel
                model.addRow(new Object[]{id, nama_Toko, no_Telp, jk, jalan, kelurahan, kecamatan, username});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void selectRow() {
        pembeliTbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = pembeliTbl.getSelectedRow();

                    if (selectedRow != -1) {
                        DefaultTableModel model = (DefaultTableModel) pembeliTbl.getModel();
                        String id = (String) model.getValueAt(selectedRow, 0);
                        String nama = (String) model.getValueAt(selectedRow, 1);
                        String no_Telp = (String) model.getValueAt(selectedRow, 2);
                        String jk = (String) model.getValueAt(selectedRow, 3);
                        String jalan = (String) model.getValueAt(selectedRow, 4);
                        String kelurahan = (String) model.getValueAt(selectedRow, 5);
                        String kecamatan = (String) model.getValueAt(selectedRow, 6);
                        String username = (String) model.getValueAt(selectedRow, 7);
                        idPointer = Integer.parseInt(id);

                        setFields(nama, no_Telp, jk, jalan, kelurahan, kecamatan, username);
                    }
                }
            }

        });
    }
    private void setFields(String nama, String noTelp, String jk, String jalan, String kelurahan, String kecamatan, String username) {
        namaField.setText(nama);
        noTelpField.setText(noTelp);
        jkComboBox.setSelectedItem(jk);
        jalanField.setText(jalan);
        kelurahanField.setText(kelurahan);
        kecamatanField.setText(kecamatan);
        usernameField.setText(username);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namaLabel = new javax.swing.JLabel();
        namaField = new javax.swing.JTextField();
        noTelpLabel = new javax.swing.JLabel();
        noTelpField = new javax.swing.JTextField();
        kelurahanLabel = new javax.swing.JLabel();
        kelurahanField = new javax.swing.JTextField();
        kecamatanLabel = new javax.swing.JLabel();
        kecamatanField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pembeliTbl = new javax.swing.JTable();
        prevButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        jkLabel = new javax.swing.JLabel();
        jalanLabel = new javax.swing.JLabel();
        jalanField = new javax.swing.JTextField();
        jkComboBox = new javax.swing.JComboBox<>();
        passField = new javax.swing.JPasswordField();
        passLabel = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        namaLabel.setText("Nama");
        getContentPane().add(namaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        getContentPane().add(namaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 270, -1));

        noTelpLabel.setText("Nomor Telepon");
        getContentPane().add(noTelpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        getContentPane().add(noTelpField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 270, -1));

        kelurahanLabel.setText("Kelurahan");
        getContentPane().add(kelurahanLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));
        getContentPane().add(kelurahanField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 270, -1));

        kecamatanLabel.setText("Kecamatan");
        getContentPane().add(kecamatanLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));
        getContentPane().add(kecamatanField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 270, -1));

        usernameLabel.setText("Username");
        getContentPane().add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));
        getContentPane().add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 270, -1));

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 512, 103, -1));

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 512, 109, -1));

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 103, -1));

        pembeliTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pembeli", "Nama", "NoTelp", "Jenis Kelamin", "Jalan", "Kelurahan", "Kecamatan", "Username"
            }
        ));
        jScrollPane1.setViewportView(pembeliTbl);
        if (pembeliTbl.getColumnModel().getColumnCount() > 0) {
            pembeliTbl.getColumnModel().getColumn(3).setResizable(false);
            pembeliTbl.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 28, 864, 475));

        prevButton.setText("<");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });
        getContentPane().add(prevButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 512, -1, -1));

        nextButton.setText(">");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 512, -1, -1));

        jkLabel.setText("Jenis Kelamin");
        getContentPane().add(jkLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jalanLabel.setText("Jalan");
        getContentPane().add(jalanLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));
        getContentPane().add(jalanField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 270, -1));

        jkComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));
        getContentPane().add(jkComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 270, -1));
        getContentPane().add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 270, -1));

        passLabel.setText("Password");
        getContentPane().add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 550, 109, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String nama = namaField.getText();
        String noTelp = noTelpField.getText();
        String jk = (String)jkComboBox.getSelectedItem();
        String jalan = jalanField.getText();
        String kelurahan = kelurahanField.getText();
        String kecamatan = kecamatanField.getText();
        String username = usernameField.getText();
        char [] arrPass = passField.getPassword();
        String password = new String(arrPass);
        DBNeeds.insertPembeli(nama, noTelp, jk, jalan, kelurahan, kecamatan, username, password);
        refreshTable();
        refreshTextField();
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String nama = namaField.getText();
        DBNeeds.deletePembeli(nama);
        refreshTable();
        refreshTextField();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String nama = namaField.getText();
        String noTelp = noTelpField.getText();
        String jk = (String)jkComboBox.getSelectedItem();
        String jalan = jalanField.getText();
        String kelurahan = kelurahanField.getText();
        String kecamatan = kecamatanField.getText();
        String username = usernameField.getText();
        char [] arrPass = passField.getPassword();
        String password = new String(arrPass);
        DBNeeds.updatePembeli(idPointer, nama, noTelp, jk, jalan, kelurahan, kecamatan, username, password);
        refreshTable();
        refreshTextField();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        refreshTextField();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) pembeliTbl.getModel();
        int rowCount = model.getRowCount();
        try{
            if (rowCount > 0) {
                currentRow = (currentRow - 1) % rowCount;
                String nama = (String) model.getValueAt(currentRow, 1);
                String noTelp = (String) model.getValueAt(currentRow, 2);
                String jk = (String) model.getValueAt(currentRow, 3);
                String jalan = (String) model.getValueAt(currentRow, 4);
                String kelurahan = (String) model.getValueAt(currentRow, 5);
                String kecamatan = (String) model.getValueAt(currentRow, 6);
                String username = (String) model.getValueAt(currentRow, 7);
                setFields(nama, noTelp, jk, jalan, kelurahan, kecamatan, username);

                pembeliTbl.setRowSelectionInterval(currentRow, currentRow);
                if (rowCount < 0){
                    currentRow = 0;
                }
            } 
        } catch (IndexOutOfBoundsException e){
            System.err.println("This is First Index, Please press the Next Button");
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) pembeliTbl.getModel();
        int rowCount = model.getRowCount();
        try {
            if (rowCount > 0 && currentRow < rowCount - 1) {
                currentRow++;
                String nama = (String) model.getValueAt(currentRow, 1);
                String noTelp = (String) model.getValueAt(currentRow, 2);
                String jk = (String) model.getValueAt(currentRow, 3);
                String jalan = (String) model.getValueAt(currentRow, 4);
                String kelurahan = (String) model.getValueAt(currentRow, 5);
                String kecamatan = (String) model.getValueAt(currentRow, 6);
                String username = (String) model.getValueAt(currentRow, 7);
                setFields(nama, noTelp, jk, jalan, kelurahan, kecamatan, username);

                pembeliTbl.setRowSelectionInterval(currentRow, currentRow);
            }
            if (currentRow <= rowCount - 1){
                System.err.println("This is Last Index, Please press the Previous Button");
            }
        } catch (IndexOutOfBoundsException e){
            System.err.println("This is Last Index, Please press the Previous Button");
        }
    }//GEN-LAST:event_nextButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jalanField;
    private javax.swing.JLabel jalanLabel;
    private javax.swing.JComboBox<String> jkComboBox;
    private javax.swing.JLabel jkLabel;
    private javax.swing.JTextField kecamatanField;
    private javax.swing.JLabel kecamatanLabel;
    private javax.swing.JTextField kelurahanField;
    private javax.swing.JLabel kelurahanLabel;
    private javax.swing.JTextField namaField;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField noTelpField;
    private javax.swing.JLabel noTelpLabel;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTable pembeliTbl;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
