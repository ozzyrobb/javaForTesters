package com.javafortesters.chap011exceptions.examples;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by robb on 02/09/2017.
 */
public class ExceptionsExamplesTest {

    @Test
    public void throwANullPointerException() {
        Integer age = null;
        String ageAsString;

        try {
            ageAsString = age.toString();
        } catch (NullPointerException e) {
            System.out.println("getMessage - " + e.getMessage());
            System.out.println("getStackTrace - " + Arrays.toString(e.getStackTrace()));
            System.out.println("printStackTrace");
            e.printStackTrace();
            age = 18;
            ageAsString = age.toString();
        }

        String yourAge = "You are " + ageAsString + " years old";

        assertEquals("You are 18 years old", yourAge);
    }
}
