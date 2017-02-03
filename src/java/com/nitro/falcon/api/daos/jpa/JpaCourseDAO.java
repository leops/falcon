package com.nitro.falcon.api.daos.jpa;

import com.nitro.falcon.api.daos.CourseDAO;
import com.nitro.falcon.models.Course;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * JpaUserDAO
 * @author leops
 */
@Stateless
public class JpaCourseDAO implements CourseDAO {
    @PersistenceContext(name="Falcon-PU")
    private EntityManager em;

    @Override
    public List<Course> listCourses() {
        return em.createQuery("SELECT c FROM Course c").getResultList();
    }
}
