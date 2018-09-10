/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.ndtu.mobileshop.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NDT;
 */
@Entity
@Table(name = "News")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "News.findAll", query = "SELECT n FROM News n")
    , @NamedQuery(name = "News.findByNewsId", query = "SELECT n FROM News n WHERE n.newsId = :newsId")
    , @NamedQuery(name = "News.findByTitle", query = "SELECT n FROM News n WHERE n.title = :title")
    , @NamedQuery(name = "News.findByNewContent", query = "SELECT n FROM News n WHERE n.newContent = :newContent")
    , @NamedQuery(name = "News.findByImgPath", query = "SELECT n FROM News n WHERE n.imgPath = :imgPath")
    , @NamedQuery(name = "News.findByStatus", query = "SELECT n FROM News n WHERE n.status = :status")
    , @NamedQuery(name = "News.findByCreatedDate", query = "SELECT n FROM News n WHERE n.createdDate = :createdDate")
    , @NamedQuery(name = "News.findByImgSlider", query = "SELECT n FROM News n WHERE n.imgSlider = :imgSlider")})
public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "news_id")
    private Integer newsId;
    @Column(name = "title")
    private String title;
    @Column(name = "new_content")
    private String newContent;
    @Column(name = "img_path")
    private String imgPath;
    @Column(name = "status")
    private Integer status;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "img_slider")
    private String imgSlider;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Employee employeeId;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private NewsCategory categoryId;

    public News() {
    }

    public News(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getImgSlider() {
        return imgSlider;
    }

    public void setImgSlider(String imgSlider) {
        this.imgSlider = imgSlider;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public NewsCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(NewsCategory categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsId != null ? newsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof News)) {
            return false;
        }
        News other = (News) object;
        if ((this.newsId == null && other.newsId != null) || (this.newsId != null && !this.newsId.equals(other.newsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.News[ newsId=" + newsId + " ]";
    }
    
}
