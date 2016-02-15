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
public class IngredientPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "RecipeID", nullable = false)
    private int recipeID;
    @Basic(optional = false)
    @Column(name = "MaterialID", nullable = false)
    private int materialID;

    public IngredientPK() {
    }

    public IngredientPK(int recipeID, int materialID) {
        this.recipeID = recipeID;
        this.materialID = materialID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) recipeID;
        hash += (int) materialID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngredientPK)) {
            return false;
        }
        IngredientPK other = (IngredientPK) object;
        if (this.recipeID != other.recipeID) {
            return false;
        }
        if (this.materialID != other.materialID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.rra.entities.IngredientPK[ recipeID=" + recipeID + ", materialID=" + materialID + " ]";
    }
    
}
