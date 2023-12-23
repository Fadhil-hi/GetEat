
package Entity;

public class Pembeli {
    private int id;
    private String nama;
    private String noTelp;
    private String jk;
    private String jalan;
    private String kelurahan;
    private String kecamatan;

    public Pembeli(int id, String nama, String noTelp, String jk, String jalan, String kelurahan, String kecamatan) {
        this.id = id;
        this.nama = nama;
        this.noTelp = noTelp;
        this.jk = jk;
        this.jalan = jalan;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
    }

    public String getJalan() {
        return jalan;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getJk() {
        return jk;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public String getNoTelp() {
        return noTelp;
    }
    
    
}
