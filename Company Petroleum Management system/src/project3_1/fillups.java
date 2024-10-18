/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fillups extends javax.swing.JFrame {

    public Connection con;
    ResultSet rs = null;
    Statement st;
    int row,fid;
    String u_username = "u";

    public fillups() {
        initComponents();
        setSize(1000,600);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=projectdb1;selectMethod=cursor", "sa", "123456");
            st = con.createStatement();
            jLabel2.setText(u_username);
            rs = st.executeQuery("select * from user_info where u_username='" + u_username + "'");
            if (rs.next()) {
                jLabel1.setText("Welcome " + rs.getString("u_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        alldata();
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
    }

    public fillups(String x) {
        initComponents();
        u_username = x;
        initComponents();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=projectdb1;selectMethod=cursor", "sa", "123456");
            st = con.createStatement();
            jLabel2.setText(u_username);
            rs = st.executeQuery("select * from user_info where u_username='" + u_username + "'");
            if (rs.next()) {
                jLabel1.setText("Welcome " + rs.getString("u_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        alldata();
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
    }

    public void alldata() {
        try {
            rs = st.executeQuery("select * from Fillup f \n"
                    + "inner join request r on f.r_id=r.r_id where u_username='" + u_username + "'");
            while (rs.next()) {
                String a, b, c, d, e, f, g, h, i, j;
                a = String.valueOf(rs.getInt("fi_id"));
                b = rs.getString("m_username");
                c = String.valueOf(rs.getInt("r_id"));
                d = rs.getString("Used");
                e = String.valueOf(rs.getInt("v_id"));
                f = String.valueOf(rs.getInt("rf_id"));
                g = String.valueOf(rs.getInt("rf_amount"));
                h = String.valueOf(rs.getFloat("f_amount"));
                i = rs.getDate("r_date").toString();
                j = rs.getTime("r_time").toString();
                String data[] = {a, b, c, d, e, f, g, h, i, j};
                DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                tm.addRow(data);
            }
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unApproveddata() {
        try {
            rs = st.executeQuery("select * from Fillup f \n"
                    + "inner join request r on f.r_id=r.r_id where used='No' and u_username='" + u_username + "'");
            while (rs.next()) {
                String a, b, c, d, e, f, g, h, i, j;
                a = String.valueOf(rs.getInt("fi_id"));
                b = rs.getString("m_username");
                c = String.valueOf(rs.getInt("r_id"));
                d = rs.getString("Used");
                e = String.valueOf(rs.getInt("v_id"));
                f = String.valueOf(rs.getInt("rf_id"));
                g = String.valueOf(rs.getInt("rf_amount"));
                h = String.valueOf(rs.getFloat("f_amount"));
                i = rs.getDate("r_date").toString();
                j = rs.getTime("r_time").toString();
                String data[] = {a, b, c, d, e, f, g, h, i, j};
                DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                tm.addRow(data);
            }
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Approveddata() {
        try {
            rs = st.executeQuery("select * from Fillup f \n"
                    + "inner join request r on f.r_id=r.r_id where used = 'Yes' and u_username='" + u_username + "'");
            while (rs.next()) {
                String a, b, c, d, e, f, g, h, i, j;
                a = String.valueOf(rs.getInt("fi_id"));
                b = rs.getString("m_username");
                c = String.valueOf(rs.getInt("r_id"));
                d = rs.getString("Used");
                e = String.valueOf(rs.getInt("v_id"));
                f = String.valueOf(rs.getInt("rf_id"));
                g = String.valueOf(rs.getInt("rf_amount"));
                h = String.valueOf(rs.getFloat("f_amount"));
                i = rs.getDate("r_date").toString();
                j = rs.getTime("r_time").toString();
                String data[] = {a, b, c, d, e, f, g, h, i, j};
                DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                tm.addRow(data);
            }
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Slip no", "Approved by", "request no", "Used", "Vehicle", "Refill Type", "Refill amount", "Fill amount", "Date", "Time"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(18, 120, 792, 221);

        jButton1.setText("Print Slip");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(348, 359, 87, 34);

        jButton2.setText("Click if you have filled up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(578, 430, 196, 34);

        jButton3.setText("Back");
        getContentPane().add(jButton3);
        jButton3.setBounds(33, 433, 65, 29);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("user");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 60, 261, 31);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Used", "Unused" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(617, 75, 137, 27);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(638, 16, 116, 43);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        row = jTable1.getSelectedRow();
        fid=Integer.parseInt(tm.getValueAt(row, 0).toString());
        if (tm.getValueAt(row, 3).toString().equals("Yes")) {
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
        } else {
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            tm.setRowCount(0);
            if (jComboBox1.getSelectedIndex() == 0) {
                alldata();
            } else if (jComboBox1.getSelectedIndex() == 1) {
                Approveddata();
            } else if (jComboBox1.getSelectedIndex() == 2) {
                unApproveddata();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            st.executeUpdate("Update fillup set Used='Yes' where"
                    + "fi_id="+fid+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Printed", "Successful", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(fillups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fillups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fillups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fillups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fillups().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
