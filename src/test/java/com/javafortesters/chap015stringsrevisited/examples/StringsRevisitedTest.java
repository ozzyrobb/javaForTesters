package com.javafortesters.chap015stringsrevisited.examples;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringsRevisitedTest {

    @Test
    public void printUsingSpecialCharacters() {
        System.out.println("Bob said \"hello\" to his cat's friend");
        System.out.println("This is a single backslash \\");
    }

    @Test
    public void stringConcatenation() {
        String ps1 = "This is " + "String2";
        assertThat(ps1, is("This is String2"));
        String ps2 = "This is " + 4;
        assertThat(ps2, is("This is 4"));

        String thisIs = "This is ";
        String s1 = thisIs.concat("String1");
        assertThat(s1, is("This is String1"));
    }

    @Test
    public void convertingToAString() {
        String intConcatConvert = "" + 1;
        assertThat(intConcatConvert, is("1"));

        String integerIntConvert = Integer.toString(2);
        assertThat(integerIntConvert, is("2"));

        String integerStringConvert = String.valueOf(3);
        assertThat(integerStringConvert, is("3"));
    }

    @Test
    public void convertingFromAString() {
        assertThat(Integer.valueOf("2"), is(2));

        char[] cArray = {'2', '3'};
        assertThat("23".toCharArray(), is(cArray));
    }

    // When we convert between byte and String we may need to control the encoding.
    // If we use an incorrect encoding then an UnsupportedEncodingException will be thrown:

    @Test
    public void canConvertBytesUTF8() throws UnsupportedEncodingException {
        byte[] b8Array = "hello there".getBytes("UTF8");
    }

    @Test public void compareTo() {
        String hello = "Hello";
        assertThat(hello.compareTo("Hello"), is(0));

        // If the argument String is smaller than the String then compareTo returns a negative number:

        assertThat(hello.compareTo("hello") < 0, is(true));
        assertThat(hello.compareTo("Helloo") < 0, is(true));
        assertThat(hello.compareTo("Hemlo") < 0, is(true));

        // If the argument String is larger than the String then compareTo returns a positive number:

        assertThat(hello.compareTo("H") > 0, is(true));
        assertThat(hello.compareTo("Helln") > 0, is(true));
        assertThat(hello.compareTo("HeLlo") > 0, is(true));
    }

    @Test
    public void compareToIgnoreCase() {
        String hello = "Hello";
        assertThat(hello.compareToIgnoreCase("hello"), is(0));
        assertThat(hello.compareToIgnoreCase("Hello"), is(0));
        assertThat(hello.compareToIgnoreCase("heLlo"), is(0));
    }

    @Test
    public void contains() {
        String hello = "Hello";
        assertThat(hello.contains("He"), is(true));
        assertThat(hello.contains("Hello"), is(true));

        // Case is important when using contains:

        assertThat(hello.contains("LL"), is(false));

        assertThat(hello.contains("z"), is(false));
    }

    @Test
    public void contentEquals() {
        String hello = "Hello";

        // The contentEqual method will work with any object that implements the charSequence interface, or against a StringBuffer (e.g. a StringBuilder)

        assertThat(hello.contentEquals("Hello"), is(true));
        assertThat(hello.contentEquals("hello"), is(false));

        // The equals method enforces the additional rule that the parameter must be a String, as well as having equal content:

        assertThat(hello.equals("Hello"), is(true));

        // The equalsIgnoreCase method works the same as equals but ignores the case in the comparison:

        assertThat(hello.equalsIgnoreCase("hello"), is(true));
    }

    @Test
    public void endsWithAndStartsWith() {
        String hello = "Hello";
        assertThat(hello.endsWith("Hello"), is(true));
        assertThat(hello.endsWith(""), is(true));
        assertThat(hello.endsWith("lo"), is(true));

        assertThat(hello.startsWith("Hello"), is(true));
        assertThat(hello.startsWith(""), is(true));
        assertThat(hello.startsWith("He"), is(true));

        // Both endsWith and startsWith implement case sensitive searches:

        assertThat(hello.endsWith("Lo"), is(false));
        assertThat(hello.startsWith("he"), is(false));
    }

    @Test
    public void isEmpty() {
        String empty = "";
        assertThat(empty.isEmpty(), is(true));
        assertThat(empty.length(), is(0));
    }
}