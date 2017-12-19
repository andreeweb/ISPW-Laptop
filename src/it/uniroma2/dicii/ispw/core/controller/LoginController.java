package it.uniroma2.dicii.ispw.core.controller;

import it.uniroma2.dicii.ispw.core.exception.DatabaseException;
import it.uniroma2.dicii.ispw.core.interfaces.UserDao;
import it.uniroma2.dicii.ispw.core.model.User;
import it.uniroma2.dicii.ispw.core.model.UserBean;
import it.uniroma2.dicii.ispw.core.dao.Persistence;
import it.uniroma2.dicii.ispw.core.dao.UserDaoFactory;
import it.uniroma2.dicii.ispw.core.exception.UserDaoException;
import it.uniroma2.dicii.ispw.utils.Sha;

/**
 * Controller class for Login Use Case
 *
 * @author Andrea Cerra
 */

public class LoginController {

    /**
     * Passing a UserBean, this method takes care of
     * validating the username and password received from the boundary.
     *
     * @param userBean user bean which contains username and password received from the boundary
     * @throws DatabaseException error with database connection or wrong type in config
     * @throws UserDaoException error in user search
     */
    public void validateLogin(UserBean userBean) throws UserDaoException, DatabaseException {

        UserDao dao = UserDaoFactory.getSingletonInstance().getUserDAO(Persistence.MSSQL);
        User user = dao.getUserByUsernameAndPassword(userBean.getUsername(), Sha.sha256(userBean.getPassword()));

        System.out.println("User Login: " + user.toString());

    }
}
