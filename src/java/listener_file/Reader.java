package listener_file;



import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import static listener_file.File_upload3.answer_set;
import static listener_file.File_upload3.key;
import static listener_file.File_upload3.question_set;
//import static grammer_file.Reading_Mode1.reader_area;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * create table login_cretential (uid int AUTO_INCREMENT PRIMARY,u_name varchar,password varchar,email varchar);
 * 
 * 
 * @author Admin
 */




public class Reader extends javax.swing.JFrame {
    public static String flag="1";
    public static Configuration config;
    public static LiveSpeechRecognizer rec;
    public static String q1="what is your password?";
    public static Voice voice;
    //public static Dictionary question_set = new Hashtable();
    //public static Dictionary answer_set = new Hashtable();
    public static String temp_key;
    public static int count=0; 
    //public static String key[]={"q1","q2"};
    
    
    

    /**
     * Creates new form speech_to_text
     */
    public Reader() {
        speech();
        initComponents();
        viva_mode.setEnabled(false);
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice("kevin16");
        voice.allocate();
        voice.setRate(140);
        feedback.setEnabled(false);
         start_reader.setEnabled(false);
        //question_set.put("q1","what is the command?");
        //question_set.put("q2","java is object oriented langauge?");
        /*question_set.put("q1","When is 'World Ozone Day' observed?\n" +
"1) January 15\n" +
"2) April 25\n" +
"3) December 16\n" +
"4) September 16");*/
        
        //answer_set.put("q1","open");
        //answer_set.put("q2","right");
        
       
        
        /*try{
            speech();
        }catch(Exception e)
        {
            System.out.println(e);
        }*/
        
    }

    public static void speech()
    {
        config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        //config.setDictionaryPath(file_upload.dictionary_file_path);
        config.setDictionaryPath("src\\java\\listener_file\\dict.dic");
        //config.setDictionaryPath("D:\\test\\test1\\dict.dic");
        //config.setLanguageModelPath(file_upload.language_file_path);
        config.setLanguageModelPath("src\\java\\listener_file\\lang.lm");
        //config.setLanguageModelPath("D:\\test\\test1\\lang.lm");
        System.out.println("hii");
        
        try{
            rec = new LiveSpeechRecognizer(config);
            rec.startRecognition(true);
        }catch(Exception e)
        {
            System.out.println(e);
        }
        //return(rec);
    }
    
    public static void next()
        {
            if((count+1)<key.length)
            {
                count=count+1;
                content();
            
            }
            else
            {
                voice.speak("it is an last question");
            }
            
            
        }
    
     public static void previous()
        {
            if((count-1)>=0)
            {
                count=count-1;
                content();
            }
            else
            {
                voice.speak("it is an First question");
            }
            
            
        }
    
    public static void content()
        {
            //display.setText("\n"+key[count]+": "+question_set.get(key[count]));
            //display.setText(display.getText()+"\n"+"Answer"+": "+answer_set.get(key[count]));
            voice.speak("question:    "+(String)question_set.get(key[count]));
            voice.speak("answer:    "+(String)answer_set.get(key[count]));
            
            /*for (Enumeration k = answer_set.keys(); k.hasMoreElements();)
            {
                if(temp_key==(String)k.nextElement())
                {
                    voice.speak("question:    "+(String)question_set.get(temp_key));
                    voice.speak("answer:    "+(String)answer_set.get(temp_key));
                    display.setText("\n"+temp_key+": "+question_set.get(temp_key));
                    display.setText(display.getText()+"\n"+"Answer"+": "+answer_set.get(temp_key));
                    break;
                }
            }*/
            
            /*for(int count=0;count<File_upload1.key.length-1;count++)
            {
                voice.speak("question:    "+(String)question_set.get(File_upload1.key[count]));
                voice.speak("answer:    "+(String)answer_set.get(File_upload1.key[count]));
                display.setText("\n"+File_upload1.key[count]+": "+question_set.get(File_upload1.key[count]));
                display.setText(display.getText()+"\n"+"Answer"+": "+answer_set.get(File_upload1.key[count]));
            }*/
        }
    
    
    public static void speech_button()
    {
        try
        {
            //LiveSpeechRecognizer rec = new LiveSpeechRecognizer(config);
            
            
            SpeechResult speechResult =null;
            long t= System.currentTimeMillis();
            long end = t+15000;
   
            while((System.currentTimeMillis() < end) && (speechResult=rec.getResult())!=null)
            //for(int i=0;i<100;i++)
            {
                String result =speechResult.getHypothesis();
                //if(result.equalsIgnoreCase("open"))
                //System.out.println("you speech=");
                if(result.equalsIgnoreCase("repeat"))
                {
                    //System.out.println("you speech="+result);
              
                    //text1.setText(text1.getText()+result);
                    
                    //text1.setText(result);
                    voice.speak("YOUR sayed:  "+result);
                    content();
                    t=System.currentTimeMillis();
                    end = t+15000;
                    
                    //rec.startRecognition(false);
                    //break;
                }
                else if(result.equalsIgnoreCase("next"))
                {
                    voice.speak("YOUR sayed:  "+result);
                    next();
                    t=System.currentTimeMillis();
                    end = t+15000;
                }
                else if(result.equalsIgnoreCase("previous"))
                {
                    voice.speak("YOUR sayed:  "+result);
                    previous();
                    t=System.currentTimeMillis();
                    end = t+10000;
                }
                
                //sleep(1000);    
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

        stop = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();
        start_reader = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        start_point = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        instruction = new javax.swing.JCheckBox();
        back = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        feedback = new javax.swing.JButton();
        viva_mode = new javax.swing.JButton();

        stop.setText("stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1388, 905));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        display.setEditable(false);
        display.setColumns(20);
        display.setRows(5);
        display.setText("-> AFTER STARTING VIVA READER READ THE QUESTION SO LISTEN\nCAREFULLY.\n\n-> IF YOU WANT TO REPEAT THE QUESTION JUST SAY REPEAT AFTER\nREADER STOP OR COMPLETE THE QUESITON.\n\n-> IF YOU WANT TO JUMP TO THE NEXT QUESTION JUST SAY NEXT AFTER\nREADER STOP OR COMPLETE THE QUESITON.\n\n-> IF YOU WANT TO JUMP TO THE PREVOIUS QUESTION JUST SAY PREVIOUS AFTER\nREADER STOP OR COMPLETE THE QUESITON.\n\n-> ANSWER THE QUESTION ONLY AFTER READER STOP OR COMPLETE THE\nQUESITON,IT GIVES YOU 10sec TO ANSWER.IF YOU DON'T KNOW THE\nANSWER THEN WAIT FOR READER TO READ NEXT QUESTION. ");
        jScrollPane1.setViewportView(display);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 636, 287));

        start_reader.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        start_reader.setText("START");
        start_reader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_readerActionPerformed(evt);
            }
        });
        getContentPane().add(start_reader, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 140, 59));

        jLabel1.setText("START FROM QUESTION NUMBER:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 243, 39));

        start_point.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_pointActionPerformed(evt);
            }
        });
        getContentPane().add(start_point, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 560, 291, 34));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("READING MODE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 301, 34));

        instruction.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        instruction.setText("CLICK ON CHECKBOX IF YOU READ");
        instruction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructionActionPerformed(evt);
            }
        });
        getContentPane().add(instruction, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 280, -1));

        back.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 130, 50));

        exit.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, 120, 50));

        feedback.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        feedback.setText("FEEDBACK");
        feedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedbackActionPerformed(evt);
            }
        });
        getContentPane().add(feedback, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 50));

        viva_mode.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        viva_mode.setText("VIVA MODE");
        viva_mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viva_modeActionPerformed(evt);
            }
        });
        getContentPane().add(viva_mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 180, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // TODO add your handling code here:
        
        //voice.speak(q1);
    }//GEN-LAST:event_stopActionPerformed

    private void start_readerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_readerActionPerformed
        // TODO add your handling code here:
        //voice.speak(file_upload.read);
     String q=""; 
     count=0;
    //for(int count=0;count<File_upload1.key.length-1;count++)
    while(count<key.length)
    {
        System.out.println(count +"l="+(key.length));
        //display.setText("\n"+key[count]+": "+question_set.get(key[count]));
        //display.setText(display.getText()+"\n"+"Answer"+": "+answer_set.get(key[count]));
        voice.speak("question:    "+(String)question_set.get(key[count]));
        voice.speak("answer:    "+(String)answer_set.get(key[count]));
        
        speech_button();
        count++;
    }
    rec.stopRecognition();
    System.out.println(count +"l="+(key.length-1));
    feedback.setEnabled(true);
    /* if(!("".equals(start_point.getText())))
     {
          q = start_point.getText();
          
        //JOptionPane.showMessageDialog(null,"<html><h1><span style=\"color:red font:-size:10px\">PLEASE ENTER NUMBER<span></h1><html>","ALERT",JOptionPane.INFORMATION_MESSAGE);
     }
     else
     { */  
        
       /* for (Enumeration k = answer_set.keys(); k.hasMoreElements();)
        {
            temp_key = (String)k.nextElement();
            if(start_point.getText().equalsIgnoreCase(temp_key) && !("".equals(start_point.getText())))
                continue;
            voice.speak("question:    "+(String)question_set.get(temp_key));
            voice.speak("answer:    "+(String)answer_set.get(temp_key));
            display.setText("\n"+temp_key+": "+question_set.get(temp_key));
            display.setText(display.getText()+"\n"+"Answer"+": "+answer_set.get(temp_key));
            speech_button();
        }*/
        //voice.speak((String)question_set.get("q1"));
        //speech_button();
        
    }//GEN-LAST:event_start_readerActionPerformed

    private void start_pointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_pointActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_start_pointActionPerformed

    private void instructionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionActionPerformed
        // TODO add your handling code here:
        if(instruction.isSelected())
        {
            start_reader.setEnabled(true);
            back.setEnabled(false);
        }
        else
        {
            back.setEnabled(true);
            start_reader.setEnabled(false);
        }
    }//GEN-LAST:event_instructionActionPerformed

    private void feedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedbackActionPerformed
        // TODO add your handling code here:
        new grammer_file.feedback().setVisible(true);
    }//GEN-LAST:event_feedbackActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new File_upload3().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        int j = JOptionPane.showConfirmDialog(null,"DO YOU REALLY WANT TO CLOSE","SELECT",JOptionPane.YES_NO_OPTION);
        if(j==0)
        {
          System.exit(0);   //exit the application
        }
    }//GEN-LAST:event_exitActionPerformed

    private void viva_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viva_modeActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        rec.stopRecognition();
        new grammer_file.Practice_viva_room().setVisible(true);
    }//GEN-LAST:event_viva_modeActionPerformed

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
            java.util.logging.Logger.getLogger(Reader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reader().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private static javax.swing.JTextArea display;
    private javax.swing.JButton exit;
    private javax.swing.JButton feedback;
    private javax.swing.JCheckBox instruction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField start_point;
    private javax.swing.JButton start_reader;
    private javax.swing.JButton stop;
    private javax.swing.JButton viva_mode;
    // End of variables declaration//GEN-END:variables
}
