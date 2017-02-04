package com.nitro.falcon.daos.jpa;

import com.nitro.falcon.daos.QuizzDAO;
import com.nitro.falcon.models.Quizz;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * QuizzDAOImpl
 * @author leops
 */
public class QuizzDAOImpl implements QuizzDAO {
    @PersistenceContext(name="Falcon-PU")
    private EntityManager em;
    
    @Override
    public Quizz findById(long id) {
        return em.find(Quizz.class, id);
    }
}
