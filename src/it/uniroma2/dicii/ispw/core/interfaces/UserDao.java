package it.uniroma2.dicii.ispw.core.interfaces;

import it.uniroma2.dicii.ispw.core.model.User;
import it.uniroma2.dicii.ispw.core.exception.UserDaoException;

/**
 * Interface DAO for entity User
 *
 * @author Andrea Cerra
 */

public interface UserDao {

    /**
     * Get User by username and password from database.
     *
     * @param username string containing the username
     * @param password string containing the password
     * @return instance of User
     * @throws UserDaoException if search fail or an error occurs.
     */
    User getUserByUsernameAndPassword(String username, String password) throws UserDaoException;

}
