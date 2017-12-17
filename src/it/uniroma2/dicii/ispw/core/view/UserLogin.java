package it.uniroma2.dicii.ispw.core.view;

// boundary class per UC Login

import it.uniroma2.dicii.ispw.core.controller.LoginController;
import it.uniroma2.dicii.ispw.core.model.UserBean;

public class UserLogin {

    public UserLogin() {

    }

    public boolean login(String username, String password){

        UserBean user = new UserBean(username, password);

        LoginController controller = new LoginController();
        controller.validateLogin(user);

        return controller.validateLogin(user);
    }
}
