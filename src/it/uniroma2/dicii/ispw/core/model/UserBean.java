package it.uniroma2.dicii.ispw.core.model;

/**
 * Bean class for entity User
 *
 * @author Andrea Cerra
 */

public class UserBean {

    private String username;
    private String password;

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return the username of the user bean
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return the password of the user bean
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param username the username of the user bean
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @param password the password of the user bean
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
