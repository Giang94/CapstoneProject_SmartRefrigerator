/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rra.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThanhLam
 */
@Entity
@Table(name = "RecipeStep", catalog = "RRA", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecipeStep.findAll", query = "SELECT r FROM RecipeStep r"),
    @NamedQuery(name = "RecipeStep.findByStepID", query = "SELECT r FROM RecipeStep r WHERE r.recipeStepPK.stepID = :stepID"),
    @NamedQuery(name = "RecipeStep.findByRecipeID", query = "SELECT r FROM RecipeStep r WHERE r.recipeStepPK.recipeID = :recipeID"),
    @NamedQuery(name = "RecipeStep.findByStepDetail", query = "SELECT r FROM RecipeStep r WHERE r.stepDetail = :stepDetail"),
    @NamedQuery(name = "RecipeStep.findByStepImage", query = "SELECT r FROM RecipeStep r WHERE r.stepImage = :stepImage")})
public class RecipeStep implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecipeStepPK recipeStepPK;
    @Basic(optional = false)
    @Column(name = "StepDetail", nullable = false, length = 2147483647)
    private String stepDetail;
    @Column(name = "StepImage", length = 2147483647)
    private String stepImage;

    public RecipeStep() {
    }

    public RecipeStep(RecipeStepPK recipeStepPK) {
        this.recipeStepPK = recipeStepPK;
    }

    public RecipeStep(RecipeStepPK recipeStepPK, String stepDetail) {
        this.recipeStepPK = recipeStepPK;
        this.stepDetail = stepDetail;
    }

    public RecipeStep(int stepID, int recipeID) {
        this.recipeStepPK = new RecipeStepPK(stepID, recipeID);
    }

    public RecipeStepPK getRecipeStepPK() {
        return recipeStepPK;
    }

    public void setRecipeStepPK(RecipeStepPK recipeStepPK) {
        this.recipeStepPK = recipeStepPK;
    }

    public String getStepDetail() {
        return stepDetail;
    }

    public void setStepDetail(String stepDetail) {
        this.stepDetail = stepDetail;
    }

    public String getStepImage() {
        return stepImage;
    }

    public void setStepImage(String stepImage) {
        this.stepImage = stepImage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipeStepPK != null ? recipeStepPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecipeStep)) {
            return false;
        }
        RecipeStep other = (RecipeStep) object;
        if ((this.recipeStepPK == null && other.recipeStepPK != null) || (this.recipeStepPK != null && !this.recipeStepPK.equals(other.recipeStepPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.rra.entities.RecipeStep[ recipeStepPK=" + recipeStepPK + " ]";
    }
    
}
