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
    private String name;
    
    @NotEmpty
    @Column(nullable=false)
    private String description;
    
    private List<String> modules;
    
    private long duration;
    
    public String getName() {
        return name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public List<String> getModules() {
        return modules;
    }
    
    public long getDuration() {
        return duration;
    }
}
