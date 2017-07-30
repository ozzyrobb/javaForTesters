package com.javafortesters.chap009arraysandforloopiteration.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by robb on 30/07/2017.
 */
public class ArraysTest {

    @Test
    public void userArrayTest() {
    User users[] = new User[] {new User("user1", "password"), new User("user2", "password"), new User("user3", "password")};
//    User users[] = new User[3];
//    users[0] = new User();
//    users[1] = new User();
//    users[2] = new User();
    assertEquals("user[0] is user1", "user1", users[0].getUsername());
    assertEquals("user[1] is user2", "user2", users[1].getUsername());
    assertEquals("user[2] is user3", "user3", users[2].getUsername());

        for (User user : users) {
            String username = user.getUsername();
            System.out.println(username);
        }
    }
}
