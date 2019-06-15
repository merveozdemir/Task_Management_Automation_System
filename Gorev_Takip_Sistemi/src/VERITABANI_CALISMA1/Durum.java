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
@Table(name = "DURUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Durum.findAll", query = "SELECT d FROM Durum d"),
    @NamedQuery(name = "Durum.findByDurumNo", query = "SELECT d FROM Durum d WHERE d.durumNo = :durumNo"),
    @NamedQuery(name = "Durum.findByAdi", query = "SELECT d FROM Durum d WHERE d.adi = :adi")})
public class Durum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DURUM_NO")
    private Integer durumNo;
    @Column(name = "ADI")
    private String adi;

    public Durum() {
    }

    public Durum(Integer durumNo) {
        this.durumNo = durumNo;
    }

    public Integer getDurumNo() {
        return durumNo;
    }

    public void setDurumNo(Integer durumNo) {
        this.durumNo = durumNo;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (durumNo != null ? durumNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Durum)) {
            return false;
        }
        Durum other = (Durum) object;
        if ((this.durumNo == null && other.durumNo != null) || (this.durumNo != null && !this.durumNo.equals(other.durumNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VERITABANI_CALISMA1.Durum[ durumNo=" + durumNo + " ]";
    }
    
}
