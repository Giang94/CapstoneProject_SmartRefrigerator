/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rra.services;

import javax.ejb.Remote;
import org.json.simple.JSONObject;

/**
 *
 * @author ThanhLam
 */
@Remote
public interface RefrigeratorBeanRemote {

    JSONObject addFood(JSONObject input);

    JSONObject editFood(JSONObject input);

    JSONObject removeFood(JSONObject input);
    
}
