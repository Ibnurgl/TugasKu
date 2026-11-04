package database;

// BARIS IMPORT INI WAJIB ADA
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {
    private static Connection koneksi;

   public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                // Baris ini memaksa Java mengenali dan memuat driver MySQL
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                
                String url = "jdbc:mysql://localhost:3306/tugasku_db"; 
                String user = "root"; 
                String password = ""; 

                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi ke Database Berhasil!");
                
            } catch (Exception e) { // Ubah menjadi Exception agar menangkap semua jenis eror
                System.out.println("Koneksi Gagal: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Koneksi Database Gagal: " + e.getMessage());
            }
        }
        return koneksi;
    }
}
