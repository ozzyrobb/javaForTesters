package com.javafortesters.domainentities;

/**
 * Created by robb on 06/09/2017.
 */
public class ReadOnlyUser extends User {

//    public ReadOnlyUser() {
//        this("username", "password");
//    }
//
//    public ReadOnlyUser(String username, String password) {
//        super(username, password);
//    }

    @Override
    public String getPermission() {
        return "ReadOnly";
    }
}
