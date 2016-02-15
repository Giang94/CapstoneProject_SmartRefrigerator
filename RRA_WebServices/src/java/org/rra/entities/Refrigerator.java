/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rra.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThanhLam
 */
@Entity
@Table(name = "Refrigerator", catalog = "RRA", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Refrigerator.findAll", query = "SELECT r FROM Refrigerator r"),
    @NamedQuery(name = "Refrigerator.findById", query = "SELECT r FROM Refrigerator r WHERE r.id = :id"),
    @NamedQuery(name = "Refrigerator.findByUserID", query = "SELECT r FROM Refrigerator r WHERE r.userID = :userID"),
    @NamedQuery(name = "Refrigerator.findByFoodID", query = "SELECT r FROM Refrigerator r WHERE r.foodID = :foodID"),
    @NamedQuery(name = "Refrigerator.findByDateAdded", query = "SELECT r FROM Refrigerator r WHERE r.dateAdded = :dateAdded"),
    @NamedQuery(name = "Refrigerator.findByDateExpired", query = "SELECT r FROM Refrigerator r WHERE r.dateExpired = :dateExpired"),
    @NamedQuery(name = "Refrigerator.findByIsNotify", query = "SELECT r FROM Refrigerator r WHERE r.isNotify = :isNotify"),
    @NamedQuery(name = "Refrigerator.findByNotifyBefore", query = "SELECT r FROM Refrigerator r WHERE r.notifyBefore = :notifyBefore")})
public class Refrigerator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "UserID", nullable = false)
    private int userID;
    @Basic(optional = false)
    @Column(name = "FoodID", nullable = false)
    private int foodID;
    @Basic(optional = false)
    @Column(name = "DateAdded", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Basic(optional = false)
    @Column(name = "DateExpired", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExpired;
    @Basic(optional = false)
    @Column(name = "IsNotify", nullable = false)
    private boolean isNotify;
    @Column(name = "NotifyBefore")
    private Integer notifyBefore;

    public Refrigerator() {
    }

    public Refrigerator(Integer id) {
        this.id = id;
    }

    public Refrigerator(Integer id, int userID, int foodID, Date dateAdded, Date dateExpired, boolean isNotify) {
        this.id = id;
        this.userID = userID;
        this.foodID = foodID;
        this.dateAdded = dateAdded;
        this.dateExpired = dateExpired;
        this.isNotify = isNotify;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public boolean getIsNotify() {
        return isNotify;
    }

    public void setIsNotify(boolean isNotify) {
        this.isNotify = isNotify;
    }

    public Integer getNotifyBefore() {
        return notifyBefore;
    }

    public void setNotifyBefore(Integer notifyBefore) {
        this.notifyBefore = notifyBefore;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Refrigerator)) {
            return false;
        }
        Refrigerator other = (Refrigerator) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.rra.entities.Refrigerator[ id=" + id + " ]";
    }
    
}
