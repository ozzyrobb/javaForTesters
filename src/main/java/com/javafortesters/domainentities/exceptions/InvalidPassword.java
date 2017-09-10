package com.javafortesters.domainentities.exceptions;

/**
 * Created by robb on 07/09/2017.
 */
public class InvalidPassword extends Exception {
    public InvalidPassword(String message) {
        super(message);
    }
}
