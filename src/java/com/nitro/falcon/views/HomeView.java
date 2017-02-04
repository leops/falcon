package com.nitro.falcon.views;

import com.nitro.falcon.daos.CourseDAO;
import com.nitro.falcon.models.Course;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * HomeView
 * @author leops
 */
@ManagedBean(name = "homeView")
@ViewScoped
public class HomeView {
    private List<Course> courses;
    
    @EJB(beanName=CourseDAO.IMPL_NAME)
    private CourseDAO courseDAO;
    
    @PostConstruct
    public void init() {
        courses = courseDAO.listCourses();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public boolean isLogged() {
        return true;
    }
}
