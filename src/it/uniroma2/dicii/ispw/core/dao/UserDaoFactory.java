package it.uniroma2.dicii.ispw.core.dao;

import it.uniroma2.dicii.ispw.core.exception.DatabaseException;
import it.uniroma2.dicii.ispw.core.interfaces.UserDao;

/**
 * Factory class for Data Access Object class
 *
 * @author Andrea Cerra
 */

public class UserDaoFactory {

    private static UserDaoFactory instance = null;

    protected UserDaoFactory(){

    }

    /**
     * Return an istance of concrete daope
     *
     * @param type check enum Persistence
     * @return UserDao object
     * @throws DatabaseException error with database connection or wrong type in config
     */
    public UserDao getUserDAO(Persistence type) throws DatabaseException{

        switch (type) {

            case PostgreSQL: return new PGUserDao();
            case File: return new FileUserDao();
            case MySQL: return new MySqlUserDao();
            default: throw new DatabaseException("Invalid type : " + type);

        }
    }

    /**
     * Return or inizialize the factory singleton istance
     *
     * @return reference to singleton istance
     */
    public synchronized static final UserDaoFactory getSingletonInstance() {

        if (UserDaoFactory.instance == null)
            UserDaoFactory.instance = new UserDaoFactory();
        return instance;
    }
}
