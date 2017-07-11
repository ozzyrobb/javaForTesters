package com.javafortesters.domainobject;

/**
 * Created by robb on 4/05/2017.
 */
public class TestAppEnv {
    public static final String DOMAIN = "192.123.0.3";
    public static final String PORT = "67";

    public static String getUrl() {
        return "http://" + DOMAIN + ":" + PORT;

    }


}
