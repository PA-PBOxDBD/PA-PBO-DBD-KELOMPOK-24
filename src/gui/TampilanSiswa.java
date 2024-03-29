/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import database.Database;
import database.Nilai;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.sql.*;




/**
 *
 * @author user
 */
public class TampilanSiswa extends javax.swing.JFrame {
    /**
     * Creates new form TampilanSiswa
     */
    public TampilanSiswa() {
        initComponents();
    }

    public final void getNilai() {
        try {
            String nis = NISfield.getText(); // Mengambil nilai NIS dari JTextField

            String sql = "SELECT s.id_user, u.nama, " +
                        "n1.nilai AS Matematika, " +
                        "n2.nilai AS Bahasa_Indonesia, " +
                        "n3.nilai AS Bahasa_Inggris, " +
                        "n4.nilai AS Teori_Kejuruan, " +
                        "((n1.nilai + n2.nilai + n3.nilai + n4.nilai)) AS Score, " +
                        "CASE " +
                        "    WHEN ((n1.nilai + n2.nilai + n3.nilai + n4.nilai) / 4) >= 85 THEN 'A' " +
                        "    WHEN ((n1.nilai + n2.nilai + n3.nilai + n4.nilai) / 4) >= 70 THEN 'B' " +
                        "    WHEN ((n1.nilai + n2.nilai + n3.nilai + n4.nilai) / 4) >= 60 THEN 'C' " +
                        "    WHEN ((n1.nilai + n2.nilai + n3.nilai + n4.nilai) / 4) >= 40 THEN 'D' " +
                        "    ELSE 'E' " +
                        "END AS Predikat " +
                        "FROM siswa s " +
                        "JOIN user u ON s.id_user = u.id_user " +
                        "LEFT JOIN nilai n1 ON s.id_user = n1.siswa_id_user AND n1.mata_pelajaran_kode_mapel = 'A1' " +
                        "LEFT JOIN nilai n2 ON s.id_user = n2.siswa_id_user AND n2.mata_pelajaran_kode_mapel = 'A2' " +
                        "LEFT JOIN nilai n3 ON s.id_user = n3.siswa_id_user AND n3.mata_pelajaran_kode_mapel = 'A3' " +
                        "LEFT JOIN nilai n4 ON s.id_user = n4.siswa_id_user AND n4.mata_pelajaran_kode_mapel = 'A4' " +
                        "WHERE s.id_user = ?";

            Connection conn = Database.connect();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nis); // Set nilai parameter
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                jTextFieldNama.setText(rs.getString("nama")); // Perbaikan pada field nama
                jTextFieldMatematika.setText(rs.getString("Matematika"));
                jTextFieldBahasaIndonesia.setText(rs.getString("Bahasa_Indonesia"));
                jTextFieldBahasaInggris.setText(rs.getString("Bahasa_Inggris"));
                jTextFieldTeoriKejuruan.setText(rs.getString("Teori_Kejuruan"));
                jTextFieldScore.setText(rs.getString("Score"));
                jTextFieldPredikat.setText(rs.getString("Predikat"));
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan.");
            }

            conn.close(); // Tutup koneksi setelah penggunaan
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jTextFieldMatematika = new javax.swing.JTextField();
        jTextFieldNama = new javax.swing.JTextField();
        jTextFieldBahasaIndonesia = new javax.swing.JTextField();
        jTextFieldBahasaInggris = new javax.swing.JTextField();
        jTextFieldTeoriKejuruan = new javax.swing.JTextField();
        jTextFieldScore = new javax.swing.JTextField();
        jTextFieldPredikat = new javax.swing.JTextField();
        NISfield = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextFieldMatematika, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 190, 30));
        getContentPane().add(jTextFieldNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 190, 30));
        getContentPane().add(jTextFieldBahasaIndonesia, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 190, 30));
        getContentPane().add(jTextFieldBahasaInggris, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 190, 30));
        getContentPane().add(jTextFieldTeoriKejuruan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 190, 30));

        jTextFieldScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldScoreActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 190, 30));
        getContentPane().add(jTextFieldPredikat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, 190, 30));

        NISfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NISfieldActionPerformed(evt);
            }
        });
        getContentPane().add(NISfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 190, 30));

        jButton2.setBackground(new java.awt.Color(240, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("LOGOUT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 660, -1, -1));

        jButton1.setBackground(new java.awt.Color(240, 0, 0));
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setText("Tampil");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 655, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Transkrip.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NISfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NISfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NISfieldActionPerformed

    private void jTextFieldScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldScoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldScoreActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getNilai();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(TampilanSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TampilanSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TampilanSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TampilanSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TampilanSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NISfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldBahasaIndonesia;
    private javax.swing.JTextField jTextFieldBahasaInggris;
    private javax.swing.JTextField jTextFieldMatematika;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldPredikat;
    private javax.swing.JTextField jTextFieldScore;
    private javax.swing.JTextField jTextFieldTeoriKejuruan;
    // End of variables declaration//GEN-END:variables
}
