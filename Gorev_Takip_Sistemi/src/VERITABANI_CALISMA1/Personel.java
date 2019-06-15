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
@Table(name = "PERSONEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personel.findAll", query = "SELECT p FROM Personel p"),
    @NamedQuery(name = "Personel.findByPersonelId", query = "SELECT p FROM Personel p WHERE p.personelId = :personelId"),
    @NamedQuery(name = "Personel.findByAdi", query = "SELECT p FROM Personel p WHERE p.adi = :adi"),
    @NamedQuery(name = "Personel.findBySoyadi", query = "SELECT p FROM Personel p WHERE p.soyadi = :soyadi"),
    @NamedQuery(name = "Personel.findByTcNo", query = "SELECT p FROM Personel p WHERE p.tcNo = :tcNo"),
    @NamedQuery(name = "Personel.findByUnvan", query = "SELECT p FROM Personel p WHERE p.unvan = :unvan")})
public class Personel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PERSONEL_ID")
    private Integer personelId;
    @Column(name = "ADI")
    private String adi;
    @Column(name = "SOYADI")
    private String soyadi;
    @Column(name = "TC_NO")
    private Integer tcNo;
    @Column(name = "UNVAN")
    private String unvan;

    public Personel() {
    }

    public Personel(Integer personelId) {
        this.personelId = personelId;
    }

    public Integer getPersonelId() {
        return personelId;
    }

    public void setPersonelId(Integer personelId) {
        this.personelId = personelId;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public Integer getTcNo() {
        return tcNo;
    }

    public void setTcNo(Integer tcNo) {
        this.tcNo = tcNo;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personelId != null ? personelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personel)) {
            return false;
        }
        Personel other = (Personel) object;
        if ((this.personelId == null && other.personelId != null) || (this.personelId != null && !this.personelId.equals(other.personelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VERITABANI_CALISMA1.Personel[ personelId=" + personelId + " ]";
    }
    
}
