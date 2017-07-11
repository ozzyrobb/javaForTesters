package com.javafortesters.chap005testwithourownclasses.domainobject.examples;

import com.javafortesters.domainobject.TestAppEnv;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by robb on 4/05/2017.
 */
public class TestAppEnvironmentTest {

    @Test
    public void canGetUrlStatically() {
        assertEquals("Returns URL", "http://192.123.0.3:67", TestAppEnv.getUrl());
    }

    @Test
    public void canGetDomainAndPortStatically() {
        assertEquals("Just the domain", "192.123.0.3", TestAppEnv.DOMAIN);
        assertEquals("Just the port", "67", TestAppEnv.PORT);
    }
}
