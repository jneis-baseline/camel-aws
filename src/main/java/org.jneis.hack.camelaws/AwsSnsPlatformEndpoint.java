package org.jneis.hack.camelaws;

import com.amazonaws.services.sns.model.CreatePlatformEndpointResult;

public class AwsSnsPlatformEndpoint {

    private CreatePlatformEndpointResult result;

    public AwsSnsPlatformEndpoint(CreatePlatformEndpointResult result) {
        this.result = result;
    }

    public String getArn() {
        return result.getEndpointArn();
    }

}
