package org.jneis.hack.camelaws;

import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;

class AwsSnsCreatePlatformEndpointRequest {

    private final CreatePlatformEndpointRequest request;

    public AwsSnsCreatePlatformEndpointRequest(String platformToken, String platformApplicationArn) {
        request = new CreatePlatformEndpointRequest();
        request.setCustomUserData("CustomData - Useful to store endpoint specific data");
        request.setToken(platformToken);
        request.setPlatformApplicationArn(platformApplicationArn);
    }

    public CreatePlatformEndpointRequest toAwsSns() {
        return request;
    }

}
