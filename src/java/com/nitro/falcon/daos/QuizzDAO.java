package com.nitro.falcon.daos;

import com.nitro.falcon.models.Quizz;
import javax.ejb.Local;

/**
 * QuizzDAO
 * @author leops
 */
@Local
public interface QuizzDAO {
    // Replace with UserDAOImpl to use JPA
    public static final String IMPL_NAME = "QuizzDAOMock";
    
    Quizz findById(final long id);
}
