
package gui;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.bluetooth.RemoteDevice;


public class TestBlue {
    
    public static boolean scanOnce(){
        boolean found = false;
        long start = System.currentTimeMillis();
        int i = 1;      
        try { 
            Vector v = RemoteDeviceDiscovery.discoverDevices();

            System.out.println("Time taken for round "+i+++": "
                    + (System.currentTimeMillis() - start)/1000.0+"secs");

            if(v==null){
                System.out.println("Wrong");
                return false;
            }

            found = checkBluetoothAddress(v);
            System.out.println("=======================================");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return found;
    }
    
    public static void startScan(){
        
        boolean keepRunning = true;
        int i = 1;
        try {
            while(keepRunning){
                long start = System.currentTimeMillis();
                Vector v = RemoteDeviceDiscovery.discoverDevices();
                System.out.println("Time taken for round "+i+++": "
                        + (System.currentTimeMillis() - start)/1000.0+"secs");
                
                if(v==null){
                    System.out.println("Wrong");
                    return;
                }
                
                keepRunning = checkBluetoothAddress(v);
                System.out.println("=======================================");
            }
        } catch (IOException ex) {
            Logger.getLogger(TestBlue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestBlue.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    static boolean checkBluetoothAddress(Vector v){
        
        boolean keepSearching = false;
        String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
        String user = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_com LIMIT 1");
            rs.first();
            Iterator itr = v.iterator();
            while(itr.hasNext()){
                String remoteAddr = ((RemoteDevice) itr.next()).getBluetoothAddress();
                if(rs.getString("blue_add").equals(remoteAddr)){
                    System.out.println("Match found in db... avoid terminate now.");
                    keepSearching = true;
                    break;
                }
            }
            
            return keepSearching;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println("Some db related error");
        return false;
    }
}

