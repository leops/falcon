package com.nitro.falcon.apis;

import com.nitro.falcon.daos.UserDAO;
import com.nitro.falcon.models.User;
import com.nitro.falcon.utils.TokenUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * UserAPI
 * @author leops
 */
@WebService(serviceName = "UserAPI")
public class UserAPI {
    @WebMethod(operationName = "getToken")
    public String getToken(@WebParam(name = "username") final String username, @WebParam(name = "password") final String password) {
        try {
            final Context ctx = new InitialContext();
            final UserDAO userDao = (UserDAO) ctx.lookup("java:global/Falcon/UserDAO");
            
            final User user = userDao.findByName(username);
            if(user == null) {
                return null;
            }
            
            final String hashed = TokenUtils.hashPassword(password, user.getSalt());
            if(!hashed.equals(user.getPassword())) {
                return null;
            }
            
            return TokenUtils.getToken(user);
        } catch (NamingException ex) {
            Logger.getLogger(UserAPI.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @WebMethod(operationName = "getUser")
    public User getUser(@WebParam(name = "token") final String token) {
        try {
            final Context ctx = new InitialContext();
            final UserDAO userDao = (UserDAO) ctx.lookup("java:global/Falcon/UserDAO");
            
            final String username = TokenUtils.fromToken(token);
            return userDao.findByName(username);
        } catch (NamingException ex) {
            Logger.getLogger(UserAPI.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
