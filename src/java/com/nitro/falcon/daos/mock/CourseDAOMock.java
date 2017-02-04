package com.nitro.falcon.daos.mock;

import com.nitro.falcon.daos.CourseDAO;
import com.nitro.falcon.models.Course;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

/**
 * CourseDAOMock
 * @author leops
 */
@Stateless
public class CourseDAOMock implements CourseDAO {
    private static final Map<String, Course> courses = new HashMap<>();
    static {
        final Course course1 = new Course();
        course1.setName("Course 1");
        course1.setDescription("Blah");
        
        courses.put(course1.getName(), course1);
    }
    
    @Override
    public List<Course> listCourses() {
        return new ArrayList<>(courses.values());
    }
    
    @Override
    public Course findByName(final String name) {
        return courses.get(name);
    }
}
