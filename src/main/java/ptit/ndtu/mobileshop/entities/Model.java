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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Model")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Model.findAll", query = "SELECT m FROM Model m")
    , @NamedQuery(name = "Model.findByModelId", query = "SELECT m FROM Model m WHERE m.modelId = :modelId")
    , @NamedQuery(name = "Model.findByImages", query = "SELECT m FROM Model m WHERE m.images = :images")
    , @NamedQuery(name = "Model.findByQuantity", query = "SELECT m FROM Model m WHERE m.quantity = :quantity")
    , @NamedQuery(name = "Model.findByDifPrice", query = "SELECT m FROM Model m WHERE m.difPrice = :difPrice")})
public class Model implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "model_id")
    private Integer modelId;
    @Column(name = "images")
    private String images;
    @Column(name = "quantity")
    private Integer quantity;
    @Basic(optional = false)
    @Column(name = "dif_price")
    private double difPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private List<BillDetail> billDetailList;
    @JoinColumn(name = "color_id", referencedColumnName = "color_id")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Color colorId;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Product productId;
    @JoinColumn(name = "storage_id", referencedColumnName = "storage_id")
    @ManyToOne(fetch= FetchType.LAZY)
    private Storage storageId;

    public Model() {
    }

    public Model(Integer modelId) {
        this.modelId = modelId;
    }

    public Model(Integer modelId, double difPrice) {
        this.modelId = modelId;
        this.difPrice = difPrice;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getDifPrice() {
        return difPrice;
    }

    public void setDifPrice(double difPrice) {
        this.difPrice = difPrice;
    }

    @XmlTransient
    public List<BillDetail> getBillDetailList() {
        return billDetailList;
    }

    public void setBillDetailList(List<BillDetail> billDetailList) {
        this.billDetailList = billDetailList;
    }

    public Color getColorId() {
        return colorId;
    }

    public void setColorId(Color colorId) {
        this.colorId = colorId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Storage getStorageId() {
        return storageId;
    }

    public void setStorageId(Storage storageId) {
        this.storageId = storageId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelId != null ? modelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Model)) {
            return false;
        }
        Model other = (Model) object;
        if ((this.modelId == null && other.modelId != null) || (this.modelId != null && !this.modelId.equals(other.modelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Model[ modelId=" + modelId + " ]";
    }
    
}
