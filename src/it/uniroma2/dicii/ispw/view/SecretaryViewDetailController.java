package it.uniroma2.dicii.ispw.view;

import it.uniroma2.dicii.ispw.bean.IssueBean;
import it.uniroma2.dicii.ispw.controller.IssueManagementController;
import it.uniroma2.dicii.ispw.enumeration.IssueState;
import it.uniroma2.dicii.ispw.exception.DaoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.util.List;

public class SecretaryViewDetailController {

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private Text featureTextField;

    @FXML
    private Text classroomTextField;

    @FXML
    private ComboBox statusCombo;

    @FXML
    private Button confirmButton;

    @FXML
    private Button discardButton;

    private ObservableList<IssueState> issueStates = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        confirmButton.setOnAction(this::confirmButtonAction);
        discardButton.setOnAction(this::discardButtonAction);
    }

    private void discardButtonAction(ActionEvent actionEvent) {

    }

    private void confirmButtonAction(ActionEvent actionEvent) {

    }

    /**
     *
     * @param issueBean userBean
     */
    public void onCreateView(IssueBean issueBean) {

        System.out.println(issueBean.toString());

        descriptionTextArea.setText(issueBean.getDescription());
        featureTextField.setText(issueBean.getFeature().getName());
        classroomTextField.setText(issueBean.getClassroom().getName());

        IssueManagementController controller = new IssueManagementController();

        try {

            List<IssueState> list = controller.getIssueStateList();

            issueStates.addAll(list);
            statusCombo.setItems(issueStates);

        } catch (DaoException e) {
            e.printStackTrace();
            // todo no data available
        }
    }

}
