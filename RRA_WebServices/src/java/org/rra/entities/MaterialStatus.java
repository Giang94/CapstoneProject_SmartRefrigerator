/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rra.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThanhLam
 */
@Entity
@Table(name = "MaterialStatus", catalog = "RRA", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialStatus.findAll", query = "SELECT m FROM MaterialStatus m"),
    @NamedQuery(name = "MaterialStatus.findByStatusID", query = "SELECT m FROM MaterialStatus m WHERE m.statusID = :statusID"),
    @NamedQuery(name = "MaterialStatus.findByStatus", query = "SELECT m FROM MaterialStatus m WHERE m.status = :status")})
public class MaterialStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "StatusID", nullable = false)
    private Integer statusID;
    @Basic(optional = false)
    @Column(name = "Status", nullable = false, length = 50)
    private String status;

    public MaterialStatus() {
    }

    public MaterialStatus(Integer statusID) {
        this.statusID = statusID;
    }

    public MaterialStatus(Integer statusID, String status) {
        this.statusID = statusID;
        this.status = status;
    }

    public Integer getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer statusID) {
        this.statusID = statusID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusID != null ? statusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialStatus)) {
            return false;
        }
        MaterialStatus other = (MaterialStatus) object;
        if ((this.statusID == null && other.statusID != null) || (this.statusID != null && !this.statusID.equals(other.statusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.rra.entities.MaterialStatus[ statusID=" + statusID + " ]";
    }
    
}
