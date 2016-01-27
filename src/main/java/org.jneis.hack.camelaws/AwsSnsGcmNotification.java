package org.jneis.hack.camelaws;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class AwsSnsGcmNotification implements AwsSnsNotification {

    private final Gcm gcm;

    public AwsSnsGcmNotification(String message) {
        gcm = new Gcm();
        gcm.data = new Data();
        gcm.data.message = message;
    }

    @Override
    public AwsSnsPlatformAttributes attributes() {
        return AwsSnsPlatformAttributes.none();
    }

    @Override
    public String json() {
        JsonObject obj = new JsonObject();
        obj.add("GCM", jsonTree());
        return new Gson().toJson(obj);
    }

    private JsonObject jsonTree() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
                .toJsonTree(gcm)
                .getAsJsonObject();
    }

    private static class Gcm {
        public Data data;
//        public String collapseKey; // "Welcome"
//        public String delayWhileIdle; // true
//        public String timeToLive; // "125"
//        public String dryRun; // false
    }

    private static class Data {
        public String message;
    }

}
