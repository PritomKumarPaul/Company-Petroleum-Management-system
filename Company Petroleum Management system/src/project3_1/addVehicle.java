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
public class addVehicle extends javax.swing.JFrame {

    String m_username = "m";

    /**
     * Creates new form addVehicle
     */
    public addVehicle() {
        initComponents();
        jLabel1.setText(m_username);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=projectdb1;selectMethod=cursor", "sa", "123456");
            Statement st = con.createStatement();
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            tm.setRowCount(0);

            ResultSet rs = st.executeQuery("select * from vehicles");
            while (rs.next()) {

                String vid = String.valueOf(rs.getInt("v_id"));
                String vColor = rs.getString("v_color");
                String mdName = rs.getString("md_name");

                String data[] = {vid, vColor, mdName, Float.toString(rs.getFloat("c_f_amount"))};

                tm.addRow(data);

            }
            rs = st.executeQuery("select md_name from model");
            while (rs.next()) {
                String mdname = rs.getString("md_name");
                jComboBox1.addItem(mdname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public addVehicle(String x) {
        initComponents();
        m_username = x;
        jLabel1.setText(m_username);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=projectdb1;selectMethod=cursor", "sa", "123456");
            Statement st = con.createStatement();
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            tm.setRowCount(0);

            ResultSet rs = st.executeQuery("select * from vehicles");
            while (rs.next()) {

                String vid = String.valueOf(rs.getInt("v_id"));
                String vColor = rs.getString("v_color");
                String mdName = rs.getString("md_name");

                String data[] = {vid, vColor, mdName, Float.toString(rs.getFloat("c_f_amount"))};

                tm.addRow(data);

            }
            rs = st.executeQuery("select md_name from model");
            while (rs.next()) {
                String mdname = rs.getString("md_name");
                jComboBox1.addItem(mdname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("m");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(800, 0, 90, 30);

        jButton1.setText("Add Vehicle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 400, 130, 25);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehicle Id", "Vehicle color", "Model name", "Fuel capacity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 60, 452, 100);

        jLabel2.setText("Color");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(195, 220, 90, 30);

        jLabel3.setText("Model Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(191, 270, 100, 16);

        jLabel4.setText("Fuel Capacity");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(191, 320, 100, 16);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(410, 220, 220, 22);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(410, 320, 220, 22);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(450, 400, 130, 25);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(410, 270, 230, 22);

        jButton3.setText("Add new model");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(750, 360, 140, 60);

        setSize(new java.awt.Dimension(941, 513));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        managerActivity ma = new managerActivity();
        ma.show();

        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=projectdb1;selectMethod=cursor", "sa", "123456");
            Statement st = con.createStatement();

            String c = jTextField1.getText();
            String md = jComboBox1.getSelectedItem().toString();
            ResultSet rs = st.executeQuery("select t_f_amount from model where md_name='" + md + "'  ");
            rs.next();
            float fc = Float.valueOf(rs.getFloat("t_f_amount"));
            jTextField3.setText(Float.toString(fc));
            String query = "insert into vehicles values('" + c + "','" + md + "'," + fc + ")";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "data added successfully");

            rs = st.executeQuery("select * from vehicles");

            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            tm.setRowCount(0);
            while (rs.next()) {
                String vid = String.valueOf(rs.getInt("v_id"));
                String vColor = rs.getString("v_color");
                String mdName = rs.getString("md_name");

                String data[] = {vid, vColor, mdName, Float.toString(rs.getFloat("c_f_amount"))};
                tm.addRow(data);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
        addModel am = new addModel(m_username, 1);
        am.show();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(addVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addVehicle().setVisible(true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}
