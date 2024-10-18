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

/**
 *
 * @author Fariha
 */
public class Engine extends javax.swing.JFrame {

    public Connection con;
    ResultSet rs = null;
    Statement st;
    String m_username = "m";
    int back, backp;

    public Engine() {
        initComponents();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=projectdb1;selectMethod=cursor", "sa", "123456");
            st = con.createStatement();

            rs = st.executeQuery("select * from engine");
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            tm.setRowCount(0);
            while (rs.next()) {
                String eName = rs.getString("en_name");
                String fName = rs.getString("f_name");
                String data[] = {eName, fName};
                tm.addRow(data);
            }
            rs = st.executeQuery("select f_name from fuels");
            while (rs.next()) {
                String fname = rs.getString("f_name");
                jComboBox1.addItem(fname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Engine(String x, int y, int z) {
        initComponents();
        m_username = x;
        back = y;
        backp = z;
        jLabel1.setText(m_username);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=projectdb1;selectMethod=cursor", "sa", "123456");
            st = con.createStatement();

            rs = st.executeQuery("select * from engine");
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            tm.setRowCount(0);
            while (rs.next()) {
                String eName = rs.getString("en_name");
                String fName = rs.getString("f_name");
                String data[] = {eName, fName};
                tm.addRow(data);
            }
            rs = st.executeQuery("select f_name from fuels");
            while (rs.next()) {
                String fname = rs.getString("f_name");
                jComboBox1.addItem(fname);
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("m");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(650, 0, 140, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Engine Name", "Fuel Name"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 70, 452, 100);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 330, 55, 23);

        jButton2.setText("Add Engine");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(580, 340, 170, 23);

        jLabel2.setText("Engine name:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 190, 120, 40);

        jLabel3.setText("Fuel Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 250, 110, 14);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(290, 190, 120, 30);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(290, 240, 130, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=projectdb1;selectMethod=cursor", "sa", "123456");
            Statement st = con.createStatement();

            String en = jTextField1.getText();
            String fn = jComboBox1.getSelectedItem().toString();

            String query = "insert into engine values('" + en + "','" + fn + "')";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "data added successfully");

            ResultSet rs = st.executeQuery("select * from engine");
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            tm.setRowCount(0);
            while (rs.next()) {

                String eName = rs.getString("en_name");
                String fName = rs.getString("f_name");

                String data[] = {eName, fName};

                tm.addRow(data);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (back == 0) {
            managerActivity ma = new managerActivity(m_username);
            ma.show();
            dispose();
        } else {
            addModel am = new addModel(m_username, backp);
            am.show();
            dispose();
        }
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
            java.util.logging.Logger.getLogger(Engine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Engine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Engine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Engine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Engine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
