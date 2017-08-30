package com.javafortesters.chap010introducingcollections.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
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

    @Test
    public void retainAll() {
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

        assertTrue(daysOfWeek.containsAll(workdays));
        assertTrue(daysOfWeek.containsAll(weekendDays));

        daysOfWeek.retainAll(weekendDays);

        assertEquals("daysOfWeek only contains weekendDays now", 2, daysOfWeek.size());
        assertTrue(daysOfWeek.containsAll(weekendDays));
        assertFalse(daysOfWeek.containsAll(workdays));
    }

    @Test
    public void toArrayNoArgument() {
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

        // When we call toArray without an argument, it will retun an array of Object.

        Object[] daysOfWeekArray = daysOfWeek.toArray();
        assertEquals("daysOfWeekArray contains 7 elements", 7, daysOfWeekArray.length);

        // If we subsequently wanted to use elements from the array we would have to cast them as String. i.e. (String)

        assertEquals("Monday".length(),((String)daysOfWeekArray[0]).length());
    }

    @Test
    public void toArrayWithArgument(){
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

        // The toArray(anArray) call, where we pass as argument an initialized array, avoids the above problems:

        String[] anotherArray = new String[daysOfWeek.size()];
        daysOfWeek.toArray(anotherArray);

        assertEquals("Monday".length(), anotherArray[0].length());
    }

    @Test
    public void collectionOfUserExercise() {
        Collection<User> users = new ArrayList<>();

        assertEquals("users has 0 elements", 0, users.size());
        assertTrue(users.isEmpty());

        User bill = new User();
        User ben = new User();

        users.add(bill);
        users.add(ben);

        assertEquals("users has 2 elements", 2, users.size());
        assertFalse(users.isEmpty());

        Collection<User> newUsers = new ArrayList<>();

        User james = new User();
        User lars = new User();

        newUsers.add(james);
        newUsers.add(lars);

        users.addAll(newUsers);

        assertTrue(users.contains(james));
        assertTrue(users.contains(lars));

        System.out.println("newUsers contains: ");
        for (Object user : newUsers) {
            System.out.println();
        }

        newUsers.removeAll(users);
        assertEquals(0, newUsers.size());

        System.out.println("Now newUsers contains: ");
        for (Object user : newUsers) {
            System.out.println(user);
        }

        users.clear();
        assertEquals(0, users.size());
    }
}
