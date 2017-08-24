package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by robb on 24/08/2017.
 */
public class CollectionsTest {

    @Test
    public void simpleArrayExample() {
        String[] numbers0123Array = {"zero", "one", "two", "three"};
        List<String> numbers0123 = Arrays.asList(numbers0123Array);

        for (String numberText : numbers0123) {
            System.out.println(numberText);
        }

        assertEquals("zero", numbers0123.get(0));
        assertEquals("three", numbers0123.get(3));
    }

    // The above converts the array to a List using the asList method on the java.util.Arrays class.
    // The list is declared using the 'Generics' notation.

    @Test
    public void simpleDynamicCollectionExample() {
        List<String> numbers0123 = new ArrayList<String>();

        numbers0123.add("zero");
        numbers0123.add("one");
        numbers0123.add("two");
        numbers0123.add("three");

        for (String numberText : numbers0123) {
            System.out.println(numberText);
        }

        assertEquals("zero", numbers0123.get(0));
        assertEquals("three", numbers0123.get(3));
    }

    // Because collections are dynamic, I can add the String values into the List without worrying about the size of the list, because I know the List will resize.

    // List<String> numbers0123 = new ArrayList<String>();
    // In the above declaration List is an interface which declares the type of Collection I am using.
    // ArrayList is the specific implementation of List that I am using.
}
