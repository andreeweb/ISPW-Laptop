package it.uniroma2.dicii.ispw.frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginViewController {

    // Reference to the main application.
    private MainApp mainApp;

    @FXML
    private Button loginButton;

    @FXML
    private void initialize() {

        // set action
        loginButton.setOnAction(this::loginButtonAction);
    }

    // Login button
    private void loginButtonAction(ActionEvent event) {

        this.mainApp.showMainView();
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
