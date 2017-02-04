package com.nitro.falcon.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    
    @OneToMany
    private final List<Course> viewedCourses;
    
    @OneToMany
    private final List<Quizz> passedQuizzes;
    
    public User() {
        viewedCourses = new ArrayList<>();
        passedQuizzes = new ArrayList<>();
    }

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

    public List<Course> getViewedCourses() {
        return viewedCourses;
    }
    
    public void viewCourse(final Course course) {
        viewedCourses.add(course);
    }
    
    public boolean hasViewedCourse(final Course course) {
        return viewedCourses.stream()
            .anyMatch(c -> c.getName().equals(course.getName()));
    }
    
    public void passQuizz(final Quizz quizz) {
        passedQuizzes.add(quizz);
    }
    
    public boolean hasPassedQuizz(final Quizz quizz) {
        return passedQuizzes.stream()
            .anyMatch(q -> q!= null && q.getId() == quizz.getId());
    }
}
