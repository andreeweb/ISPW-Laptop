package it.uniroma2.dicii.ispw.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Elephant");
        this.primaryStage.getIcons().add(new Image("file:resources/images/elephant-128.png"));

        initRootLayout();
        showLoginView();

    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {

        try {

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("RootView.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the login view inside the root layout.
     */
    public void showLoginView() {

        try {

            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("LoginView.fxml"));
            BorderPane loginView = loader.load();

            // Set view into the center of root layout.
            rootLayout.setCenter(loginView);

            // Give the controller access to the main app.
            LoginViewController controller = loader.getController();
            controller.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the main view inside the root layout.
     */
    public void showMainView() {

        try {

            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("MainView.fxml"));
            BorderPane mainView = loader.load();

            // Set view into the center of root layout.
            rootLayout.setCenter(mainView);

            // Give the controller access to the main app.
            MainViewController controller = loader.getController();
            controller.setMainApp(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
