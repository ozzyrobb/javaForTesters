package com.javafortesters.chap014junitexplored.examples;

import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.exceptions.User;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by robb on 11/09/2017.
 */
public class JunitExploredTest {

    @Test(expected = InvalidPassword.class)
    public void expectInvalidPasswordException() throws InvalidPassword {
        User user = new User("username", "<6");
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void invalidPasswordThrown() throws InvalidPassword {
        expected.expect(InvalidPassword.class);
        expected.expectMessage("> 6 chars");
        User user = new User("username", ",6");
    }

    @BeforeClass
    public static void runOncePerClassBeforeAnyTests() {
        System.out.println("@BeforeClass run once before all tests");
    }

    @AfterClass
    public static void runOncePerClassAfterAnyTests() {
        System.out.println("@AfterClass run once after all tests");
    }

    @Before
    public void runOncePerTestBeforeTest() {
        System.out.println("@Before run once before each test");
    }

    @After
    public void runOncePerTestAfterTest() {
        System.out.println("@After run once after each test");
    }

    @Ignore("Because it is not finished yet")
    @Test
    public void thisTestIsIgnored() {
    }

    @Test
    public void useAssertThatWithHamcrestMatchers() {
        assertThat("3 + 3 = 6",3 + 3, is(6));
    }

    @Test
    public void testAlwaysFails() {
        fail("fail always fails");
    }
}
