package com.javafortesters.chap008selectionsanddecisions.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

    @Test
    public void ifElseAddHttp() {
        String url = "www.seleniumsimplified.com";
        if (url.startsWith("http")) {
            // do nothing the url is fine
        } else {
            url = addHttp(url);
        }
        assertTrue(url.startsWith("http://"));
        assertEquals("http://www.seleniumsimplified.com", url);
    }

    @Test
    public void truthyEqualsTrue() {
//        boolean truthy = 4>3;
//        if (truthy)
        assertTrue("3 is less than 4", truthy(3, 4));
        assertFalse("4 is not greater than 3", truthy(4, 3));
    }

    private boolean truthy(int firstNumber, int secondNumber) {
        return firstNumber < secondNumber;
    }

    @Test
    public void ifElseTruthy() {
        boolean truthy = true;
        if (truthy) {
            assertTrue(truthy);
            assertFalse(!truthy);
        } else {
            assertFalse(truthy);
        }
    }

    @Test
    public void nestedIfElseHorror() {
        boolean truthy = false;
        boolean falsey = true;
        if (truthy) {
            if (!falsey) {
                if (truthy && !falsey) {
                    if (falsey || truthy) {
                        assertTrue(truthy);
                        assertFalse(falsey);
                    }
                }
            } else {
                assertTrue(truthy);
                assertFalse(falsey);
            }
        } else {
            if (!truthy) {
                if (falsey) {
                    assertTrue(falsey);
                    assertFalse(truthy);
                } else {
                    assertFalse(falsey);
                    assertFalse(truthy);
                }
            }
        }
    }

    @Test
    public void switchExample() {
        assertEquals("M", likelyGenderIs("sir"));
        assertEquals("M", likelyGenderIs("mr"));
        assertEquals("M", likelyGenderIs("master"));
        assertEquals("F", likelyGenderIs("miss"));
        assertEquals("F", likelyGenderIs("mrs"));
        assertEquals("F", likelyGenderIs("ms"));
        assertEquals("F", likelyGenderIs("lady"));
        assertEquals("F", likelyGenderIs("madam"));
    }

    private String likelyGenderIs(String title) {
        String likelyGender;
        switch (title.toLowerCase()) {
            case "sir":
                likelyGender = "M";
                break;
            case "mr":
                likelyGender = "M";
                break;
            case "master":
                likelyGender = "M";
                break;
            default:
                likelyGender = "F";
                break;
        }
        return likelyGender;
    }

    @Test
    public void switchOnShortCode() {
        assertEquals("United Kingdom", countryIs("Uk"));
        assertEquals("United States", countryIs("US"));
        assertEquals("United States", countryIs("UsA"));
        assertEquals("France", countryIs("fr"));
        assertEquals("Sweden", countryIs("sE"));
        assertEquals("Rest of World", countryIs("Au"));
    }

    private String countryIs(String shortCode) {
        String countryName;
        switch (shortCode.toUpperCase()) {
            case "UK":
                countryName = "United Kingdom";
                break;
            case "US":
                countryName = "United States";
                break;
            case "USA":
                countryName = "United States";
                break;
            case "FR":
                countryName = "France";
                break;
            case "SE":
                countryName = "Sweden";
                break;
            default:
                countryName = "Rest of World";
                break;
        }
        return countryName;
    }

    @Test
    public void switchOnNumberAsString() {
        assertEquals("One", numberAsString(1));
        assertEquals("Two", numberAsString(2));
        assertEquals("Three", numberAsString(3));
        assertEquals("Four", numberAsString(4));
        assertEquals("Too big", numberAsString(5));
        assertEquals("Too small", numberAsString(0));
    }

    private String numberAsString(int number) {
        String nameForNumber;
        if (number < 5) {
            switch (number) {
                case 1:
                    nameForNumber = "One";
                    break;
                case 2:
                    nameForNumber = "Two";
                    break;
                case 3:
                    nameForNumber = "Three";
                    break;
                case 4:
                    nameForNumber = "Four";
                    break;
                default:
                    nameForNumber = "Too small";
                    break;
            }
            return nameForNumber;
        } else {
            nameForNumber = "Too big";
            return nameForNumber;
        }
    }

    @Test
    public void switchOnNumberAsStringBonus() {
        assertEquals("One", numberAsStringBonus(1));
        assertEquals("Two", numberAsStringBonus(2));
        assertEquals("Three", numberAsStringBonus(3));
        assertEquals("Four", numberAsStringBonus(4));
        assertEquals("Too big", numberAsStringBonus(5));
        assertEquals("Too small", numberAsStringBonus(0));
    }

    private String numberAsStringBonus(int numberBonus) {
        String nameForNumberBonus;
        if (numberBonus < 5) {
            switch (numberBonus) {
                case 1:
                    return "One";
                case 2:
                    return "Two";
                case 3:
                    return "Three";
                case 4:
                    return "Four";
                default:
                    return "Too small";
            }
        } else {
            nameForNumberBonus = "Too big";
            return nameForNumberBonus;
        }
    }


}
