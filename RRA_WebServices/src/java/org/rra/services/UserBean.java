/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rra.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.json.simple.JSONObject;
import org.rra.entities.User;

/**
 *
 * @author ThanhLam
 */
@Stateless
public class UserBean implements UserBeanLocal, UserBeanRemote {
    @PersistenceContext(unitName = "RRA_WebServicesPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public JSONObject checkLogin(JSONObject input) {
        JSONObject result = new JSONObject();
        
        //Lay thong tin
        String username = (String) input.get("username");
        String password = (String) input.get("password");
        
        //Kiem tra username
        Query query = em.createNamedQuery("User.findByUsername");
        query.setParameter("username", username);
        try {
            User user = (User) query.getSingleResult();
            if (user.getPassword().equals(password)) { //Kiem tra password
                result.put("Result", "Logged in");
            } else { //Sai password
                result.put("Result", "Invalid");
            }
        } catch (NoResultException e) { //Username khong ton tai
            result.put("Result", "Invalid");
        }
        
        return result;
    }
    
    @Override
    public JSONObject register(JSONObject input) {
        JSONObject result = new JSONObject();
        
        //Lay thong tin
        String username = (String) input.get("username");
        String password = (String) input.get("password");
        
        //Kiem tra username
        Query query = em.createNamedQuery("User.findByUsername");
        query.setParameter("username", username);
        try {
            User user = (User) query.getSingleResult();
            result.put("Result", "Username existed"); //Da ton tai
        } catch (NoResultException e) { //Chua ton tai, tao tai khoan moi
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            em.persist(newUser);
            result.put("Result", "Succeed");
        }
        
        return result;
    }
}
