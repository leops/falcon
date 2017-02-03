package com.nitro.falcon.api.daos;

import com.nitro.falcon.models.Course;
import java.util.List;
import javax.ejb.Local;

/**
 * UserDAO
 * @author leops
 */
@Local
public interface CourseDAO {
    List<Course> listCourses();
}
