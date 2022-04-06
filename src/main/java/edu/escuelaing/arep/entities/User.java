package edu.escuelaing.arep.entities;

/**
 * Class that represents an application user.
 * @author Camilo Pichimata - Zuly Vargas
 */
public class User {
    String user;
    String password;

    /**
     * Creates an user.
     * @param user - name user.
     * @param password - password user.
     */
    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    /**
     * Returns the name user.
     * @return user - name user.
     */
    public String getUser() {
        return user;
    }

    /**
     * Update the user name
     * @param user - new user name.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Returns the password.
     * @return password - password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Update the password.
     * @param password - new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
