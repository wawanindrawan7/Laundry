/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenis_cucian;

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
public class CucianDAOImp implements CucianDAO {

    private Koneksi con = new Koneksi();
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel dtm;
    private final String[] column = {"KODE JENIS", "JENIS CUCIAN", "HARGA"};

    private String view = "select * from jenis_cucian";
    private String insert = "insert into jenis_cucian (jenis_cucian, harga) values (?, ?)";

    private String update = "update jenis_cucian set jenis_cucian=?,"
            + "harga=? where kd_jenis=?";
    private String delete = "delete from jenis_cucian where kd_jenis=?";
    private String search = "select * from jenis_cucian where jenis_cucian like %?%";

    @Override
    public void read(JTable table) {
        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();
            rs = s.executeQuery(view);  //eksekusi yg tdk merubah isi tabel
            while (rs.next()) {
                Object[] col = new Object[3];
                col[0] = rs.getInt("kd_jenis");
                col[1] = rs.getString("jenis_cucian");
                col[2] = rs.getString("harga");

                dtm.addRow(col);
            }
            table.setModel(dtm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void create(Cucian cucian) {
        try {
            ps = con.getCon().prepareStatement(insert);
            ps.setString(1, cucian.getJenis_cucian());
            ps.setString(2, String.valueOf(cucian.getHarga()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tambah data berhasil ^^");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void update(Cucian cucian) {
        try {
            ps = con.getCon().prepareStatement(update);
            ps.setString(1, cucian.getJenis_cucian());
            ps.setString(2, String.valueOf(cucian.getHarga()));
            ps.setString(3, String.valueOf(cucian.getId()));
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
