package it.uniroma2.dicii.ispw.core.controller;

import it.uniroma2.dicii.ispw.core.interfaces.UserDao;
import it.uniroma2.dicii.ispw.core.model.User;
import it.uniroma2.dicii.ispw.core.model.UserBean;
import it.uniroma2.dicii.ispw.dao.Persistence;
import it.uniroma2.dicii.ispw.dao.UserDaoFactory;
import it.uniroma2.dicii.ispw.exception.UserDaoException;
import it.uniroma2.dicii.ispw.utils.Sha;

public class LoginController {

    private UserDao userDao;

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

    public boolean validateLogin(UserBean userBean){

        boolean isValidUser;

        User user = new User();
        user.setUsername(userBean.getUsername());
        user.setPassword(Sha.sha256(userBean.getPassword()));

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
