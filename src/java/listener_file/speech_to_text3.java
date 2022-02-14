package listener_file;



import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import static grammer_file.File_upload1.answer_set;
import static grammer_file.File_upload1.key;
import static grammer_file.File_upload1.question_set;
import static grammer_file.Reading_Mode1.reader_area;
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




public class speech_to_text3 extends javax.swing.JFrame {
    public static String flag="1";
    public static Configuration config;
    public static LiveSpeechRecognizer rec;
    public static String q1="what is your password?";
    public static Voice voice;
    public static Dictionary question_set = new Hashtable();
    public static Dictionary answer_set = new Hashtable();
    public static String temp_key;
    public static int count=0; 
    public static String key[]={"q1","q2"};
    
    
    

    /**
     * Creates new form speech_to_text
     */
    public speech_to_text3() {
        speech();
        initComponents();
        
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice("kevin16");
        voice.allocate();
        question_set.put("q1","what is the command?");
        question_set.put("q2","java is object oriented langauge?");
        /*question_set.put("q1","When is 'World Ozone Day' observed?\n" +
"1) January 15\n" +
"2) April 25\n" +
"3) December 16\n" +
"4) September 16");*/
        
        answer_set.put("q1","open");
        answer_set.put("q2","right");
        
       
        
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
            long end = t+3000;
   
            while((speechResult=rec.getResult())!=null && (System.currentTimeMillis() < end))
            //for(int i=0;i<100;i++)
            {
                String result =speechResult.getHypothesis();
                //if(result.equalsIgnoreCase("open"))
                
                if(result.equalsIgnoreCase("repeat"))
                {
                    //System.out.println("you speech="+result);
              
                    //text1.setText(text1.getText()+result);
                    
                    //text1.setText(result);
                    voice.speak("YOUR sayed:  "+result);
                    content();
                    t=System.currentTimeMillis();
                    end = t+2000;
                    
                    //rec.startRecognition(false);
                    //break;
                }
                else if(result.equalsIgnoreCase("next"))
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        start_point = new javax.swing.JTextField();

        stop.setText("stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        display.setColumns(20);
        display.setRows(5);
        jScrollPane1.setViewportView(display);

        jButton1.setText("START");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("reader");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("START FROM QUESTION NUMBER:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(start_point, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(start_point, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        speech_button();
       /* try
        {
            //LiveSpeechRecognizer rec = new LiveSpeechRecognizer(config);
            
            
            SpeechResult speechResult =null;
            
            while((speechResult=rec.getResult())!=null)
            //for(int i=0;i<100;i++)
            {
                String result =speechResult.getHypothesis();
                //if(result.equalsIgnoreCase("open"))
                if(result.equalsIgnoreCase((String)answer_set.get("q1")))
                {
                    //System.out.println("you speech="+result);
              
                    //text1.setText(text1.getText()+result);
                    text1.setText(result);
                    voice.speak(result);
                    //rec.startRecognition(false);
                    break;
                }
                //sleep(1000);    
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // TODO add your handling code here:
        
        //voice.speak(q1);
    }//GEN-LAST:event_stopActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    System.out.println(count +"l="+(key.length-1));
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
            java.util.logging.Logger.getLogger(speech_to_text3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(speech_to_text3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(speech_to_text3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(speech_to_text3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new speech_to_text3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea display;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField start_point;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables
}
