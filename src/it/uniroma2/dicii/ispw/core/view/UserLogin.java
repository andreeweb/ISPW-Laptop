package it.uniroma2.dicii.ispw.core.view;

import it.uniroma2.dicii.ispw.core.controller.LoginController;
import it.uniroma2.dicii.ispw.core.exception.DatabaseException;
import it.uniroma2.dicii.ispw.core.exception.UserDaoException;
import it.uniroma2.dicii.ispw.core.model.UserBean;

/**
 * Boundary class for Login Use Case
 *
 * @author Andrea Cerra
 */

public class UserLogin {

    /**
     *
     * @param username username string from the view controller
     * @param password password string from the view controller
     * @throws DatabaseException error with database connection or wrong type in config
     * @throws UserDaoException error in user search
     */
    public void login(String username, String password) throws DatabaseException, UserDaoException {

        UserBean user = new UserBean(username, password);

        LoginController controller = new LoginController();
        controller.validateLogin(user);

    }
}
