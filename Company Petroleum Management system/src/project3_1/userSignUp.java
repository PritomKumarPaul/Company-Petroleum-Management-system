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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class userSignUp extends javax.swing.JFrame {

    public Connection con;
    ResultSet rs = null;
    Statement st;

    public userSignUp() {
        initComponents();
        setSize(1000,540);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=projectdb1;selectMethod=cursor", "sa", "123456");
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidUsername(String username) {
        boolean isValid = true;
        if (username.charAt(0) != 'u' || username.charAt(1) != '_') {
            //System.out.println("usernamem must have (u_) in the begining");
            JOptionPane.showMessageDialog(null, "usernamem must have (u_) in the begining", "Error", JOptionPane.INFORMATION_MESSAGE);
            isValid = false;
        } else if (username.length() < 3) {
            //System.out.println("usernamem be more than 2 characters in length.");
            JOptionPane.showMessageDialog(null, "usernamem be more than 2 characters in length.", "Error", JOptionPane.INFORMATION_MESSAGE);
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidName(String name) {
        boolean isValid = true;
        String numbers = "(.*[0-9].*)";
        String specialChars = "(.*[@,#,$,%,_].*$)";
        if (name.matches(numbers)) {
            //System.out.println("Password must have atleast one number");
            JOptionPane.showMessageDialog(null, "name must have only letters", "Error", JOptionPane.INFORMATION_MESSAGE);
            isValid = false;
        } else if (name.matches(specialChars)) {
            //System.out.println("Password must have atleast one special character among @#$%");
            JOptionPane.showMessageDialog(null, "name must have only letters", "Error", JOptionPane.INFORMATION_MESSAGE);
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidAge(String age) {
        boolean isValid = true;
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCaseChars = "(.*[a-z].*)";
        String specialChars = "(.*[@,#,$,%,_].*$)";
        if (age.matches(upperCaseChars)) {
            //System.out.println("Password must have atleast one uppercase character");
            JOptionPane.showMessageDialog(null, "enter age correctly", "Error", JOptionPane.INFORMATION_MESSAGE);
            isValid = false;
        } else if (age.matches(lowerCaseChars)) {
            //System.out.println("Password must have atleast one lowercase character");
            JOptionPane.showMessageDialog(null, "enter age correctly", "Error", JOptionPane.INFORMATION_MESSAGE);
            isValid = false;
        } else if (age.matches(specialChars)) {
            //System.out.println("Password must have atleast one special character among @#$%");
            JOptionPane.showMessageDialog(null, "enter age correctly", "Error", JOptionPane.INFORMATION_MESSAGE);
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidPassword(String password) {
        boolean isValid = true;
        if (password.length() > 20 || password.length() < 8) {
            //System.out.println("Password must be less than 20 and more than 8 characters in length.");
            JOptionPane.showMessageDialog(null, "Password must be less than 20 and more than 8 characters in length.", "Error", JOptionPane.INFORMATION_MESSAGE);
            isValid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCaseChars = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(upperCaseChars)) {
            //System.out.println("Password must have atleast one uppercase character");
            JOptionPane.showMessageDialog(null, "Password must have atleast one uppercase character", "Error", JOptionPane.INFORMATION_MESSAGE);
            isValid = false;
        } else if (!password.matches(lowerCaseChars)) {
            //System.out.println("Password must have atleast one lowercase character");
            JOptionPane.showMessageDialog(null, "Password must have atleast one lowercase character", "Error", JOptionPane.INFORMATION_MESSAGE);
            isValid = false;
        } else if (!password.matches(numbers)) {
            //System.out.println("Password must have atleast one number");
            JOptionPane.showMessageDialog(null, "Password must have atleast one number", "Error", JOptionPane.INFORMATION_MESSAGE);
            isValid = false;
        } else if (!password.matches(specialChars)) {
            //System.out.println("Password must have atleast one special character among @#$%");
            JOptionPane.showMessageDialog(null, "Password must have atleast one special character among @#$%", "Error", JOptionPane.INFORMATION_MESSAGE);
            isValid = false;
        }
        return isValid;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 160, 130, 34);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(340, 90, 310, 35);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(340, 150, 310, 34);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Enter Username and Passoword Here");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(330, 20, 310, 34);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User name:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 100, 120, 35);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Re-enter Password:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 210, 150, 50);
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(340, 210, 310, 40);

        jButton1.setText("Sign Up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(480, 420, 120, 25);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(380, 420, 59, 25);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(340, 280, 320, 35);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 280, 170, 50);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(340, 340, 320, 35);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Age:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 340, 160, 40);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 1020, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Aa@00000
        try {
            rs = st.executeQuery("select u_username from user_info where u_username='" + jTextField1.getText() + "'");
            if (!rs.next()) {

                String password1 = jPasswordField1.getText();
                String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
                if (jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Name can't be empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else if (jTextField3.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Age can't be empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else if (!isValidAge(jTextField3.getText())) {
                    jTextField3.setText("");
                } else if (jTextField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Username can't be empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else if (!isValidUsername(jTextField1.getText())) {
                    jTextField1.setText("");
                } else if (!isValidName(jTextField2.getText())) {
                    jTextField2.setText("");
                } else if (jPasswordField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Password can't be empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else if (!isValidPassword(password1)) {
                    JOptionPane.showMessageDialog(null, "Password can't be empty!", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else if (!(jPasswordField1.getText().equals(jPasswordField2.getText()))) {
                    jPasswordField2.setText("");
                    JOptionPane.showMessageDialog(null, "Re-entered password doesn't match!", "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String no="no";
                    try {
                        if (st.executeUpdate("INSERT INTO user_info values ('" + jTextField1.getText() + "','" + jPasswordField1.getText() + "','" + jTextField2.getText() + "'," + Integer.valueOf(jTextField3.getText()) + ",'"+no+"')") == 1) {
                            JOptionPane.showMessageDialog(null, "data inserted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                        //insert into user_info values ('u_u','Aa@00000','aa',22,'no')
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Username already taken", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        userLogin ul = new userLogin();
        ul.show();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(userSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userSignUp().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
