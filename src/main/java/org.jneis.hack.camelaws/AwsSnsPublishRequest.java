package org.jneis.hack.camelaws;

import com.amazonaws.services.sns.model.PublishRequest;

public class AwsSnsPublishRequest {

    private final PublishRequest request;

    public AwsSnsPublishRequest(String endpointArn, AwsSnsNotification notification) {
        this.request = new PublishRequest();
        this.request.setMessageAttributes(notification.attributes().toAwsSns());
        this.request.setMessageStructure("json");
        this.request.setTargetArn(endpointArn);
        this.request.setMessage(notification.json());
    }

    public PublishRequest toAwsSns() {
        return request;
    }

}
