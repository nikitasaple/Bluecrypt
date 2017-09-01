/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mysql.jdbc.Statement;
import java.awt.Dialog;
import java.awt.Frame;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.bluetooth.RemoteDevice;
import javax.crypto.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FilenameUtils;



public class protectionPageGUI extends javax.swing.JFrame {
 
    
    JFileChooser browse=new JFileChooser();
    String iv = null;
    String salt = null;
    List<String> encrFiles = new ArrayList<String>();
    private String eFile;
    String blue_name;
    String blue_add;
    InputStream inputstreamE;
    private String fileParent;
    final Frame parent = this;
    File arrFiles[];
    private String[] FileNames;
    List<String> results = new ArrayList<String>();
    
   
    public protectionPageGUI() {
        initComponents();
    }
    public void getDatabase(){
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
              blue_name=rs.getString(1);
              blue_add=rs.getString(2);
            }
         } catch (Exception ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    public void storeFile(){
           String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
           String user = "root";
           
            try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO file_info VALUES (?)");
            pstmt.setBlob(1, inputstreamE);
      
    }
            catch(Exception ex){
                ex.printStackTrace();
            }} 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        selectProtectLabel = new javax.swing.JLabel();
        pathText = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        selectDisableLable = new javax.swing.JLabel();
        disableProButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        proFolderList = new javax.swing.JList();
        enableProButton = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Protection");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        selectProtectLabel.setText("Select Folder to Protect:");

        pathText.setEditable(false);
        pathText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathTextActionPerformed(evt);
            }
        });

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        selectDisableLable.setText("Select File to Decrypt :");

        disableProButton.setText("Decrypt ");
        disableProButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disableProButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        progressBar.setIndeterminate(true);
        progressBar.setVisible(false);

        proFolderList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(proFolderList);

        enableProButton.setText("Enable Protection");
        enableProButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableProButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectProtectLabel)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pathText)
                        .addGap(18, 18, 18)
                        .addComponent(browseButton)
                        .addGap(47, 47, 47))))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(disableProButton)
                .addGap(18, 18, 18)
                .addComponent(exitButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectDisableLable)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(enableProButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(selectProtectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browseButton)
                    .addComponent(pathText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enableProButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectDisableLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disableProButton)
                    .addComponent(exitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String[] getFilepathFromDb(String filename) {
        String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
        String user = "root"; 
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM encrypted_files WHERE name=? LIMIT 1");
            stmt.setString(1, filename);
            System.out.println("performing query: "+stmt.toString());
             ResultSet rs = stmt.executeQuery();
            rs.first();
            System.out.println(rs.getString(1));
            return new String[]{
                rs.getString(2), rs.getString(3), rs.getString(4)
            };
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    private void removeFileFromDb(String filename){
        String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
        String user = "root"; 
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            PreparedStatement stmt = con.prepareStatement("DELETE FROM encrypted_files WHERE name=? LIMIT 1");
            stmt.setString(1, filename);
            stmt.executeUpdate();
            con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void disableProButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disableProButtonActionPerformed
       
        progressBar.setVisible(true);
        
       
        new Thread(new Runnable() {

            @Override
            public void run() {
              if(!TestBlue.scanOnce()){
                    SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            MyDialog mDialog = new MyDialog(parent, true);
                            mDialog.setTitle("Error");
                            mDialog.setDialogLabel("No bluetooth device found!");
                            mDialog.setVisible(true);
                          
                            progressBar.setVisible(false);
                            
                        }
                    }); 
                    return;
                }
                passValidatorDiag passDiag=new passValidatorDiag(parent, true);
                passDiag.setVisible(true);
            
                Crypto dc = new Crypto ("mypassword");
                
                if(proFolderList.getSelectedValue() == null){
                    SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            
                            progressBar.setVisible(false);
                        }
                    });
                    return;
                }
                ListModel filenameListModel = proFolderList.getModel();
                String[] filenames = new String[filenameListModel.getSize()];
                for(int i=0;i<filenameListModel.getSize();i++){
                    filenames[i] = filenameListModel.getElementAt(i).toString();
                }
                for(String filename : filenames){
                String[] fileDetail = getFilepathFromDb(filename);
                System.out.println(Arrays.toString(fileDetail));
                
                File input = new File(fileDetail[0]);
                
                try{
                if(!input.exists())
                    throw new Exception("File doesnt exist : "+pathText.getText());
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                String filewoext=FilenameUtils.removeExtension(filename);
                String ext = FilenameUtils.getExtension(input.getName());
                File eoutput = new File (input.getParent()+"/"+filewoext+"."+ext);

                File doutput = new File (input.getParent()+"/"+filewoext+"d"+"."+ext);

                    try
                    {
                        dc.setupDecrypt (fileDetail[1], fileDetail[2]);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }


                        // write out decrypted file

                        try
                    {
                        dc.ReadEncryptedFile (eoutput, doutput);
                        System.out.println ("decryption finished to " + doutput.getName ());
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                        eoutput.delete();
                   
                    SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        progressBar.setVisible(false);
                        
                    }
                });
                    
                removeFileFromDb(filename);
            }
                MyDialog mDialog=new MyDialog(parent, true);
                mDialog.setTitle("Success");
                mDialog.setDialogLabel("File(s) Successfully Deccrypted!");
                mDialog.setVisible(true);
                proFolderList.setListData(new String[]{""});
            }
        }).start();
                   
      
    
    }//GEN-LAST:event_disableProButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
     System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
      
        File selectedFile;
        
       browse.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
       if(browse.showOpenDialog(pathText) ==JFileChooser.APPROVE_OPTION){
           selectedFile = browse.getSelectedFile();
          String fname=browse.getName(selectedFile);
          System.out.println(fname+"folder");
               pathText.setText(selectedFile.getAbsolutePath());
               arrFiles=selectedFile.listFiles();
               for(File x:arrFiles){
               
               System.out.println(x.getName());
               }
    }   
       else 
       pathText.setText("");
     
           
   
    }//GEN-LAST:event_browseButtonActionPerformed

    private void pathTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathTextActionPerformed

    private void addFileToDb(File input,String iv, String salt) {
        String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
        String user = "root"; 
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO encrypted_files VALUES(?,?,?,?)");
            stmt.setString(1, input.getName());
            stmt.setString(2, input.getAbsolutePath());
            stmt.setString(3, iv);
            stmt.setString(4, salt);
            stmt.executeUpdate();
            con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
      private void displayFilesFromDb() {
                     String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
            String user = "root"; 
             try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            PreparedStatement stmt = con.prepareStatement("SELECT name FROM encrypted_files ");
            System.out.println("performing query: "+stmt.toString());
            ResultSet rs = stmt.executeQuery();
           
            while(rs.next()){
                results.add(rs.getString(1));
            }
            proFolderList.setListData(results.toArray());
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            }
    
    private void enableProButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enableProButtonActionPerformed
       
     progressBar.setVisible(true);  
     exitButton.setVisible(true);     
     
     new Thread(new Runnable() {
            private Array encryptedFiles;
            private String names;
            private Array fileArr;
           
            

            @Override
            public void run() {
                TestBlue.startScan();
                
                if(arrFiles == null)
                    return;
                
         for(File input : arrFiles){
                String fileName=input.getName();
                System.out.println("Encrytping now : "+fileName);
                try{
                    if(!input.exists())
                    throw new Exception("File doesnt exist : "+pathText.getText());
                 }catch(Exception e){
                 e.printStackTrace();
                 }
                
                
                String ext = FilenameUtils.getExtension(input.getName());
                fileParent=input.getParent();
                String filewoext=FilenameUtils.removeExtension(fileName);
                System.out.println(filewoext+"name");
                File eoutput = new File (fileParent+"/"+filewoext+"e"+"."+ext);
                
                String eFile;
                eFile=eoutput.getName();
                System.out.println(eFile);
                File doutput = new File (fileParent+"/"+filewoext+"d"+"."+ext);
                Crypto en = new Crypto ("mypassword");
              
                try
                {
                    en.setupEncrypt ();
                    iv = Hex.encodeHexString (en.getInitVec ()).toUpperCase ();
                    salt = Hex.encodeHexString (en.getSalt ()).toUpperCase ();
                    addFileToDb(eoutput,iv,salt);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            
                try
                {
                    en.WriteEncryptedFile (input, eoutput);
                    System.out.printf ("File encrypted to " + eoutput.getName () + "\niv:" + iv + "\nsalt:" + salt + "\n\n");
                    input.delete();
                    SwingUtilities.invokeLater(new Runnable() {
                    @Override
                        
                    public void run() {
                            progressBar.setVisible(false);
                            
                        }
                    });
                    
                }
                catch (IllegalBlockSizeException e)
                {
                    e.printStackTrace();
                }
                catch (BadPaddingException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
       
            }   
                displayFilesFromDb();
                System.exit(0);
                arrFiles = null;
            }
     
     }).start();
                   
        
    }//GEN-LAST:event_enableProButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       displayFilesFromDb();
    }//GEN-LAST:event_formWindowOpened

   
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
            java.util.logging.Logger.getLogger(protectionPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(protectionPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(protectionPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(protectionPageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                
                new protectionPageGUI().setVisible(true);
               
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton disableProButton;
    private javax.swing.JButton enableProButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField pathText;
    private javax.swing.JList proFolderList;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel selectDisableLable;
    private javax.swing.JLabel selectProtectLabel;
    // End of variables declaration//GEN-END:variables

}
