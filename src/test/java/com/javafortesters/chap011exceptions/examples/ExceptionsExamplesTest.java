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

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionExpected() {
        Integer age = null;
        age.toString();
    }

    @Test
    public void tryCatchFinallyANullPointerException() {
        Integer age = null;
        String ageAsString;
        String yourAge = "";

        try {
            ageAsString = age.toString();
        } catch (NullPointerException e) {
            age = 18;
            ageAsString = age.toString();
        } finally {

            // Code in the finally block will be executed regardless of whether or not an exception was thrown

            yourAge = "You are " + age.toString() + " years old";
        }

        assertEquals("You are 18 years old", yourAge);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exampleTryCatchFinally() {
        Integer age = null;

        try {
            System.out.println("1. Generate a null pointer exception");
            System.out.println(age.toString());
        } catch (NullPointerException e) {
            System.out.println("2. Handle null pointer exception");
            throw new IllegalArgumentException("Null pointer became illegal", e);
        } finally {
            System.out.println("3. Run code in finally section");
        }
    }
}
