/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.util.List;
import javax.swing.JTable;
import jenis_cucian.Cucian;
import pelanggan.Pelanggan;
import pengguna.Pengguna;

/**
 *
 * @author M WAWAN INDRAWAN
 */
public interface OrderDAO {

    public List<Pelanggan> loadpelanggan();

    public List<Cucian> loadcucian();

    public void read(JTable table);

    public void berat_cucian(int berat_cucian, int harga);

    public void create(Order order, int id);

    public void delete(int id);

    public void search(JTable jt, String key);
}
