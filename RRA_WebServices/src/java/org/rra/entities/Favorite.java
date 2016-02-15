/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rra.entities;

import java.io.Serializable;
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
@Table(name = "Favorite", catalog = "RRA", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favorite.findAll", query = "SELECT f FROM Favorite f"),
    @NamedQuery(name = "Favorite.findByRecipeID", query = "SELECT f FROM Favorite f WHERE f.favoritePK.recipeID = :recipeID"),
    @NamedQuery(name = "Favorite.findByUserID", query = "SELECT f FROM Favorite f WHERE f.favoritePK.userID = :userID")})
public class Favorite implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FavoritePK favoritePK;

    public Favorite() {
    }

    public Favorite(FavoritePK favoritePK) {
        this.favoritePK = favoritePK;
    }

    public Favorite(int recipeID, int userID) {
        this.favoritePK = new FavoritePK(recipeID, userID);
    }

    public FavoritePK getFavoritePK() {
        return favoritePK;
    }

    public void setFavoritePK(FavoritePK favoritePK) {
        this.favoritePK = favoritePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (favoritePK != null ? favoritePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favorite)) {
            return false;
        }
        Favorite other = (Favorite) object;
        if ((this.favoritePK == null && other.favoritePK != null) || (this.favoritePK != null && !this.favoritePK.equals(other.favoritePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.rra.entities.Favorite[ favoritePK=" + favoritePK + " ]";
    }
    
}
