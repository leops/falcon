package com.nitro.falcon.apis;

import com.nitro.falcon.daos.CourseDAO;
import com.nitro.falcon.daos.UserDAO;
import com.nitro.falcon.models.Course;
import com.nitro.falcon.models.User;
import com.nitro.falcon.utils.TokenUtils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * CourseAPI
 * @author leops
 */
@WebService(serviceName = "CourseAPI")
public class CourseAPI {
    @WebMethod(operationName = "listCourses")
    public List<Course> listCourses() {
        try {
            final Context ctx = new InitialContext();
            final CourseDAO courseDAO = (CourseDAO) ctx.lookup("java:global/Falcon/CourseDAO");
            
            return courseDAO.listCourses();
        } catch (final NamingException ex) {
            Logger.getLogger(CourseAPI.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @WebMethod(operationName = "getCourse")
    public Course getCourse(final @WebParam(name = "name") String name) {
        try {
            final Context ctx = new InitialContext();
            final CourseDAO courseDAO = (CourseDAO) ctx.lookup("java:global/Falcon/CourseDAO");
            
            return courseDAO.findByName(name);
        } catch (final NamingException ex) {
            Logger.getLogger(CourseAPI.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @WebMethod(operationName = "takeCourse")
    public boolean takeCourse(@WebParam(name = "token") final String token, @WebParam(name = "course") final String courseName) {
        try {
            final Context ctx = new InitialContext();
            final UserDAO userDao = (UserDAO) ctx.lookup("java:global/Falcon/UserDAO");
            final CourseDAO courseDAO = (CourseDAO) ctx.lookup("java:global/Falcon/CourseDAO");
            
            final String username = TokenUtils.fromToken(token);
            final User user = userDao.findByName(username);
            
            final Course course = courseDAO.findByName(courseName);
            user.viewCourse(course);
            
            return true;
        } catch (NamingException ex) {
            Logger.getLogger(UserAPI.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
