package main1;



import grammer_file.*;
import java.io.*;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.*;
import grammer_file.Reading_Mode1;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.table.DefaultTableModel;
import static main1.Teacher_Login_Form.t_code;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

public class teacher_file_upload extends javax.swing.JFrame {
    
    //public static String name1 = "ANand";
    //public static int noq = 0;  //creting this because of its avoid unneccesary typecasting from Sting to Int
    //public static String[] key;
    //public String[] sample;
    //public boolean val_key;
    //public int k_count=0;
    //public static String uploaded_file_name;
    //public static String file_path = "";
    //public String[] key1 = new String[noq];
    public boolean checkpoint1=false;
    public boolean checkpoint2=false;
    public boolean checkpoint3=true;
    //public String keyword = "";
    //public static String question_set_file_path = "";
    public static String dictionary_file_path = "";
    public static String language_file_path = "";
    //public static String read="";
    public static String answer_f="";
    public static boolean checkpoint_dic=false;
    public static boolean checkpoint_lang=false;
    public static boolean checkpoint_answer=false;
    
    
    
    /**
     * Creates new form first_page
     */
    public teacher_file_upload() {
        initComponents();
        dic_file.setEnabled(false);
        language_file.setEnabled(false);
        save.setEnabled(false);
        logout.setEnabled(false);
                
    }
    
    //copy the uploaded file with static path file
    public static void copy_file(String s_file,String d_file) throws IOException 
    {
        FileInputStream in = null;
        FileOutputStream out = null; 
        try {
            in = new FileInputStream(s_file);
            out = new FileOutputStream(d_file); 
            int c;
            while ((c = in.read()) != -1) 
            {
                out.write(c);
            }
        }finally {
            if (in != null)
            {
                in.close();
            }
            if (out != null)
            { 
                out.close();
            }
        }
    }
    
    
        public static void generate_answer_f(String d_file) throws IOException 
    {
        FileWriter out = null; 
        out = new FileWriter(d_file);
        try { 
            out.write(""+answer_f);
            if (out != null)
            {
                out.close();
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        
       /* FileOutputStream out = null; 
        try {
            out = new FileOutputStream(d_file); 
            int c;
            out.write(""+answer_f);
        }finally {
            
            if (out != null)
            { 
                out.close();
            }
        }*/
    }
    //converted unstructured into structure
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        dic_file = new javax.swing.JButton();
        language_file = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        answer_tf = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        url = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1388, 905));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("INFORMATION OF WORD FILE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 559, 50));

        back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, 140, 40));

        logout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 20, 124, 40));

        dic_file.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dic_file.setText("UPLOAD DICTIONARY FILE OR .dic");
        dic_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dic_fileActionPerformed(evt);
            }
        });
        getContentPane().add(dic_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, 400, -1));

        language_file.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        language_file.setText("UPLOAD LANGUAGE FILE OR .lm");
        language_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                language_fileActionPerformed(evt);
            }
        });
        getContentPane().add(language_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 480, 400, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("UPLOAD AFTER MANUAL WORK");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 288, 31));

        save.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 540, 210, 60));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("DOWNLOAD ANSWER TEXT FILE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 305, 36));

        answer_tf.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        answer_tf.setText("DOWNLOAD");
        answer_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer_tfActionPerformed(evt);
            }
        });
        getContentPane().add(answer_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 400, 36));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("INSTRUCTION:\n1. DOWNLOAD ABOVE TEXT FILE AND UPLOAD TO THE GIVEN URL(CLICK ON \"CLICK ME\" \n   BUTTON YOU WILL DIRECTED TO THE NEW PAGE).\n2. CLICK ON GENERATE BUTTON AND SAVE TWO FILES HAVING (.dic) & (.lm) EXTENSION.\n3. FOE SAVING FILE YOU JUST NEED TO LEFT CLICK ON THAT FILE AND SELECT SAVE AS.\n4. THEN UPLOAD THAT IN THE BELOW LINK.");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 760, 120));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("URL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 280, 32));

        url.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        url.setText("CLICK ME");
        url.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlActionPerformed(evt);
            }
        });
        getContentPane().add(url, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 400, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        //new Teacher_Home_Page().setVisible(true);       //directing to the Login_form
    }//GEN-LAST:event_backActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        int j = JOptionPane.showConfirmDialog(null,"DO YOU REALLY WANT TO LOGOUT","SELECT",JOptionPane.YES_NO_OPTION);
        if(j==0)
        {
          setVisible(false);
          //new Login_form().setVisible(true);   //logout
        }
        
    }//GEN-LAST:event_logoutActionPerformed

    private void dic_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dic_fileActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fc=new JFileChooser(); 
                int i=fc.showOpenDialog(this); 
                //String file_path = "";
                //System.out.println("i= "+i);
                if(i==JFileChooser.APPROVE_OPTION)
                { 
                    File f=fc.getSelectedFile(); 
                    
                    dictionary_file_path = f.getPath();     //get the file path
                    try{  
                        //copy_file(dictionary_file_path,"src\\java\\grammer_file\\dict.dic");
                        copy_file(dictionary_file_path,"C:\\Users\\Admin\\Documents\\Project_language_file\\"+t_code+".dic");
                        checkpoint_dic=true;
                    }catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }
                else if(i==JFileChooser.CANCEL_OPTION)
                {
                    //System.out.println("i= "+i);
                    JOptionPane.showMessageDialog(this,"Cancel");
                }
                else
                {
                    System.out.println("nothing");
                }
                 boolean val_key = Pattern.compile(".*"+".dic").matcher(dictionary_file_path).matches();
                if(!val_key)
                {
                    JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">ONLY DICTIONARY or .dic FILE SUPPORTED<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE);

                }
                if(checkpoint_dic)
                {
                    JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">DICTIONARY or .dic FILE UPLOADED SUCCESSFULLY<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE);

                }
    }//GEN-LAST:event_dic_fileActionPerformed

    private void language_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_language_fileActionPerformed
        // TODO add your handling code here:
        JFileChooser fc=new JFileChooser(); 
                int i=fc.showOpenDialog(this); 
                //String file_path = "";
                //System.out.println("i= "+i);
                if(i==JFileChooser.APPROVE_OPTION)
                { 
                    File f=fc.getSelectedFile(); 
                    
                    language_file_path = f.getPath();     //get the file path
                    try{  
                        //copy_file(language_file_path,"src\\java\\grammer_file\\lang.lm");
                        copy_file(language_file_path,"C:\\Users\\Admin\\Documents\\Project_language_file\\"+t_code+".lm");
                        checkpoint_lang=true;
                    }catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }
                else if(i==JFileChooser.CANCEL_OPTION)
                {
                    //System.out.println("i= "+i);
                    JOptionPane.showMessageDialog(this,"Cancel");
                }
                else
                {
                    System.out.println("nothing");
                }
                  boolean val_key = Pattern.compile(".*"+".lm").matcher(language_file_path).matches();
                if(!val_key)
                {
                    JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">ONLY LANGUAUE or .lm FILE SUPPORTED<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE);

                }
                if(checkpoint_lang)
                {
                    JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">LANGUAUE or .lm FILE UPLOADED SUCCESSFULLY<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE);

                }
    }//GEN-LAST:event_language_fileActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        if(!checkpoint_dic)
        {
           JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE UPLOAD DICTIONARY OR .dic FILE<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE); 
        }
        else if(!checkpoint_lang)
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE UPLOAD LANGYAGE OR .lm FILE<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else 
        {
           // int i =
            JOptionPane.showConfirmDialog(null,"<html><h1><span style=\"font:-size:10px\"><B>FILE UPLOADED SUCCESSFULLY<br></B>","AUTHETICATION",JOptionPane.OK_OPTION);
            
            setVisible(false);
                new Teacher_Home_Page().setVisible(true);
            /*(i==0)
            {
                setVisible(false);
                new Teacher_Login_Form().setVisible(true);    //directing to the Login_form
            }
            else
            {
                save.setEnabled(false);
            }
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">FILE UPLOADED SUCCESSFULLY<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);*/
        }
    }//GEN-LAST:event_saveActionPerformed

    private void answer_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer_tfActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery("select * from question_set where teacher_code='"+t_code+"'");
            while(rs.next())
            {
                //System.out.println("2");
                answer_f = answer_f + "\n" +rs.getString(3); 
                //String arr[] = {rs.getString(1),rs.getString(2),rs.getString(3)};
            }
            answer_f = answer_f + "\n" +"repeat";
            
            
            generate_answer_f("C:\\Users\\Admin\\Documents\\test\\User_answer_file\\"+t_code+".txt");
            checkpoint_answer=true;
        }catch(Exception e)
        {
                System.out.print(e);
        }
        if(checkpoint_lang)
        {
              JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">ANSWER FILE SAVED SUCCESSFULLY,<BR>C:\\Users\\Admin\\Documents\\test\\User_answer_file\\"+t_code+".txt<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE);

         }
        
        System.out.println("answer=\n"+answer_f);
        
        
        dic_file.setEnabled(true);
        language_file.setEnabled(true);
        save.setEnabled(true);
    }//GEN-LAST:event_answer_tfActionPerformed

    private void urlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlActionPerformed
        // TODO add your handling code here:
        Desktop browser = Desktop.getDesktop();
        try {
            browser.browse(new URI("http://www.speech.cs.cmu.edu/tools/lmtool-new.html"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
    }//GEN-LAST:event_urlActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws IOException {
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
            java.util.logging.Logger.getLogger(teacher_file_upload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(teacher_file_upload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(teacher_file_upload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(teacher_file_upload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new teacher_file_upload().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton answer_tf;
    private javax.swing.JButton back;
    private javax.swing.JButton dic_file;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton language_file;
    private javax.swing.JButton logout;
    private javax.swing.JButton save;
    private javax.swing.JButton url;
    // End of variables declaration//GEN-END:variables
}
