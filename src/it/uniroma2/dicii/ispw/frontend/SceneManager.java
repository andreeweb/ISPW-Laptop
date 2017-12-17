package it.uniroma2.dicii.ispw.frontend;

import it.uniroma2.dicii.ispw.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SceneManager {

    // Reference to the root layout.
    private BorderPane rootLayout;

    /**
     *
     * The inner-class LazyCointainer is loaded only at the first invocation of getInstance.
     * This activity results "thread-safe".
     * @author gulyx, andreeweb
     *
     */
    private static class LazyCointainer{
        public final static SceneManager sigletonInstance = new SceneManager();
    }

    protected SceneManager() {
    }

    public static final SceneManager getSingletonInstance() {
        return LazyCointainer.sigletonInstance;
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param rootLayout
     */
    public void setRootLayout(BorderPane rootLayout) {
        this.rootLayout = rootLayout;
    }

    /**
     * Shows the login view inside the root layout.
     */
    public void showLoginView() {

        try {

            // Load login view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("LoginView.fxml"));
            BorderPane loginView = loader.load();

            // Set view into the center of root layout.
            rootLayout.setCenter(loginView);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the main view inside the root layout.
     */
    public void showMainView() {

        try {

            // Load main view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("MainView.fxml"));
            BorderPane mainView = loader.load();

            // Set view into the center of root layout.
            rootLayout.setCenter(mainView);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
