package com.nitro.falcon.views;

import java.awt.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * LoginView
 * @author leops
 */
@ManagedBean(name = "loginView")
@ViewScoped
public class LoginView {
    private String username;
    private String password;

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

    public void doLogin(final ActionEvent actionEvent) {
        // TODO
    }
}
