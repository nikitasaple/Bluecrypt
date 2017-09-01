
package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBTest {
    public static void main(String[] args) {
        String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
        String user = "root";
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO demotable VALUES (?,?)");
            pstmt.setInt(1, 21);
            pstmt.setString(2, "Ankita Kesarkar");
            try{
                System.out.println(""+pstmt.executeUpdate());
            }
            catch(SQLException e){
                System.out.println("The given roll_no already exists! Please give a different one.");
            }
           
        } catch (Exception ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
