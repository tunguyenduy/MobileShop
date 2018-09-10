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
@Table(name = "BillDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillDetail.findAll", query = "SELECT b FROM BillDetail b")
    , @NamedQuery(name = "BillDetail.findByBillId", query = "SELECT b FROM BillDetail b WHERE b.billDetailPK.billId = :billId")
    , @NamedQuery(name = "BillDetail.findByModelId", query = "SELECT b FROM BillDetail b WHERE b.billDetailPK.modelId = :modelId")
    , @NamedQuery(name = "BillDetail.findByQuantity", query = "SELECT b FROM BillDetail b WHERE b.quantity = :quantity")
    , @NamedQuery(name = "BillDetail.findByPrice", query = "SELECT b FROM BillDetail b WHERE b.price = :price")
    , @NamedQuery(name = "BillDetail.findByDiscount", query = "SELECT b FROM BillDetail b WHERE b.discount = :discount")})
public class BillDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BillDetailPK billDetailPK;
    @Column(name = "quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "discount")
    private Double discount;
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id", insertable = false, updatable = false)
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Bill bill;
    @JoinColumn(name = "model_id", referencedColumnName = "model_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch= FetchType.LAZY)
    private Model model;

    public BillDetail() {
    }

    public BillDetail(BillDetailPK billDetailPK) {
        this.billDetailPK = billDetailPK;
    }

    public BillDetail(int billId, int modelId) {
        this.billDetailPK = new BillDetailPK(billId, modelId);
    }

    public BillDetailPK getBillDetailPK() {
        return billDetailPK;
    }

    public void setBillDetailPK(BillDetailPK billDetailPK) {
        this.billDetailPK = billDetailPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billDetailPK != null ? billDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillDetail)) {
            return false;
        }
        BillDetail other = (BillDetail) object;
        if ((this.billDetailPK == null && other.billDetailPK != null) || (this.billDetailPK != null && !this.billDetailPK.equals(other.billDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BillDetail[ billDetailPK=" + billDetailPK + " ]";
    }
    
}
