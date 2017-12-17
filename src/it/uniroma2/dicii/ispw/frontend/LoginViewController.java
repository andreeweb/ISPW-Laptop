package it.uniroma2.dicii.ispw.frontend;

import it.uniroma2.dicii.ispw.MainApp;
import it.uniroma2.dicii.ispw.core.view.UserLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    // Login button
    private void loginButtonAction(ActionEvent event) {

        boolean validLogin;

        UserLogin ul = new UserLogin();
        validLogin = ul.login(usernameText.getText(), passwordText.getText());

        if (validLogin){

            SceneManager sm = SceneManager.getSingletonInstance();
            sm.showMainView();

        }else{

            errorLabel.setManaged(true);
        }


    }
}
