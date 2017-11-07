package com.javafortesters.exercisemethods;

import java.util.ArrayList;
import java.util.List;

public class StringsRevisited {
    public static List<Integer> findAllOccurrences(String stringToSearch, String substring) {
        List<Integer> substrings = new ArrayList<>();
        for (int pos = 0; pos < stringToSearch.length(); pos++) {
            substrings.add(stringToSearch.indexOf(substring, pos));
        }
        return substrings;
    }
}
