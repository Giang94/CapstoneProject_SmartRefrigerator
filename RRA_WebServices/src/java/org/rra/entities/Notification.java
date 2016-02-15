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
@Table(name = "Notification", catalog = "RRA", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n"),
    @NamedQuery(name = "Notification.findByNotificationID", query = "SELECT n FROM Notification n WHERE n.notificationID = :notificationID"),
    @NamedQuery(name = "Notification.findByUserID", query = "SELECT n FROM Notification n WHERE n.userID = :userID"),
    @NamedQuery(name = "Notification.findByNotificationContent", query = "SELECT n FROM Notification n WHERE n.notificationContent = :notificationContent"),
    @NamedQuery(name = "Notification.findBySendingTime", query = "SELECT n FROM Notification n WHERE n.sendingTime = :sendingTime"),
    @NamedQuery(name = "Notification.findByIsSent", query = "SELECT n FROM Notification n WHERE n.isSent = :isSent")})
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NotificationID", nullable = false)
    private Integer notificationID;
    @Basic(optional = false)
    @Column(name = "UserID", nullable = false)
    private int userID;
    @Basic(optional = false)
    @Column(name = "NotificationContent", nullable = false, length = 2147483647)
    private String notificationContent;
    @Basic(optional = false)
    @Column(name = "SendingTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendingTime;
    @Basic(optional = false)
    @Column(name = "IsSent", nullable = false)
    private boolean isSent;

    public Notification() {
    }

    public Notification(Integer notificationID) {
        this.notificationID = notificationID;
    }

    public Notification(Integer notificationID, int userID, String notificationContent, Date sendingTime, boolean isSent) {
        this.notificationID = notificationID;
        this.userID = userID;
        this.notificationContent = notificationContent;
        this.sendingTime = sendingTime;
        this.isSent = isSent;
    }

    public Integer getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(Integer notificationID) {
        this.notificationID = notificationID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }

    public Date getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(Date sendingTime) {
        this.sendingTime = sendingTime;
    }

    public boolean getIsSent() {
        return isSent;
    }

    public void setIsSent(boolean isSent) {
        this.isSent = isSent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificationID != null ? notificationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.notificationID == null && other.notificationID != null) || (this.notificationID != null && !this.notificationID.equals(other.notificationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.rra.entities.Notification[ notificationID=" + notificationID + " ]";
    }
    
}
