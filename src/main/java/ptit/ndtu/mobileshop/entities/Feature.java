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
@Table(name = "Feature")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feature.findAll", query = "SELECT f FROM Feature f")
    , @NamedQuery(name = "Feature.findByTechId", query = "SELECT f FROM Feature f WHERE f.techId = :techId")
    , @NamedQuery(name = "Feature.findByTechName", query = "SELECT f FROM Feature f WHERE f.techName = :techName")
    , @NamedQuery(name = "Feature.findByTechDescription", query = "SELECT f FROM Feature f WHERE f.techDescription = :techDescription")})
public class Feature implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tech_id")
    private Integer techId;
    @Column(name = "tech_name")
    private String techName;
    @Column(name = "tech_description")
    private String techDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "feature")
    private List<ProductDetail> productDetailList;

    public Feature() {
    }

    public Feature(Integer techId) {
        this.techId = techId;
    }

    public Integer getTechId() {
        return techId;
    }

    public void setTechId(Integer techId) {
        this.techId = techId;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public String getTechDescription() {
        return techDescription;
    }

    public void setTechDescription(String techDescription) {
        this.techDescription = techDescription;
    }

    @XmlTransient
    public List<ProductDetail> getProductDetailList() {
        return productDetailList;
    }

    public void setProductDetailList(List<ProductDetail> productDetailList) {
        this.productDetailList = productDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (techId != null ? techId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feature)) {
            return false;
        }
        Feature other = (Feature) object;
        if ((this.techId == null && other.techId != null) || (this.techId != null && !this.techId.equals(other.techId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Feature[ techId=" + techId + " ]";
    }
    
}
