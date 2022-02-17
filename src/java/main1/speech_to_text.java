package main1;



import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import static main1.student_details.answer_set;
import static main1.student_details.key;
//import static grammer_file.File_upload1.noq;
import static main1.student_details.question_set;
//import static grammer_file.Reading_Mode1.reader_area;
import java.io.IOException;
//import static java.lang.Thread.sleep;
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
    public static int count1=0;
    //public static int noq=3;
    public static Dictionary user_answer = new Hashtable();
    //public static Dictionary user_min = new Hashtable();
    public static Dictionary user_sec = new Hashtable();
    //public static Dictionary question_set = new Hashtable();
    //public static Dictionary answer_set = new Hashtable();
    
    
    

    /**
     * Creates new form speech_to_text
     */
    public speech_to_text() {
        speech();
        initComponents();
        start_viva.setEnabled(false);
        display_qn.setText(""+student_details.count);
        
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
        //config.setDictionaryPath(grammer_file.File_upload1.dictionary_file_path);
        config.setDictionaryPath("src\\java\\grammer_file\\dict.dic");
        //config.setDictionaryPath("D:\\test\\test1\\dict.dic");
        //config.setLanguageModelPath(grammer_file.File_upload1.language_file_path);
        config.setLanguageModelPath("src\\java\\grammer_file\\lang.lm");
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
                
                if(result.equalsIgnoreCase((String)answer_set.get(key[count1])))
                {
                    //System.out.println("you speech="+result);
              
                    //text1.setText(text1.getText()+result);
                    user_answer.put(key[count1],result);
                    user_sec.put(key[count1],(end-System.currentTimeMillis()));
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
        start_viva = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        display_qn = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        instruction = new javax.swing.JCheckBox();

        stop.setText("stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        start_viva.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        start_viva.setText("START VIVA");
        start_viva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_vivaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("NUMBER OF QUESION");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VIVA ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("INSTRUCTION FOR VIVA");

        display_qn.setEditable(false);
        display_qn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                display_qnActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("-> AFTER STARTING VIVA READER READ THE QUESTION SO LISTEN\nCAREFULLY.\n-> IF YOU WANT TO REPEAT THE QUESTION JUST SAY REPEAT AFTER\nREADER STOP.\n-> ANSWER THE QUESTION ONLY AFER READER STOP IT GIVES YOU\n10sec TO ANSWER.IF YOU DON'T KNOW THE ANSWER THEN WAIT FOR\nFOR READER TO READ NEXT QUESTION. \n\n");
        jScrollPane1.setViewportView(jTextArea1);

        instruction.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        instruction.setText("CLICK THE BOX IF YOU READED");
        instruction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(71, 71, 71)
                                .addComponent(display_qn, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(instruction, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(start_viva, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(display_qn)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(instruction)
                .addGap(32, 32, 32)
                .addComponent(start_viva, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // TODO add your handling code here:
        
        //voice.speak(q1);
    }//GEN-LAST:event_stopActionPerformed

    private void start_vivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_vivaActionPerformed
        // TODO add your handling code here:
        //voice.speak(file_upload.read);
        for(int i=0;i<student_details.count;i++)
        {
            user_answer.put(key[i],"");
            //user_min.put(key[i],0);
            user_sec.put(key[i],0);
        }
        count1=0;
        /**
        for (Enumeration k = answer_set.keys(); k.hasMoreElements();)
        {
            
            String temp_key = (String)k.nextElement();
            voice.speak((String)question_set.get(temp_key));
            speech_button();
            count=count+1;
        
        * */
        while(count1<key.length)
        {
            System.out.println(count1 +"l="+(key.length));
            //display.setText("\n"+key[count]+": "+question_set.get(key[count]));
            //display.setText(display.getText()+"\n"+"Answer"+": "+answer_set.get(key[count]));
            //voice.speak("question:    "+(String)question_set.get(key[count]));
            voice.speak("question:    "+((String)question_set.get(key[count1])).replaceAll("\\n", "\n"+"."+"\n"+"."));
            //System.out.println(((String)question_set.get(key[count])).replaceAll("\\n","\n"+"                    "));
            speech_button();
            count1++;
        }
       
        setVisible(false);
        new Performance_evaluation1().setVisible(true);
        //voice.speak((String)question_set.get("q1"));
        //speech_button();
        
    }//GEN-LAST:event_start_vivaActionPerformed

    private void instructionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionActionPerformed
        // TODO add your handling code here:
        if(instruction.isSelected())
        {
            start_viva.setEnabled(true);
        }
        else
        {
            start_viva.setEnabled(false);
        }
    }//GEN-LAST:event_instructionActionPerformed

    private void display_qnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_display_qnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_display_qnActionPerformed

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
    private javax.swing.JTextField display_qn;
    private javax.swing.JCheckBox instruction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton start_viva;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables
}
