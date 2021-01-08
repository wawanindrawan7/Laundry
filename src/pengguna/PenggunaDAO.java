package pengguna;

import javax.swing.JTable;

public interface PenggunaDAO {
    public void read(JTable table);

    public void create(Pengguna user);

    public void update(Pengguna user);

    public void delete(int id);

    public void search(String key);
}