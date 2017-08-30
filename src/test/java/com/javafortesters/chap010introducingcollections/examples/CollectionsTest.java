package com.javafortesters.chap010introducingcollections.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void daysOfTheWeek() {
        String[] someDays = {"Tuesday", "Thursday", "Wednesday", "Monday", "Saturday", "Sunday", "Friday"};

        List<String> days = Arrays.asList(someDays);

        // With the for each loop, I can iterate over every item in the List and when I find "Monday" i will have to break out of the loop:

        int forCount = 0;
        for (String day : days) {
            if (day.equals("Monday")) {
                break;
            }
            forCount++;
        }
        assertEquals("Monday is at position 3", 3, forCount);

        // With the for loop, I will iterate over the size of the List and break when I find "Monday":

        int loopCount;
        for (loopCount = 0; loopCount <= days.size(); loopCount++) {
            if (days.get(loopCount).equals("Monday")) {
                break;
            }
        }
        assertEquals("Monday is at position 3", 3, loopCount);

        // With the while loop, I can make the check for "Monday" the loop exit condition, so I only 'do' the body of the loop 'while' I have not found "Monday":

        int count = 0;
        while (!days.get(count).equals("Monday")) {
            count++;
        }
        assertEquals("Monday is at position 3", 3, count);

        // With the do...while loop, I need to set the index outside the valid boundary of the list because I increment it in the body of the loop.
        // And again, I only 'do' the body of the loop 'while' I have not found "Monday":

        int doCount = -1;
        do {
            doCount++;
        } while (!days.get(doCount).equals("Monday"));
        assertEquals("Monday is at position 3", 3, doCount);
    }

    @Test
    public void daysExercise() {
        String[] weekdays = {"Tuesday", "Thursday", "Wednesday", "Monday", "Saturday", "Sunday", "Friday"};

        List<String> days = Arrays.asList(weekdays);

        int i = 0;
        for (;!days.get(i).equals("Monday");) {
            i++;
        }
        assertEquals("Monday is at position 3", 3, i);
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

