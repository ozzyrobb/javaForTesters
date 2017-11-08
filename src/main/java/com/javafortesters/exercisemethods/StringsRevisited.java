package com.javafortesters.exercisemethods;

import java.util.ArrayList;
import java.util.List;

public class StringsRevisited {
    public static List<Integer> findAllOccurrences(String stringToSearch, String substring) {
        List<Integer> substrings = new ArrayList<>();
        List<Integer> dedupe = new ArrayList<>();
        for (int pos = 0; pos < stringToSearch.length(); pos++) {
            dedupe.add(stringToSearch.indexOf(substring, pos));
            if (!substrings.contains(dedupe.get(pos)) && dedupe.get(pos) != -1) {
                substrings.add(dedupe.get(pos));
            }
        }
        return substrings;
    }

    public static List<Integer> findAllOccurrencesReversed(String stringToSearch, String substring) {
        List<Integer> substrings = new ArrayList<>();
        List<Integer> dedupe = new ArrayList<>();
        int index = 0;
        for (int pos = stringToSearch.length(); pos > 0; pos--) {
            dedupe.add(stringToSearch.lastIndexOf(substring, pos));
            if (!substrings.contains(dedupe.get(index)) && dedupe.get(index) != -1) {
                substrings.add(dedupe.get(index));
            }
            index++;
        }
        return substrings;
    }
}
