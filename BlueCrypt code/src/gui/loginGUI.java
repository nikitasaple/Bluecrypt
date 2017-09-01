
package gui;

import com.mysql.jdbc.Statement;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class loginGUI extends javax.swing.JFrame {
    private String username1;
    private String password1;
    String passString1;
    private String blueName;
    private String blueAdd;
    final Frame parent = this;

  
        public loginGUI() {
        initComponents();

    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        passPassword = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        progBar = new javax.swing.JProgressBar();
        progBar.setVisible(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BlueCrypt v1.0");

        welcomeLabel.setText("Welcome!! Enter your Username and Password to Login:");

        usernameLabel.setText("USERNAME:");

        passLabel.setText("PASSWORD:");

        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });

        passPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passPasswordActionPerformed(evt);
            }
        });

        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setText("REGISTER");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        progBar.setIndeterminate(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loginButton)
                                .addGap(18, 18, 18)
                                .addComponent(registerButton)
                                .addGap(18, 18, 18)
                                .addComponent(exitButton))
                            .addComponent(welcomeLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passLabel)
                                    .addComponent(usernameLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(usernameText))))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(248, Short.MAX_VALUE)
                        .addComponent(progBar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(welcomeLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(passPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(registerButton)
                    .addComponent(exitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(progBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void getDatabase(){
           String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
           String user = "root";
           
            try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            Statement stmt = (Statement) con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("SELECT username, password FROM user_com LIMIT ?");
            pstmt.setInt(1, 1);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
            username1=rs.getString(1);
            password1=rs.getString(2);
            System.out.println("username:"+username1+"  "+"password:"+password1);
            }
            
           
        } catch (Exception ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
   public boolean checkNullDatabase(){
        boolean checkStatus = false;
         String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
           String user = "root";
           
            try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            Statement stmt = (Statement) con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("SELECT username, password FROM user_com LIMIT ?");
            pstmt.setInt(1, 1);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
            username1=rs.getString(1);
            password1=rs.getString(2);
            }
            if(username1==null||password1==null){
            
                checkStatus=true;
            }
            else
                checkStatus=false;
       
        } catch (Exception ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
             return checkStatus;
        
       
   
   
   }
   public boolean checkNullBlueDatabase(){
        boolean checkStatus = false;
         String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
           String user = "root";
           
            try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            Statement stmt = (Statement) con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("SELECT blue_name, blue_add FROM user_com LIMIT ?");
            pstmt.setInt(1, 1);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
            blueName=rs.getString(1);
            blueAdd=rs.getString(2);
            }
            if(blueName.equals("")||blueAdd.equals("")){
            
                checkStatus=true;
            }
            else
                checkStatus=false;
           
           
        } catch (Exception ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
             return checkStatus;
        
       
   
   
   }
    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextActionPerformed

    private void passPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passPasswordActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        progBar.setVisible(true);
        new Thread(new Runnable() {

            @Override
            public void run() {
                 getDatabase();
        char[] pass1=passPassword.getPassword();
        passString1=String.copyValueOf(pass1);
        
       
        if(usernameText.getText().equals(username1)&& passString1.equals(password1)){
            System.out.println("Success");
         
            if( TestBlue.scanOnce()){
                  protectionPageGUI pg=new protectionPageGUI();
                  pg.setVisible(true);
                  parent.setVisible(false);
                   }     
            else{
                 MyDialog mDialog=new MyDialog(parent, true);
                 mDialog.setDialogLabel("Switch on your Paired Bluetooth Device");
                 mDialog.setTitle("Error");
                 mDialog.setVisible(true);
                }
     
        }
        else{
            System.out.println("Error");
                MyDialog mDialog=new MyDialog(parent, true);
                 mDialog.setDialogLabel("Username and Passwords dont match");
                 mDialog.setTitle("Error");
                 mDialog.setVisible(true);
        }
        SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            progBar.setVisible(false);
                            
                        }
                    });
        System.out.println("Button clicked");
        
                
            }
        }).start();
        
       
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
       getDatabase();
        if(checkNullDatabase()){
            RegisterPageGUI regPg = new RegisterPageGUI();
            loginGUI.this.setVisible(false);
            regPg.setVisible(true);
        }
        else{
                 MyDialog mDialog=new MyDialog(this, true);
                 mDialog.setDialogLabel("You are already registered");
                 mDialog.setTitle("Error");
                 mDialog.setVisible(true);
        
        
        }
       
        
        
        
    }//GEN-LAST:event_registerButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
     System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

   
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new loginGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passPassword;
    private javax.swing.JProgressBar progBar;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameText;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
