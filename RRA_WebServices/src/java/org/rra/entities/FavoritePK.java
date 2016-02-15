/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rra.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ThanhLam
 */
@Embeddable
public class FavoritePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "RecipeID", nullable = false)
    private int recipeID;
    @Basic(optional = false)
    @Column(name = "UserID", nullable = false)
    private int userID;

    public FavoritePK() {
    }

    public FavoritePK(int recipeID, int userID) {
        this.recipeID = recipeID;
        this.userID = userID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) recipeID;
        hash += (int) userID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoritePK)) {
            return false;
        }
        FavoritePK other = (FavoritePK) object;
        if (this.recipeID != other.recipeID) {
            return false;
        }
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.rra.entities.FavoritePK[ recipeID=" + recipeID + ", userID=" + userID + " ]";
    }
    
}
