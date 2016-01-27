package org.jneis.hack.camelaws;

import com.google.gson.Gson;

public class AwsSnsMpnsNotification implements AwsSnsNotification {

    private static final String pattern = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
            "<wp:Notification xmlns:wp=\"WPNotification\">" +
            "<wp:Tile>" +
//                "<wp:Count>%s</wp:Count>" +
            "<wp:Title>%s</wp:Title>" +
            "</wp:Tile>" +
            "</wp:Notification>";

    private final String MPNS;

    public AwsSnsMpnsNotification(String message) {
        MPNS = String.format(pattern, message);
    }

    private static final AwsSnsPlatformAttributes attributes = AwsSnsPlatformAttributes.builder()
            .put("AWS.SNS.MOBILE.MPNS.Type", "String", "token")
            .put("AWS.SNS.MOBILE.MPNS.NotificationClass", "String", "realtime").build();

    @Override
    public AwsSnsPlatformAttributes attributes() {
        return attributes;
    }

    @Override
    public String json() {
        return new Gson().toJson(this);
    }

}
