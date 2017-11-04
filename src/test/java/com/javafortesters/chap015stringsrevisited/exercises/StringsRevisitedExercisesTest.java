package com.javafortesters.chap015stringsrevisited.exercises;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringsRevisitedExercisesTest {

    @Test
    public void experimentWithSpecialCharacters() {
        System.out.println("I can put tabs \t into my strings");
        System.out.println("And I can use the backspace \bcharacter");
        System.out.println("I can separate text onto \na new line");
        System.out.println("I can use a carriage return \rto return to the beginning of a line");
    }

    @Test
    public void constructAString() {
        char[] cArray = {'2', '3'};
        assertThat(new String(cArray), is("23"));

        byte[] bArray = {'4', '5'};
        assertThat(new String(bArray), is("45"));

        StringBuffer sBuffer = new StringBuffer("bill");
        assertThat(new String(sBuffer), is("bill"));

        StringBuilder sBuilder = new StringBuilder("ben");
        assertThat(new String(sBuilder), is("ben"));
    }
}
