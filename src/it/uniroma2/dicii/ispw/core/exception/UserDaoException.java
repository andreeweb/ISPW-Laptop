package it.uniroma2.dicii.ispw.core.exception;

/**
 * DAO Exception for UserDao
 *
 * @author Andrea Cerra
 */

public class UserDaoException extends Exception{

    /**
     *
     * @param message Exception message
     */
    public UserDaoException(String message) {
        super(message);
    }

    /**
     *
     * @param message Exception message
     * @param cause Throwable cause
     */
    public UserDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param cause Throwable cause
     */
    public UserDaoException(Throwable cause) {
        super(cause);
    }
}
