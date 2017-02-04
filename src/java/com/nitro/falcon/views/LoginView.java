package com.nitro.falcon.views;

import com.nitro.falcon.daos.UserDAO;
import com.nitro.falcon.models.User;
import com.nitro.falcon.utils.FaceUtils;
import com.nitro.falcon.utils.TokenUtils;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * LoginView
 * @author leops
 */
@ManagedBean(name = "loginView")
@ViewScoped
public class LoginView implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String username;
    private String password;
    
    @EJB(beanName=UserDAO.IMPL_NAME)
    private UserDAO userDAO;
    
    @ManagedProperty("#{sessionData}")
    private SessionData sessionData;
    
    @PostConstruct
    public void checkLogin() {
        if(sessionData.isLogged()) {
            FaceUtils.redirect("index");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setSessionData(SessionData sessionData) {
        this.sessionData = sessionData;
    }

    public void doLogin() {
        final User user = userDAO.findByName(username);
        if(user != null) {
            if(TokenUtils.hashPassword(password, user.getSalt()).equals(user.getPassword())) {
                sessionData.setUser(user);
                FaceUtils.redirect("index");
            }
        }
    }
    
    public void doRegister() {
        final User user = new User();
        user.setUsername(username);
        user.setSalt(TokenUtils.genSalt());
        user.setPassword(TokenUtils.hashPassword(password, user.getSalt()));
        
        userDAO.save(user);
        sessionData.setUser(user);
        FaceUtils.redirect("index");
    }
}
