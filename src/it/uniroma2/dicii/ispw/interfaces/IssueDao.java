package it.uniroma2.dicii.ispw.interfaces;

import it.uniroma2.dicii.ispw.enumeration.IssueState;
import it.uniroma2.dicii.ispw.exception.DaoException;
import it.uniroma2.dicii.ispw.model.Issue;

import java.util.List;

/**
 * Interface DAO for entity Issue
 *
 * @author Andrea Cerra
 */

public interface IssueDao {

    /**
     * Get all issue from database
     *
     * @return array
     */
    List<Issue> getIssues() throws DaoException;

    /**
     *
     * @return array
     * @throws DaoException
     */
    List<IssueState> getIssueStates() throws DaoException;
}
