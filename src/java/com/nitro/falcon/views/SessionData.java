package com.nitro.falcon.views;

import com.nitro.falcon.models.User;
import com.sun.istack.Nullable;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * SessionData
 * @author leops
 */
@ManagedBean(name = "sessionData")
@SessionScoped
public class SessionData implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private @Nullable User user;

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }
    
    public boolean isLogged() {
        return user != null;
    }
    
    public void logout() {
        user = null;
    }
}
