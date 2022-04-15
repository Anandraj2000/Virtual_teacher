package main1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import grammer_file.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

import java.util.Dictionary;
import static main1.student_details.*;
import static main1.student_details.answer_set;
import static main1.student_details.count;
import static main1.student_details.question_set;
import static main1.student_details.t_code;
import static main1.Viva_room1.score;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import static main1.Viva_room1.identify;
import static main1.student_details.key;
//import Viva_room1.answer_set;


//import main.Home_page;
//import main.Login_form;

/**
 *
 * @author Admin
 */
public class Performance_evaluation1 extends javax.swing.JFrame {
    public static String result_content = "";
    public static String forwhome = "";
    public static int score1 = 0;
    //public static Dictionary answer_set1 = new Hashtable();
    //public static Dictionary question_set1 = new Hashtable();
    public static int noq=count;
    

    /**
     * Creates new form Performance_evaluation
     */
    public static void getResult()
    {
        /*int c = 0;
        for (Enumeration k = answer_set.keys(); k.hasMoreElements();)
        {
            String temp_key1 = (String)k.nextElement();
            result_content = "\n"+result_content +"\n"+(c+1)+": "+ question_set.get(temp_key1)+"\nCORRECT ANSWER: "+answer_set1.get(temp_key1)+"\nYOUR ANSWER: "+Viva_room1.user_answer.get(temp_key1)+"\nTIME= "+Viva_room1.user_sec.get(temp_key1)+" sec"+"\n";
            c = c + 1;
        }*/
        int count1=0;
        while(count1<key.length)
        {
            System.out.println(count1 +"l="+(key.length));
            //display.setText("\n"+key[count]+": "+question_set.get(key[count]));
            //display.setText(display.getText()+"\n"+"Answer"+": "+answer_set.get(key[count]));
            result_content = "\n"+result_content +"\n"+(count1+1)+": "+ question_set.get(key[count1])+"\nCORRECT ANSWER: "+answer_set.get(key[count1])+"\nYOUR ANSWER: "+Viva_room1.user_answer.get(key[count1])+"\nTIME= "+Viva_room1.user_sec.get(key[count1])+" sec"+"\n";
            
            count1++;
        }
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
            PreparedStatement ps=conn.prepareStatement("insert into "+t_code+" (name,gender,email,seat_no,class,total_question,score,date)values(?,?,?,?,?,?,?,?)");
            
            ps.setString(1,name1);
            ps.setString(2,gender1);
            ps.setString(3,email1);
            ps.setString(4,seat_no1);
            ps.setString(5,s_class1);
            ps.setString(6,""+noq);
            ps.setString(7,""+score);
            LocalDateTime now = LocalDateTime.now();
            ps.setString(8,""+now);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Performance_evaluation1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        analysis.setText(result_content);
        total1.setText(noq+"");
        correct_answer.setText(""+score);
        //correct_answer.setText(""+score);
        wrong_answer.setText(""+(noq-score));
        //average_time.setText(""+average+"\tsec");
        
    }
    public Performance_evaluation1() {
        initComponents();
        getResult();
        back_to_home_page.setEnabled(false);
        
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        analysis = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        total1 = new javax.swing.JTextField();
        correct_answer = new javax.swing.JTextField();
        wrong_answer = new javax.swing.JTextField();
        back_to_home_page = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        save = new javax.swing.JButton();
        feedback = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        average_time = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1388, 905));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ANALYSIS OF YOUR PERFORMANCE");

        analysis.setColumns(20);
        analysis.setRows(5);
        jScrollPane1.setViewportView(analysis);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("TOTAL NO OF QUESTION:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("CORRECT ANSWERED:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("WRONG ANSWERED:");

        back_to_home_page.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        back_to_home_page.setText("HOME PAGE");
        back_to_home_page.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_to_home_pageActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        feedback.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        feedback.setText("FEEDBACK");
        feedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedbackActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("AVEARGE TIME TAKEN:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(502, 502, 502))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(back_to_home_page)
                                .addGap(27, 27, 27)
                                .addComponent(feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(total1)
                                    .addComponent(correct_answer)
                                    .addComponent(wrong_answer, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(average_time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back_to_home_page, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(correct_answer, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(wrong_answer, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(average_time, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        int j = JOptionPane.showConfirmDialog(null,"DO YOU WANT TO GIVE SOME FEEDBACK","SELECT",JOptionPane.YES_NO_OPTION);
        if(j==0)
        {
            
            new grammer_file.feedback().setVisible(true);
             //
        }
        else
        {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void back_to_home_pageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_to_home_pageActionPerformed
        // TODO add your handling code here:
        int j = JOptionPane.showConfirmDialog(null,"DO YOU REALLY WANT TO JUMP TO HOMEPAGE","SELECT",JOptionPane.YES_NO_OPTION);
        if(j==0)
        {
            analysis.setText("");
          setVisible(false);
          new Main_page().setVisible(true);  //
        }
    }//GEN-LAST:event_back_to_home_pageActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
          forwhome = "Student";
          new grammer_file.Save_file().setVisible(true);
    }//GEN-LAST:event_saveActionPerformed

    private void feedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedbackActionPerformed
        // TODO add your handling code here:
        new grammer_file.feedback().setVisible(true);
    }//GEN-LAST:event_feedbackActionPerformed

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
            java.util.logging.Logger.getLogger(Performance_evaluation1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Performance_evaluation1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Performance_evaluation1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Performance_evaluation1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Performance_evaluation1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea analysis;
    private static javax.swing.JLabel average_time;
    private javax.swing.JButton back_to_home_page;
    private static javax.swing.JTextField correct_answer;
    private javax.swing.JButton exit;
    private javax.swing.JButton feedback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton save;
    private static javax.swing.JTextField total1;
    private static javax.swing.JTextField wrong_answer;
    // End of variables declaration//GEN-END:variables
}
