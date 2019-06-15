/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VERITABANI_CALISMA1;

import java.sql.Connection;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Suat
 */
public class JYoneticiAnasayfa extends javax.swing.JFrame {
                   DefaultTableModel dtm;
                   String kolonIsimleri[]={"Görev No", "Görev Adı", "Görev Sahibi", "Başlangıç Tarihi", "Bitiş Tarihi", "Durumu"};
                   Connection con;
                   EntityManagerFactory emf;
                   EntityManager em;
                   int yapiliyorGorevSayisi=0;
                   int bitmisGorevSayisi=0;
                   int beklemedekiGorevSayisi=0;
                   int tumGorevler=0;
    /**
     * Creates new form JYoneticiAnasayfa
     */
    public JYoneticiAnasayfa() {
       initComponents();
       ResetDtm();
        
            emf=Persistence.createEntityManagerFactory("DonemOdevi_Cal_smaPU");
            em=emf.createEntityManager();
            
       Query q2 = em.createQuery("SELECT p FROM Personel p");
       List<Personel> personelList = q2.getResultList();
       for (Personel p : personelList) {
           jComboBox2.addItem(p.getPersonelId() + " " + p.getAdi() + " " + p.getSoyadi());
       }
       
       
       GorevleriGoruntule();
       
       Query q=em.createQuery("SELECT g FROM Gorev g");
       List<Gorev> gorevList=q.getResultList();
        for (Gorev g:gorevList) {
             if(g.getDurumNo()==1){
                 beklemedekiGorevSayisi++;
             }
             else if(g.getDurumNo()==2){
                yapiliyorGorevSayisi++;
             }
             else if(g.getDurumNo()==3){
                bitmisGorevSayisi++;
             }
        }
        
        jTextField5.setText(String.valueOf(beklemedekiGorevSayisi));
        jTextField4.setText(String.valueOf(yapiliyorGorevSayisi));
        jTextField3.setText(String.valueOf(bitmisGorevSayisi));
        
        
        
                       
        
    }
    
     private void ResetDtm(){
         dtm=new DefaultTableModel();
         dtm.setColumnIdentifiers(kolonIsimleri);
         jTable1.setModel(dtm);
         
     
     }
     private void GorevleriGoruntule(){
                 
         Query q=em.createQuery("SELECT g FROM Gorev g");
         Query q2=em.createQuery("SELECT p FROM Personel p");
         Query q3=em.createQuery("SELECT d FROM Durum d");
         
         List<Gorev> gorevList=q.getResultList();
         List<Personel> personelList=q2.getResultList();
         List<Durum> durumList=q3.getResultList();
      
         for (int i = 0; i < gorevList.size(); i++) {
             for (int j = 0; j < personelList.size(); j++) {
                 for (int k = 0; k <durumList.size(); k++) {
                  if(gorevList.get(i).getGorevSahibiId() == personelList.get(j).getPersonelId()){
                    if(gorevList.get(i).getDurumNo()== durumList.get(k).getDurumNo()){
                 int gorevNo=gorevList.get(i).getGorevNo();
                 String gorevAdi=gorevList.get(i).getAdi();
                 String gorevSahibi=personelList.get(j).getAdi()+" "+personelList.get(j).getSoyadi();
                 String baslangicTarihi=gorevList.get(i).getBaslangicTarihi();
                 String bitisTarihi=gorevList.get(i).getBitisTarihi();
                 String durumu=durumList.get(k).getAdi ();
                 dtm.addRow(new Object[]{gorevNo, gorevAdi, gorevSahibi,baslangicTarihi,bitisTarihi,durumu});
                    }
                  }
                 }
             }
         }
         
         tumGorevler= dtm.getRowCount();
         jTextField2.setText(String.valueOf(tumGorevler));
         
//             for (Gorev g:gorevList) {
//             if(g.getDurumNo()==1){
//                 beklemedekiGorevSayisi++;
//             }
//             else if(g.getDurumNo()==2){
//                yapiliyorGorevSayisi++;
//             }
//             else if(g.getDurumNo()==3){
//                bitmisGorevSayisi++;
//             }
//        }
//        
//        jTextField5.setText(String.valueOf(beklemedekiGorevSayisi));
//        jTextField4.setText(String.valueOf(yapiliyorGorevSayisi));
//        jTextField3.setText(String.valueOf(bitmisGorevSayisi));

       }

     private void GorevleriGoruntule(String gorevAdi){

         Query q=em.createQuery("SELECT g FROM Gorev g WHERE g.adi=:pGorevAdi");
         q.setParameter("pGorevAdi", gorevAdi);
         Query q2=em.createQuery("SELECT p FROM Personel p");
         Query q3=em.createQuery("SELECT d FROM Durum d");
         
        
         List<Gorev> gorevList=q.getResultList();
         List<Personel> personelList=q2.getResultList();
         List<Durum> durumList=q3.getResultList();
      
         for (int i = 0; i < gorevList.size(); i++) {
             for (int j = 0; j < personelList.size(); j++) {
                 for (int k = 0; k <durumList.size(); k++) {
                     if (gorevList.get(i).getGorevSahibiId()== personelList.get(j).getPersonelId()) {
                      if(gorevList.get(i).getDurumNo()==durumList.get(k).getDurumNo()){
                 int gorevNo=gorevList.get(i).getGorevNo();
                 String gorevAdi2=gorevList.get(i).getAdi();
                 String gorevSahibi=personelList.get(j).getAdi()+" "+personelList.get(j).getSoyadi();
                 String baslangicTarihi=gorevList.get(i).getBaslangicTarihi();
                 String bitisTarihi=gorevList.get(i).getBitisTarihi();
                 String durumu=durumList.get(k).getAdi();
                 dtm.addRow(new Object[]{gorevNo, gorevAdi2, gorevSahibi,baslangicTarihi,bitisTarihi,durumu});
                  }
               }
             }
           }
         }

       
         
     }
     
     private void GorevleriGoruntule2 (String gorevSahibi){
         String gS=gorevSahibi;  
         String[] kelimeler = gS.split(" ");
         String Id=kelimeler[0];
         System.out.println(kelimeler[0]);
         

          
              Query q=em.createQuery("SELECT g FROM Gorev g");
              Query q2=em.createQuery("SELECT p FROM Personel p WHERE p.personelId=:pId");
              Query q3=em.createQuery("SELECT d FROM Durum d");
              q2.setParameter("pId", Integer.parseInt(Id));
              List<Gorev> gorevList=q.getResultList();
              List<Personel> personelList=q2.getResultList();
              List<Durum> durumList=q3.getResultList();
              
              
         for (int i = 0; i < gorevList.size(); i++) {
             for (int j = 0; j < personelList.size(); j++) {
                 for (int k = 0; k <durumList.size(); k++) {
                     if (gorevList.get(i).getGorevSahibiId()== personelList.get(j).getPersonelId()) {
                      if(gorevList.get(i).getDurumNo()==durumList.get(k).getDurumNo()){
                 int gorevNo=gorevList.get(i).getGorevNo();
                 String gorevAdi2=gorevList.get(i).getAdi();
                 String gorevSahibi2=personelList.get(j).getAdi()+" "+personelList.get(j).getSoyadi();
                 String baslangicTarihi=gorevList.get(i).getBaslangicTarihi();
                 String bitisTarihi=gorevList.get(i).getBitisTarihi();
                 String durumu=durumList.get(k).getAdi();
                 dtm.addRow(new Object[]{gorevNo, gorevAdi2, gorevSahibi2,baslangicTarihi,bitisTarihi,durumu});
                  }
               }
             }
           }
         }
      


       
      }
     
     private void GorevleriGoruntule3(int durumNo){
              Query q=em.createQuery("SELECT g FROM Gorev g WHERE g.durumNo=:pDurumNo");
              Query q2=em.createQuery("SELECT p FROM Personel p");
              Query q3=em.createQuery("SELECT d FROM Durum d WHERE d.durumNo=:pDurumNo");
              q.setParameter("pDurumNo", durumNo);
              q3.setParameter("pDurumNo", durumNo);
              List<Gorev> gorevList=q.getResultList();
              List<Personel> personelList=q2.getResultList();
              List<Durum> durumList=q3.getResultList();
              
          for (int i = 0; i < gorevList.size(); i++) {
             for (int j = 0; j < personelList.size(); j++) {
                 for (int k = 0; k <durumList.size(); k++) {
                     if (gorevList.get(i).getGorevSahibiId()== personelList.get(j).getPersonelId()) {

                 int gorevNo=gorevList.get(i).getGorevNo();
                 String gorevAdi2=gorevList.get(i).getAdi();
                 String gorevSahibi2=personelList.get(j).getAdi()+" "+personelList.get(j).getSoyadi();
                 String baslangicTarihi=gorevList.get(i).getBaslangicTarihi();
                 String bitisTarihi=gorevList.get(i).getBitisTarihi();
                 String durumu=durumList.get(k).getAdi();
                 dtm.addRow(new Object[]{gorevNo, gorevAdi2, gorevSahibi2,baslangicTarihi,bitisTarihi,durumu});
                   
               }
             }
           }
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
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 200, 800, 800));
        setLocation(new java.awt.Point(400, 200));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Genel Durum", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 0, 102))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 71, 664, 208));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 31, 98, -1));

        jButton5.setText("Ara");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 30, -1, -1));

        jLabel1.setText("Görev Ara:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 34, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tüm Görevler", "Beklemede", "Yapılıyor", "Tamamlandı" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 118, -1));

        jButton6.setText("Görüntüle");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        jLabel2.setText("Tüm Görevlerin Sayısı:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 130, -1));

        jLabel3.setText("Bitmiş Görevlerin Sayısı:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 139, -1));

        jTextField2.setEditable(false);
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 40, -1));

        jTextField3.setEditable(false);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 40, -1));

        jButton8.setText("Ara");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jLabel4.setText("Personel Ara:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 34, 80, -1));

        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 127, -1));

        jLabel5.setText("Yapılıyor Görevlerin Sayısı:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 140, -1));

        jTextField4.setEditable(false);
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 40, -1));

        jLabel6.setText("Beklemedeki Görevlerin Sayısı:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 147, -1));

        jTextField5.setEditable(false);
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 40, 20));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Mevcut Personeller");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Yeni Görev Oluştur");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setText("Personel Performans");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setText("Giriş Sayfasına Dön");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton7))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                      
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             JPersonelEkle personelEkle= new JPersonelEkle();
             personelEkle.setVisible(true);
             this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
                  
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JGorevOlustur gorevOlustur = new JGorevOlustur();
        gorevOlustur.setVisible(true);
        this.setVisible(false);
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setVisible(false);
        em.close();
        emf.close();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        ResetDtm();
        GorevleriGoruntule2(String.valueOf(jComboBox2.getSelectedItem()));
        
       
      
          
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
           ResetDtm();    
           GorevleriGoruntule(jTextField1.getText());
               
                   
                 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ResetDtm();      
        if(jComboBox1.getSelectedIndex()==0){
                    GorevleriGoruntule();
                   }   
        else{
            GorevleriGoruntule3(jComboBox1.getSelectedIndex());
        }
                
                  
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       JPersonelPerformans personelPerformans= new JPersonelPerformans();
       personelPerformans.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(JYoneticiAnasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JYoneticiAnasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JYoneticiAnasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JYoneticiAnasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JYoneticiAnasayfa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
