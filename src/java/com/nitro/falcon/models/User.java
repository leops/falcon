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
    public String username;
    
    @NotEmpty
    @Column(nullable=false)
    public String password;
    
    @NotEmpty
    @Column(nullable=false)
    public byte[] salt;
}
