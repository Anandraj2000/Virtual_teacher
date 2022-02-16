package main1;

import java.sql.*;
import java.util.regex.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Admin_sign_up extends javax.swing.JFrame {
    public static boolean valid = false;
    public static String t_code;

    /**
     * Creates new form Login_form
     */
    public void validate_email(String email)
    {
        Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b",Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);

        if (m.find())
            valid= true;
    }
    
    public Admin_sign_up() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        Uname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        show_password = new javax.swing.JCheckBox();
        password = new javax.swing.JPasswordField();
        conform_password = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        teacher_code = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 102));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 0, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGN-UP PAGE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 500, 61));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("USERNAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 306, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("EMAIL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 357, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("PASSWORD");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 357, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("CONFORM PASSWORD");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 350, 30));

        submit.setBackground(new java.awt.Color(255, 204, 0));
        submit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        submit.setText("SUBMIT");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 600, 172, 57));
        getContentPane().add(Uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 280, 30));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 280, 30));

        back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back.setText("BACK TO HOME PAGE");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 230, 50));

        show_password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        show_password.setText("show password");
        show_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(show_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 360, 180, 30));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 320, 270, 30));
        getContentPane().add(conform_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, 270, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("TEACHER CODE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 340, 30));
        getContentPane().add(teacher_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 270, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        String name1=Uname.getText();
        String email1=email.getText();
        //write code to check username and password field is empty or not
        validate_email(email1);
        String pass1= password.getText();
        String cpass1=conform_password.getText();
        int f=0;
        //System.out.print(pass1+""+cpass1);
        if(!valid)
        {
            f=1;
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">TYPE CORRECT EMAIL ADDRESS<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else if(teacher_code.getText().isEmpty())
        {
            f=1;
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER THE TEACHER CODE<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else if(Uname.getText().isEmpty())
        {
            f=1;
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER THE USERNAME<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            

            if(pass1.equals(cpass1))
            {
                try{
                t_code=teacher_code.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
                Statement st = conn.createStatement();
                ResultSet rs=st.executeQuery("select * from admin_records where u_name='"+Uname+"'");
                while(rs.next())
                {
                    //Checking name and password are validate or is user authenticate user or not from Database
                    if(Uname.equals(rs.getString(2)))
                    {
                        JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">THIS USERNAME IS ALREADY EXIST<br>PLEASE ENTER ANOTHER USERNAME<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
                    }
                    else if(teacher_code.equals(rs.getString(5)))//username is correct but password is incorrect
                    {
                        //System.out.println("Type correct password");
                        JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">THIS TEACHER CODE IS ALREADY EXIST<br>PLEASE ENTER ANOTHER TEACHER CODE<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
                    }  
                }
                if(f==0)
                {
                    PreparedStatement ps=conn.prepareStatement("insert into admin_records (u_name,password1,email,teacher_code)values(?,?,?,?)");
                    ps.setString(1,name1);
                    ps.setString(2,pass1);
                    ps.setString(3,email1);
                    ps.setString(4,teacher_code.getText());
                    ps.executeUpdate();
                    int i = JOptionPane.showConfirmDialog(null,"<html><h1><span style=\"font:-size:10px\"><B>Account created Successful<br>USERNAME:</B>"+name1+"<br><B>PASSWORD:</B>"+pass1+"<B>TEACHER CODE:</B>"+teacher_code.getText()+"<span></h1><html>","AUTHETICATION",JOptionPane.OK_OPTION);
                    if(i==0)
                    {
                        setVisible(false);
                        //new Login_form().setVisible(true);    //directing to the Login_form
                    }
                    else
                    {
                        submit.setEnabled(false);
                    }
                }
                }catch(Exception e){
                    System.out.print(e);
                }
                System.out.print("");
                //int i = JOptionPane.showConfirmDialog(null,"<html><h1><span style=\"font:-size:10px\"><B>Account created Successful<br>USERNAME:</B>"+name1+"<br><B>PASSWORD:</B>"+pass1+"<span></h1><html>","AUTHETICATION",JOptionPane.OK_OPTION);
                
            }
            else
            {
                //check if  password and conform password are same or not
                JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">Password and conform password must be match<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_submitActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        //new Login_form().setVisible(true);   //directing to the Login_form
    }//GEN-LAST:event_backActionPerformed

    private void show_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_passwordActionPerformed
        // TODO add your handling code here:
        if(show_password.isSelected())
        {
            password.setEchoChar((char)0);
        }
        else
        {
            password.setEchoChar('*');
        }
    }//GEN-LAST:event_show_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_sign_up().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Uname;
    private javax.swing.JButton back;
    private javax.swing.JPasswordField conform_password;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField password;
    private javax.swing.JCheckBox show_password;
    private javax.swing.JButton submit;
    public static javax.swing.JTextField teacher_code;
    // End of variables declaration//GEN-END:variables
}
