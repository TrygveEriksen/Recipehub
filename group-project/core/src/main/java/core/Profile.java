package core;

import java.util.regex.Pattern;

/**
 * This class is used to contain Profile information
 * @author Adrian Haabpiht Solberg
 */
public class Profile {
    private String username;
    private String password;

    /**
     * This constructor initializes the username and password
     * @param username - String value to set as username
     * @param password - String value to set as password
     */
    public Profile(String username, String password) {
        isValidUsername(username);
        this.username = username;
        isValidPassword(password);
        this.password = password;
    }

    /**
     * This metod checks if a username is valid according to the following criterias:
     * - Must have length of at least 5
     * - Must only contain letters and numbers
     * @param username - String value to check
     * @throws IllegalArgumeentException if username is invalid
     */
    private void isValidUsername(String username) {
        if (username.length() < 5) {
            throw new IllegalArgumentException("Username is too short");
        }
        if (!Pattern.matches("^[a-zA-Z0-9]+$", username)) {
            throw new IllegalArgumentException("Username must only contain letters and numbers");
        }
    }

    /**
     * This metod checks if a password is valid according to the following criterias:
     * - Must have length of at least 8
     * - Must contain a lower case letter
     * - Must contain an upper case letter
     * 
     * @param password - String value to check
     * @throws IllegalArgumeentException if password is invalid
     */
    private void isValidPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password is too short");
        }
        if (!Pattern.matches(".*[a-z].*", password)) {
            throw new IllegalArgumentException("Password must contain a lower case letter");
        }
        if (!Pattern.matches(".*[A-Z].*", password)) {
            throw new IllegalArgumentException("Password must contain an upper case letter");
        }
    }

    /**
     * This method will return the username of the given profile
     * @return String value for username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method will return the password of the given profile
     * @return String value for password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method will set thee prfile's username to the string sent in if the string is a valid username
     * @param username - String value to set as username
     */
    public void setUsername(String username) {
        isValidUsername(username);
        this.username = username;
    }

    /**
     * This method will set thee prfile's password to the string sent in if the string is a valid password
     * @param password - String value to set as password
     */
    public void setPassword(String password) {
        isValidPassword(password);
        this.password = password;
    }
}