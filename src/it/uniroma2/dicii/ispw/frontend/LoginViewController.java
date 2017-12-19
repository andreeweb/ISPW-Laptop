package it.uniroma2.dicii.ispw.frontend;

import it.uniroma2.dicii.ispw.core.exception.DatabaseException;
import it.uniroma2.dicii.ispw.core.exception.UserDaoException;
import it.uniroma2.dicii.ispw.core.view.UserLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * JavaFX Controller class for LoginViewController.fxml
 *
 * @author Andrea Cerra
 */

public class LoginViewController {

    @FXML
    public TextField passwordText;

    @FXML
    public TextField usernameText;

    @FXML
    public Label errorLabel;

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

        UserLogin ul = new UserLogin();

        try {

            ul.login(usernameText.getText(), passwordText.getText());

            SceneManager sm = SceneManager.getSingletonInstance();
            sm.showMainView();

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
