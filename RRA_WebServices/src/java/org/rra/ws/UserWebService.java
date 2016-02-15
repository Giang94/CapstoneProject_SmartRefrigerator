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
import org.rra.services.UserBeanLocal;

/**
 *
 * @author ThanhLam
 */
@WebService(serviceName = "UserWebService")
@Stateless()
public class UserWebService {
    @EJB
    private UserBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "register")
    public JSONObject register(@WebParam(name = "input") JSONObject input) {
        return ejbRef.register(input);
    }

    @WebMethod(operationName = "checkLogin")
    public JSONObject checkLogin(@WebParam(name = "input") JSONObject input) {
        return ejbRef.checkLogin(input);
    }
    
}
