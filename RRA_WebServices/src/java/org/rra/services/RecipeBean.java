/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rra.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author ThanhLam
 */
@Stateless
public class RecipeBean implements RecipeBeanLocal, RecipeBeanRemote {
    @PersistenceContext(unitName = "RRA_WebServicesPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public JSONArray searchByRecipeName(JSONObject input) {
        
        //Lay thong tin
        String searchText = (String) input.get("searchText");
        
        //Query
        String jpql = 
                "SELECT r FROM Recipe r WHERE r.recipeName LIKE :recipeName";
        Query query = em.createQuery(jpql);
        query.setParameter("recipeName", "%" + searchText + "%");
        List list = query.getResultList();
        
        JSONArray result = new JSONArray();
        for (Object obj: list) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("value", obj);
            result.add(jsonObject);
        }
        
        return result;
    }
    
    
}
