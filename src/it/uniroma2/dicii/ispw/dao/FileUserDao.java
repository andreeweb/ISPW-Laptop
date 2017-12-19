package it.uniroma2.dicii.ispw.dao;

import it.uniroma2.dicii.ispw.interfaces.UserDao;
import it.uniroma2.dicii.ispw.model.User;
import it.uniroma2.dicii.ispw.exception.UserDaoException;

/**
 * Concrete implementation of UserDao interfaces
 * this implementation works with File.
 *
 * @author Andrea Cerra
 *
 */

public class FileUserDao implements UserDao{

    @Override
    public User getUserByUsernameAndPassword(String username, String password) throws UserDaoException {
        return null;
    }
}
