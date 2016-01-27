package org.jneis.hack.camelaws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

public class AwsSnsCredentials {

    private final AWSCredentials credentials;

    public AwsSnsCredentials(AwsSnsProperties props) {
        credentials = new BasicAWSCredentials(props.accessKey(), props.secretKey());
    }

    public AWSCredentials toAwsSns() {
        return credentials;
    }

}
