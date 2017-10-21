package id.co.kamil.cafe;

/**
 * Created by Irham on 10/21/2017.
 */

public class Pesanan {
    private int id;
    private String tgl;
    private String meja;
    private String jam;
    private String menu;
    private String harga;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getMeja() {
        return meja;
    }

    public void setMeja(String meja) {
        this.meja = meja;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    @Override
    public String toString() {
        return "Pesanan{" +
                "tgl='" + tgl + '\'' +
                ", meja='" + meja + '\'' +
                ", jam='" + jam + '\'' +
                ", menu='" + menu + '\'' +
                ", harga='" + harga + '\'' +
                '}';
    }
}
