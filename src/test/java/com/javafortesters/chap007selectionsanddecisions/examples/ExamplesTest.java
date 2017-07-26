package com.javafortesters.chap007selectionsanddecisions.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by robb on 26/07/2017.
 */
public class ExamplesTest {

    @Test
    public void moreTernary() {
        String url = "www.eviltester.com";

        url = url.startsWith("http") ? url : addHttp(url);

        assertTrue(url.startsWith("http://"));
        assertEquals("http://www.eviltester.com", url);
    }

    private String addHttp(String url) {
        return "http://" + url;
    }

    @Test
    public void ternaryCats() {
//        int numberOfCats = 3;

//        String catOrCats = numberOfCats == 1 ? "cat" : "cats";

        assertEquals("2 == cats", "cats", catOrCats(2));
        assertEquals("1 == cat", "cat", catOrCats(1));
    }

    private String catOrCats(int numberOfCats) {
        return numberOfCats == 1 ? "cat" : "cats";
    }

    @Test
    public void ifAddHttp() {
        String url = "www.seleniumsimplified.com";
        if (!url.startsWith("http://")) {
            url = addHttp(url);
        }
        assertTrue(url.startsWith("http://"));
        assertEquals("http://www.seleniumsimplified.com", url);
    }

//    @Test
//    public boolean truthyEqualsTrue() {
//        if (truthy == true) return true;
//        return truthy;
//    }
}
