package order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jenis_cucian.Cucian;
import koneksi.Koneksi;
import pelanggan.Pelanggan;
import pengguna.Pengguna;

public class OrderDAOImp implements OrderDAO {

    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel dtm;
    String status1;
    private Koneksi con = new Koneksi();
    private String read = "SELECT B.no_order,A.nama_pelanggan, B.t_bayar, B.bayar, B.sisa, B.berat, B.keterangan, C.jenis_cucian, C.harga FROM pelanggan A JOIN penerimaan B ON A.id_pelanggan=B.id_pelanggan JOIN jenis_cucian C ON C.kd_jenis = B.kd_jenis";
    private String loadpelanggan = "select * from pelanggan";
    private String loadcucian = "select * from jenis_cucian";
    private String insert = "insert into penerimaan (id_pelanggan,nama_pelanggan, kd_jenis, jenis_cucian, berat, keterangan, harga, t_bayar, bayar, sisa"
            + ") value (?, ?, ?, ? ,?, ?, ?, ?, ?, ?)";
    private String delete = "delete from penerimaan where id = ?";
    private String[] column = {"NO ORDER", "NAMA PELANGGAN", "JENIS CUCIAN", "BERAT", "KETERANGAN", "HARGA", "TOTAL BAYAR"
        + "BAYAR", "SISA"};

    @Override
    public List<Pelanggan> loadpelanggan() {
        List<Pelanggan> pelangganlist = new ArrayList<>();

        try {
            s = con.getCon().createStatement();
            rs = s.executeQuery(loadpelanggan);

            while (rs.next()) {
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setId(rs.getInt("id_pelanggan"));
                pelanggan.setNama(rs.getString("nama_pelanggan"));
                pelanggan.setAlamat(rs.getString("alamat"));
                pelanggan.setAlamat(rs.getString("telp"));
                pelangganlist.add(pelanggan);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return pelangganlist;
    }

    @Override
    public List<Cucian> loadcucian() {
        List<Cucian> cucianlist = new ArrayList<>();

        try {
            s = con.getCon().createStatement();
            rs = s.executeQuery(loadcucian);

            while (rs.next()) {
                Cucian cucian = new Cucian();
                cucian.setId(rs.getInt("kd_jenis"));
                cucian.setJenis_cucian(rs.getString("jenis_cucian"));
                cucian.setHarga(rs.getInt("harga"));
                cucianlist.add(cucian);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return cucianlist;
    }

    @Override
    public void read(JTable table) {

        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();
            rs = s.executeQuery(read);

            while (rs.next()) {
                Object[] oj = new Object[9];
                oj[0] = rs.getInt("no_order");
                oj[1] = rs.getString("nama_pelanggan");
                oj[2] = rs.getString("jenis_cucian");
                oj[3] = rs.getInt("berat") + " Kg";
                oj[4] = rs.getString("keterangan");
                oj[5] = rs.getInt("keterangan");
                oj[6] = rs.getInt("harga");
                oj[7] = rs.getInt("total_bayar");
                oj[8] = rs.getInt("bayar");
                oj[9] = rs.getInt("sisa");
                dtm.addRow(oj);
            }
            table.setModel(dtm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(table, e.getMessage());
        }
    }

    @Override
    public void berat_cucian(int berat_cucian, int harga) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Order order, int id) {
        try {
            ps = con.getCon().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setInt(2, order.getBerat());
            ps.setString(3, order.getKeterangan());
            ps.setInt(4, order.getTotal_bayar());
            ps.setInt(5, order.getBayar());
            ps.setInt(6, order.getSisa());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Transaksi Berhasil berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("error");

        }
    }

    @Override
    public void delete(int id) {
        try {
            ps = con.getCon().prepareStatement(delete);
            ps.setString(1, String.valueOf(id));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void search(JTable jt, String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
