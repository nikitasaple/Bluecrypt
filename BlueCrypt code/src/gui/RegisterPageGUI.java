
package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


class JTextFieldLimit extends PlainDocument{
    int limit;
    JTextFieldLimit(int limit){
        super();
        this.limit = limit;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
    if(offs > (limit-1))
            return;
        else        
            super.insertString(offs, str, a); 
    }
}
class JTextDOBFormat extends PlainDocument{
    JTextDOBFormat(){
        super();
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
    if(getLength() >= (10))
            return;
               
        super.insertString(offs, str, a); 
        if(offs == 1 || offs == 4)
        {
            super.insertString(offs+1, "/", a);
        }
    }
}

public class RegisterPageGUI extends javax.swing.JFrame {

    
    public RegisterPageGUI() {
        initComponents();
        nameText.setDocument(new JTextFieldLimit(25));
        mnoText.setDocument(new JTextFieldLimit(10));
        emailText.setDocument(new JTextFieldLimit(25));
        imeiText.setDocument(new JTextFieldLimit(15));
        dobText.setDocument(new JTextDOBFormat());
        passPassword.setDocument(new JTextFieldLimit(10));
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        infoLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        dobLabel = new javax.swing.JLabel();
        mnoLabel = new javax.swing.JLabel();
        imeiLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        repeatLabel = new javax.swing.JLabel();
        tncLabel = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        nameText = new javax.swing.JTextField();
        dobText = new javax.swing.JTextField();
        mnoText = new javax.swing.JTextField();
        imeiText = new javax.swing.JTextField();
        emailText = new javax.swing.JTextField();
        usernameText = new javax.swing.JTextField();
        passPassword = new javax.swing.JPasswordField();
        repPassPassword = new javax.swing.JPasswordField();
        exitButton = new javax.swing.JButton();
        labelSuggsPass = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");

        infoLabel.setText("Please Register your software with the following details:");

        nameLabel.setText("NAME:");

        dobLabel.setText("DATE OF BIRTH:");

        mnoLabel.setText("MOBILE NUMBER:");

        imeiLabel.setText("IMEI No.:");

        emailLabel.setText("Email Id:");

        usernameLabel.setText("USERNAME:");

        passwordLabel.setText("PASSWORD:");

        repeatLabel.setText("REPEAT PASSWORD:");

        tncLabel.setText("By clicking CREATE, you agree to our T&C,");

        createButton.setText("CREATE");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        resetButton.setText("RESET");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        mnoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnoTextActionPerformed(evt);
            }
        });

        imeiText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imeiTextActionPerformed(evt);
            }
        });

        usernameText.setEditable(false);
        usernameText.setToolTipText("");
        usernameText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usernameText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameTextMouseClicked(evt);
            }
        });
        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });
        usernameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameTextFocusGained(evt);
            }
        });

        passPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passPasswordActionPerformed(evt);
            }
        });
        passPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passPasswordFocusLost(evt);
            }
        });

        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        labelSuggsPass.setText("(5-10 characters)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(createButton)
                        .addGap(18, 18, 18)
                        .addComponent(resetButton)
                        .addGap(29, 29, 29)
                        .addComponent(exitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(tncLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(infoLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(repeatLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(repPassPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(passwordLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(passPassword))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(usernameLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(usernameText, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(emailLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(emailText))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(imeiLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(imeiText))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(nameText))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(mnoLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(mnoText))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(dobLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dobText))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelSuggsPass)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dobLabel)
                    .addComponent(dobText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mnoLabel)
                    .addComponent(mnoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imeiLabel)
                    .addComponent(imeiText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSuggsPass))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repeatLabel)
                    .addComponent(repPassPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(tncLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton)
                    .addComponent(resetButton)
                    .addComponent(exitButton))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        MyDialog mDialog = new MyDialog(this, true);
        if(checkValidName()){
            mDialog.setDialogLabel("Entered Name Is incorrect");
             mDialog.setTitle("Error");
            mDialog.setVisible(true);
            return;
        }
        
        
        
        if(checkValidDOB()){
            mDialog.setDialogLabel("Entered Date of Birth is incorrect!");
             mDialog.setTitle("Error");
            mDialog.setVisible(true);return;
        }
        
        if(checkValidMobile()){
            mDialog.setDialogLabel("Entered mobile number is incorrect!");
             mDialog.setTitle("Error");
            mDialog.setVisible(true);return;
        }
        
        if (checkValidIMEI()){
            mDialog.setDialogLabel("Entered IMEI Number is Incorrecct");
             mDialog.setTitle("Error");
            mDialog.setVisible(true);return;
        }
         if(checkValidEmailId()){
            mDialog.setDialogLabel("Entered Email ID is incorrect!");
             mDialog.setTitle("Error");
            mDialog.setVisible(true);return;
        }
         if(checkValidPasswordLength()){
            mDialog.setDialogLabel("Password is less than 5 characters!");
             mDialog.setTitle("Error");
            mDialog.setVisible(true);return;
        }
         if(checkValidPasswordSpace()){
            mDialog.setDialogLabel("Password contains blank spaces!");
            mDialog.setTitle("Error");
            mDialog.setVisible(true);return;
        }
         if(checkValidPasswordMatch()){
            mDialog.setDialogLabel("Password doesnt match!");
             mDialog.setTitle("Error");
            mDialog.setVisible(true);return;
        }
         storeDatabase();
         mDialog.setDialogLabel("You are now Registered!!");
         mDialog.setTitle("Success");
         mDialog.setVisible(true);
         
         CreateProfilePageGUI cpg= new CreateProfilePageGUI();
         cpg.setVisible(true);
         this.setVisible(false);
         
         
        
    }//GEN-LAST:event_createButtonActionPerformed

    private boolean checkValidDOB(){
        Calendar cal = Calendar.getInstance();
        int currYear = cal.getWeekYear();
        System.out.println(currYear);
        String dd,mm,yyyy;
        String dob = dobText.getText();
        if(dob.length() < 10)
            return true;
        String[] a = dob.split("/");
        dd = a[0];
        mm = a[1];
        yyyy = a[2];
        int day, month, year;
        try{
            day = Integer.parseInt(dd);
            month = Integer.parseInt(mm);
            year = Integer.parseInt(yyyy);
        }catch(Exception e){
            return true;
        }
        if(!(year<=currYear && year>=(currYear-150)))
            return true;
           if(month > 12 || month < 1){
            return true;
        }
        else
        {
         
        }
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: if(day > 31 || day < 1){
                return true;
            }
            case 2: if(year % 4 == 0){
                if(day > 29 || day < 1)
                    return true;
            }else{
                if(day > 28 || day < 1)
                    return true;
            }
            default: if(day > 30 || day < 1)
                return true;
        }
        return false;
    }
    
    private boolean checkValidMobile(){
        String mob = mnoText.getText();
        if(mob.length()<10) return true;
         if(mob.trim().length() == 0)
             return true;
        boolean mobileFlag = false;
        char a[] = mob.toCharArray();
        for(char c : a){
            if(!Character.isDigit(c)){
                mobileFlag = true;
                break;
            }
        }
        return mobileFlag;
    }
    
   private boolean checkValidName(){
       String name = nameText.getText();
       if(name.trim().length() == 0)
           return true;
       boolean mobileFlag = false;
        char a[] = name.toCharArray();
        for(char n : a){
            if(!Character.isLetter(n) && (n != ' ')){
                mobileFlag = true;
                break;
            }
        }
        return mobileFlag;
   }
   
   private boolean checkValidEmailId(){
        String email_id = emailText.getText();
        if(email_id.trim().length() == 0)
           return true;
        String email_format = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Boolean validity = email_id.matches(email_format);
        if(!validity){
            return true;
        }
        else
        return false;
    }

    private boolean checkValidIMEI(){
        String imei = imeiText.getText();
        if(imei.length()<15) return true; 
        if(imei.trim().length() == 0)
             return true;
        boolean mobileFlag = false;
        char a[] = imei.toCharArray();
        for(char c : a)
            if(!Character.isDigit(c)){
                mobileFlag = true;
                break;
            }return mobileFlag;
        }
    
     private boolean checkValidPasswordLength(){
        char[] password = passPassword.getPassword();
       if(password.length == 0 || password.length <5)
           return true;
       else
           return false;
      
   }
     
      private boolean checkValidPasswordSpace(){
       char[] password = passPassword.getPassword();
       boolean mobileFlag = false;
       
        for(char n : password){
            if((n == ' ')){
                mobileFlag = true;
                break;
            }
        }
        return mobileFlag;
   }
        
      private boolean checkValidPasswordMatch(){
      char[] pass1=passPassword.getPassword();
      String passString1=String.copyValueOf(pass1);
      char[] pass2=repPassPassword.getPassword();
      String passString2=String.copyValueOf(pass2);
      
      if(passString1.equals(passString2))
      return false;
      else
          return true;
      
      
      
      }
      private void storeDatabase(){
      
          String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
           String user = "root";
           
            try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO user_com VALUES (?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1,nameText.getText());
            pstmt.setString(2,dobText.getText());
            pstmt.setString(3,mnoText.getText());
            pstmt.setString(4,imeiText.getText());
            pstmt.setString(5,emailText.getText());
            pstmt.setString(6,usernameText.getText());
            char[] pass1=passPassword.getPassword();
            String passString1=String.copyValueOf(pass1);
            pstmt.setString(7,passString1);
            pstmt.setString(8,"");
            pstmt.setString(9,"");
            try{
                pstmt.executeUpdate();
            }
            catch(SQLException e){
            e.printStackTrace();
            }
            pstmt.setString(8,"");
            pstmt.setString(9,"");
           } catch (Exception ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
  
      }
   
   public void connection(){
        String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
           String user = "root";
           
            try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            }
            catch(Exception e){
            e.printStackTrace();
            }
   
   }
    
    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void imeiTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imeiTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imeiTextActionPerformed

    private void passPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passPasswordActionPerformed

    private void mnoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnoTextActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        nameText.setText("");
        mnoText.setText("");
        imeiText.setText("");
        dobText.setText("");
        emailText.setText("");
        usernameText.setText("");
        passPassword.setText("");
        repPassPassword.setText("");
    }//GEN-LAST:event_resetButtonActionPerformed

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextActionPerformed
       
    }//GEN-LAST:event_usernameTextActionPerformed

    private void usernameTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameTextMouseClicked
         // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextMouseClicked

    private void usernameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTextFocusGained
      if(usernameText.isFocusOwner()){
        usernameText.setText(emailText.getText());
        } // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFocusGained

    private void passPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passPasswordFocusLost
      
    }//GEN-LAST:event_passPasswordFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
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
            java.util.logging.Logger.getLogger(RegisterPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run(){
                new RegisterPageGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createButton;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JTextField dobText;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel imeiLabel;
    private javax.swing.JTextField imeiText;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel labelSuggsPass;
    private javax.swing.JLabel mnoLabel;
    private javax.swing.JTextField mnoText;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JPasswordField passPassword;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField repPassPassword;
    private javax.swing.JLabel repeatLabel;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel tncLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
