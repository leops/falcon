package com.nitro.falcon.daos;

import com.nitro.falcon.models.Course;
import java.util.List;
import javax.ejb.Local;

/**
 * CourseDAO
 * @author leops
 */
@Local
public interface CourseDAO {
    // Replace with CourseDAOImpl to use JPA
    public static final String IMPL_NAME = "CourseDAOMock";
    
    List<Course> listCourses();
    public Course findByName(String courseId);
}
