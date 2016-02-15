/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rra.ws;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rra.services.RecipeBeanLocal;

/**
 *
 * @author ThanhLam
 */
@WebService(serviceName = "RecipeWebService")
@Stateless()
public class RecipeWebService {
    @EJB
    private RecipeBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "searchByRecipeName")
    public JSONArray searchByRecipeName(@WebParam(name = "input") JSONObject input) {
        return ejbRef.searchByRecipeName(input);
    }
    
}
