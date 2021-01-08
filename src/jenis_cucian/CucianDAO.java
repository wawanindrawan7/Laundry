/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenis_cucian;

import javax.swing.JTable;


/**
 *
 * @author M WAWAN INDRAWAN
 */
public interface CucianDAO {
     public void read(JTable table);

    public void create(Cucian cucian);

    public void update(Cucian cucian);

    public void delete(int id);

    public void search(String key);
}
