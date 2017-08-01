package com.javafortesters.chap009arraysandforloopiteration.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by robb on 30/07/2017.
 */
public class ArraysAndForLoopsTest {

    @Test
    public void userArrayTest() {
    User users[] = new User[3];
    users[0] = new User("user1", "password");
    users[1] = new User("user2", "password");
    users[2] = new User("user3", "password");

    assertEquals("user[0] is user1", "user1", users[0].getUsername());
    assertEquals("user[1] is user2", "user2", users[1].getUsername());
    assertEquals("user[2] is user3", "user3", users[2].getUsername());

        for (User newUser : users) {
            System.out.println(newUser.getUsername());
        }
    }

    @Test
    public void simpleArrayExample() {
        String[] numbers0123 = {"zero", "one", "two", "three"};

        for (String numberText : numbers0123) {
            System.out.println(numberText);
        }

        assertEquals("zero", numbers0123[0]);
        assertEquals("three", numbers0123[3]);
    }

    @Test
    public void arrayOf100Users() {
        User lotsOfUsers[] = new User[100];

        int index = 0;
        int number = 1;
        for (User user : lotsOfUsers) {
            lotsOfUsers[index] = new User("user" + number, "password" + number);

            System.out.println(lotsOfUsers[index].getUsername() + "," + lotsOfUsers[index].getPassword());

            index++;
            number++;
        }

        assertEquals("user[0] is user1","user1", lotsOfUsers[0].getUsername());
        assertEquals("user[0] is password1","password1", lotsOfUsers[0].getPassword());
        assertEquals("user[99] is user100","user100", lotsOfUsers[99].getUsername());
        assertEquals("user[99] is password100","password100", lotsOfUsers[99].getPassword());
    }

}
