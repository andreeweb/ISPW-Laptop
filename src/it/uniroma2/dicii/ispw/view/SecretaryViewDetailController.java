package it.uniroma2.dicii.ispw.view;

import it.uniroma2.dicii.ispw.bean.IssueBean;
import javafx.fxml.FXML;

public class SecretaryViewDetailController {

    @FXML
    private void initialize() {

    }

    /**
     *
     * @param issueBean userBean
     */
    public void onCreateView(IssueBean issueBean) {

        System.out.println(issueBean.toString());

    }

}
