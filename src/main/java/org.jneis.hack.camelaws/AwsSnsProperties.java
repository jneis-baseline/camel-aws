package org.jneis.hack.camelaws;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class AwsSnsProperties {

    private final Properties props;

    public AwsSnsProperties(Properties props) {
        this.props = props;
    }

    public static AwsSnsProperties fromPropsFile() {
        InputStream stream = AwsSnsProperties.class.getResourceAsStream("aws-sns.properties");
        Properties props = new Properties();
        try {
            props.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new AwsSnsProperties(props);
    }

    public String endpoint() {
        return get("endpoint");
    }

    public String accessKey() {
        return get("accessKey");
    }

    public String secretKey() {
        return get("secretKey");
    }

    public String proxyHost() {
        return get("proxyHost");
    }

    public int proxyPort() {
        return getInt("proxyPort");
    }

    private String get(String key) {
        return props.getProperty(key);
    }

    private int getInt(String key) {
        return Integer.parseInt(Optional.ofNullable(get(key)).orElse("0"));
    }
}
