
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import static grammer_file.File_upload1.answer_set;
import static grammer_file.File_upload1.key;
import static grammer_file.File_upload1.noq;
import static grammer_file.File_upload1.question_set;
import static grammer_file.Reading_Mode1.reader_area;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

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




public class speech_to_text extends javax.swing.JFrame {
    public static String flag="1";
    public static Configuration config;
    public static LiveSpeechRecognizer rec;
    //public static String q1="what is your password?";
    public static Voice voice;
    //public static Dictionary question_set = new Hashtable();
    //public static Dictionary answer_set = new Hashtable();
    //public static String key[]={"q1","q2","q3"};
    public static int count=0;
    //public static int noq=3;
    public static Dictionary user_answer = new Hashtable();
    //public static Dictionary user_min = new Hashtable();
    public static Dictionary user_sec = new Hashtable();
    
    
    

    /**
     * Creates new form speech_to_text
     */
    public speech_to_text() {
        speech();
        initComponents();
        
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice("kevin16");
        voice.allocate();
        //question_set.put("q1","what is the command?");
        //question_set.put("q2","java is object oriented langauge?");
        //question_set.put("q3","After work done from the server what last action must you perform?");
        /*question_set.put("q1","When is 'World Ozone Day' observed?\n" +
"1) January 15\n" +
"2) April 25\n" +
"3) December 16\n" +
"4) September 16");*/
        
        //answer_set.put("q1","open");
        //answer_set.put("q2","right");
        //answer_set.put("q3","close");
        
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
        config.setDictionaryPath(grammer_file.File_upload1.dictionary_file_path);
        //config.setDictionaryPath("src\\java\\grammer_file\\dict.dic");
        //config.setDictionaryPath("D:\\test\\test1\\dict.dic");
        config.setLanguageModelPath(grammer_file.File_upload1.language_file_path);
        //config.setLanguageModelPath("src\\java\\grammer_file\\lang.lm");
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
    
    
    public static void speech_button()
    {
        try
        {
            //LiveSpeechRecognizer rec = new LiveSpeechRecognizer(config);
            
            
            SpeechResult speechResult =null;
            long t= System.currentTimeMillis();
            long end = t+5000;
   
            while((speechResult=rec.getResult())!=null && (System.currentTimeMillis() < end))
            //for(int i=0;i<100;i++)
            {
                String result =speechResult.getHypothesis();
                //if(result.equalsIgnoreCase("open"))
                
                if(result.equalsIgnoreCase((String)answer_set.get(key[count])))
                {
                    //System.out.println("you speech="+result);
              
                    //text1.setText(text1.getText()+result);
                    user_answer.put(key[count],result);
                    user_sec.put(key[count],(end-System.currentTimeMillis()));
                    //text1.setText(result);
                    voice.speak("YOUR ANSWER:  "+result);
                    //rec.startRecognition(false);
                    break;
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
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
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
                .addContainerGap(94, Short.MAX_VALUE))
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
        for(int i=0;i<noq;i++)
        {
            user_answer.put(key[i],"");
            //user_min.put(key[i],0);
            user_sec.put(key[i],0);
        }
        count=0;
        /**
        for (Enumeration k = answer_set.keys(); k.hasMoreElements();)
        {
            
            String temp_key = (String)k.nextElement();
            voice.speak((String)question_set.get(temp_key));
            speech_button();
            count=count+1;
        
        * */
        while(count<key.length)
        {
            System.out.println(count +"l="+(key.length));
            //display.setText("\n"+key[count]+": "+question_set.get(key[count]));
            //display.setText(display.getText()+"\n"+"Answer"+": "+answer_set.get(key[count]));
            voice.speak("question:    "+(String)question_set.get(key[count]));
            speech_button();
            count++;
        }
        setVisible(false);
        new Performance_evaluation1().setVisible(true);
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
            java.util.logging.Logger.getLogger(speech_to_text.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(speech_to_text.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(speech_to_text.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(speech_to_text.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new speech_to_text().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea display;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables
}
