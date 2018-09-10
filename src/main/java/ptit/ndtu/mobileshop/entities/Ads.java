/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.ndtu.mobileshop.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NDT;
 */
@Entity
@Table(name = "Ads")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ads.findAll", query = "SELECT a FROM Ads a")
    , @NamedQuery(name = "Ads.findByAdsId", query = "SELECT a FROM Ads a WHERE a.adsId = :adsId")
    , @NamedQuery(name = "Ads.findByTitle", query = "SELECT a FROM Ads a WHERE a.title = :title")
    , @NamedQuery(name = "Ads.findByUrl", query = "SELECT a FROM Ads a WHERE a.url = :url")
    , @NamedQuery(name = "Ads.findByStatus", query = "SELECT a FROM Ads a WHERE a.status = :status")
    , @NamedQuery(name = "Ads.findByPath", query = "SELECT a FROM Ads a WHERE a.path = :path")
    , @NamedQuery(name = "Ads.findByPosition", query = "SELECT a FROM Ads a WHERE a.position = :position")})
public class Ads implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ads_id")
    private Integer adsId;
    @Column(name = "title")
    private String title;
    @Column(name = "url")
    private String url;
    @Column(name = "status")
    private Integer status;
    @Column(name = "path")
    private String path;
    @Column(name = "position")
    private Integer position;

    public Ads() {
    }

    public Ads(Integer adsId) {
        this.adsId = adsId;
    }

    public Integer getAdsId() {
        return adsId;
    }

    public void setAdsId(Integer adsId) {
        this.adsId = adsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adsId != null ? adsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ads)) {
            return false;
        }
        Ads other = (Ads) object;
        if ((this.adsId == null && other.adsId != null) || (this.adsId != null && !this.adsId.equals(other.adsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ads[ adsId=" + adsId + " ]";
    }
    
}
