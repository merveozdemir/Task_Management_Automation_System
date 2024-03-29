/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VERITABANI_CALISMA1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suat
 */
public class JGorevOlustur extends javax.swing.JFrame {

    DefaultTableModel dtm;
    String kolonIsimleri[] = {"Görev No", "Görev Adı", "Görev Sahibi", "Başlangıç Tarihi", "Bitiş Tarihi", "Durumu"};
    Connection con;
    EntityManagerFactory emf;
    EntityManager em;
    DefaultListModel dm;
    

    /**
     * Creates new form JGorevOlustur
     */
    public JGorevOlustur() {
        initComponents();
        ResetDtm();
        jComboBox1.removeAllItems();
        dm=new DefaultListModel();
        jList1.setModel(dm);

        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
            emf = Persistence.createEntityManagerFactory("DonemOdevi_Cal_smaPU");
            em = emf.createEntityManager();
            GorevleriGoruntule();

            Query q2 = em.createQuery("SELECT p FROM Personel p");
            List<Personel> personelList = q2.getResultList();
            for (Personel p : personelList) {
                jComboBox1.addItem(p.getPersonelId() + " " + p.getAdi() + " " + p.getSoyadi());
                dm.addElement(p.getPersonelId() + " " + p.getAdi() + " " + p.getSoyadi());
            }

        } catch (SQLException ex) {
            Logger.getLogger(JGorevOlustur.class.getName()).log(Level.SEVERE, null, ex);

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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray), "Mevcut Görevler"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 580, 180));

        jButton4.setText("Geri Dön");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 333, 150, 30));

        jButton5.setText("Görev Sil");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 150, 30));

        jButton6.setText("Görev Sahibini Değiştir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 150, -1));

        jScrollPane2.setViewportView(jList1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 150, 120));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray), "Görev Oluştur"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Görev No:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 129, -1));

        jLabel1.setText("Görev Adı:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 129, -1));

        jLabel5.setText("Görev Sahibi:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jComboBox1.setToolTipText("");
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1İtemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 129, -1));

        jLabel3.setText("Başlangıç Tarihi: ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 131, -1));

        jButton2.setText("Tarih Ekle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 126, -1));

        jLabel4.setText("Bitiş Tarihi:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));
        jPanel2.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 133, -1));

        jButton3.setText("Tarih Ekle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 128, -1));

        jButton1.setText("Oluştur");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 209, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResetDtm() {
        dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(kolonIsimleri);
        jTable1.setModel(dtm);

    }

    private void GorevleriGoruntule() {

        Query q = em.createQuery("SELECT g FROM Gorev g");
        Query q2 = em.createQuery("SELECT p FROM Personel p");
        Query q3 = em.createQuery("SELECT d FROM Durum d");
        List<Gorev> gorevList = q.getResultList();
        List<Personel> personelList = q2.getResultList();
        List<Durum> durumList = q3.getResultList();

        for (int i = 0; i < gorevList.size(); i++) {
            for (int j = 0; j < personelList.size(); j++) {
                for (int k = 0; k < durumList.size(); k++) {
                    if (gorevList.get(i).getGorevSahibiId() == personelList.get(j).getPersonelId()) {
                        if (gorevList.get(i).getDurumNo() == durumList.get(k).getDurumNo()) {
                            int gorevNo = gorevList.get(i).getGorevNo();
                            String gorevAdi = gorevList.get(i).getAdi();
                            String gorevSahibi = personelList.get(j).getAdi() + " " + personelList.get(j).getSoyadi();
                            String baslangicTarihi = gorevList.get(i).getBaslangicTarihi();
                            String bitisTarihi = gorevList.get(i).getBitisTarihi();
                            String durumu = durumList.get(k).getAdi();
                            dtm.addRow(new Object[]{gorevNo, gorevAdi, gorevSahibi, baslangicTarihi, bitisTarihi, durumu});
                        }
                    }
                }
            }
        }

    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField3.setText(formatter.format(jDateChooser1.getDate()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void GorevOlustur() {
        String s = (String) jComboBox1.getSelectedItem();
        String[] kelimeler = s.split(" ");
        System.out.println(kelimeler[0]);
        String sql = "INSERT INTO gorev (gorev_no, adi, gorev_sahibi_id, baslangic_tarihi,bitis_tarihi, durum_no) VALUES (?,?,?,?,?,?)";
                  //entityle yappp!!!1
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(jTextField2.getText()));
            ps.setString(2, jTextField1.getText());
            ps.setInt(3, Integer.parseInt(kelimeler[0]));
            ps.setString(4, jTextField3.getText());
            ps.setString(5, jTextField4.getText());
            ps.setInt(6, 1);
            ps.executeUpdate();
          
        } catch (SQLException ex) {
            Logger.getLogger(JGorevOlustur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        GorevOlustur();
        ResetDtm();
        GorevleriGoruntule();

//        em.close();
//        emf.close();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField4.setText(formatter.format(jDateChooser2.getDate()));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        em.close();
        emf.close();
        JYoneticiAnasayfa yoneticiAnasayfa=new JYoneticiAnasayfa();
        yoneticiAnasayfa.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1İtemStateChanged
//        dm = new DefaultListModel();
//        jList3.setModel(dm);
//        Query q = em.createQuery("SELECT p FROM Personel p");
//        List<Personel> personelList = q.getResultList();
//        for (int i = 0; i < personelList.size(); i++) {
//          if ((personelList.get(i).getPersonelId()+" "+personelList.get(i).getAdi()+" "+personelList.get(i).getSoyadi())== jComboBox1.getSelectedItem()) {
//             dm.addElement(personelList.get(i).getAdi() + " " + personelList.get(i).getSoyadi());
//            }
//
//        }
    }//GEN-LAST:event_jComboBox1İtemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
//        DefaultListModel dm = new DefaultListModel();
//        jList3.setModel(dm);
//        Query q = em.createQuery("SELECT p FROM Personel p");
//        List<Personel> personelList = q.getResultList();
//        for (int i = 0; i < personelList.size(); i++) {
//            if (personelList.get(i).getPersonelId() == Integer.parseInt(String.valueOf(jComboBox1.getSelectedItem()))) {
//                dm.addElement(personelList.get(i).getAdi() + " " + personelList.get(i).getSoyadi());
//             }
//            else{
//                dm.removeAllElements();
//            }
        //       }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
             int gorevNo= Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
        Query q=em.createQuery("DELETE FROM Gorev g WHERE g.gorevNo=:pGorevNo");
                 q.setParameter("pGorevNo", gorevNo);
                 
                 em.getTransaction().begin();
                 q.executeUpdate();
                 em.getTransaction().commit();
                 
                 dtm.removeRow(jTable1.getSelectedRow());
                 
                 JOptionPane.showMessageDialog(this, "Görev Başarıyla Silindi.", " ", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String s = (String) jList1.getSelectedValue();
        String[] kelimeler = s.split(" ");;
        int personelId= Integer.parseInt(kelimeler[0]);
        int gorevNo= Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
        System.out.println(kelimeler[0]);  
        
        
        Query q=em.createQuery("UPDATE Gorev g SET g.gorevSahibiId=:pPersonelId WHERE g.gorevNo=:pGorevNo");
        q.setParameter("pPersonelId", personelId);
        q.setParameter("pGorevNo", gorevNo);
        
        em.getTransaction().begin();
        q.executeUpdate();
        em.getTransaction().commit();
        
        Query q2=em.createQuery("SELECT p FROM Personel p WHERE p.personelId=:pId");
        q2.setParameter("pId", personelId);
        List<Personel> personelList=q2.getResultList();
        for (Personel p:personelList) {
             dtm.setValueAt(p.getAdi()+" "+p.getSoyadi(), jTable1.getSelectedRow(), 2);
        }
        
        JOptionPane.showMessageDialog(this, "Görev Sahibi Başarıyla Değiştirildi.", " ", JOptionPane.INFORMATION_MESSAGE);
        
        
      
           
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(JGorevOlustur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JGorevOlustur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JGorevOlustur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JGorevOlustur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JGorevOlustur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
