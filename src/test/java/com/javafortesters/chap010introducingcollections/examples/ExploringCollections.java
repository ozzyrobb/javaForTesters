package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by robb on 26/08/2017.
 */
public class ExploringCollections {

    @Test
    public void addToCollection() {
        List<String> workdays = new ArrayList<>();
        List<String> daysOfWeek = new ArrayList<>();
        List<String> weekendDays = new ArrayList<>();

        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        weekendDays.add("Saturday");
        weekendDays.add("Funday");
        weekendDays.remove("Funday");
        weekendDays.add("Sunday");

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        for (String dayOfWeek : daysOfWeek) {
            System.out.println(dayOfWeek);
        }

        assertEquals("workdays contains 5 elements",5, workdays.size());
        assertTrue("daysOfWeek contains 5 elements", daysOfWeek.containsAll(workdays));
        assertFalse("weekendDays does not contain Funday",weekendDays.contains("Funday"));
        assertEquals("weekendDays contains 2 elements", 2, weekendDays.size());
        assertTrue("Bug fixed, Sunday is in the collection now", weekendDays.contains("Sunday"));

        assertEquals("daysOfWeek contains 7 elements", 7, daysOfWeek.size());
        daysOfWeek.clear();
        assertEquals("daysOfWeek is now empty", 0, daysOfWeek.size());
        assertTrue(daysOfWeek.isEmpty());
    }

    @Test
    public void removeAll() {
        List<String> workdays = new ArrayList<>();
        List<String> daysOfWeek = new ArrayList<>();
        List<String> weekendDays = new ArrayList<>();

        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        weekendDays.add("Saturday");
        weekendDays.add("Sunday");

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        assertEquals("daysOfWeek contains 7 elements", 7, daysOfWeek.size());

        daysOfWeek.removeAll(weekendDays);

        assertTrue(daysOfWeek.containsAll(workdays));
        assertEquals("daysOfWeek contains 5 elements", 5, daysOfWeek.size());
        assertFalse(daysOfWeek.containsAll(weekendDays));
    }

    @Test
    public void retainAll() {
        List<String> workdays = new ArrayList<>();
        List<String> daysOfWeek = new ArrayList<>();
        List<String> weekendDays = new ArrayList<>();

        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        weekendDays.add("Saturday");
        weekendDays.add("Sunday");

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        assertTrue(daysOfWeek.containsAll(workdays));
        assertTrue(daysOfWeek.containsAll(weekendDays));

        daysOfWeek.retainAll(weekendDays);

        assertEquals("daysOfWeek only contains weekendDays now", 2, daysOfWeek.size());
        assertTrue(daysOfWeek.containsAll(weekendDays));
        assertFalse(daysOfWeek.containsAll(workdays));
    }

    @Test
    public void toArrayNoArgument() {
        List<String> workdays = new ArrayList<>();
        List<String> daysOfWeek = new ArrayList<>();
        List<String> weekendDays = new ArrayList<>();

        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        weekendDays.add("Saturday");
        weekendDays.add("Sunday");

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        // When we call toArray without an argument, it will retun an array of Object.

        Object[] daysOfWeekArray = daysOfWeek.toArray();
        assertEquals("daysOfWeekArray contains 7 elements", 7, daysOfWeekArray.length);

        // If we subsequently wanted to use elements from the array we would have to cast them as String. i.e. (String)

        assertEquals("Monday".length(),((String)daysOfWeekArray[0]).length());
    }

    @Test
    public void toArrayWithArgument(){
        List<String> workdays = new ArrayList<>();
        List<String> daysOfWeek = new ArrayList<>();
        List<String> weekendDays = new ArrayList<>();

        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        weekendDays.add("Saturday");
        weekendDays.add("Sunday");

        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekendDays);

        // The toArray(anArray) call, where we pass as argument an initialized array, avoids the above problems:

        String[] anotherArray = new String[daysOfWeek.size()];
        daysOfWeek.toArray(anotherArray);

        assertEquals("Monday".length(), anotherArray[0].length());
    }

    @Test
    public void getAnElementAtAnIndex() {
        List<String> days = new ArrayList<>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");

        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
    }

    @Test
    public void removeAnElementAtAnIndex() {
        List<String> days = new ArrayList<>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");

        days.remove(1);

        assertEquals(2, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Wednesday", days.get(1));
    }

    @Test
    public void addAnElementAtAnIndex() {
        List<String> days = new ArrayList<>();

        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");

        days.add(0, "Monday");
        days.add(2, "Wednesday");
        days.add(4, "Friday");
        days.add(6, "Sunday");

        assertEquals("Tuesday", days.get(1));
        assertEquals("Thursday", days.get(3));
        assertEquals("Saturday", days.get(5));
    }

    @Test
    public void addAllElementsAtAnIndex() {
        List<String> days = new ArrayList<>();
        List<String> missingDays = new ArrayList<>();

        days.add("Monday");
        days.add("Friday");

        missingDays.add("Tuesday");
        missingDays.add("Wednesday");
        missingDays.add("Thursday");

        days.addAll(1, missingDays);

        assertEquals(5, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
        assertEquals("Thursday", days.get(3));
        assertEquals("Friday", days.get(4));
    }

    @Test
    public void indexOfElement() {
        List<String> days = new ArrayList<>();

        days.add("Tuesday");
        days.add("Thursday");
        days.add("Saturday");
        days.add("Thursday");

        assertEquals(2, days.indexOf("Saturday"));
        assertEquals(1, days.indexOf("Thursday"));
        assertEquals(3, days.lastIndexOf("Thursday"));
    }

    @Test
    public void setElementAtAnIndex() {
        List<String> days = new ArrayList<>();

        days.add("Monday");
        days.add("Thursday");
        days.add("Wednesday");

        days.set(1, "Tuesday");

        assertEquals("Tuesday", days.get(1));

        assertEquals(3, days.size());
        assertEquals("Monday", days.get(0));
        assertEquals("Tuesday", days.get(1));
        assertEquals("Wednesday", days.get(2));
    }

    @Test
    public void subListToCreatePortionOfAList() {
        List<String> days = new ArrayList<>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        List<String> weekdays = days.subList(0,5);

        assertEquals(5, weekdays.size());
        assertEquals("Monday", weekdays.get(0));
        assertEquals("Tuesday", weekdays.get(1));
        assertEquals("Wednesday", weekdays.get(2));
        assertEquals("Thursday", weekdays.get(3));
        assertEquals("Friday", weekdays.get(4));
    }

    @Test
    public void setDoesNotAllowDuplicateElements() {
        Set<String> workdays = new HashSet<>();

        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");

        assertEquals(1, workdays.size());
    }

    @Test
    public void putElementsInAMap() {
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals(3, map.size());

        map.put("key1", "newValue1");
        assertEquals("newValue1", map.get("key1"));
    }

    @Test
    public void useGetToRetrieveAValue() {
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
        assertEquals("value3", map.get("key3"));

        assertEquals(null, map.get("key4"));
        assertNull(map.get("key4"));
    }

    @Test
    public void removeValueFromAMap() {
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        map.remove("key1");

        assertEquals(2, map.size());
    }

    @Test
    public void clearAllValuesFromAMap() {
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");

        map.clear();

        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    public void containsKeyAndContainsValue() {
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertTrue(map.containsKey("key1"));
        assertFalse(map.containsKey("key4"));

        assertTrue(map.containsValue("value1"));
        assertFalse(map.containsValue("value4"));
    }

    @Test
    public void putAllToAddAMapToAMap() {
        Map<String,String> map = new HashMap<>();

        Map<String,String> newMap = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        newMap.put("key1", "newMapValue1");
        newMap.put("key4", "value4");

        map.putAll(newMap);

        assertEquals(4, map.size());
        assertEquals("newMapValue1", map.get("key1"));
    }

    @Test
    public void returnACollectionContainingMapValues() {
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Collection<String> values = map.values();

        assertTrue(values.contains("value1"));
        assertTrue(values.contains("value2"));
        assertTrue(values.contains("value3"));
        assertFalse(values.contains("value4"));
    }

    @Test
    public void returnASetContainingMapKeys() {
        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Set<String> keys = map.keySet();

        assertTrue(keys.contains("key1"));
        assertTrue(keys.contains("key2"));
        assertTrue(keys.contains("key3"));
        assertFalse(keys.contains("key4"));
    }

    @Test
    public void entrySet() {
        // An Entry is the "key, value" pair
        // Entry exposes the getValue, getKey and setValue methods

        // The following code iterates through the entries in the Map and sets all values to "Bob":

        Map<String,String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Set<Map.Entry<String,String>> entries = map.entrySet();

        for (Map.Entry<String,String> entry : entries) {
            entry.setValue("bob");
        }

        assertEquals(3, entries.size());
    }
}
