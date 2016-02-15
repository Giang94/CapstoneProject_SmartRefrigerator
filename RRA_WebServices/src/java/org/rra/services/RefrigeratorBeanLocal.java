/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rra.services;

import javax.ejb.Local;
import org.json.simple.JSONObject;

/**
 *
 * @author ThanhLam
 */
@Local
public interface RefrigeratorBeanLocal {

    JSONObject addFood(JSONObject input);

    JSONObject editFood(JSONObject input);

    JSONObject removeFood(JSONObject input);
    
}
