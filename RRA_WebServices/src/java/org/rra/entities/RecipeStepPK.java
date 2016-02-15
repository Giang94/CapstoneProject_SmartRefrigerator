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
public class RecipeStepPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "StepID", nullable = false)
    private int stepID;
    @Basic(optional = false)
    @Column(name = "RecipeID", nullable = false)
    private int recipeID;

    public RecipeStepPK() {
    }

    public RecipeStepPK(int stepID, int recipeID) {
        this.stepID = stepID;
        this.recipeID = recipeID;
    }

    public int getStepID() {
        return stepID;
    }

    public void setStepID(int stepID) {
        this.stepID = stepID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) stepID;
        hash += (int) recipeID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecipeStepPK)) {
            return false;
        }
        RecipeStepPK other = (RecipeStepPK) object;
        if (this.stepID != other.stepID) {
            return false;
        }
        if (this.recipeID != other.recipeID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.rra.entities.RecipeStepPK[ stepID=" + stepID + ", recipeID=" + recipeID + " ]";
    }
    
}
