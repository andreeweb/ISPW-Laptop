package it.uniroma2.dicii.ispw.dao.db;

import it.uniroma2.dicii.ispw.core.model.User;
import it.uniroma2.dicii.ispw.exception.MoreThanOneUserInDB;
import it.uniroma2.dicii.ispw.exception.UserNotFound;

import java.sql.*;

public class UserDao {

    public static User getUser(User user) throws UserNotFound, MoreThanOneUserInDB{

        Statement stmt = null;

        try {

            // get connection
            // TODO add exception in singleton
            Connection connection = ConnectionManager.getSingletonInstance().getConnection();

            // create statement
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // query
            String sql = "SELECT * " + "FROM users where username = '" + user.getUsername() + "' AND password = '" + user.getPassword() + "';";

            // execute
            ResultSet rs = stmt.executeQuery(sql);

            // rs not empty
            if (!rs.first())
                throw new UserNotFound("User not found in database");

            // ops..
            boolean moreThanOne = rs.first() && rs.next();
            if (moreThanOne)
                throw new MoreThanOneUserInDB("Multiple user in DB with same credentials");

            // set cursor
            rs.first();

            // read data
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setPassword("");

            // Clean-up
            rs.close();
            stmt.close();

        } catch (UserNotFound userNotFound){

            userNotFound.printStackTrace();
            throw userNotFound;

        } catch (MoreThanOneUserInDB moreThanOneUserInDB){

            moreThanOneUserInDB.printStackTrace();
            throw moreThanOneUserInDB;

        } catch (SQLException sqlException) {

            // TODO system exit? really?

            sqlException.printStackTrace();
            System.exit(1);

        } finally {

            try {

                if (stmt != null)
                    stmt.close();

            } catch (SQLException sqlException) {

                sqlException.printStackTrace();
                System.exit(1);
            }
        }

        return user;
    }

}
