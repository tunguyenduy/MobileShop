/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.ndtu.mobileshop.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NDT;
 */
@Entity
@Table(name = "ProductDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductDetail.findAll", query = "SELECT p FROM ProductDetail p")
    , @NamedQuery(name = "ProductDetail.findByProductId", query = "SELECT p FROM ProductDetail p WHERE p.productDetailPK.productId = :productId")
    , @NamedQuery(name = "ProductDetail.findByTechId", query = "SELECT p FROM ProductDetail p WHERE p.productDetailPK.techId = :techId")
    , @NamedQuery(name = "ProductDetail.findByInformation", query = "SELECT p FROM ProductDetail p WHERE p.information = :information")})
public class ProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductDetailPK productDetailPK;
    @Column(name = "information")
    private String information;
    @JoinColumn(name = "tech_id", referencedColumnName = "tech_id", insertable = false, updatable = false)
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Feature feature;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Product product;

    public ProductDetail() {
    }

    public ProductDetail(ProductDetailPK productDetailPK) {
        this.productDetailPK = productDetailPK;
    }

    public ProductDetail(int productId, int techId) {
        this.productDetailPK = new ProductDetailPK(productId, techId);
    }

    public ProductDetailPK getProductDetailPK() {
        return productDetailPK;
    }

    public void setProductDetailPK(ProductDetailPK productDetailPK) {
        this.productDetailPK = productDetailPK;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productDetailPK != null ? productDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDetail)) {
            return false;
        }
        ProductDetail other = (ProductDetail) object;
        if ((this.productDetailPK == null && other.productDetailPK != null) || (this.productDetailPK != null && !this.productDetailPK.equals(other.productDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductDetail[ productDetailPK=" + productDetailPK + " ]";
    }
    
}
