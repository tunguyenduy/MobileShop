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
public class BillDetailPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "bill_id")
    private int billId;
    @Basic(optional = false)
    @Column(name = "model_id")
    private int modelId;

    public BillDetailPK() {
    }

    public BillDetailPK(int billId, int modelId) {
        this.billId = billId;
        this.modelId = modelId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) billId;
        hash += (int) modelId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillDetailPK)) {
            return false;
        }
        BillDetailPK other = (BillDetailPK) object;
        if (this.billId != other.billId) {
            return false;
        }
        if (this.modelId != other.modelId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BillDetailPK[ billId=" + billId + ", modelId=" + modelId + " ]";
    }
    
}
