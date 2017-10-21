package id.co.kamil.cafe;

/**
 * Created by Irham on 10/21/2017.
 */

public class DataMenu {
    private String nama;
    private String penjelasan;
    private String harga;
    private String jenis;

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "DataMenu{" +
                "nama='" + nama + '\'' +
                ", penjelasan='" + penjelasan + '\'' +
                ", harga='" + harga + '\'' +
                ", jenis='" + jenis + '\'' +
                '}';
    }
}
