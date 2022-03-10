package grammer_file;



import listener_file.*;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import static grammer_file.File_upload1.noq;
import grammer_file.Performance_evaluation22222;
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




public class Practice_viva_room extends javax.swing.JFrame {
    public static String flag="1";
    public static Configuration config;
    public static LiveSpeechRecognizer rec;
    public static String q1="what is your password?";
    public static Voice voice;
    //public static Dictionary question_set = new Hashtable();
    //public static Dictionary answer_set = new Hashtable();
    public static String temp_key;
    public static int count=0;
    public static int score=0;
     public static Dictionary user_answer = new Hashtable();
    public static Dictionary user_sec = new Hashtable();
    //public static String key[]={"q1","q2"};
    
    
    

    /**
     * Creates new form speech_to_text
     */
    public Practice_viva_room() {
        speech();
        initComponents();
        
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice("kevin16");
        voice.allocate();
        voice.setRate(130);
        start_viva.setEnabled(false);
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
                repeat();
            
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
                repeat();
            }
            else
            {
                voice.speak("it is an First question");
            }
            
            
        }
    
    public static void repeat()
        {
            //display.setText("\n"+key[count]+": "+question_set.get(key[count]));
            //display.setText(display.getText()+"\n"+"Answer"+": "+answer_set.get(key[count]));
            voice.speak("question:    "+(String)question_set.get(key[count]));
            //voice.speak("answer:    "+(String)answer_set.get(key[count]));
            
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
            long end = t+10000;
   
            while((System.currentTimeMillis() < end) && (speechResult=rec.getResult())!=null)
            //for(int i=0;i<100;i++)
            {
                String result =speechResult.getHypothesis();
                //if(result.equalsIgnoreCase("open"))
                //System.out.println("recorded");
                if(result.equalsIgnoreCase("repeat"))
                {
                    //System.out.println("you speech="+result);
              
                    //text1.setText(text1.getText()+result);
                    
                    //text1.setText(result);
                    voice.speak("YOUR sayed:  "+result);
                    repeat();
                    t=System.currentTimeMillis();
                    end = t+15000;
                    
                    //rec.startRecognition(false);
                    //break;
                }
                else if(result.equalsIgnoreCase((String)answer_set.get(key[count])))
                {
                    voice.speak("YOUR sayed:  "+result);
                    user_answer.put(key[count],result);
                    user_sec.put(key[count],(end-System.currentTimeMillis()));
                    score++;
                    break;
                }
               /* else if(result.equalsIgnoreCase("next"))
                {
                    voice.speak("YOUR sayed:  "+result);
                    next();
                    t=System.currentTimeMillis();
                    end = t+5000;
                }
                else if(result.equalsIgnoreCase("previous"))
                {
                    voice.speak("YOUR sayed:  "+result);
                    previous();
                    t=System.currentTimeMillis();
                    end = t+5000;
                }*/
                
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
        start_viva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        start_point = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        instruction = new javax.swing.JCheckBox();
        back = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        stop.setText("stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1388, 905));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        start_viva.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        start_viva.setText("START VIVA");
        start_viva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_vivaActionPerformed(evt);
            }
        });
        getContentPane().add(start_viva, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 170, 59));

        jLabel1.setText("START FROM QUESTION NUMBER:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 243, 39));
        getContentPane().add(start_point, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 291, 34));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("PRACTICE VIVA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 300, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("-> AFTER STARTING VIVA READER READ THE QUESTION SO LISTEN\nCAREFULLY.\n\n-> IF YOU WANT TO REPEAT THE QUESTION JUST SAY REPEAT AFTER\nREADER STOP OR COMPLETE THE QUESITON.\n\n-> ANSWER THE QUESTION ONLY AFTER READER STOP OR COMPLETE THE\nQUESITON,IT GIVES YOU 10sec TO ANSWER.IF YOU DON'T KNOW THE\nANSWER THEN WAIT FOR READER TO READ NEXT QUESTION.");
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 520, 210));

        instruction.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        instruction.setText("CLICK CHECKBOX IF YOU READED");
        instruction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructionActionPerformed(evt);
            }
        });
        getContentPane().add(instruction, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 270, -1));

        back.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        back.setText("BACK");
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, 130, 50));

        exit.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        exit.setText("EXIT");
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 20, 130, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // TODO add your handling code here:
        
        //voice.speak(q1);
    }//GEN-LAST:event_stopActionPerformed

    private void start_vivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_vivaActionPerformed
        // TODO add your handling code here:
        //voice.speak(file_upload.read);
     String q=""; 
     
     for(int i=0;i<noq;i++)
        {
            user_answer.put(key[i],"");
            //user_min.put(key[i],0);
            user_sec.put(key[i],0);
        }
    //for(int count=0;count<File_upload1.key.length-1;count++)
    count=0;
    while(count<key.length)
    {
        System.out.println(count +"l="+(key.length));
        //display.setText("\n"+key[count]+": "+question_set.get(key[count]));
        //display.setText(display.getText()+"\n"+"Answer"+": "+answer_set.get(key[count]));
        voice.speak("question:    "+(String)question_set.get(key[count]));
        //voice.speak("answer:    "+(String)answer_set.get(key[count]));
        
        speech_button();
        count++;
    }
    setVisible(false);
    new Performance_evaluation22222().setVisible(true);
    //System.out.println(count +"l="+(key.length-1));
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
        
    }//GEN-LAST:event_start_vivaActionPerformed

    private void instructionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionActionPerformed
        // TODO add your handling code here:
        if(instruction.isSelected())
        {
            start_viva.setEnabled(true);
            back.setEnabled(false);
        }
        else
        {
            back.setEnabled(true);
            start_viva.setEnabled(false);
        }
    }//GEN-LAST:event_instructionActionPerformed

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
            java.util.logging.Logger.getLogger(Practice_viva_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Practice_viva_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Practice_viva_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Practice_viva_room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Practice_viva_room().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton exit;
    private javax.swing.JCheckBox instruction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField start_point;
    private javax.swing.JButton start_viva;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables
}
