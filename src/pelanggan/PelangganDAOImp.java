/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelanggan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author M WAWAN INDRAWAN
 */
public class PelangganDAOImp implements PelangganDAO {

    private Koneksi con = new Koneksi();
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel dtm;
    private final String[] column = {"ID", "NAMA PELANGGAN", "ALAMAT", "NO TELEPON"};

    private String view = "select * from pelanggan";
    private String insert = "insert into pelanggan (nama_pelanggan, alamat, telp) values (?, ?, ?)";

    private String update = "update pelanggan set nama_pelanggan=?,"
            + "alamat=?, telp=? where id_pelanggan=?";
    private String delete = "delete from pelanggan where id_pelanggan=?";
    private String search = "select * from pelanggan where nama_pelanggan like %?%";

    @Override
    public void read(JTable table) {
        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();
            rs = s.executeQuery(view);  //eksekusi yg tdk merubah isi tabel
            while (rs.next()) {
                Object[] col = new Object[4];
                col[0] = rs.getInt("id_pelanggan");
                col[1] = rs.getString("nama_pelanggan");
                col[2] = rs.getString("alamat");
                col[3] = rs.getString("telp");

                dtm.addRow(col);
            }
            table.setModel(dtm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void create(Pelanggan pelanggan) {
        try {
            ps = con.getCon().prepareStatement(insert);
            ps.setString(1, pelanggan.getNama());
            ps.setString(2, pelanggan.getNoTelp());
            ps.setString(3, pelanggan.getAlamat());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tambah data berhasil ^^");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void update(Pelanggan pelanggan) {
        try {
            ps = con.getCon().prepareStatement(update);
            ps.setString(1, pelanggan.getNama());
            ps.setString(2, pelanggan.getNoTelp());
            ps.setString(3, pelanggan.getAlamat());
            ps.setString(4, String.valueOf(pelanggan.getId()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ubah data berhasil ^^");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
          try {
            ps = con.getCon().prepareStatement(delete);
            ps.setString(1, String.valueOf(id));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hapus data berhasil ^^");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void search(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
