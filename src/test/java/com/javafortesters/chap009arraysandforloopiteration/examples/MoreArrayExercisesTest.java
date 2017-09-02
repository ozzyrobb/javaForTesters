package com.javafortesters.chap009arraysandforloopiteration.examples;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by robb on 19/08/2017.
 */
public class MoreArrayExercisesTest {

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

    @Test
    public void sortingArrays() {
        int[] intArray = {2,4,3,0,1};
        Arrays.sort(intArray);

        String[] stringArray = {"three", "two", "zero", "four", "one"};
        Arrays.sort(stringArray);

        assertEquals("array[0] = 0", 0, intArray[0]);
        assertEquals("array[2] = 2", 2, intArray[2]);
        assertEquals("array[9] = 4", 4, intArray[4]);


        assertEquals("array[0] = four", "four", stringArray[0]);
        assertEquals("array[2] = three", "three", stringArray[2]);
        assertEquals("array[4] = zero", "zero", stringArray[4]);
    }

    @Test
    public void sumArrayValues() {
        int[] array = {2,4,3,0,1};
        int arraySum = 0;
        for (int index : array) {
            arraySum+= index;
        }

        assertEquals("arraySum = 10", 10, arraySum);
    }

    @Test
    public void printGrid() {
        String[][] grid = new String[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++)  {
                System.out.print("- ");
            }
            System.out.println("");
        }
    }

    @Test
    public void calculateAverage() {
        int[] array = {2,4,3,0,1};
        int sum = 0;
        double average;

        for (int index : array) {
            sum+= index;
        }
        average = (sum / array.length);

        assertEquals("Average = 2",2, average, 0);
    }

    @Test
    public void arrayContainsValue() {
        int[] array = {2,4,3,0,1};
        int value = 4;
        boolean valuePresent = false;
        for (int index : array) {
            if (index == value) {
                valuePresent = true;
            }
        }
        assertTrue("array contains value", valuePresent);
    }

    private static boolean containsValue(int[] array, int value) {
        for (int index : array) {
            if (index == value) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void arrayValueTest() {
        int[] myArray = {1,2,3,4,5};

        assertTrue("array contains value", containsValue(myArray, 5));
    }

    private static int findIndex(int[] arrayToCheck, int valueToFind) {
        if (arrayToCheck == null) {
            return -1;
        }
        for (int i = 0; i < arrayToCheck.length; i++) {
            if (arrayToCheck[i] == valueToFind) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void valueAtIndex() {
        int[] myArray = {0,5,4,7,8,9,2,3};
        assertEquals("value is at index 3", 3, findIndex(myArray, 7));
    }
}
