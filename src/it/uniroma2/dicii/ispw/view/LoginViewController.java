package it.uniroma2.dicii.ispw.view;

import it.uniroma2.dicii.ispw.controller.LoginController;
import it.uniroma2.dicii.ispw.exception.DatabaseException;
import it.uniroma2.dicii.ispw.exception.UserDaoException;
import it.uniroma2.dicii.ispw.bean.UserBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Boundary class for Login Use Case
 * JavaFX (controller) class for LoginViewController.fxml
 *
 * @author Andrea Cerra
 */

public class LoginViewController {

    @FXML
    private TextField passwordText;

    @FXML
    private TextField usernameText;

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    @FXML
    private void initialize() {

        // set action
        loginButton.setOnAction(this::loginButtonAction);

        //hide calculation in frame for the error label
        errorLabel.setManaged(false);
    }

    /**
     * Login button action
     *
     * @param event JavaFX event
     */
    private void loginButtonAction(ActionEvent event) {

        UserBean userBean = new UserBean(usernameText.getText(), passwordText.getText());

        try {

            LoginController controller = new LoginController();
            userBean = controller.validateLogin(userBean);

            switch (userBean.getRole()){

                case SECRETARY:
                    SceneManager.getSingletonInstance().showSecretaryView(userBean);
                    break;
                case TECHNICIAN:
                    break;
            }

        } catch (DatabaseException e) {

            errorLabel.setManaged(true);
            errorLabel.setText("Errore di connessione al database.");
            e.printStackTrace();

        } catch (UserDaoException e) {

            errorLabel.setManaged(true);
            errorLabel.setText("Username e/o password errati.");
            e.printStackTrace();
        }

    }
}
