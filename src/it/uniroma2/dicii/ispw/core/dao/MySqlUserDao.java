package it.uniroma2.dicii.ispw.core.dao;

import it.uniroma2.dicii.ispw.core.interfaces.UserDao;
import it.uniroma2.dicii.ispw.core.model.User;
import it.uniroma2.dicii.ispw.core.exception.UserDaoException;

/**
 * Concrete implementation of UserDao interfaces
 * this implementation works with MySQL database.
 *
 * @author Andrea Cerra
 *
 */
public class MySqlUserDao implements UserDao {

    @Override
    public User getUserByUsernameAndPassword(String username, String password) throws UserDaoException {
        return null;
    }
}
