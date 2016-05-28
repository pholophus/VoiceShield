/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiorecord;
import java.io.File;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author KAUSTABH
 */
public class EncryptionForm extends javax.swing.JFrame  {

    /**
     * Creates new form EncryptionForm
     */
    public EncryptionForm() {
        initComponents();
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
        keyTF = new javax.swing.JTextField();
        byteBtn = new javax.swing.JButton();
        encryptBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Encryption");

        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 18)); // NOI18N
        jLabel1.setText("Enter a 16 Character Key");

        keyTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyTFActionPerformed(evt);
            }
        });

        byteBtn.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        byteBtn.setText("Get Audio Byte");
        byteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byteBtnActionPerformed(evt);
            }
        });

        encryptBtn.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        encryptBtn.setText("Encrypt it!!");
        encryptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptBtnActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(byteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyTF, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(encryptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(byteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keyTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(encryptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keyTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keyTFActionPerformed

    private void encryptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptBtnActionPerformed
        // TODO add your handling code here:
        
        String key = (String)keyTF.getText();
        
        System.out.println("Your key is: " + key);
        File inputFile = new File("document.txt");
        File encryptedFile = new File("document.encrypted");
        
        try {
            Writer writer = new FileWriter("C:\\Users\\LENOVO\\Desktop\\enckey.txt", false);
            writer.write(key);
            AesEncryption.encrypt(key, inputFile, encryptedFile);
            writer.close();
            
        } catch (CryptoException | IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_encryptBtnActionPerformed

    private void byteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byteBtnActionPerformed
        // TODO add your handling code here:
        try{
            File fileIn = new File("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\AudioRecord\\junk.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(fileIn);
            int bytesPerFrame = 
    audioInputStream.getFormat().getFrameSize();
    if (bytesPerFrame == AudioSystem.NOT_SPECIFIED) {
    // some audio formats may have unspecified frame size
    // in that case we may read any amount of bytes
    bytesPerFrame = 1;
  } 
  // Set an arbitrary buffer size of 1024 frames.
  int numBytes = 1024 * bytesPerFrame; 
  byte[] audioBytes = new byte[numBytes];
            //Path soundpath = Paths.get("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\AudioRecord\\junk.wav"); 
         //byte[] bytes = Files.readAllBytes(soundpath);   
         System.out.println("Audio bytes array is: " + audioBytes.toString());
         String soundstr = new String (audioBytes);
         Writer writer = new FileWriter("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\AudioRecord\\document.txt", false);
            writer.write(soundstr);
            writer.close();
        }catch (IOException | UnsupportedAudioFileException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
        
    }//GEN-LAST:event_byteBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EncryptionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncryptionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncryptionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncryptionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncryptionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton byteBtn;
    private javax.swing.JButton encryptBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField keyTF;
    // End of variables declaration//GEN-END:variables
}
