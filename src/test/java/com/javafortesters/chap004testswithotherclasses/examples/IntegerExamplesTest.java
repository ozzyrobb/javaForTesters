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
}
