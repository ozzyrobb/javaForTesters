package com.javafortesters.chap009arraysandforloopiteration.examples;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by robb on 19/08/2017.
 */
public class moreArrayExercises {

    @Test
    public void fillArrayWithForLoop() {
        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }

        assertEquals("array[0] = 0", 0, array[0]);
        assertEquals("array[5] = 5", 5, array[5]);
        assertEquals("array[9] = 9", 9, array[9]);
    }

    @Test
    public void fillArrayWithForEachLoop() {
        int[] array = new int[10];

        int index = 0;
        for (int item : array) {
            array[index] = index;
            index++;
        }

        assertEquals("array[0] = 0", 0, array[0]);
        assertEquals("array[5] = 5", 5, array[5]);
        assertEquals("array[9] = 9", 9, array[9]);
    }

    @Test
    public void fillArrayWithMethod() {
        int[] array = new int[10];

        Arrays.fill(array, 10);

        assertEquals("array[0] = 10", 10, array[0]);
        assertEquals("array[5] = 10", 10, array[5]);
        assertEquals("array[9] = 10", 10, array[9]);
    }

    @Test
    public void fillArrayRangeWithMethod() {
        int[] array = new int[10];

        Arrays.fill(array, 2, 7, 10);

        assertEquals("array[0] = 0", 0, array[0]);
        assertEquals("array[5] = 10", 10, array[5]);
        assertEquals("array[9] = 0", 0, array[9]);
    }
}