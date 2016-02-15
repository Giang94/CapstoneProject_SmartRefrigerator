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
import javax.persistence.Lob;
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
@Table(name = "Recipe", catalog = "RRA", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r"),
    @NamedQuery(name = "Recipe.findByRecipeID", query = "SELECT r FROM Recipe r WHERE r.recipeID = :recipeID"),
    @NamedQuery(name = "Recipe.findByRecipeName", query = "SELECT r FROM Recipe r WHERE r.recipeName = :recipeName"),
    @NamedQuery(name = "Recipe.findByIntroduction", query = "SELECT r FROM Recipe r WHERE r.introduction = :introduction"),
    @NamedQuery(name = "Recipe.findByViewedNumber", query = "SELECT r FROM Recipe r WHERE r.viewedNumber = :viewedNumber"),
    @NamedQuery(name = "Recipe.findByDateAdded", query = "SELECT r FROM Recipe r WHERE r.dateAdded = :dateAdded")})
public class Recipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RecipeID", nullable = false)
    private Integer recipeID;
    @Basic(optional = false)
    @Column(name = "RecipeName", nullable = false, length = 2147483647)
    private String recipeName;
    @Column(name = "Introduction", length = 2147483647)
    private String introduction;
    @Lob
    @Column(name = "RecipeImage")
    private byte[] recipeImage;
    @Basic(optional = false)
    @Column(name = "ViewedNumber", nullable = false)
    private int viewedNumber;
    @Basic(optional = false)
    @Column(name = "DateAdded", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    public Recipe() {
    }

    public Recipe(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public Recipe(Integer recipeID, String recipeName, int viewedNumber, Date dateAdded) {
        this.recipeID = recipeID;
        this.recipeName = recipeName;
        this.viewedNumber = viewedNumber;
        this.dateAdded = dateAdded;
    }

    public Integer getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public byte[] getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(byte[] recipeImage) {
        this.recipeImage = recipeImage;
    }

    public int getViewedNumber() {
        return viewedNumber;
    }

    public void setViewedNumber(int viewedNumber) {
        this.viewedNumber = viewedNumber;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipeID != null ? recipeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.recipeID == null && other.recipeID != null) || (this.recipeID != null && !this.recipeID.equals(other.recipeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.rra.entities.Recipe[ recipeID=" + recipeID + " ]";
    }
    
}
