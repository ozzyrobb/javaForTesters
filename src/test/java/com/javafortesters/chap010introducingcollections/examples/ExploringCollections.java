package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by robb on 26/08/2017.
 */
public class ExploringCollections {

    @Test
    public void addToCollection() {
        List<String> days = new ArrayList<>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        days.remove(0);
        days.add(0, "Monday");

        assertEquals("Tuesday", days.get(1));

    }
}
