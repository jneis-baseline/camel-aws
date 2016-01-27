package org.jneis.hack.camelaws;

import com.amazonaws.ClientConfiguration;

public class AwsSnsConfiguration {

    private final ClientConfiguration config;

    public AwsSnsConfiguration(AwsSnsProperties props) {
        config = new ClientConfiguration();
        config.setProxyHost(props.proxyHost());
        config.setProxyPort(props.proxyPort());
    }

    public ClientConfiguration toAwsSns() {
        return config;
    }

}
