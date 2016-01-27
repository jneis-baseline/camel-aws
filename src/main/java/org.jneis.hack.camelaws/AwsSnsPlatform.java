package org.jneis.hack.camelaws;

import java.util.function.Function;

public enum AwsSnsPlatform {

    APNS ("i", AwsSnsApnsNotification::new),
    GCM ("a", AwsSnsGcmNotification::new),
    MPNS ("w", AwsSnsMpnsNotification::new);

    private final String lms;
    private final Function<String, ? extends AwsSnsNotification> constructor;

    AwsSnsPlatform(String lms, Function<String, ? extends AwsSnsNotification> constructor) {
        this.lms = lms;
        this.constructor = constructor;
    }

    public AwsSnsNotification notification(String message) {
        return constructor.apply(message);
    }

    public static AwsSnsPlatform from(String lms) {
        for (AwsSnsPlatform p : values()) {
            if (p.lms.equals(lms.toLowerCase())) {
                return p;
            }
        }
        throw new IllegalArgumentException(String.format("Unsupported platform: %s", lms));
    }

}
