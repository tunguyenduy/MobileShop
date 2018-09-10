/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.ndtu.mobileshop.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NDT;
 */
@Entity
@Table(name = "Storage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Storage.findAll", query = "SELECT s FROM Storage s")
    , @NamedQuery(name = "Storage.findByStorageId", query = "SELECT s FROM Storage s WHERE s.storageId = :storageId")
    , @NamedQuery(name = "Storage.findByAmount", query = "SELECT s FROM Storage s WHERE s.amount = :amount")})
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "storage_id")
    private Integer storageId;
    @Column(name = "amount")
    private Integer amount;
    @OneToMany(mappedBy = "storageId")
    private List<Model> modelList;

    public Storage() {
    }

    public Storage(Integer storageId) {
        this.storageId = storageId;
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @XmlTransient
    public List<Model> getModelList() {
        return modelList;
    }

    public void setModelList(List<Model> modelList) {
        this.modelList = modelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storageId != null ? storageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storage)) {
            return false;
        }
        Storage other = (Storage) object;
        if ((this.storageId == null && other.storageId != null) || (this.storageId != null && !this.storageId.equals(other.storageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Storage[ storageId=" + storageId + " ]";
    }
    
}
