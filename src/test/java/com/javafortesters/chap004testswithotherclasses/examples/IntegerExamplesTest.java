package com.javafortesters.chap004testswithotherclasses.examples;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by robb on 1/05/2017.
 */
public class IntegerExamplesTest {

    @Test
    public void integerExploration() {
        Integer four = new Integer(4);
        assertEquals("intValue returns 4", 4, four.intValue());
        Integer five = new Integer("5");
        assertEquals("intValue returns int 5", 5, five.intValue());
        Integer six = 6;
        assertEquals("autoboxing assignment for 6", 6, six.intValue());
    }

    @Test
    public void toHexString() {
        String hex = Integer.toHexString(21);
        assertEquals("toHexString returns b", "15", hex);
    }

    @Test
    public void maxInt() {
        int max = Integer.MAX_VALUE;
        assertEquals("Integer.MAX_VALUE returns 2147483647", 2147483647, max);
        int min = Integer.MIN_VALUE;
        assertEquals("Integer.MIN_VALUE returns -2147483648", -2147483648, min);

    }

    @Test
    public void toBinaryString() {
        assertEquals("toBinaryString returns 1000","1000", Integer.toBinaryString(8));
        assertEquals("toBinaryString returns 10000", "10000", Integer.toBinaryString(16));
        assertEquals("toBinaryString returns 1010", "1010", Integer.toBinaryString(10));
    }

    @Test
    public void compareTo() {
        assertEquals("compareTo returns 0", 0, Integer.valueOf(5).compareTo(5));
        assertEquals("compareTo returns 1", 1, Integer.valueOf(6).compareTo(5));
        assertEquals("compareTo returns -1", -1, Integer.valueOf(5).compareTo(6));
    }

    @Test
    public void compare() {
        assertEquals("compare returns 0", 0, Integer.compare(5, 5));
        assertEquals("compare returns 1", 1, Integer.compare(6, 5));
        assertEquals("compare returns -1", -1, Integer.compare(5, 6));
    }

    /*
    The above provides examples of instantiating a class, using static methods, and also demonstrates how you can use tests to explore new libraries.
     You should however use caution when instantiating classes in your code, because while an int equals an int, an Integer does not always equal an Integer.

    For example:

     assertEquals(4,4);
     assertTrue(4==4);

     Both of the above would pass, but if I did the following:

     Integer firstFour = new Integer(4);
     Integer secondFour = new Integer(4);

     assertEquals(firstFour, secondFour);
     assertEquals(firstFour==secondFour);

     Then the second test would fail.

     This is because primitives are simple, and there's no difference between value and identity. Every 4 in the code refers to the same 4.
     Objects are different. We instantiate them, so firstFour and secondFour refer to different objects, even though they have the same 'value'.

     With assertEquals, JUnit uses the equals method to compare the value. When using the '==' operator, Java is checking if the two object variables
     refer to the same instantiation.
     */
}
