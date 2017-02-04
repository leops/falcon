package com.nitro.falcon.daos.jpa;

import com.nitro.falcon.daos.UserDAO;
import com.nitro.falcon.models.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * UserDAOImpl
 * @author leops
 */
@Stateless
public class UserDAOImpl implements UserDAO {
    @PersistenceContext(name="Falcon-PU")
    private EntityManager em;
    
    @Override
    public User findByName(String username) {
        return em.find(User.class, username);
    }

    @Override
    public void save(final User user) {
        em.persist(user);
    }
}
