package it.uniroma2.dicii.ispw.core.interfaces;

import it.uniroma2.dicii.ispw.core.model.User;
import it.uniroma2.dicii.ispw.core.exception.UserDaoException;

public interface UserDao {

    /**
     * Get user from persistence
     *
     * @param username string containing the username
     * @return a User object
     * @exception UserDaoException if the search fails and the user is not found.
     */
    User getUserByUsernameAndPassword(String username, String password) throws UserDaoException;

}
