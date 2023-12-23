package BuyerDashboard;

import Database.DBNeeds;
import java.sql.Date;
import java.time.LocalDate;

public class tes {
    
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        Date date = java.sql.Date.valueOf(today);
        String tanggal = "2023-11-21";
        String status = "Belum dikirim";
        int total = 32000;
        int idPenjual = 10000;
        int idPembeli = 20000;
    }
    
}
