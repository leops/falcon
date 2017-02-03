package com.nitro.falcon.views;

import com.nitro.falcon.api.daos.CourseDAO;
import com.nitro.falcon.models.Course;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * HomeView
 * @author leops
 */
@ManagedBean
@ViewScoped
public class HomeView {
    public List<Course> courses;
    
    @ManagedProperty("#{courseDAO}")
    private CourseDAO courseDAO;
    
    @PostConstruct
    public void init() {
        courses = courseDAO.listCourses();
    }
}
