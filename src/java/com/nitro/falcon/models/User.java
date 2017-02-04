package com.nitro.falcon.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User
 * @author leops
 */
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotEmpty
    @Column(unique=true, nullable=false)
    private String username;
    
    @NotEmpty
    @Column(nullable=false)
    private String password;
    
    @NotEmpty
    @Column(nullable=false)
    private byte[] salt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
