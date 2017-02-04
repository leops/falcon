package com.nitro.falcon.daos.mock;

import com.nitro.falcon.daos.UserDAO;
import com.nitro.falcon.models.User;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

/**
 * UserDAOMock
 * @author leops
 */
@Stateless
public class UserDAOMock implements UserDAO {
    private static final Map<String, User> users = new HashMap<>();

    @Override
    public User findByName(final String username) {
        return users.get(username);
    }

    @Override
    public void save(final User user) {
        users.put(user.getUsername(), user);
    }
}
