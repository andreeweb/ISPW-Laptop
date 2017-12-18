package it.uniroma2.dicii.ispw.core.controller;

import it.uniroma2.dicii.ispw.core.model.User;
import it.uniroma2.dicii.ispw.core.model.UserBean;
import it.uniroma2.dicii.ispw.dao.db.UserDao;
import it.uniroma2.dicii.ispw.exception.MoreThanOneUserInDB;
import it.uniroma2.dicii.ispw.exception.UserNotFound;
import it.uniroma2.dicii.ispw.utils.Sha;

public class LoginController {

    public LoginController() {
    }

    public boolean validateLogin(UserBean userBean){

        boolean validUser;

        User user = new User();
        user.setUsername(userBean.getUsername());
        user.setPassword(Sha.sha256(userBean.getPassword()));

        try {

            user = UserDao.getUser(user);
            System.out.println("USER: " + user.toString());

            validUser = true;

        } catch (UserNotFound userNotFound) {

            userNotFound.printStackTrace();
            validUser = false;

        } catch (MoreThanOneUserInDB moreThanOneUserInDB) {

            moreThanOneUserInDB.printStackTrace();
            validUser = false;

        }

        return validUser;
    }
}
