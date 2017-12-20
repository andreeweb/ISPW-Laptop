package it.uniroma2.dicii.ispw.view;

import it.uniroma2.dicii.ispw.bean.UserBean;
import it.uniroma2.dicii.ispw.model.Issue;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * JavaFX (controller) class for SecretaryView.fxml
 *
 * @author Andrea Cerra
 */

public class SecretaryViewController {

    private UserBean userBean;

    @FXML
    private Label nameLabel;

    @FXML
    private Button exitButton;

    @FXML
    private TableView<Issue> issueTableView;
    @FXML
    private TableColumn<Issue, String> issueName;
    @FXML
    private TableColumn<Issue, String> issueDescription;

    private ObservableList<Issue> issueData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        // set action
        exitButton.setOnAction(this::exitButtonAction);

        // Listen for selection changes and show the person details when changed.
        issueTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showIssueDetails(newValue));
    }

    private void showIssueDetails(Issue issue) {


    }

    /**
     *
     * @param userBean userBean
     */
    public void setUserBean(UserBean userBean) {

        this.userBean = userBean;
        nameLabel.setText("Benvenuto " + userBean.getName());

        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 2", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto3","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));
        issueData.add(new Issue("Guasto1","Guasto alla lavagna in aula 1", "Confermato"));

        issueTableView.setItems(issueData);

        issueName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        issueDescription.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));

    }

    /**
     * Exit/logout button action
     *
     * @param event JavaFX event
     */
    private void exitButtonAction(ActionEvent event) {

        SceneManager sm = SceneManager.getSingletonInstance();
        sm.showLoginView();
    }
}
