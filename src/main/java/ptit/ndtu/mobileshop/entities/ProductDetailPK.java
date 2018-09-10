/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.ndtu.mobileshop.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author NDT;
 */
@Embeddable
public class ProductDetailPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @Column(name = "tech_id")
    private int techId;

    public ProductDetailPK() {
    }

    public ProductDetailPK(int productId, int techId) {
        this.productId = productId;
        this.techId = techId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getTechId() {
        return techId;
    }

    public void setTechId(int techId) {
        this.techId = techId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productId;
        hash += (int) techId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDetailPK)) {
            return false;
        }
        ProductDetailPK other = (ProductDetailPK) object;
        if (this.productId != other.productId) {
            return false;
        }
        if (this.techId != other.techId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductDetailPK[ productId=" + productId + ", techId=" + techId + " ]";
    }
    
}
