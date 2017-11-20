package com.javafortesters.domainentities.exceptions;

/**
 * Created by robb on 10/09/2017.
 */
public class User {
    private String username;
    private String password;

    public User(){
        this("username", "Passw0rd", false);
    }

    private User(String username, String password, boolean b) {
        // only call this because we don't want to throw the exception
        this.username = username;
        try{
            setPassword(password);
        }catch(InvalidPassword e){
            throw new IllegalArgumentException(
                    "Default password incorrect ", e);
        }
    }

    public User(String username, String password) throws InvalidPassword{
        this.username = username;
        setPassword(password);
    }

    public void setPassword(String password) throws InvalidPassword {

        if(password.length()<7){
            throw new InvalidPassword("Password must be > 6 chars");
        }

        if (!password.matches(".*[0-9]+.*")){
            throw new InvalidPassword("Password must have a digit");
        }

        if (!password.matches(".*[A-Z]+.*")){
            throw new InvalidPassword("Password  must have an uppercase letter");
        }

        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
