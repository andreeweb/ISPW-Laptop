package it.uniroma2.dicii.ispw.frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainViewController {

    // Reference to the main application.
    private MainApp mainApp;

    @FXML
    private Button exitButton;

    @FXML
    private void initialize() {

        // set action
        exitButton.setOnAction(this::exitButtonAction);
    }

    // Login button
    private void exitButtonAction(ActionEvent event) {

        this.mainApp.showLoginView();
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
