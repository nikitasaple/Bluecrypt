/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.intel.bluetooth.RemoteDeviceHelper;
import com.mysql.jdbc.Statement;
import java.awt.Component;
import java.util.Vector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.obex.*;

import javax.bluetooth.*;
import javax.microedition.io.Connector;
import javax.obex.*;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SwingUtilities;


public class CreateProfilePageGUI extends javax.swing.JFrame {

   static final List<RemoteDevice> devicesDiscovered = new ArrayList<>();
    private String selectedBluetoothDevice;
    private int length;
    private byte[] data;
    private String pairedAdd;
    private String pairedName;
     
    public CreateProfilePageGUI() {
       
        initComponents();
    }
    
    
    private void storeDatabase(){
      
          String url="jdbc:mysql://127.0.0.1:3306/regis_comp";
           String user = "root";
           
            try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, "");
            Statement stmt = (Statement) con.createStatement();
            PreparedStatement pstmt = con.prepareStatement("UPDATE user_com SET blue_name=?, blue_add=?");
            pstmt.setString(1,pairedName);
            pstmt.setString(2,pairedAdd);
            try{
                pstmt.executeUpdate();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            } catch (Exception ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scanBluetoothButton = new javax.swing.JButton();
        selectDeviceLabel = new javax.swing.JLabel();
        pairDeviceBluetooth = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        deviceList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Create Profile ");

        scanBluetoothButton.setText("Scan Bluetooth Devices");
        scanBluetoothButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanBluetoothButtonActionPerformed(evt);
            }
        });

        selectDeviceLabel.setText("Select the Bluetooth device to pair with:");

        pairDeviceBluetooth.setText("Add this Device");
        pairDeviceBluetooth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pairDeviceBluetoothActionPerformed(evt);
            }
        });

        deviceList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        deviceList.setToolTipText("");
        jScrollPane2.setViewportView(deviceList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectDeviceLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pairDeviceBluetooth))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(scanBluetoothButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(scanBluetoothButton)
                .addGap(26, 26, 26)
                .addComponent(selectDeviceLabel)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pairDeviceBluetooth)
                        .addGap(52, 52, 52)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scanBluetoothButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanBluetoothButtonActionPerformed
          
        devicesDiscovered.clear();
         final Object inquiryCompletedEvent = new Object();
         DiscoveryListener listener = new DiscoveryListener() {
         List<String> deviceNames = new ArrayList<String>();
         @Override
         public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
         try {
                    String bluetoothAddress = btDevice.getBluetoothAddress();
                    System.out.println("\t name " + btDevice.getFriendlyName(true)+" address : "+bluetoothAddress);
                    devicesDiscovered.add(btDevice);
                    RemoteDevice[] bds = new RemoteDevice[devicesDiscovered.size()];
                    for(RemoteDevice bd : devicesDiscovered.toArray(bds)){
                       
                        if(bd.getFriendlyName(true) != null)
                            deviceNames.add(bd.getFriendlyName(true));
                        else
                            deviceNames.add(bd.getBluetoothAddress());
                    }
                    
                        deviceList.setListData(deviceNames.toArray());
                  
                } catch (IOException cantGetDeviceName) {
                }
            }
            
            @Override
            public void inquiryCompleted(int discType) {
                synchronized(inquiryCompletedEvent){
                 inquiryCompletedEvent.notifyAll();
                }
            }

            public void serviceSearchCompleted(int transID, int respCode) {
            }

            public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
            }
        };
           
            synchronized(inquiryCompletedEvent) {
                boolean started = false;
                try {
                started = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
                }   catch (BluetoothStateException e) {
                e.printStackTrace();
            }

            if (started) {
            try {
                    inquiryCompletedEvent.wait();
             } catch (InterruptedException ex) {
                    ex.printStackTrace();
            }
           }
        }

    
    }//GEN-LAST:event_scanBluetoothButtonActionPerformed

    
    private void pairDeviceBluetoothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pairDeviceBluetoothActionPerformed
        String selectedValue = deviceList.getSelectedValue().toString();
        RemoteDevice[] bds = new RemoteDevice[devicesDiscovered.size()];
        RemoteDevice remoteDevice = null;
        for(RemoteDevice bd : devicesDiscovered.toArray(bds)){
            try {
                if(bd.getFriendlyName(true).equalsIgnoreCase(selectedValue)){
                    remoteDevice = bd;
                    break;
                }
            } catch (IOException ex) {
                Logger.getLogger(CreateProfilePageGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Address is : "+remoteDevice.getBluetoothAddress());
        try {
            System.out.println("Name is : "+remoteDevice.getFriendlyName(true));
        } catch (IOException ex) {
            Logger.getLogger(CreateProfilePageGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        pairedAdd=remoteDevice.getBluetoothAddress();
        try {
        pairedName=remoteDevice.getFriendlyName(true);
            } catch (IOException ex) {
            Logger.getLogger(CreateProfilePageGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        storeDatabase();
        MyDialog mDialog=new MyDialog(this,true);
        mDialog.setDialogLabel("Device Succesfully added!!");
        mDialog.setTitle("Success!!");
        mDialog.setVisible(true);
        
        protectionPageGUI pg=new protectionPageGUI();
        pg.setVisible(true);
        this.setVisible(false);
        
    
       
    }//GEN-LAST:event_pairDeviceBluetoothActionPerformed

    
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
            java.util.logging.Logger.getLogger(CreateProfilePageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateProfilePageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateProfilePageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateProfilePageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CreateProfilePageGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList deviceList;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pairDeviceBluetooth;
    private javax.swing.JButton scanBluetoothButton;
    private javax.swing.JLabel selectDeviceLabel;
    // End of variables declaration//GEN-END:variables

    
    public int getDeviceList() {
        return  deviceList.getSelectedIndex();
    }

    
    public void setDeviceList(javax.swing.JList deviceList) {
        this.deviceList = deviceList;
    }

    
     class BluetoothDevice{
     String address, name;

        public BluetoothDevice(String address, String name) {
            this.address = address;
            this.name = name;
        }
        
        public String[] getDeviceNames(){
            return null;
        }
    }
}

