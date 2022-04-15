/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main1;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.SplittableRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;


/**
 *
 * @author Admin
 */
public class student_details extends javax.swing.JFrame {
    public static int checkpoint1=0;
    public static String otp="";
    public static Dictionary question_set = new Hashtable();
    public static Dictionary answer_set = new Hashtable();
    public static int count=0;
    public static String[] key;
    public static String[] range;
    public static String t_code;
    public static String name1="";
    public static String gender1="";
    public static String email1="";
    public static String s_class1="";
    public static String seat_no1="";
    

    /**
     * Creates new form student_details
     * 
     */
    public student_details() {
        
        initComponents();
        save_details.setEnabled(true);
    }
    
    
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
    
    
    public static void generate_qn(int n) throws NullPointerException 
    {
        Random random = new Random();
        int i=0,r_no;
        while(i<n)
        {
            r_no = random.nextInt(range.length);
            System.out.println("random="+random);
            key[i]=""+range[r_no];
            i++;
            String[] copy = new String[range.length - 1];
            for (int k = 0, j = 0; k <range.length; k++) 
            {
                if (k != r_no) {
                    copy[j++] = range[k];
                }
            }
            range = copy.clone();
        }
            
            
    
        //StringBuilder sb = new StringBuilder();
        /*int i=0,random;
        while(i<n)
        {
            random=splittableRandom.nextInt(1,10);
            System.out.println("random="+random);
            for(String temp:range)
            {
                if(temp.equals(""+random))
                {
                    int check=0;
                    //check random no is already present or not
                    if(key.length==0)
                    {
                        key[i]=""+random;
                        i++;
                        break;
                    }
                    else
                    {
                        /*for(String j:key)
                        //for(int j=0;j<key.length;j++)
                        {
                            if(j.equals(""+random))
                            {
                                check=1;
                                break;
                            }

                        }*/
                        /*for(int j=0;j<key.length;j++)
                        {
                            System.out.println("key="+key.length);
                            System.out.println("keyV="+(""+random).equals(key[j]));

                            if((""+random).equals(key[j]))
                            {
                                check=1;
                                break;
                            }

                        }
                        
                        if(check==0)
                        {
                            key[i]=""+random;
                            i++;
                            break;
                        }
                    }
                    
                    
                }
            }
        }*/
        System.out.println("keys:"+key.toString());
}
    
    public static void generate_OTP(int n)
    {
        SplittableRandom splittableRandom = new SplittableRandom();
        //StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<n;i++)
        {
            otp=otp+(splittableRandom.nextInt(1,10));
        }
        
    }
    
    
    public static void send_email(String recepient) throws MessagingException
    {
        System.out.println("Preparing to send otp");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port.","587");
        
        String myAccountEmail = "jaiswar.ar@somaiya.edu";
        String password = "Anand@2000";
        
        
        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
         Message message = properMessage(session, myAccountEmail, recepient);
         
         Transport.send(message);
         System.out.println("OTP sent successfully");
         
         
    }     
         
         private static Message properMessage(Session session, String myAccountEmail, String recepient)
         {
            Message message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress(myAccountEmail));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
                message.setSubject("Viva OTP");
                message.setText(otp);
                return message;
            } catch (MessagingException ex) {
                Logger.getLogger(student_details.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
         }
         
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        f_name = new javax.swing.JTextField();
        m_name = new javax.swing.JTextField();
        l_name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        seat_no = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        u_otp = new javax.swing.JTextField();
        save_details = new javax.swing.JButton();
        verify_email = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        s_class = new javax.swing.JTextField();
        send_otp = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        u_teacher_code = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        exit = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1388, 905));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("STUDENT DETAILS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 38, 377, 43));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 132, 251, 41));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("FIRST NAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 87, 251, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("MIDDEL NAME");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 145, 251, 45));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("LAST NAME");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 208, 251, 50));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("GENDER");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 276, 251, 38));
        getContentPane().add(f_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 87, 293, 40));
        getContentPane().add(m_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 145, 293, 40));
        getContentPane().add(l_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 208, 293, 42));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("SEAT NUMBER");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 325, 251, 44));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("EMAIL");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 377, 251, 39));
        getContentPane().add(seat_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 327, 293, 44));

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 377, 293, 42));

        u_otp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_otpActionPerformed(evt);
            }
        });
        getContentPane().add(u_otp, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 430, 241, 37));

        save_details.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        save_details.setText("SAVE");
        save_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_detailsActionPerformed(evt);
            }
        });
        getContentPane().add(save_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 600, 240, 50));

        verify_email.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        verify_email.setText("VERIFY(ENTER OTP)");
        verify_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verify_emailActionPerformed(evt);
            }
        });
        getContentPane().add(verify_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 220, 40));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("CLASS");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 488, 251, 37));
        getContentPane().add(s_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 487, 290, 40));

        send_otp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        send_otp.setText("SEND OTP");
        send_otp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_otpActionPerformed(evt);
            }
        });
        getContentPane().add(send_otp, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 377, 120, 40));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("TEACHER CODE");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 531, 251, 34));

        u_teacher_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_teacher_codeActionPerformed(evt);
            }
        });
        getContentPane().add(u_teacher_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 534, 290, 40));

        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        male.setText("MALE");
        getContentPane().add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 276, 116, -1));

        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        female.setText("FEMALE");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        getContentPane().add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 276, 148, -1));

        exit.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 130, 40));

        back.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void u_otpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_otpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_otpActionPerformed

    private void verify_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verify_emailActionPerformed
        // TODO add your handling code here:
        if(!u_otp.getText().isEmpty() && u_otp.getText().equals(otp))
        {
            save_details.setEnabled(true);    
        }
        else
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">TYPE CORRECT OTP<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_verify_emailActionPerformed

    private void save_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_detailsActionPerformed
        // TODO add your handling code here:
        int f=0;
        if(f_name.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER THE FIRST NAME<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE); 
        }
        else if(l_name.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER THE LAST NAME<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else if(m_name.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER THE MIDDLE NAME<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else if(seat_no.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER THE SEAT NUMBER<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else if(s_class.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER THE CLASS Ii.e BSC-CS<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else if(!male.isSelected() && !female.isSelected())
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE SELECT GENDER<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else if(u_teacher_code.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER THE TEACHER CODE PROVIDED BY TOUR TEACHER<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else if(email.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER THE EMAIL Ii.e BSC-CS<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else if(!u_otp.getText().isEmpty() && u_otp.getText().equals(otp))
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">TYPE CORRECT OTP<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else{
            System.out.println("DONE1");
            try{
                //t_code=teacher_code.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
                Statement st = conn.createStatement();
                ResultSet rs=st.executeQuery("select * from teacher_records where teacher_code='"+u_teacher_code.getText()+"'");
                
                int j=0;
                while(rs.next())
                {
                    System.out.println("i="+j);
                    count=rs.getInt(5);
                    key = new String[count];
   
                    //System.out.println("count"+count);
                    j++;
                            //Checking name and password are validate or is user authenticate user or not from Database
                }
                //System.out.print("i="+j);
                if(j==0)
                {
                    JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">THIS TEACHER CODE IS NOT EXIST<br>PLEASE ENTER ANOTHER TEACHER CODE<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    Statement st1 = conn.createStatement();
                    ResultSet rs1=st1.executeQuery("select * from "+u_teacher_code.getText()+" where email='"+email.getText()+"'");
                    int k=0;
                    while(rs1.next())
                    {
                        System.out.print("i="+k);
                        k++;
                                    //Checking name and password are validate or is user authenticate user or not from Database
                    }
                    //System.out.print("i="+j);
                    if(k>0)
                    {
                        JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">THIS EMAIL IS ALREADY RESPONDED<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    { 
                        System.out.println("Done@");
                        Statement st3 = conn.createStatement();
                        ResultSet rs3=st3.executeQuery("select * from question_set where teacher_code='"+u_teacher_code.getText()+"'");
                        System.out.println("Done2");
                        int m=0;
                        while(rs3.next())
                        {
                            System.out.print("i="+m);
                            m++;
                                        //Checking name and password are validate or is user authenticate user or not from Database
                        }
                        //System.out.print("i="+j);
                        if(m<count && m==0)
                        {
                            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">THIS TEACHER CODE HAVE ZERO OR LESS QUESTION<BR>CONTACT YOUR TEACHER<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
                        }
                        else
                        {
                            range = new String[m];
                            System.out.print("Done3");
                            int i=0;
                            Statement st4 = conn.createStatement();
                            ResultSet rs4=st4.executeQuery("select * from question_set where teacher_code='"+u_teacher_code.getText()+"'");
                            while(rs4.next())
                            {
                                //System.out.print("Done4");
                                range[i]=""+rs4.getInt(1);
                                i++;
                                question_set.put(""+rs4.getInt(1), rs4.getString(2));
                                answer_set.put(""+rs4.getInt(1), rs4.getString(3));
                                //Checking name and password are validate or is user authenticate user or not from Database

                            }
                            /*for (Enumeration k1 = answer_set.keys(); k1.hasMoreElements();)
                            {
                                String temp_key = (String)k1.nextElement();
                                System.out.println("\n"+temp_key+": "+question_set.get(temp_key));
                                System.out.println("ANSWER: "+(String)answer_set.get(temp_key)+"\n");


                            }*/
                            int count1=0;
                            generate_qn(count);
                            while(count1<key.length)
                            {
                                System.out.println(count +"l="+(key.length));
                                //display.setText("\n"+key[count]+": "+question_set.get(key[count]));
                                //display.setText(display.getText()+"\n"+"Answer"+": "+answer_set.get(key[count]));
                                //voice.speak("question:    "+(String)question_set.get(key[count]));
                                System.out.println("question:    "+((String)question_set.get(key[count1])));
                                System.out.println("question:    "+((String)answer_set.get(key[count1])));
                                //System.out.println(((String)question_set.get(key[count])).replaceAll("\\n","\n"+"                    "));
                                //speech_button();
                                count1++;
                            }
                            
                            
                            
                            name1=f_name.getText()+" "+m_name.getText()+" "+l_name.getText();
                            if(male.isSelected())
                                gender1="male";
                            else
                                gender1="female";
                            //ps.setString(2,pass1);
                            email1=email.getText();
                            seat_no1=seat_no.getText();
                            s_class1=s_class.getText();
                            
                            
                            t_code=u_teacher_code.getText();
                            copy_file("C:\\Users\\Admin\\Documents\\Project_language_file\\"+t_code+".dic","src\\\\java\\\\grammer_file\\\\dict.dic");
                            copy_file("C:\\Users\\Admin\\Documents\\Project_language_file\\"+t_code+".lm","src\\\\java\\\\grammer_file\\\\lang.lm");
                            setVisible(false);
                            new Viva_room1().setVisible(true);
                        }
                    }
                }
      
               
               
            }   catch (Exception ex) {
                Logger.getLogger(student_details.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        }   
    }//GEN-LAST:event_save_detailsActionPerformed

    private void send_otpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_otpActionPerformed
        // TODO add your handling code here:
        
        if(!email.getText().isEmpty())
        {
            try {
                generate_OTP(5);
                send_email(email.getText());
            } catch (MessagingException ex) {
                Logger.getLogger(student_details.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
            System.out.println(otp);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">TYPE CORRECT Email<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_send_otpActionPerformed

    private void u_teacher_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_teacher_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_teacher_codeActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Main_page().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        int j = JOptionPane.showConfirmDialog(null,"DO YOU REALLY WANT TO CLOSE","SELECT",JOptionPane.YES_NO_OPTION);
        if(j==0)
        {
          System.exit(0);   //exit the application
        }
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(student_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new student_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField email;
    private javax.swing.JButton exit;
    private javax.swing.JTextField f_name;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField l_name;
    private javax.swing.JTextField m_name;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField s_class;
    private javax.swing.JButton save_details;
    private javax.swing.JTextField seat_no;
    private javax.swing.JButton send_otp;
    private javax.swing.JTextField u_otp;
    private javax.swing.JTextField u_teacher_code;
    private javax.swing.JButton verify_email;
    // End of variables declaration//GEN-END:variables
}
