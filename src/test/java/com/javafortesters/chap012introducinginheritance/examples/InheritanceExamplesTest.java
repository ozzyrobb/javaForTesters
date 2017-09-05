package com.javafortesters.chap012introducinginheritance.examples;

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
}
