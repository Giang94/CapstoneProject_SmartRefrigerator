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
import org.json.simple.JSONObject;
import org.rra.services.RefrigeratorBeanLocal;

/**
 *
 * @author ThanhLam
 */
@WebService(serviceName = "RefrigeratorWebService")
@Stateless()
public class RefrigeratorWebService {
    @EJB
    private RefrigeratorBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addFood")
    public JSONObject addFood(@WebParam(name = "input") JSONObject input) {
        return ejbRef.addFood(input);
    }

    @WebMethod(operationName = "editFood")
    public JSONObject editFood(@WebParam(name = "input") JSONObject input) {
        return ejbRef.editFood(input);
    }

    @WebMethod(operationName = "removeFood")
    public JSONObject removeFood(@WebParam(name = "input") JSONObject input) {
        return ejbRef.removeFood(input);
    }
    
}
