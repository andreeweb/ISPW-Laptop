package it.uniroma2.dicii.ispw.controller;

import it.uniroma2.dicii.ispw.exception.DatabaseException;
import it.uniroma2.dicii.ispw.interfaces.UserDao;
import it.uniroma2.dicii.ispw.model.User;
import it.uniroma2.dicii.ispw.bean.UserBean;
import it.uniroma2.dicii.ispw.enumeration.Persistence;
import it.uniroma2.dicii.ispw.dao.UserDaoFactory;
import it.uniroma2.dicii.ispw.exception.UserDaoException;
import it.uniroma2.dicii.ispw.utils.Sha;

/**
 * Controller class for Login Use Case
 *
 * @author Andrea Cerra
 */

public class LoginController {

    private User user;

    // todo questo controller non fa la new dell'user, rivedere diagramma classi con associazione

    /**
     * Passing a UserBean, this method takes care of
     * validating the username and password received from the boundary.
     *
     * @param userBean user bean which contains username and password received from the boundary
     * @throws DatabaseException error with database connection or wrong type in config
     * @throws UserDaoException error in user search
     */
    public UserBean validateLogin(UserBean userBean) throws UserDaoException, DatabaseException {

        UserDao dao = UserDaoFactory.getSingletonInstance().getUserDAO(Persistence.PostgreSQL);
        user = dao.getUserByUsernameAndPassword(userBean.getUsername(), Sha.sha256(userBean.getPassword()));

        userBean.setRole(user.getRole());
        userBean.setName(user.getName());
        userBean.setSurname(user.getSurname());

        System.out.println("User Login: " + user.toString());

        return userBean;
    }
}
