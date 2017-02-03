package com.nitro.falcon.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Course
 * @author leops
 */
@Entity
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotEmpty
    @Column(unique=true, nullable=false)
    public String name;
    
    @NotEmpty
    @Column(nullable=false)
    public String description;
    
    public List<String> modules;
    
    public long duration;
}
