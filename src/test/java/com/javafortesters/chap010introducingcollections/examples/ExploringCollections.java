package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by robb on 26/08/2017.
 */
public class ExploringCollections {

    @Test
    public void addToCollection() {
        List<String> workdays = new ArrayList<>();
        List<String> daysOfWeek = new ArrayList<>();
        List<String> weekendDays = new ArrayList<>();

        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        weekendDays.add("Saturday");
        weekendDays.add("Funday");
        weekendDays.remove("Funday");
        weekendDays.add("Sunday");

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        for (String dayOfWeek : daysOfWeek) {
            System.out.println(dayOfWeek);
        }

        assertEquals("workdays contains 5 elements",5, workdays.size());
        assertTrue("daysOfWeek contains 5 elements", daysOfWeek.containsAll(workdays));
        assertFalse("weekendDays does not contain Funday",weekendDays.contains("Funday"));
        assertEquals("weekendDays contains 2 elements", 2, weekendDays.size());
        assertTrue("Bug fixed, Sunday is in the collection now", weekendDays.contains("Sunday"));

        assertEquals("daysOfWeek contains 7 elements", 7, daysOfWeek.size());
        daysOfWeek.clear();
        assertEquals("daysOfWeek is now empty", 0, daysOfWeek.size());
        assertTrue(daysOfWeek.isEmpty());
    }

    @Test
    public void removeAll() {
        List<String> workdays = new ArrayList<>();
        List<String> daysOfWeek = new ArrayList<>();
        List<String> weekendDays = new ArrayList<>();

        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        weekendDays.add("Saturday");
        weekendDays.add("Sunday");

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        assertEquals("daysOfWeek contains 7 elements", 7, daysOfWeek.size());

        daysOfWeek.removeAll(weekendDays);

        assertTrue(daysOfWeek.containsAll(workdays));
        assertEquals("daysOfWeek contains 5 elements", 5, daysOfWeek.size());
        assertFalse(daysOfWeek.containsAll(weekendDays));
    }
}
