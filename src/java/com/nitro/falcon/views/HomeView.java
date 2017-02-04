package com.nitro.falcon.views;

import com.nitro.falcon.daos.CourseDAO;
import com.nitro.falcon.daos.QuizzDAO;
import com.nitro.falcon.models.Course;
import com.nitro.falcon.models.Quizz;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * HomeView
 * @author leops
 */
@ManagedBean(name = "homeView")
@ViewScoped
public class HomeView implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<Course> courses;
    
    @EJB(beanName=CourseDAO.IMPL_NAME)
    private CourseDAO courseDAO;

    @ManagedProperty("#{sessionData}")
    private SessionData session;
    
    @PostConstruct
    public void init() {
        courses = courseDAO.listCourses();
    }

    public void setSession(SessionData session) {
        this.session = session;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void takeCourse(final Course course) {
        session.getUser().viewCourse(course);
    }
    
    public boolean hasPassedQuizz() {
        final Quizz quizz = new Quizz();
        quizz.setId(0);
        return session.getUser().hasPassedQuizz(quizz);
    }
}
