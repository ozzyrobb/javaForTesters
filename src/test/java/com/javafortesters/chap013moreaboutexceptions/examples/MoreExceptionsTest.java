package com.javafortesters.chap013moreaboutexceptions.examples;

import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.exceptions.User;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by robb on 07/09/2017.
 */
public class MoreExceptionsTest {

    @Test
    public void canCreateDefaultUserWithoutHandlingException() {
        User aUser = new User();
        assertEquals("username", aUser.getUsername());
        assertEquals("password", aUser.getPassword());
    }

    @Test
    public void haveToCatchIllegalPasswordForParamConstructor() {
        try {
            User aUser = new User("me", "wrong");
            fail("An exception should have been thrown");
        } catch (InvalidPassword invalidPassword) {
            assertTrue("The exception was thrown", true);
        }
    }

    @Test(expected = InvalidPassword.class)
    public void constructUserWithException() throws InvalidPassword {
        User aUser = new User("username", "p");
    }

    @Test
    public void createDefaultUserWithNoThrowsInvalidPasswordException() {
        User aUser = new User();
        assertEquals("password", aUser.getPassword());
    }

    @Test
    public void createUserWithInvalidPasswordExceptionMessages() {
        User aUser;

        try {
            aUser = new User("username", "p");
            fail("An invalid Password Exception should have been thrown");
        } catch (InvalidPassword invalidPassword) {
            assertTrue(invalidPassword.getMessage().startsWith("Password must be > 6 chars"));
        }
    }

    @Test
    public void setPasswordWithInvalidPasswordExceptionMessages() {
        User aUSer = new User();

        try {
            aUSer.setPassword("tiny");
            fail("An Invalid Password Exception should have been thrown");
        } catch (InvalidPassword e) {
            assertTrue(e.getMessage().startsWith("Password must be > 6 chars"));
        }
    }
}
