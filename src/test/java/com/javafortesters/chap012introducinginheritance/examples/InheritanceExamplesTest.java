package com.javafortesters.chap012introducinginheritance.examples;

import com.javafortesters.domainentities.AdminUser;
import com.javafortesters.domainentities.ReadOnlyUser;
import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by robb on 05/09/2017.
 */
public class InheritanceExamplesTest {

    @Test
    public void testGetUrlViaUserObject() {
        User newUser = new User();

        assertEquals("http://192.123.0.3:67", newUser.getUrl());
    }

    @Test
    public void aUserHasNormalPermissions() {
        User aUser = new User();
        assertEquals("Normal", aUser.getPermission());
    }

    @Test
    public void anAdminUserDefaultConstructor() {
        AdminUser adminUser = new AdminUser();
        assertEquals("adminuser", adminUser.getUsername());
        assertEquals("password", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }

    @Test
    public void anAdminUserHasElevatedPermissions() {
        AdminUser adminUser = new AdminUser("admin", "Passw0rd");
        assertEquals("admin", adminUser.getUsername());
        assertEquals("Passw0rd", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }

    @Test
    public void aReadOnlyUserDefaultContstructor() {
        ReadOnlyUser readOnlyUser = new ReadOnlyUser();
        assertEquals("username", readOnlyUser.getUsername());
        assertEquals("password", readOnlyUser.getPassword());
        assertEquals("ReadOnly", readOnlyUser.getPermission());
    }

//    @Test
//    public void aReadOnlyUserHasReadOnlyPermissions() {
//        ReadOnlyUser readOnlyUser = new ReadOnlyUser("readOnly", "p4ssw0rd");
//        assertEquals("readOnly", readOnlyUser.getUsername());
//        assertEquals("p4ssw0rd", readOnlyUser.getPassword());
//        assertEquals("ReadOnly", readOnlyUser.getPermission());
//    }
}
