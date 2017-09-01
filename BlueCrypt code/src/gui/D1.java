
package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class D1 {
    public static void main(String args[]) {
        String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
        String user = "root"; 
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM encrypted_files WHERE name=? LIMIT 1");
            stmt.setString(1, "9.jpg");
            ResultSet rs = stmt.executeQuery();
            rs.first();
            System.out.println(rs.getString(1));
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}
