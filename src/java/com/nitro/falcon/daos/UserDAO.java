package com.nitro.falcon.daos;

import com.nitro.falcon.models.User;
import javax.ejb.Local;

/**
 * UserDAO
 * @author leops
 */
@Local
public interface UserDAO {
    // Replace with UserDAOImpl to use JPA
    public static final String IMPL_NAME = "UserDAOMock";
    
    User findByName(final String username);

    public void save(User user);
}
