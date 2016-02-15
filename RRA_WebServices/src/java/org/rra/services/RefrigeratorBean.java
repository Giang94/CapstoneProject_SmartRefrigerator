/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rra.services;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.json.simple.JSONObject;
import org.rra.entities.Material;
import org.rra.entities.Refrigerator;
import org.rra.entities.User;

/**
 *
 * @author ThanhLam
 */
@Stateless
public class RefrigeratorBean implements RefrigeratorBeanLocal, RefrigeratorBeanRemote {

    @PersistenceContext(unitName = "RRA_WebServicesPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public JSONObject addFood(JSONObject input) {
        //Lay thong tin
        int userId = (Integer) input.get("userId");
        int foodId = (Integer) input.get("foodId");
        Date dateAdded = (Date) input.get("dateAdded");
        Date dateExpired = (Date) input.get("dateExpired");
        boolean isNotify = (Boolean) input.get("isNotify");

        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setUserID(userId);
        refrigerator.setFoodID(foodId);
        refrigerator.setDateAdded(dateAdded);
        refrigerator.setDateExpired(dateExpired);
        refrigerator.setIsNotify(isNotify);

        em.persist(refrigerator);

        //Tra ket qua??????????
        JSONObject result = new JSONObject();
        result.put("result", "Added");
        return result;
    }

    @Override
    public JSONObject editFood(JSONObject input) { //Chua ro can update nhung gi
        //Amount? Unit? Status?

        //Lay thong tin
        int id = (Integer) input.get("id");
        Date dateExpired = (Date) input.get("dateExpired");

        Refrigerator refrigerator = em.find(Refrigerator.class, id);
        if (refrigerator != null) {
            refrigerator.setDateExpired(dateExpired);

            em.merge(refrigerator);
        }
        
        //Tra ket qua
        JSONObject result = new JSONObject();
        result.put("result", "Edited");
        return result;
    }

    @Override
    public JSONObject removeFood(JSONObject input) {
        //Remove food la sua status thanh "Removed"?
        //Tam thoi xoa luon
        
        //Lay thong tin
        int id = (Integer) input.get("id");

        Refrigerator refrigerator = em.find(Refrigerator.class, id);
        if (refrigerator != null) {
            em.remove(refrigerator);
        }
        
        //Tra ket qua
        JSONObject result = new JSONObject();
        result.put("result", "Removed");
        return result;
    }

}
