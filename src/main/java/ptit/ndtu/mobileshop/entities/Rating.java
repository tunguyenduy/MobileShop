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
@Table(name = "Rating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rating.findAll", query = "SELECT r FROM Rating r")
    , @NamedQuery(name = "Rating.findByCustomerId", query = "SELECT r FROM Rating r WHERE r.ratingPK.customerId = :customerId")
    , @NamedQuery(name = "Rating.findByProductId", query = "SELECT r FROM Rating r WHERE r.ratingPK.productId = :productId")
    , @NamedQuery(name = "Rating.findByVote", query = "SELECT r FROM Rating r WHERE r.vote = :vote")})
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RatingPK ratingPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vote")
    private Double vote;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Customer customer;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Product product;

    public Rating() {
    }

    public Rating(RatingPK ratingPK) {
        this.ratingPK = ratingPK;
    }

    public Rating(int customerId, int productId) {
        this.ratingPK = new RatingPK(customerId, productId);
    }

    public RatingPK getRatingPK() {
        return ratingPK;
    }

    public void setRatingPK(RatingPK ratingPK) {
        this.ratingPK = ratingPK;
    }

    public Double getVote() {
        return vote;
    }

    public void setVote(Double vote) {
        this.vote = vote;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        hash += (ratingPK != null ? ratingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rating)) {
            return false;
        }
        Rating other = (Rating) object;
        if ((this.ratingPK == null && other.ratingPK != null) || (this.ratingPK != null && !this.ratingPK.equals(other.ratingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Rating[ ratingPK=" + ratingPK + " ]";
    }
    
}
