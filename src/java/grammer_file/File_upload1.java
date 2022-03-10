package grammer_file;



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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

public class File_upload1 extends javax.swing.JFrame {
    
    //public static String name1 = "ANand";
    public static int noq = 0;  //creting this because of its avoid unneccesary typecasting from Sting to Int
    public static Dictionary answer_set = new Hashtable();
    public static Dictionary question_set = new Hashtable();
    public static Dictionary hindi_set = new Hashtable();
    public static String[] key;
    //public String[] sample;
    public boolean val_key;
    public int k_count=0;
    //public static String uploaded_file_name;
    public static String file_path = "";
    //public String[] key1 = new String[noq];
    public boolean checkpoint1=false;
    public boolean checkpoint2=false;
    public boolean checkpoint3=true;
    public String keyword = "";
    public static String question_set_file_path = "";
    public static String dictionary_file_path = "";
    public static String language_file_path = "";
    public static String read="";
    
    
    /**
     * Creates new form first_page
     */
    public File_upload1() {
        initComponents();
        ta.setText("PLEASE WAIT FOR FILE UPLOADING IT TAKES TIMES");
        reading_mode.setEnabled(false);
                test_mode.setEnabled(false);
                
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
    
    //converted unstructured into structure
    public void separator()
    {
            
            /*int noq = 0;
            try{
            noq = Integer.parseInt(NOQ1.getText());
            }catch(NumberFormatException e)
            {
                System.out.println(e);
            }*/
            //System.out.println(noq);

            //here we split question part from answer part by use the keyword(Answer Key)
            String ta1="Answer Key";
             String[] subs = ta.getText().split("Answer Key");
            //boolean val_key = Pattern.matches(".*"+ta1+".*",ta.getText());//use to find keyword this tell is is search_key id present in temp or not
            boolean val_key = Pattern.compile(".*"+ta1+".*").matcher(ta.getText().trim()).matches();
            if(!(subs.length==2))  //checing for Answer Key is present or not
            {
                JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">FILE HAVING SOME ISSUE, ANSWER SET NOT FOUND IN FILE<br>PLEASE CHECK FILE OR TRY OTHER FILE<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE); 
            }
            else
            { 
                checkpoint1=true;
                
                reading_mode.setEnabled(true);
                test_mode.setEnabled(true);
               

                ques_area.setText(subs[0]);
                ans_area.setText(subs[1]);

                //separating hindi part
                String[] subs1 = ques_area.getText().split("Hindi");
                String[] subs2 = ans_area.getText().split("Hindi");
                //System.out.println("Q"+subs1[1]==null);
                //System.out.println("A"+subs2[1]==null);
                if(subs1.length==2)
                {
                    System.out.println("in ques");
                    ques_area.setText(subs1[0]);
                    hindi.setText(hindi.getText()+subs1[1]);
                }
                else if(subs2.length==2)
                {
                    ans_area.setText(subs2[0]);
                    hindi.setText(hindi.getText()+subs2[1]);
                }
            }
    }
    
    public void findkeyword(String[] answer_area2)
    {
        String[] keyword_sample = {"Question\\s\\d*"," Question\\s\\d*","Question\\.\\s\\d*","Que\\s\\d*","Que\\.\\s\\d*","Q\\s\\d*","Q\\.\\s\\d*","\\d*\\."};
        
        int len = keyword_sample.length;
	for(int i=0;i<len;i++)
	{
            k_count=0;
            //String search_key = keyword_sample[i]+"{"+noq+",}";//we can do {noq} instead of {noq,}
            String search_key = keyword_sample[i];  //check one by one key from keyword_sample for the keyword
            for(String temp:answer_area2)
            {
                boolean val_key = Pattern.matches(search_key,temp);//use to find keyword this tell is is search_key id present in temp or not
                if(val_key)
                {
                    k_count = k_count +1;       //count the no of time search_key present in answer_area2
                }
                System.out.println("keyword="+search_key+"val_key"+val_key);
            }
            if(k_count==noq)    //check no of time search_key present in answer_area2 is equal to noq if yes then search key is our keyword
            {
                keyword = keyword_sample[i];
                checkpoint2=true;
                break;
            }
            /*if(val_key)
            {
                keyword = keyword_sample[i];
                break;
            }*/
	}

    }
    
    public void split_file() throws ArrayIndexOutOfBoundsException
    {
        try{
        noq = Integer.parseInt(NOQ1.getText());     //typecaste from Sring to integer
        }catch(NumberFormatException e)
        {
            System.out.println(e);
        }
        //System.out.println(noq);
        /*String[] subs = ta.getText().split("Answer Key");
        ques_area.setText(subs[0]);
        ans_area.setText(subs[1]);*/
        //String ans_area1 = ans_area.getText().replaceAll("[\r\n]+", " ");
        try{
            
            //this code is for table formate answer
        String ans_area1 = ans_area.getText();
        String ques_area1 = ques_area.getText();
        key = new String[noq];                  //store question_no
	String[] value = new String[noq];      //store correct option
        String[] ans_area11 = ans_area1.split("[\r\n]");
        /*String ans11="";
        for(String temp:ans_area11)
        {
            hindi.setText(hindi.getText()+"\n"+temp);
            ans11=hindi.getText()+"\n"+temp;
        }*/
            //hindi.setText(hindi.getText()+"\n"+temp);
        
            //String[] answer_area2 = ans11.split("[\r\n]");
        //String[] answer_area2 = ans_area1.split("[\r\n]");        //split ans_area1 text into string array from new line  because of find the keyword
        findkeyword(ans_area11);
        if(!checkpoint2)
        {
            String[] answer_area2 = ans_area1.split("\\s");        //split ans_area1 text into string array from new line  because of find the keyword
            findkeyword(answer_area2);
        }
        
        //String[] sample = {"Question 1","Correct Option - 2","Question 2","Correct Option - 3","Question 3","Correct Option - 1","Question 4","Correct Option - 2","Question 5","Correct Option - 3",};
		/*for(int i=0;i<10;i++)
		{
			System.out.println("sss"+answer_area2[i]+i);
		}*/
        //String ques_area1 = ques_area.getText().replaceAll("[\r\n]+", " ");
        
        //String ans_area1 = " Que. 1 Correct Option - 4 Que. 2 Correct Option - 1 Que. 3 Correct Option - 2 Que. 4 Correct Option - 1 Que. 5 Correct Option - 1 Que. 6 Correct Option - 3 Que. 7 Correct Option - 3 Que. 8 Correct Option - 1 Que. 9 Correct Option - 2 Que. 10 Correct Option - 1";
        //System.out.println("Answer key:"+ques_area1);
        //System.out.println("Answer key:"+ans_area1);
               
        
        //findkeyword(answer_area2);
        
        if(!checkpoint2)
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">NUMBER OF QUESTION IS NOT CORRECT<br>PLEASE CHECK FILE AND TYPE CORRECT NUMBER OF QUESTION OR TRY OTHER FILE<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE); 
        }
        else
        {
            int index = 0;
            
            //keyword = "Question";
            String pat = keyword;
            //String pat = keyword+"\\s\\d*";
            //String pat ="Que.\\s\\d*";
            Pattern pattern = Pattern.compile(pat);
            Matcher matcher = pattern.matcher(ans_area1);       //find the pattern(question_no) form ans_area1
            boolean found = false;    
            while (matcher.find()) { 
                key[index] = matcher.group();       //store the matches pattern(question_no)

                    //System.out.println("I found the text "+key[index]);    
                found = true;   
                index++;
            }
            /*if(!(key.length==noq))
            {
                JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">INVALID FORMAT OF ANSWER, FILE HAVING DIFFERENT FORMAT OF ANSWER<br>PLEASE CHECK FILE<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE); 
            }*/
            //System.out.println("I found the text "+key); 
            if(!found){    
                System.out.println("No match found.");    
            } 
            //value = ans_area1.split(pat+"\\D*");        //find and store correct option by spliting pat and non-digit character
            value = ans_area1.split(pat);
            System.out.println("length of value: "+value.length);
            String[] v1 = ans_area1.split(pat);
            int c1=0;
            for(String temp:value)
            {
                boolean c=false;
                System.out.println("TEPM: "+temp);
                String ans[]={"1","2","3","4","a","b","c","d","{a}","{b}","{c}","{d}"};
                for(String temp2:ans)
                {
                    //c1=0;
                    if((temp.trim()).equals(temp2))
                    {
                        System.out.println("option find="+temp2);
                        c1++;
                    }
                    
                }
            }
            System.out.println("length of c: "+c1);
            if(!(c1==noq))
            {
                
                value = ans_area1.split(pat+"\\D*");
            }

            
            boolean found1 = false;
            System.out.println("length of value: "+value.length);
            for(int temp=0;temp<value.length;temp++)
            {
                boolean c=false;
                //System.out.println(temp);
                found1 = true;
                String ans[]={"1","2","3","4","a","b","c","d","{a}","{b}","{c}","{d}"};
                for(String temp2:ans)
                {
                    
                    if((value[temp].trim()).equals(temp2))
                    {
                        System.out.println("correct option="+temp2);
                        c=true;
                        
                    }
                    //else
                    //{
                        /*String[] option;
                        Pattern pattern1 = Pattern.compile("//d");
                        Matcher matcher1 = pattern1.matcher(value[temp]);
                        int i=0;
                        while (matcher.find()) { 
                            option[i] = matcher.group();       //store the matches pattern(question_no)
                             System.out.println(option[i]);
                                //System.out.println("I found the text "+key[index]);    
                            found = true;   
                            i++;
                        }*/
                       //JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">ANSWER PART OF QUESTION NUMBER"+temp+", HAVING SOME PROBLEM<br>PLEASE CHECK ANSWER PART OF QUESION NUMBER"+temp+"<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE); 
                    //}
                    
                }
                if(temp==0)
                    c=true;
                if(!c)
                {
                    checkpoint3=false;
                    JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">ANSWER PART OF QUESTION NUMBER"+(temp)+", HAVING SOME PROBLEM<br>PLEASE CHECK ANSWER PART OF QUESION NUMBER <br>IF EXTRA CHARACTER IS THERE REMOVE IT AND TRY AGAIN"+(temp)+"<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE); 
                }
            }
            if(checkpoint3)
            {
                System.out.println("in checkpoint 3");
                int index1 = 0;
                if(!found1){    
                    System.out.println("No match found.");    
                } 

                    //form dictionary
                System.out.println("length of value: "+value.length);
                for(int i=0;i<noq;i++)
                {
                    answer_set.put(key[i],value[i+1].trim());          //store the answer with there question_no and correct option
                    System.out.println("andwer = "+ value[i+1]);
                }
                //dict_key.setText("dict:"+set);



                //Question ka 

                //String[] value1 = new String[noq];
                String[] key1 = new String[noq];            //store the question_no
                Matcher matcher1 = pattern.matcher(ques_area1);
                boolean found2 = false;    
                while (matcher1.find()) 
                { 
                    key1[index1] = matcher1.group();

                    //System.out.println("I found the text "+key[index1]);    
                    found2 = true;  
                    //System.out.println("index: "+index1);
                    index1++;
                }    
                if(!found2)
                {    
                    System.out.println("No match found.");    
                } 
                //System.out.println("index: "+index1);
                //System.out.println("I found the text "+key[10]);
                String[] value1 = ques_area1.split(pat);        // find and store the question
                boolean found4 = false;    
                for(String temp1:value1)
                {
                    //System.out.println(temp1);
                    found4 = true; 
                }    
                if(!found4)
                {    
                    System.out.println("No match found.");    
                } 

                try{
                    //form dictionary
                    for(int i=0;i<noq;i++)
                    {
                        question_set.put(key1[i],value1[i+1]);          //store the question with there correct question_no
                        //System.out.println(key1[i]+" "+value1[i+1]);
                    }
                }catch(Exception e)
                {
                    System.out.println("no");
                }

                //dict_key.setText(dict_key.getText()+"\ndict:"+set1);


                //hindi part
                 String[] value2 = hindi.getText().split(pat);
                 for(int i=0;i<noq;i++)
                {
                    hindi_set.put(key1[i],value2[i+1]);          //store the question with there correct question_no
                }
            }
        }
        }catch(Exception e)
        {
            System.out.println(e);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NOQ1 = new javax.swing.JTextField();
        ansType = new javax.swing.JComboBox<>();
        reading_mode = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        file_chooser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ques_area = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        ans_area = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        test_mode = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        hindi = new javax.swing.JTextArea();
        logout = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("INFORMATION OF WORD FILE");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("NUMBER OF QUESTION");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("FORMATE OF ANSWER");

        NOQ1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NOQ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOQ1ActionPerformed(evt);
            }
        });

        ansType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ansType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ANSWER AT END OF ALL QUESTION(MCQ's)", " ", " " }));
        ansType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansTypeActionPerformed(evt);
            }
        });

        reading_mode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reading_mode.setText("READING MODE");
        reading_mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reading_modeActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(51, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("UPLOAD WORD FILE");

        file_chooser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        file_chooser.setText("UPLOAD");
        file_chooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_chooserActionPerformed(evt);
            }
        });

        ta.setColumns(20);
        ta.setRows(5);
        jScrollPane1.setViewportView(ta);

        ques_area.setColumns(20);
        ques_area.setRows(5);
        jScrollPane2.setViewportView(ques_area);

        ans_area.setColumns(20);
        ans_area.setRows(5);
        jScrollPane3.setViewportView(ans_area);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Question");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Answer");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Uplaoded file");

        back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        test_mode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        test_mode.setText("TEST_MODE");
        test_mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                test_modeActionPerformed(evt);
            }
        });

        hindi.setColumns(20);
        hindi.setRows(5);
        jScrollPane4.setViewportView(hindi);

        logout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("UPLOAD DICTIONARY FILE OR .dic");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("UPLOAD LANGUAGE FILE OR .lm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("UPLOAD AFTER MANUAL WORK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NOQ1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(file_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ansType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(60, 60, 60)
                        .addComponent(test_mode)
                        .addGap(78, 78, 78)
                        .addComponent(reading_mode)))
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel5)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NOQ1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ansType, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(file_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(reading_mode, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(test_mode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(47, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ansTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ansTypeActionPerformed

    private void reading_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reading_modeActionPerformed
        //String temp = ta.getText();
        checkpoint3=true;
       if("".equals(NOQ1.getText()))
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER NUMBER OF QUESTION<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            separator();
            if(checkpoint1)
            {
                split_file();
                if(checkpoint2 && checkpoint3)
                {
                    setVisible(false);
                    
                    new Practice_viva_room().setVisible(true);
                }
                
            }
            
        }
        
       /* try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","");
            Statement st = conn.createStatement();
            //st.executeUpdate("create table login_record (u_name varchar(20),password varchar(20),email varchar(20))");
            //System.out.println("TAble is created");
            //st.executeUpdate("insert into std values(name1,pass1,email)");
            PreparedStatement ps=conn.prepareStatement("insert into question_set(question_key,question_set,answer_set) values(?,?,?)");
            //ps.setInt(1,key);
            ps.setString(2,File_upload.file_path);
            //ps.setString(3,""+now);
            //ps.setInt(4,score);
            //ps.setString(5,total_time);
            //ps.setString(1,average_time);
            ps.setInt(6,40);
            ps.executeUpdate();
            


            }catch(Exception e){
                System.out.print(e);
            }*/
        
        
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_reading_modeActionPerformed

    private void file_chooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_chooserActionPerformed

                reading_mode.setEnabled(true);
                test_mode.setEnabled(true);
                JFileChooser fc=new JFileChooser(); 
                int i=fc.showOpenDialog(this); 
                //String file_path = "";
                //System.out.println("i= "+i);
                if(i==JFileChooser.APPROVE_OPTION)
                { 
                    File f=fc.getSelectedFile(); 
                    
                    question_set_file_path = f.getPath();     //get the file path
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
                
                boolean val_key = Pattern.compile(".*"+".txt").matcher(question_set_file_path).matches();
                if(!val_key)
                {
                    JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">ONLY TEXT FILE SUPPORTED<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE);

                }
                else{
                
 
                try (BufferedReader br = new BufferedReader(new FileReader(question_set_file_path)))
                {
                    String line;
                    while ((line = br.readLine()) != null) {
                        //System.out.println(line);
                        read = read+"       "+"\n"+"        "+line;
                        ta.setText(ta.getText()+"\n"+line);
                    }
                }catch(Exception e)
                    {
                        //file_upload.setEnabled(false);
                        System.out.println(e);
                        JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">FILE HAVING SOME ISSUE<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
       
        // TODO add your handling code here:

    }//GEN-LAST:event_file_chooserActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        //new Home_page().setVisible(true);       //directing to the Login_form
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

    private void test_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_test_modeActionPerformed
        // TODO add your handling code here:
        checkpoint3=true;
        if("".equals(NOQ1.getText()))
        {
            JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER NUMBER OF QUESTION<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            separator();
            if(checkpoint1)
            {
                split_file();
                if(checkpoint2 && checkpoint3)
                {
                    setVisible(false);
                    //new Quiz_Mode().setVisible(true);
                }

            }

        }
        //directing to the Quiz_mode
    }//GEN-LAST:event_test_modeActionPerformed

    private void NOQ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOQ1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NOQ1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
                        copy_file(dictionary_file_path,"src\\java\\grammer_file\\dict.dic");
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
                        copy_file(language_file_path,"src\\java\\grammer_file\\lang.lm");
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
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(File_upload1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(File_upload1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(File_upload1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(File_upload1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new File_upload1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NOQ1;
    private javax.swing.JComboBox<String> ansType;
    private javax.swing.JTextArea ans_area;
    private javax.swing.JButton back;
    private javax.swing.JButton file_chooser;
    private javax.swing.JTextArea hindi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton logout;
    private javax.swing.JTextArea ques_area;
    private javax.swing.JButton reading_mode;
    private javax.swing.JTextArea ta;
    private javax.swing.JButton test_mode;
    // End of variables declaration//GEN-END:variables
}
