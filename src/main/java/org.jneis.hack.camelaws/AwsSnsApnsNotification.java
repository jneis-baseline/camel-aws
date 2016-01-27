package org.jneis.hack.camelaws;

import com.google.gson.Gson;

public class AwsSnsApnsNotification implements AwsSnsNotification {

    private final Apns APNS;

    public AwsSnsApnsNotification(String message) {
        APNS = new Apns();
        APNS.aps = new Aps();
        APNS.aps.alert = message;
    }

    @Override
    public AwsSnsPlatformAttributes attributes() {
        return AwsSnsPlatformAttributes.none();
    }

    @Override
    public String json() {
        return new Gson().toJson(this);
    }

    private static class Apns {
        public Aps aps;
    }

    private static class Aps {
        public String alert;
//        public int badge;
//        public String sound; // "default"
//        public boolean contentAvailable;
//        public Extra extra; // set of key/value pairs (strings)
    }

}
