package it.uniroma2.dicii.ispw.controller;

import it.uniroma2.dicii.ispw.bean.ClassroomBean;
import it.uniroma2.dicii.ispw.bean.FeatureBean;
import it.uniroma2.dicii.ispw.bean.IssueBean;
import it.uniroma2.dicii.ispw.dao.DaoFactory;
import it.uniroma2.dicii.ispw.enumeration.Persistence;
import it.uniroma2.dicii.ispw.exception.DaoException;
import it.uniroma2.dicii.ispw.interfaces.IssueDao;
import it.uniroma2.dicii.ispw.model.Issue;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for Issue Management Use Case
 *
 * @author Andrea Cerra
 */
public class IssueManagementController {

    public List<IssueBean> getIssueBeanList() throws DaoException {

        IssueDao dao = DaoFactory.getSingletonInstance().getIssueDAO(Persistence.PostgreSQL);
        List<Issue> list = dao.getIssues();
        List<IssueBean> beanList = new ArrayList<IssueBean>();

        for (Issue issue:list) {

            // read data
            IssueBean issueBean = new IssueBean();
            issueBean.setId(issue.getId());
            issueBean.setDescription(issue.getDescription());
            issueBean.setState(issue.getState());

            FeatureBean featureBean = new FeatureBean();
            featureBean.setName(issue.getFeature().getName());
            featureBean.setId(issue.getFeature().getId());

            ClassroomBean classroomBean = new ClassroomBean();
            classroomBean.setName(issue.getClassroom().getName());
            classroomBean.setId(issue.getClassroom().getId());

            issueBean.setFeature(featureBean);
            issueBean.setClassroom(classroomBean);

            System.out.println("AULA: " + classroomBean.getName());

            beanList.add(issueBean);

        }
        
        return beanList;

    }
}
