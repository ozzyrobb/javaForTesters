package com.javafortesters.chap015stringsrevisited.examples;

import org.junit.Test;

    import java.io.UnsupportedEncodingException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringsRevisitedTest {

    @Test
    public void printUsingSpecialCharacters() {
        System.out.println("Bob said \"hello\" to his cat's friend");
        System.out.println("This is a single backslash \\");
    }

    @Test
    public void stringConcatenation() {
        String ps1 = "This is " + "String2";
        assertThat(ps1, is("This is String2"));
        String ps2 = "This is " + 4;
        assertThat(ps2, is("This is 4"));

        String thisIs = "This is ";
        String s1 = thisIs.concat("String1");
        assertThat(s1, is("This is String1"));
    }

    @Test
    public void convertingToAString() {
        String intConcatConvert = "" + 1;
        assertThat(intConcatConvert, is("1"));

        String integerIntConvert = Integer.toString(2);
        assertThat(integerIntConvert, is("2"));

        String integerStringConvert = String.valueOf(3);
        assertThat(integerStringConvert, is("3"));
    }

    @Test
    public void convertingFromAString() {
        assertThat(Integer.valueOf("2"), is(2));

        char[] cArray = {'2', '3'};
        assertThat("23".toCharArray(), is(cArray));
    }

    // When we convert between byte and String we may need to control the encoding.
    // If we use an incorrect encoding then an UnsupportedEncodingException will be thrown:

    @Test
    public void canConvertBytesUTF8() throws UnsupportedEncodingException {
        byte[] b8Array = "hello there".getBytes("UTF8");
    }

    @Test public void compareTo() {
        String hello = "Hello";
        assertThat(hello.compareTo("Hello"), is(0));

        // If the argument String is smaller than the String then compareTo returns a negative number:

        assertThat(hello.compareTo("hello") < 0, is(true));
        assertThat(hello.compareTo("Helloo") < 0, is(true));
        assertThat(hello.compareTo("Hemlo") < 0, is(true));

        // If the argument String is larger than the String then compareTo returns a positive number:

        assertThat(hello.compareTo("H") > 0, is(true));
        assertThat(hello.compareTo("Helln") > 0, is(true));
        assertThat(hello.compareTo("HeLlo") > 0, is(true));
    }

    @Test
    public void compareToIgnoreCase() {
        String hello = "Hello";
        assertThat(hello.compareToIgnoreCase("hello"), is(0));
        assertThat(hello.compareToIgnoreCase("Hello"), is(0));
        assertThat(hello.compareToIgnoreCase("heLlo"), is(0));
    }

    @Test
    public void contains() {
        String hello = "Hello";
        assertThat(hello.contains("He"), is(true));
        assertThat(hello.contains("Hello"), is(true));

        // Case is important when using contains:

        assertThat(hello.contains("LL"), is(false));

        assertThat(hello.contains("z"), is(false));
    }

    @Test
    public void contentEquals() {
        String hello = "Hello";

        // The contentEqual method will work with any object that implements the charSequence interface, or against a StringBuffer (e.g. a StringBuilder)

        assertThat(hello.contentEquals("Hello"), is(true));
        assertThat(hello.contentEquals("hello"), is(false));

        // The equals method enforces the additional rule that the parameter must be a String, as well as having equal content:

        assertThat(hello.equals("Hello"), is(true));

        // The equalsIgnoreCase method works the same as equals but ignores the case in the comparison:

        assertThat(hello.equalsIgnoreCase("hello"), is(true));
    }

    @Test
    public void endsWithAndStartsWith() {
        String hello = "Hello";
        assertThat(hello.endsWith("Hello"), is(true));
        assertThat(hello.endsWith(""), is(true));
        assertThat(hello.endsWith("lo"), is(true));

        assertThat(hello.startsWith("Hello"), is(true));
        assertThat(hello.startsWith(""), is(true));
        assertThat(hello.startsWith("He"), is(true));

        // Both endsWith and startsWith implement case sensitive searches:

        assertThat(hello.endsWith("Lo"), is(false));
        assertThat(hello.startsWith("he"), is(false));
    }

    @Test
    public void isEmpty() {
        String empty = "";
        assertThat(empty.isEmpty(), is(true));
        assertThat(empty.length(), is(0));
    }

    @Test
    public void regionMatchesCaseInsensitive() {
        String hello = "Hello fella";
        assertThat(hello.regionMatches(true, 6, "fez", 0, 2), is(true));

        /* In the above I am specifying:
        - perform a case insensitive comparison
        - the region of the hello String to search starting at position 6, until the end of the String
        - the substring is "fez", and
          - I want the region of this String to start at position 0, and
          - only be 2 characters long
         */
    }

    @Test
    public void regionMatchesCaseSensitive() {
        String hello = "Hello fella";
        assertThat(hello.regionMatches(4, "o F", 0, 3), is(false));

        /* In the above I am specifying:
        - perform a case sensitive comparison
        - the region of the hello String to search starting at position 4, until the end of the String
        - the substring is "o F", and
          - I want the region of this String to start at position 0, and
          - to be 3 characters long (the full length of the substring)
         */
    }

    @Test
    public void indexOf() {
        String hello = "Hello fella";
        assertThat(hello.indexOf("l"), is(2));
        assertThat(hello.indexOf("l", 3), is(3));
        assertThat(hello.indexOf("l", 4), is(8));

        assertThat(hello.indexOf("z"), is(-1));
    }

    @Test
    public void lastIndexOf() {
        String hello = "Hello fella";
        assertThat(hello.lastIndexOf("l"), is(9));
        assertThat(hello.lastIndexOf("l", 8), is(8));
        assertThat(hello.lastIndexOf("l", 7), is(3));

        assertThat(hello.lastIndexOf("z"), is(-1));
    }

    @Test
    public void stringMustIncludeADigit() {
        String mustIncludeADigit = ".*[0123456789]+.*";

        assertThat("12345678".matches(mustIncludeADigit), is(true));
        assertThat("1nvalid".matches(mustIncludeADigit), is(true));

        assertThat("invalid".matches(mustIncludeADigit), is(false));
        assertThat("Invalid".matches(mustIncludeADigit), is(false));
    }

    @Test
    public void stringMustIncludeUppercase() {
        String mustIncludeUppercase = ".*[A-Z]+.*";

        assertThat("Valid".matches(mustIncludeUppercase), is(true));
        assertThat("val1D".matches(mustIncludeUppercase), is(true));
    }

    @Test
    public void replacingStrings() {
        String hello = "Hello fella fella fella";

        assertThat(hello.replace("fella", "World"), is("Hello World World World"));
        assertThat(hello.replaceFirst("fella", "World"), is("Hello World fella fella"));
        assertThat(hello.replaceAll("fella", "World"), is("Hello World World World"));
    }

    @Test
    public void replacingStringsWithRegex() {
        assertThat("1,2,3".replaceFirst("[0-9]", "digit"), is("digit,2,3"));
        assertThat("1,2,3".replaceAll("[0-9]", "digit"), is("digit,digit,digit"));
    }

    @Test
    public void uppercaseAndLowercase() {
        String text = "In the lower 3rd";

        assertThat(text.toUpperCase(), is("IN THE LOWER 3RD"));
        assertThat(text.toLowerCase(), is("in the lower 3rd"));
    }

    @Test
    public void removingWhitespace() {
        String padded = "     trim me     ";
        assertThat(padded.length(), is(17));

        String trimmed = padded.trim();

        assertThat(trimmed.length(), is(7));
        assertThat(trimmed, is("trim me"));
    }

    @Test
    public void substrings() {
        String digits = "0123456789";

        assertThat(digits.substring(5), is("56789"));
        assertThat(digits.substring(5, 6), is("5"));
    }

    @Test
    public void format() {

        // We can use String.format and a format string instead of concatenation

        int value  = 4;
        String template = "The value %d was used";
        String formatted = String.format(template,value);
        assertThat(formatted, is("The value 4 was used"));

        // A 'format' string is a String with embedded conversion placeholders for the arguments supplied to String.format

        // %d means convert the argument to a decimal integer
        // %s means convert the argument to a String

        String use = "%s %s towards %d large %s";
        assertThat(String.format(use, "Bob", "ran", 6, "onions"), is("Bob ran towards 6 large onions"));

        // The arguments are used in order to fill the placeholders in the format string

        // The format string can specify exactly which argument it wants to use in each place holder by using %<index>$
        // e.g. %2$ would mean the 2nd argument

        String txt = "%2$s %4$s towards %3$d large %1$s";
        assertThat(String.format(txt, "Bob", "ran", 6, "onions"), is("ran onions towards 6 large Bob"));
    }

    @Test
    public void basicParsingWithSplit() {
        String csv = "1,2,3,4,5,6,7,8,9,10";
        String[] results = csv.split(",");

        assertThat(results.length, is(10));
        assertThat(results[0], is("1"));
        assertThat(results[9], is("10"));
    }

    @Test
    public void stringBuilder() {
        StringBuilder builder = new StringBuilder();

        builder.append("Hello There").replace(7,11,"World").delete(5,7);
        assertThat(builder.toString(), is("HelloWorld"));
    }

    @Test
    public void stringBuilderCapacityManagement() {
        StringBuilder builder = new StringBuilder();
        assertThat(builder.capacity(), is(16));

        StringBuilder sblen = new StringBuilder(512);
        assertThat(sblen.capacity(), is(512));
        assertThat(sblen.toString().length(), is(0));

        // You can size the StringBuilder after construction using the ensureCapacity method

        StringBuilder sb  = new StringBuilder();
        sb.ensureCapacity(600);
        assertThat(sb.capacity(), is(600));

        // If you have amended the capacity or deleted a lot of the string, you can set the capacity to the minimum necessary to hold the string using trimeToSize

        sb.trimToSize();
        assertThat(sb.capacity(), is(0));
    }

    @Test
    public void appendingToTheStringBuilder() {
        StringBuilder builder = new StringBuilder();
        builder.append("> ");
        builder.append(1);
        builder.append(" + ");
        builder.append(2);
        char[] ca = {' ', '=', ' ', '3'};
        builder.append(ca);

        assertThat(builder.toString(), is("> 1 + 2 = 3"));
    }
}