package it.uniroma2.dicii.ispw;

import it.uniroma2.dicii.ispw.view.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Elephant");
        primaryStage.getIcons().add(new Image("file:resources/images/elephant-128.png"));

        // onCreateView with root layout

        try {

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("view/RootView.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // call SceneManager
        SceneManager sm = SceneManager.getSingletonInstance();
        sm.setRootLayout(rootLayout);

        // show login view
        sm.showLoginView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
