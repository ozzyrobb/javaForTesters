package com.javafortesters.chap009arraysandforloopiteration.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.net.URLEncoder;
import java.util.Arrays;

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

        assertEquals("user[0] is user1", "user1", lotsOfUsers[0].getUsername());
        assertEquals("user[0] is password1", "password1", lotsOfUsers[0].getPassword());
        assertEquals("user[99] is user100", "user100", lotsOfUsers[99].getUsername());
        assertEquals("user[99] is password100", "password100", lotsOfUsers[99].getPassword());
    }

    @Test
    public void answerCreateAnArrayOf100Users() {
        User[] users = new User[100];

        for (int userIndex = 0; userIndex < 100; userIndex++) {
            int userId = userIndex + 1;
            users[userIndex] = new User("user" + userId, "password" + userId);
        }

        // check creation
        for (User aUser : users) {
            System.out.println(aUser.getUsername() + ", " + aUser.getPassword());
        }

        //bonus points assert creation
        int userId = 1;
        for (User aUser : users) {
            assertEquals("user" + userId, aUser.getUsername());
            assertEquals("password" + userId, aUser.getPassword());
            userId++;
        }
        //check the last one output was 100, i.e. next would be 101
        assertEquals(101, userId);
    }

    @Test
    public void workdaysExample() {
        String[] workdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        Arrays.sort(workdays);

        for (String workday : workdays) {
            System.out.println(workday);
        }

        assertEquals("Friday", workdays[0]);
        assertEquals("Monday", workdays[1]);
        assertEquals("Thursday", workdays[2]);
        assertEquals("Tuesday", workdays[3]);
        assertEquals("Wednesday", workdays[4]);
    }

    @Test
    public void workdaysMixedCaseExample() {
        String[] workdaysMixedCase = {"monday", "Tuesday", "Wednesday", "thursday", "Friday"};

        Arrays.sort(workdaysMixedCase);

        for (String workdayMixed : workdaysMixedCase) {
            System.out.println(workdayMixed);
        }

        assertEquals("Friday", workdaysMixedCase[0]);
        assertEquals("Tuesday", workdaysMixedCase[1]);
        assertEquals("Wednesday", workdaysMixedCase[2]);
        assertEquals("monday", workdaysMixedCase[3]);
        assertEquals("thursday", workdaysMixedCase[4]);
    }


    public void print2DIntArray(int[][] multi) {
        for (int[] outer : multi) {
            if (outer == null) {
                System.out.print("null");
            } else {
                for (int inner : outer) {
                    System.out.print(inner + ",");
                }
            }
            System.out.println("");
        }
    }

    @Test
    public void createTriangle2dArray() {
        int[][] triangle = new int[16][];
        for (int row = 0; row < triangle.length; row++) {
            triangle[row] = new int[row + 1];
            System.out.print("row = " + row + " | ");
            for (int i = 0; i < (row + 1); i++) {
                triangle[row][i] = i;
                System.out.print("i = " + i + " | ");
            }
            System.out.println("");
        }

        print2DIntArray(triangle);
    }

}
