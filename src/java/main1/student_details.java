/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main1;



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
    
    public static void generate_qn(int n) throws NullPointerException 
    {
        SplittableRandom splittableRandom = new SplittableRandom();
        //StringBuilder sb = new StringBuilder();
        int i=0,random;
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
                        for(int j=0;j<key.length;j++)
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
        }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1363, 716));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("STUDENT DETAILS");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("FIRST NAME");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("MIDDEL NAME");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("LAST NAME");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("GENDER");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("SEAT NUMBER");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("EMAIL");

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        u_otp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_otpActionPerformed(evt);
            }
        });

        save_details.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        save_details.setText("SAVE");
        save_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_detailsActionPerformed(evt);
            }
        });

        verify_email.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        verify_email.setText("VERIFY(ENTER OTP)");
        verify_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verify_emailActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("CLASS");

        send_otp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        send_otp.setText("SEND OTP");
        send_otp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_otpActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("TEACHER CODE");

        u_teacher_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_teacher_codeActionPerformed(evt);
            }
        });

        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        male.setText("MALE");

        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        female.setText("FEMALE");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(save_details, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(188, 188, 188))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(verify_email)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(u_otp, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(f_name)
                                            .addComponent(m_name)
                                            .addComponent(l_name)
                                            .addComponent(seat_no)
                                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(send_otp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(u_teacher_code, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(s_class, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(male, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(female, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(233, 233, 233))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(f_name)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(m_name)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(male)
                        .addComponent(female)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_no, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(send_otp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(u_otp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verify_email, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(s_class, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(u_teacher_code, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(save_details, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

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
        /*if(f_name.getText().isEmpty())
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
        else */if(u_teacher_code.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER THE TEACHER CODE PROVIDED BY TOUR TEACHER<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else if(email.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER THE EMAIL Ii.e BSC-CS<span></h1><html>","ALERT",JOptionPane.ERROR_MESSAGE);
        }
        else{
            System.out.println("DONE1");
            try{
                //t_code=teacher_code.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
                Statement st = conn.createStatement();
                ResultSet rs=st.executeQuery("select * from admin_records where teacher_code='"+u_teacher_code.getText()+"'");
                
                int j=0;
                while(rs.next())
                {
                    System.out.println("i="+j);
                    count=rs.getInt(6);
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
                            setVisible(false);
                            new speech_to_text().setVisible(true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField email;
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
