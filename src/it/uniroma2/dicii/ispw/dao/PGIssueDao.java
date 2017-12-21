package it.uniroma2.dicii.ispw.dao;

import it.uniroma2.dicii.ispw.enumeration.IssueState;
import it.uniroma2.dicii.ispw.exception.DaoException;
import it.uniroma2.dicii.ispw.interfaces.IssueDao;
import it.uniroma2.dicii.ispw.model.Classroom;
import it.uniroma2.dicii.ispw.model.Feature;
import it.uniroma2.dicii.ispw.model.Issue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PGIssueDao implements IssueDao {

    private String USER = "ispw";
    private String PASS = "ispw";
    private String DB_URL = "jdbc:postgresql://localhost/ispw_a";
    private String DRIVER_CLASS_NAME = "org.postgresql.Driver";

    @Override
    public List<Issue> getIssues() throws DaoException{

        List<Issue> list = new ArrayList<Issue>();

        Statement stmt = null;
        Connection conn = null;

        try {

            // get connection
            Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // create statement
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // query
            String sql = "SELECT issue.issue_id, issue.description, issue.state, classroom.classroom_id, classroom.name " +
                         "AS classroom_name, abstract_feature.name " +
                         "AS feature_name, abstract_feature.feature_id " +
                         "AS feature_id " +
                         "FROM issue " +
                         "JOIN concrete_feature ON (issue.concrete_feature = concrete_feature.classroom_id) " +
                         "JOIN classroom ON (concrete_feature.classroom_id = classroom.classroom_id) " +
                         "JOIN abstract_feature ON (concrete_feature.abstract_id = abstract_feature.feature_id);";

            // execute
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {

                // read data
                Issue issue = new Issue();
                issue.setId(rs.getInt("issue_id"));
                issue.setDescription(rs.getString("description"));
                issue.setState(IssueState.valueOf(rs.getString("state")));

                Feature feature = new Feature();
                feature.setName(rs.getString("feature_name"));
                feature.setId(rs.getInt("feature_id"));

                Classroom classroom = new Classroom();
                classroom.setName(rs.getString("classroom_name"));
                classroom.setId(rs.getInt("classroom_id"));

                issue.setFeature(feature);
                issue.setClassroom(classroom);

                list.add(issue);
            }

            System.out.println("Found " + list.size() + " issue in db");

            // Clean-up
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {

            // driver not found, go out
            e.printStackTrace();
            System.exit(1);

        } catch (SQLException e) {
            throw new DaoException(e.getMessage());

        } finally {

            try {

                if (stmt != null)
                    stmt.close();

                if (conn != null)
                    conn.close();

            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
        }

        return list;

    }
}