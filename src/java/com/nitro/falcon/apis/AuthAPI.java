package com.nitro.falcon.apis;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * AuthAPI
 * @author leops
 */
@WebService(serviceName = "AuthAPI")
public class AuthAPI {
    @WebMethod(operationName = "getToken")
    public String getToken(@WebParam(name = "username") final String username, @WebParam(name = "password") final String password) {
        return "";
        /*final Context ctx = new InitialContext();
        final UserDAO userDao = (UserDAO) ctx.lookup("java:global/");
        
        final User user = userDao.findByName(username);
        if(user == null) {
            return null;
        }
        
        final String hashed = UserService.hashPassword(password, user.salt);
        if(!hashed.equals(user.password)) {
            return null;
        }
        
        return UserService.getToken(user);*/
    }
}
