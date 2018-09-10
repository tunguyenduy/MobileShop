/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.ndtu.mobileshop.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Manufacturer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manufacturer.findAll", query = "SELECT m FROM Manufacturer m")
    , @NamedQuery(name = "Manufacturer.findByManuId", query = "SELECT m FROM Manufacturer m WHERE m.manuId = :manuId")
    , @NamedQuery(name = "Manufacturer.findByManuName", query = "SELECT m FROM Manufacturer m WHERE m.manuName = :manuName")
    , @NamedQuery(name = "Manufacturer.findByDescription", query = "SELECT m FROM Manufacturer m WHERE m.description = :description")})
public class Manufacturer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "manu_id")
    private Integer manuId;
    @Column(name = "manu_name")
    private String manuName;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manuId")
    private List<Product> productList;

    public Manufacturer() {
    }

    public Manufacturer(Integer manuId) {
        this.manuId = manuId;
    }

    public Integer getManuId() {
        return manuId;
    }

    public void setManuId(Integer manuId) {
        this.manuId = manuId;
    }

    public String getManuName() {
        return manuName;
    }

    public void setManuName(String manuName) {
        this.manuName = manuName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manuId != null ? manuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manufacturer)) {
            return false;
        }
        Manufacturer other = (Manufacturer) object;
        if ((this.manuId == null && other.manuId != null) || (this.manuId != null && !this.manuId.equals(other.manuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Manufacturer[ manuId=" + manuId + " ]";
    }
    
}
