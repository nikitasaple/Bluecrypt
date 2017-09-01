
package gui;

import javax.swing.JLabel;

public class MyDialog extends javax.swing.JDialog {

    
    public MyDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    MyDialog() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogLabel = new javax.swing.JLabel();
        dialogButton1 = new javax.swing.JButton();
        dialogButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ERROR");

        dialogLabel.setText("jLabel1");

        dialogButton1.setText("OK");
        dialogButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogButton1ActionPerformed(evt);
            }
        });

        dialogButton2.setText("Cancel");
        dialogButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialogButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(dialogButton1)
                .addGap(18, 18, 18)
                .addComponent(dialogButton2)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(dialogLabel)
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(dialogLabel)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dialogButton2)
                    .addComponent(dialogButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dialogButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogButton1ActionPerformed
        
        dispose();
    }//GEN-LAST:event_dialogButton1ActionPerformed

    private void dialogButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dialogButton2ActionPerformed
        
        dispose();
    }//GEN-LAST:event_dialogButton2ActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                MyDialog dialog = new MyDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dialogButton1;
    private javax.swing.JButton dialogButton2;
    private javax.swing.JLabel dialogLabel;
    // End of variables declaration//GEN-END:variables

    public void setDialogLabel(String dialogLabel) {
        this.dialogLabel.setText(dialogLabel);
    
    }
}
