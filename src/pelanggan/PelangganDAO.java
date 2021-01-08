/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelanggan;

import javax.swing.JTable;


/**
 *
 * @author M WAWAN INDRAWAN
 */
public interface PelangganDAO {
    public void read(JTable table);

    public void create(Pelanggan pelanggan);

    public void update(Pelanggan pelanggan);

    public void delete(int id);

    public void search(String key);
}
