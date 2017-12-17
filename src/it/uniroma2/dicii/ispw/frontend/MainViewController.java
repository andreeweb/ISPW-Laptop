package it.uniroma2.dicii.ispw.frontend;

import it.uniroma2.dicii.ispw.MainApp;
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

        SceneManager sm = SceneManager.getSingletonInstance();
        sm.showLoginView();
    }

}
