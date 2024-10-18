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

public class refillRequests extends javax.swing.JFrame {

    public Connection con;
    ResultSet rs = null;
    Statement st;
    String m_username = "m";
    int rid, rfid,vid;
    float cfa;
    int row, selected = 0;
    String u_username = "u";
    String rdate;

    public refillRequests() {
        initComponents();
        setSize(1000,500);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=projectdb1;selectMethod=cursor", "sa", "123456");
            st = con.createStatement();
            jLabel1.setText(m_username);
            rs = st.executeQuery("select * from manager where m_username='" + m_username + "'");
            if (rs.next()) {
                jLabel1.setText("Welcome " + rs.getString("m_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jTextField1.setEnabled(false);
        alldata();
        jLabel3.setText("Select a table row");
    }

    public refillRequests(String x) {
        m_username = x;
        initComponents();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=projectdb1;selectMethod=cursor", "sa", "123456");
            st = con.createStatement();
            jLabel1.setText(m_username);
            rs = st.executeQuery("select * from manager where m_username='" + m_username + "'");
            if (rs.next()) {
                jLabel1.setText("Welcome " + rs.getString("m_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jTextField1.setEnabled(false);
        alldata();
        jLabel3.setText("Select a table row");
    }

    public void alldata() {
        try {
            rs = st.executeQuery("select * from request r inner join vehicles v on r.v_id=v.v_id\n"
                    + "inner join model m on v.md_name=m.md_name");
            while (rs.next()) {
                String a, b, c, d, e, f, g, h, i, j, k, l;
                a = String.valueOf(rs.getInt("r_id"));
                b = rs.getString("u_username");
                c = String.valueOf(rs.getInt("v_id"));
                d = String.valueOf(rs.getInt("rf_id"));
                e = String.valueOf(rs.getInt("rf_amount"));
                f = rs.getDate("r_date").toString();
                g = rs.getTime("r_time").toString();
                h = String.valueOf(rs.getFloat("f_amount"));
                i = String.valueOf(rs.getFloat("f_cost"));
                j = rs.getString("r_status");
                k = String.valueOf(rs.getFloat("c_f_amount"));
                l = String.valueOf(rs.getFloat("t_f_amount"));
                String data[] = {a, b, c, d, e, f, g, h, i, j, k, l};
                DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                tm.addRow(data);
            }
            jLabel3.setText("Select a table row");
            jTextField1.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unApproveddata() {
        try {
            rs = st.executeQuery("select * from request r inner join vehicles v on r.v_id=v.v_id\n"
                    + "inner join model m on v.md_name=m.md_name where r_status<>'Approved'");
            while (rs.next()) {
                String a, b, c, d, e, f, g, h, i, j, k, l;
                a = String.valueOf(rs.getInt("r_id"));
                b = rs.getString("u_username");
                c = String.valueOf(rs.getInt("v_id"));
                d = String.valueOf(rs.getInt("rf_id"));
                e = String.valueOf(rs.getInt("rf_amount"));
                f = rs.getDate("r_date").toString();
                g = rs.getTime("r_time").toString();
                h = String.valueOf(rs.getFloat("f_amount"));
                i = String.valueOf(rs.getFloat("f_cost"));
                j = rs.getString("r_status");
                k = String.valueOf(rs.getFloat("c_f_amount"));
                l = String.valueOf(rs.getFloat("t_f_amount"));
                String data[] = {a, b, c, d, e, f, g, h, i, j, k, l};
                DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                tm.addRow(data);
            }
            jLabel3.setText("Select a table row");
            jTextField1.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Approveddata() {
        try {
            rs = st.executeQuery("select * from request r inner join vehicles v on r.v_id=v.v_id\n"
                    + "inner join model m on v.md_name=m.md_name where r_status='Approved'");
            while (rs.next()) {
                String a, b, c, d, e, f, g, h, i, j, k, l;
                a = String.valueOf(rs.getInt("r_id"));
                b = rs.getString("u_username");
                c = String.valueOf(rs.getInt("v_id"));
                d = String.valueOf(rs.getInt("rf_id"));
                e = String.valueOf(rs.getInt("rf_amount"));
                f = rs.getDate("r_date").toString();
                g = rs.getTime("r_time").toString();
                h = String.valueOf(rs.getFloat("f_amount"));
                i = String.valueOf(rs.getFloat("f_cost"));
                j = rs.getString("r_status");
                k = String.valueOf(rs.getFloat("c_f_amount"));
                l = String.valueOf(rs.getFloat("t_f_amount"));
                String data[] = {a, b, c, d, e, f, g, h, i, j, k, l};
                DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                tm.addRow(data);
            }
            jLabel3.setText("Select a table row");
            jTextField1.setText("");
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

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("m_username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(460, 20, 120, 31);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(250, 380, 148, 35);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "request_id", "username", "vehicle", "refill id", "refill amount", "date", "time", "fuel amount", "total cost", "status", "Current fuel", "Fuel Capacity"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(9).setMinWidth(150);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 113, 990, 233);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "approved", "not approved" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(770, 50, 136, 31);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Suggestions:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(610, 40, 109, 62);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 370, 232, 62);

        jButton3.setText("submit verdict");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(686, 382, 135, 30);

        jButton4.setText("Check");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(474, 380, 135, 35);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Amount:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(204, 60, 100, 23);

        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField1MousePressed(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(360, 60, 123, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/photo-1605282003441-a966bb348137.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 990, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        managerActivity ma = new managerActivity(m_username);
        ma.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here;
        try {
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            tm.setRowCount(0);
            if (jComboBox1.getSelectedIndex() == 0) {
                alldata();
            } else if (jComboBox1.getSelectedIndex() == 2) {
                unApproveddata();
            } else if (jComboBox1.getSelectedIndex() == 1) {
                Approveddata();
            }
            jTextField1.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        selected = 1;
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        row = jTable1.getSelectedRow();
        rid = Integer.parseInt(tm.getValueAt(row, 0).toString());
        vid = Integer.parseInt(tm.getValueAt(row, 2).toString());
        rfid = Integer.parseInt(tm.getValueAt(row, 3).toString());
        cfa=Float.parseFloat(tm.getValueAt(row, 10).toString());
        jLabel3.setText("Type amount and check");
        jTextField1.setText("");
        //System.out.println(row);
        jTextField1.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (selected == 0) {
            JOptionPane.showMessageDialog(null, "Select row first!", "error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int c = 1;
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            float cf = Float.parseFloat(tm.getValueAt(row, 10).toString()), fc = Float.parseFloat(tm.getValueAt(row, 11).toString()), a = 0,
                    fa = Float.parseFloat(tm.getValueAt(row, 7).toString());
            cfa=cfa+fa;
            String s = tm.getValueAt(row, 9).toString(), d = tm.getValueAt(row, 5).toString();
            int y, w;
            try {
                a = Float.parseFloat(jTextField1.getText().toString());

            } catch (Exception e) {
                c = 0;
            }
            if (s.equals("Approved")) {
                JOptionPane.showMessageDialog(null, "The request is already granted", "info", JOptionPane.INFORMATION_MESSAGE);
                jLabel3.setText("Choose another row");
            } else if (c == 0 || a == 0) {
                JOptionPane.showMessageDialog(null, "Enter amount correctly!", "error", JOptionPane.INFORMATION_MESSAGE);
            } else if (cf + fa > fc) {
                JOptionPane.showMessageDialog(null, "The vehicle fuel will overflow!", "info", JOptionPane.INFORMATION_MESSAGE);
                jLabel3.setText("The vehicle fuel will overflow!");
            } else if (cf + fa <= fc) {
                try {
                    rs = st.executeQuery("SET DATEFIRST 6 \n"
                            + "SELECT DATEPART(week, '" + d + "') AS dpw");
                    rs.next();
                    w = rs.getInt("dpw");
                    rs = st.executeQuery("SELECT DATEPART(yy, '" + d + "') AS dpy");
                    rs.next();
                    y = rs.getInt("dpy");
                    rs = st.executeQuery("SET DATEFIRST 6 \n"
                            + "SELECT  dpy = DATEPART(YEAR, r_date),\n"
                            + "        dpw = DATEPART(wk, r_date),\n"
                            + "        r_status,  \n"
                            + "        sum(f_amount) as total \n"
                            + "FROM    request\n"
                            + "GROUP BY DATEPART(YEAR, r_date), DATEPART(wk, r_date), r_status \n"
                            + "having DATEPART(YEAR, r_date)='" + String.valueOf(y) + "' and DATEPART(wk, r_date)='" + String.valueOf(w) + "' "
                            + "and r_status='yes'");
                    if (rs.next()) {
                        if (rs.getFloat("total") + fa > a) {
                            JOptionPane.showMessageDialog(null, "The amount will be exceeded!", "info", JOptionPane.INFORMATION_MESSAGE);
                            jLabel3.setText("The amount will be exceeded!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Request can be excepted", "info", JOptionPane.INFORMATION_MESSAGE);
                            jLabel3.setText("Yes");
                        }
                    } else {
                        if (fa > a) {
                            JOptionPane.showMessageDialog(null, "The amount will be exceeded!", "info", JOptionPane.INFORMATION_MESSAGE);
                            jLabel3.setText("The amount will be exceeded!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Request can be excepted", "info", JOptionPane.INFORMATION_MESSAGE);
                            jLabel3.setText("Yes");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (jLabel3.getText().toString().equals("Select a table row")) {
            JOptionPane.showMessageDialog(null, "Select a table row", "info", JOptionPane.INFORMATION_MESSAGE);
        } else if (jLabel3.getText().toString().equals("Choose another row")) {
            JOptionPane.showMessageDialog(null, "The request is already granted", "info", JOptionPane.INFORMATION_MESSAGE);
        } else if (jLabel3.getText().toString().equals("Type amount and check")) {
            JOptionPane.showMessageDialog(null, "Type amount and check", "info", JOptionPane.INFORMATION_MESSAGE);
        } else if (jLabel3.getText().toString().equals("Yes")) {
            try {
                st.executeUpdate("UPDATE request\n"
                        + "SET r_status = 'Approved'\n"
                        + "WHERE r_id=" + rid + "");
                st.executeUpdate("UPDATE vehicles\n"
                        + "SET c_f_amount = "+cfa+"\n"
                        + "WHERE v_id=" + vid + "");
                st.executeUpdate("insert into fillup values(" + rid + ",'" + m_username + "')");
                JOptionPane.showMessageDialog(null, "Data approved", "Success", JOptionPane.INFORMATION_MESSAGE);
                DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                tm.setRowCount(0);
                if (jComboBox1.getSelectedIndex() == 0) {
                    alldata();
                } else if (jComboBox1.getSelectedIndex() == 2) {
                    unApproveddata();
                } else if (jComboBox1.getSelectedIndex() == 1) {
                    Approveddata();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!jLabel3.getText().toString().equals("Approved")) {
            try {
                st.executeUpdate("UPDATE request\n"
                        + "SET r_status = '" + jLabel3.getText().toString() + "'\n"
                        + "WHERE r_id=" + rid + "");
                JOptionPane.showMessageDialog(null, "Data disapproved", "Success", JOptionPane.INFORMATION_MESSAGE);
                DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                tm.setRowCount(0);
                if (jComboBox1.getSelectedIndex() == 0) {
                    alldata();
                } else if (jComboBox1.getSelectedIndex() == 2) {
                    unApproveddata();
                } else if (jComboBox1.getSelectedIndex() == 1) {
                    Approveddata();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MousePressed
        // TODO add your handling code here:
        jLabel3.setText("Type amount and check");
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MousePressed

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
            java.util.logging.Logger.getLogger(refillRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(refillRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(refillRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(refillRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new refillRequests().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
