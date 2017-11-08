package com.javafortesters.chap015stringsrevisited.exercises;

import com.javafortesters.exercisemethods.StringsRevisited;
import org.junit.Test;

import static org.hamcrest.Matchers.contains;
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

    @Test
    public void regionMatchesExercise() {
        String hello = "Hello fella";
        assertThat(hello.regionMatches(9, "young lady", 6, 2), is(true));
    }

    @Test
    public void findAllOccurrencesOfSubstring() {
        String hello = "Hello fella";
        String substring = "l";

        assertThat(StringsRevisited.findAllOccurrences(hello, substring).size(), is(4));
        assertThat(StringsRevisited.findAllOccurrences(hello, substring), contains(2, 3, 8, 9));
    }

    @Test
    public void findAllOccurrencesOfSubstringReversed() {
        String hello = "Hello fella";
        String substring = "l";

        assertThat(StringsRevisited.findAllOccurrencesReversed(hello, substring).size(), is(4));
        assertThat(StringsRevisited.findAllOccurrencesReversed(hello, substring), contains(9, 8, 3, 2));
    }
}
