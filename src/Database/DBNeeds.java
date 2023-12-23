package Database;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DBNeeds {
    private static final String url = "jdbc:sqlserver://localhost\\LAPTOP-KKU381U5:1433;databaseName=GetEat;encrypt=false";
    private static final String user = "user1";
    private static final String pass = "123456789fadhil";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
    public static void insertPenjual(String namaToko, String noTelp, String jalan, String kelurahan, String kecamatan, String username, String password) {
        String query = "INSERT INTO penjual (nama_Toko, no_Telp, jalan, kelurahan, kecamatan, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, namaToko);
            preparedStatement.setString(2, noTelp);
            preparedStatement.setString(3, jalan);
            preparedStatement.setString(4, kelurahan);
            preparedStatement.setString(5, kecamatan);
            preparedStatement.setString(6, username);
            preparedStatement.setString(7, password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deletePenjual(String namaToko){
        String query = "DELETE FROM penjual WHERE nama_Toko = ?";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, namaToko);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
    public static void updatePenjual(int id, String namaToko, String noTelp, String jalan, String kelurahan, String kecamatan, String username, String password) {
    String query = "UPDATE penjual SET nama_Toko = ?, no_Telp = ?, jalan = ?, kelurahan = ?, kecamatan = ?, username = ?, password = ? WHERE id_Penjual = ?";

    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, namaToko);
            preparedStatement.setString(2, noTelp);
            preparedStatement.setString(3, jalan);
            preparedStatement.setString(4, kelurahan);
            preparedStatement.setString(5, kecamatan);
            preparedStatement.setString(6, username);
            preparedStatement.setString(7, password);
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertPembeli(String nama, String noTelp, String jk, String jalan, String kelurahan, String kecamatan, String username, String password) {
        String query = "INSERT INTO pembeli (nama, no_Telp,jenis_Kelamin, jalan, kelurahan, kecamatan, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, noTelp);
            preparedStatement.setString(3, jk);
            preparedStatement.setString(4, jalan);
            preparedStatement.setString(5, kelurahan);
            preparedStatement.setString(6, kecamatan);
            preparedStatement.setString(7, username);
            preparedStatement.setString(8, password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deletePembeli(String nama){
        String query = "DELETE FROM pembeli WHERE nama = ?";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nama);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
    public static void updatePembeli(int id, String nama, String noTelp,String jk, String jalan, String kelurahan, String kecamatan, String username, String password) {
    String query = "UPDATE pembeli SET nama = ?, no_Telp = ?, jenis_Kelamin = ?, jalan = ?, kelurahan = ?, kecamatan = ?, username = ?, password = ? WHERE id_Pembeli = ?";

    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, noTelp);
            preparedStatement.setString(3, jk);
            preparedStatement.setString(4, jalan);
            preparedStatement.setString(5, kelurahan);
            preparedStatement.setString(6, kecamatan);
            preparedStatement.setString(7, username);
            preparedStatement.setString(8, password);
            preparedStatement.setInt(9, id);
            preparedStatement.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertKurir(String nama, String noTelp, String jk, String namaKendaraan, String platNomor, String username, String password) {
        String query = "INSERT INTO kurir (nama, no_Telp, jenis_Kelamin, nama_Kendaraan, Plat_Nomor, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, noTelp);
            preparedStatement.setString(3, jk);
            preparedStatement.setString(4, namaKendaraan);
            preparedStatement.setString(5, platNomor);
            preparedStatement.setString(6, username);
            preparedStatement.setString(7, password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteKurir(String nama){
        String query = "DELETE FROM kurir WHERE nama = ?";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nama);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
    public static void updateKurir(int id, String nama, String noTelp, String jk, String namaKendaraan, String platNomor, String username, String password) {
    String query = "UPDATE kurir SET nama = ?, no_Telp = ?, jenis_Kelamin = ?, nama_Kendaraan = ?, plat_Nomor = ?, username = ?, password = ? WHERE id_Kurir = ?";

    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, noTelp);
            preparedStatement.setString(3, jk);
            preparedStatement.setString(4, namaKendaraan);
            preparedStatement.setString(5, platNomor);
            preparedStatement.setString(6, username);
            preparedStatement.setString(7, password);
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertProduk(String nama, int harga, int stok, String kategori, int idPenjual) {
        String query = "INSERT INTO produk (nama, harga, stok, id_Penjual, kategori) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nama);
            preparedStatement.setInt(2, harga);
            preparedStatement.setInt(3, stok);
            preparedStatement.setInt(4, idPenjual);
            preparedStatement.setString(5, kategori);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteProduk(int id){
        String query = "DELETE FROM produk WHERE id_Produk = ?";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
    public static void updateProduk(int id, String namaProduk, int harga, int stok, String kategori, int idPenjual) {
    String query = "UPDATE produk SET nama = ?, harga = ?, stok = ?, kategori = ?, id_Penjual = ? WHERE id_Produk = ?";

    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, namaProduk);
            preparedStatement.setInt(2, harga);
            preparedStatement.setInt(3, stok);
            preparedStatement.setString(4, kategori);
            preparedStatement.setInt(5, idPenjual);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertDetail(int idProduk, int kuantitas, int subTotal, int idPesanan) {
        String query = "INSERT INTO detail (Kuantitas, subtotal, id_Pesanan, id_Produk) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, kuantitas);
            preparedStatement.setInt(2, subTotal);
            preparedStatement.setInt(4, idProduk);
            preparedStatement.setInt(3, idPesanan);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static int insertPesanan(Date date, String status, int total, int idPembeli) {
        String query = "INSERT INTO pesanan (status_Psnn, total, id_Pembeli, tgl_pesanan) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, total);
            preparedStatement.setInt(3, idPembeli);
            preparedStatement.setDate(4, date);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        return generatedId;
                    } else {
                        System.out.println("Tidak dapat mengambil ID yang baru dibuat.");
                        return 0;
                    }
                }
            } else {
                System.out.println("Tidak ada baris yang terpengaruh.");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public static void updatePesanan(int total, int id_Pesanan, int idPenjual){
        String status = "Sedang diproses";
        String query = "UPDATE pesanan SET total = ?, status_Psnn = ?, id_Penjual = ? WHERE id_Pesanan = ?";
         
         try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, total);
            preparedStatement.setString(2, status);
            preparedStatement.setInt(3, idPenjual);
            preparedStatement.setInt(4, id_Pesanan);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void insertPembayaran(String metode, int idPesanan) {
        
        String query = "INSERT INTO pembayaran (status_Pemb, metode_Pemb, id_Pesanan) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            String status = "Lunas";
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, metode);
            preparedStatement.setInt(3, idPesanan);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String getStatusPesanan(int id){
        String status = "";
        String query = "SELECT status_Psnn FROM pesanan WHERE id_Pesanan = ?";
        
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                status = resultSet.getString("status_Psnn");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return status;
    }
    public static int getIdPesanan(int idPenjual, int idPembeli, int total){
        int idPesanan = 0;
        String query = "SELECT * FROM pesanan WHERE id_Penjual = ? AND id_Pembeli = ? AND total = ?";
        
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idPenjual);
            preparedStatement.setInt(2, idPembeli);
            preparedStatement.setInt(3, total);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                idPesanan = resultSet.getInt("id_Pesanan");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } return idPesanan;
    }
    
    public static int getIdPembeli(String username){
        int idPembeli = 0;
        String query = "SELECT id_Pembeli FROM pembeli WHERE username = ?";
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                idPembeli = resultSet.getInt("id_Pembeli");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } return idPembeli;
    }
    public static int getIdPenjual(String username){
        int idPenjual = 0;
        String query = "SELECT id_Penjual FROM penjual WHERE username = ?";
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                idPenjual = resultSet.getInt("id_Penjual");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } return idPenjual;
    }
    
    public static int getIdKurir(String username){
        int idPembeli = 0;
        String query = "SELECT id_Kurir FROM kurir WHERE username = ?";
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                idPembeli = resultSet.getInt("id_Kurir");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } return idPembeli;
    }
    
    public static int getIdPenjual(int idProduk) {
        int idPenjual = 0;

        try (Connection connection = getConnection()) {
            String query = "SELECT id_Penjual FROM produk WHERE id_Produk = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, idProduk);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        idPenjual = resultSet.getInt("id_Penjual");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idPenjual;
    }
    public static int getLatestIdPesanan() {
        int latestIdPesanan = 0;

        try (Connection connection = getConnection()) {
            String query = "SELECT MAX(id_Pesanan) AS latestIdPesanan FROM pesanan";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        latestIdPesanan = resultSet.getInt("latestIdPesanan");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return latestIdPesanan;
    }
    public static void updateStatusPesanan(int id, String status){
        String query = "UPDATE pesanan SET status_Psnn = ? WHERE id_Pesanan = ?";
         
         try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateIdKurirPesanan(int idKurir, int idPesanan){
        String query = "UPDATE pesanan SET id_Kurir = ? WHERE id_Pesanan = ?";
         
         try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idKurir);
            preparedStatement.setInt(2, idPesanan);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertPengiriman(int idKurir, Date tgl) {
        
        String query = "INSERT INTO pengiriman (id_Kurir, status_Pngrmn, tgl_Pengiriman) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            String status = "Sedang dikirim";
            preparedStatement.setInt(1, idKurir);
            preparedStatement.setString(2, status);
            preparedStatement.setDate(3, tgl);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateStatusPengiriman(int idKurir){
        String query = "UPDATE pengiriman SET status_Pngrmn = ? WHERE id_Kurir = ?";
         
         try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            String status = "Selesai dikirimkan";
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, idKurir);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
