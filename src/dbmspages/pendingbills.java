/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dbmspages;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class pendingbills extends javax.swing.JFrame {

    
    public static String name;
    public static String bid;
    public static String amount;
    public static String duedate;
    
    /**
     * Creates new form pendingbills
     */
    public pendingbills() {
        initComponents();
        Connect();
        
        frontpage fp = new frontpage();
        String usr = fp.usrname;
        //usr="457";
        
        try {
            pbcid.setText(usr);
            System.out.print("hi00");
            rs = pst.executeQuery("select cname from customer where cid='"+usr+"'");
            rs.next();
            System.out.print("hi");
            pbname.setText(rs.getString("cname"));
            rs = pst.executeQuery("select pendingdue from paid_list where cid='"+usr+"'");
            if(rs.next())
                amount = rs.getString("pendingdue");
            System.out.print("hi012");
            
            
            rs = pst.executeQuery("select cname,no,p.pldate,pendingbool,amount from customer c,pending_list p where p.pendingbool=1 and p.cid='"+usr+"'and c.cid='"+usr+"'");
            System.out.print("hi0");
            
              if(!rs.next()){
              System.out.print("hi");
                  pbptp.setEnabled(false);
                  
                  
              }
              
              else{
                  System.out.println("hi1");
                  bid = rs.getString("no");
                  name = rs.getString("cname");
                  bid = rs.getString("no");
                  name = rs.getString("cname");
                  pbname.setText(name);
                  duedate = rs.getString("pldate");
                  pbid.setText(bid);
                  pbstatus.setText("Pending");
              
              }
            
            
              while(rs.next()){
                  if(rs.getString("pendingbool")=="1")
                      System.out.println(rs.getString("no"));
                  
              
              }
            
        } catch (SQLException ex) {
            Logger.getLogger(pendingbills.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    public void close(){
        WindowEvent we = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }
    
    Connection con;
    Statement pst;
    
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/water_management","root","Kausthubh1");
            pst = con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(frontpage.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pbptp = new javax.swing.JButton();
        pbname = new javax.swing.JLabel();
        pbcid = new javax.swing.JLabel();
        pbid = new javax.swing.JLabel();
        pbstatus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(60, 73, 114));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1547, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 16, -1, -1));

        jPanel3.setBackground(new java.awt.Color(60, 73, 114));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 922, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 60, -1, -1));

        jPanel4.setBackground(new java.awt.Color(176, 225, 252));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 922, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText(">Pending Bills");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 16, 101, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 58, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("NAME:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 156, 116, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setText("CONSUMER ID:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 231, 137, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("BILL ID:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 307, 137, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("STATUS:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 391, 137, -1));

        pbptp.setBackground(new java.awt.Color(204, 204, 204));
        pbptp.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        pbptp.setForeground(new java.awt.Color(0, 0, 0));
        pbptp.setText("PROCEED TO PAY");
        pbptp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbptpActionPerformed(evt);
            }
        });
        jPanel2.add(pbptp, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 454, -1, -1));

        pbname.setText("jLabel1");
        jPanel2.add(pbname, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 159, 111, -1));

        pbcid.setText("jLabel3");
        jPanel2.add(pbcid, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 234, 111, -1));
        jPanel2.add(pbid, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 310, 111, -1));
        jPanel2.add(pbstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 394, 111, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbmspages/Add a heading (1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1630, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();
        welcomeuser wc=new welcomeuser();
        wc.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pbptpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbptpActionPerformed
        close();
        ptp pt=new ptp();
        pt.setVisible(true);
    }//GEN-LAST:event_pbptpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pendingbills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pendingbills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pendingbills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pendingbills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pendingbills().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel pbcid;
    private javax.swing.JLabel pbid;
    private javax.swing.JLabel pbname;
    private javax.swing.JButton pbptp;
    private javax.swing.JLabel pbstatus;
    // End of variables declaration//GEN-END:variables
}
