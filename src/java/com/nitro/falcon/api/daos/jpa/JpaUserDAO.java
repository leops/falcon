package com.nitro.falcon.api.daos.jpa;

import com.nitro.falcon.api.daos.UserDAO;
import com.nitro.falcon.models.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * JpaUserDAO
 * @author leops
 */
@Stateless
public class JpaUserDAO implements UserDAO {
    @PersistenceContext(name="Falcon-PU")
    private EntityManager em;
    
    @Override
    public User findByName(String username) {
        return em.find(User.class, username);
    }
}
