package order;

import java.sql.Date;
import jenis_cucian.Cucian;
import pelanggan.Pelanggan;

public class Order {

    private int nomer_order;
    private Pelanggan pelanggan;
    private int total_bayar;
    private int bayar;
    private int sisa;
    private Cucian cucian;
    private int berat;
    private String keterangan;

    public int getNomer_order() {
        return nomer_order;
    }

    public void setNomer_order(int nomer_order) {
        this.nomer_order = nomer_order;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public int getTotal_bayar() {
        return total_bayar;
    }

    public void setTotal_bayar(int total_bayar) {
        this.total_bayar = total_bayar;
    }

    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }

    public int getSisa() {
        return sisa;
    }

    public void setSisa(int sisa) {
        this.sisa = sisa;
    }

    public Cucian getCucian() {
        return cucian;
    }

    public void setCucian(Cucian cucian) {
        this.cucian = cucian;
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

}
