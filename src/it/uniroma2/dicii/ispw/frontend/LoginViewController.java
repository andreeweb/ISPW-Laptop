package it.uniroma2.dicii.ispw.frontend;

import it.uniroma2.dicii.ispw.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginViewController {



    @FXML
    private Button loginButton;

    @FXML
    private void initialize() {

        // set action
        loginButton.setOnAction(this::loginButtonAction);
    }

    // Login button
    private void loginButtonAction(ActionEvent event) {

        SceneManager sm = SceneManager.getSingletonInstance();
        sm.showMainView();
    }
}
