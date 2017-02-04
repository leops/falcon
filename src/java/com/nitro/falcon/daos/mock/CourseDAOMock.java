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
        for(int i = 1; i <= 5; i++) {
            final Course course = new Course();
            course.setName("Course " + i);
            course.setDescription("Description");
            course.setDuration((long) Math.ceil(Math.random() * 5));
            
            for(int j = 1; j <= course.getDuration(); j++) {
                course.getModules().add("Module " + j);
            }

            courses.put(course.getName(), course);
        }
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
