package it.uniroma2.dicii.ispw.model;

import it.uniroma2.dicii.ispw.enumeration.Role;

/**
 * Class for entity User
 *
 * @author Andrea Cerra
 */
public class User {

    private String username;
    private String name;
    private String surname;
    private Role role;

    //private String password;

    /**
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the surname of the user
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param username the username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @param name the name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param surname the surname of the user
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return enumeration
     * @see Role
     */
    public Role getRole() {
        return role;
    }

    /**
     *
     * @param role new role for user
     * @see Role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     *
     * @return string formatted "name surname"
     */
    @Override
    public String toString() {
        return name + " " + surname;
    }

}
