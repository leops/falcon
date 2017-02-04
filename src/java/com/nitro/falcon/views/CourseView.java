package com.nitro.falcon.views;

import com.nitro.falcon.daos.CourseDAO;
import com.nitro.falcon.models.Course;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * CourseView
 * @author leops
 */
@ManagedBean(name = "courseView")
@ViewScoped
public class CourseView {
    private String courseId;
    private Course course;
    
    @EJB(beanName=CourseDAO.IMPL_NAME)
    private CourseDAO courseDAO;

    public Course getCourse() {
        return course;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(final String courseId) {
        this.courseId = courseId;
        course = courseDAO.findByName(courseId);
    }
}
