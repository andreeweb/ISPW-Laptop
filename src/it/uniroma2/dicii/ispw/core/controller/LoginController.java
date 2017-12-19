package it.uniroma2.dicii.ispw.core.controller;

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

    private UserDao userDao;

    /**
     *
     * @return
     */
    private UserDao getUserDao(){

        UserDaoFactory factory = new UserDaoFactory();

        try{
            this.userDao = factory.getUserDAO(Persistence.PostgreSQL);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return userDao;

    }

    /**
     * Passing a UserBean, this method takes care of
     * validating the username and password received from the boundary.
     *
     * @param userBean user bean which contains username and password received from the boundary
     * @return boolean value, true if user have valid login credentials.
     */
    public boolean validateLogin(UserBean userBean){

        boolean isValidUser;
        User user;

        try {

            UserDao dao = this.getUserDao();
            user = dao.getUserByUsernameAndPassword(userBean.getUsername(), Sha.sha256(userBean.getPassword()));
            System.out.println("User Login: " + user.toString());
            isValidUser = true;

        } catch (UserDaoException userNotFound) {

            userNotFound.printStackTrace();
            isValidUser = false;

        }

        return isValidUser;
    }
}
