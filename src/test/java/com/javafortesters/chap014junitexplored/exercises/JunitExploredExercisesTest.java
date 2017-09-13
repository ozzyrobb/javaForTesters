package com.javafortesters.chap014junitexplored.exercises;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by robb on 11/09/2017.
 */
public class JunitExploredExercisesTest {

    @Test
    public void createTestMethodUsingAllAsserts() {
        int rob = 5;
        int[] robArray = {0,1,2};
        int[] robNewArray = {0,1,2};
        String bob = null;
        int job = 5;
        assertEquals("rob = 5", 5, rob);
        assertTrue(rob == 5);
        assertFalse(rob == 4);
        assertArrayEquals(robArray, robNewArray);
        assertNotNull(rob);
        assertNull(bob);
        assertNotSame(rob, bob);
        assertSame(rob, job);
    }

    @Test
    public void replicateAllTheJunitAssertsUsingAssertThat() {
        int rob = 5;
        int[] robArray = {0,1,2};
        int[] robNewArray = {0,1,2};
        String bob = null;
        int job = 5;
        int pob = 6;
        assertThat(rob, is(5));
        assertThat(rob == 5, is(true));
        assertThat(rob == 4, is(false));
        assertThat(robArray, equalTo(robNewArray));
        assertThat(rob, is(not(nullValue())));
        assertThat(bob, is(nullValue()));
        assertThat(rob, is(not(pob)));
        assertThat(rob, is(job));
    }
}
