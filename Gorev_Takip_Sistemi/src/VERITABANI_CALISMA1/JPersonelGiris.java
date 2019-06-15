/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VERITABANI_CALISMA1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suat
 */
public class JPersonelGiris extends javax.swing.JFrame {

    Connection con;

    /**
     * Creates new form JPesonelGiris
     */
    public JPersonelGiris() {
        initComponents();
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        } catch (SQLException ex) {
            Logger.getLogger(JPersonelGiris.class.getName()).log(Level.SEVERE, null, ex);
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

        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 78, 113, -1));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 134, 113, -1));

        jLabel1.setText("Kullanıcı Adı:");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 81, -1, -1));

        jLabel2.setText("Şifre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 137, -1, -1));

        jButton1.setText("Giriş Yap");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jButton2.setText("Geri Dön");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VERITABANI_CALISMA1/insan-kaynaklari-yesil-portakal.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int kullanici_id = Integer.parseInt(jTextField1.getText());
        int kullanici_tc = Integer.parseInt(String.valueOf(jPasswordField1.getPassword()));
        String sql = "SELECT * FROM Personel WHERE personel_id=" + kullanici_id;
        Personel p = new Personel();

        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                if (rs.getInt("Personel_Id") == kullanici_id && rs.getInt("Tc_No") == kullanici_tc) {
                    p.setPersonelId(rs.getInt("Personel_Id"));
                    p.setAdi(rs.getString("Adi"));
                    p.setSoyadi(rs.getString("Soyadi"));
                    p.setTcNo(rs.getInt("Tc_No"));
                    p.setUnvan(rs.getString("Unvan"));
                    JPersonelAnasayfa personelAnasayfa = new JPersonelAnasayfa(p);
                    personelAnasayfa.setVisible(true); 
                    this.setVisible(false);

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPersonelGiris.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            java.util.logging.Logger.getLogger(JPersonelGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPersonelGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPersonelGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPersonelGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPersonelGiris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}