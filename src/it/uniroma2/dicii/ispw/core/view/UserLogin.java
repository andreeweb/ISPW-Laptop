package it.uniroma2.dicii.ispw.core.view;

// boundary class per UC Login

import it.uniroma2.dicii.ispw.core.controller.LoginController;
import it.uniroma2.dicii.ispw.core.model.UserBean;

/**
 * Boundary class for Login Use Case
 *
 * @author Andrea Cerra
 */

public class UserLogin {

    /**
     * Exit/logout button action
     *
     * @param username username string from the view controller
     * @param password password string from the view controller
     * @return true is login credentials are valid, false otherwhise
     */
    public boolean login(String username, String password){

        UserBean user = new UserBean(username, password);

        LoginController controller = new LoginController();
        controller.validateLogin(user);

        return controller.validateLogin(user);
    }
}
