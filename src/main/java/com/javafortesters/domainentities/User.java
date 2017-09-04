package com.javafortesters.domainentities;

/**
 * Created by robb on 8/05/2017.
 */
public class User {

//    field variables:

    private String username;
    private String password;

//    no-argument constructor:

    public User() {
        this("username", "password");
    }

//    argument constructor:

    public User(String username, String password) {
        this.username = username;
        setPassword(password);

//        we have to use the 'this' keyword because these parameters have the same name as the fields
    }

//    an argument constructor allows us to create a User object and set the username and password at the same time


//    accessor / getter method for username:

    public String getUsername() {
        return username;
    }

//    accessor / getter method for password:

    public String getPassword() {
        return password;
    }

//    getter methods are required because we made the field variables private, to retain control over their values


//    setter method for password:

    public void setPassword(String password) {
        if (password.length() < 7) {
            throw new IllegalArgumentException("Password must be greater than 6 chars");
        }
        this.password = password;
    }
}
