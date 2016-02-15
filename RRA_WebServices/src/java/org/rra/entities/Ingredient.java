/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rra.entities;

import java.io.Serializable;
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
@Table(name = "Ingredient", catalog = "RRA", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i"),
    @NamedQuery(name = "Ingredient.findByRecipeID", query = "SELECT i FROM Ingredient i WHERE i.ingredientPK.recipeID = :recipeID"),
    @NamedQuery(name = "Ingredient.findByMaterialID", query = "SELECT i FROM Ingredient i WHERE i.ingredientPK.materialID = :materialID"),
    @NamedQuery(name = "Ingredient.findByAmount", query = "SELECT i FROM Ingredient i WHERE i.amount = :amount"),
    @NamedQuery(name = "Ingredient.findByUnit", query = "SELECT i FROM Ingredient i WHERE i.unit = :unit")})
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngredientPK ingredientPK;
    @Column(name = "Amount", length = 50)
    private String amount;
    @Column(name = "Unit", length = 50)
    private String unit;

    public Ingredient() {
    }

    public Ingredient(IngredientPK ingredientPK) {
        this.ingredientPK = ingredientPK;
    }

    public Ingredient(int recipeID, int materialID) {
        this.ingredientPK = new IngredientPK(recipeID, materialID);
    }

    public IngredientPK getIngredientPK() {
        return ingredientPK;
    }

    public void setIngredientPK(IngredientPK ingredientPK) {
        this.ingredientPK = ingredientPK;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingredientPK != null ? ingredientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.ingredientPK == null && other.ingredientPK != null) || (this.ingredientPK != null && !this.ingredientPK.equals(other.ingredientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.rra.entities.Ingredient[ ingredientPK=" + ingredientPK + " ]";
    }
    
}
