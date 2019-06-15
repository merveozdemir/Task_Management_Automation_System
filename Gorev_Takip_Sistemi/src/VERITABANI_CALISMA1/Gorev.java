/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VERITABANI_CALISMA1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Suat
 */
@Entity
@Table(name = "GOREV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gorev.findAll", query = "SELECT g FROM Gorev g"),
    @NamedQuery(name = "Gorev.findByGorevNo", query = "SELECT g FROM Gorev g WHERE g.gorevNo = :gorevNo"),
    @NamedQuery(name = "Gorev.findByAdi", query = "SELECT g FROM Gorev g WHERE g.adi = :adi"),
    @NamedQuery(name = "Gorev.findByGorevSahibiId", query = "SELECT g FROM Gorev g WHERE g.gorevSahibiId = :gorevSahibiId"),
    @NamedQuery(name = "Gorev.findByBaslangicTarihi", query = "SELECT g FROM Gorev g WHERE g.baslangicTarihi = :baslangicTarihi"),
    @NamedQuery(name = "Gorev.findByBitisTarihi", query = "SELECT g FROM Gorev g WHERE g.bitisTarihi = :bitisTarihi"),
    @NamedQuery(name = "Gorev.findByDurumNo", query = "SELECT g FROM Gorev g WHERE g.durumNo = :durumNo")})
public class Gorev implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GOREV_NO")
    private Integer gorevNo;
    @Column(name = "ADI")
    private String adi;
    @Column(name = "GOREV_SAHIBI_ID")
    private Integer gorevSahibiId;
    @Column(name = "BASLANGIC_TARIHI")
    private String baslangicTarihi;
    @Column(name = "BITIS_TARIHI")
    private String bitisTarihi;
    @Column(name = "DURUM_NO")
    private Integer durumNo;

    public Gorev() {
    }

    public Gorev(Integer gorevNo) {
        this.gorevNo = gorevNo;
    }

    public Integer getGorevNo() {
        return gorevNo;
    }

    public void setGorevNo(Integer gorevNo) {
        this.gorevNo = gorevNo;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public Integer getGorevSahibiId() {
        return gorevSahibiId;
    }

    public void setGorevSahibiId(Integer gorevSahibiId) {
        this.gorevSahibiId = gorevSahibiId;
    }

    public String getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(String baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public String getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(String bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public Integer getDurumNo() {
        return durumNo;
    }

    public void setDurumNo(Integer durumNo) {
        this.durumNo = durumNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gorevNo != null ? gorevNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gorev)) {
            return false;
        }
        Gorev other = (Gorev) object;
        if ((this.gorevNo == null && other.gorevNo != null) || (this.gorevNo != null && !this.gorevNo.equals(other.gorevNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VERITABANI_CALISMA1.Gorev[ gorevNo=" + gorevNo + " ]";
    }
    
}
