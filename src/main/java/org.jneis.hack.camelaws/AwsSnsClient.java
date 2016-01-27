package org.jneis.hack.camelaws;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;

public class AwsSnsClient {

    private final AmazonSNS client;

    public AwsSnsClient(AwsSnsCredentials credentials, AwsSnsConfiguration configuration, String endpoint) {
        client = new AmazonSNSClient(credentials.toAwsSns(), configuration.toAwsSns());
        client.setEndpoint(endpoint);
    }

    public static AwsSnsClient from(AwsSnsProperties props) {
        AwsSnsCredentials credentials = new AwsSnsCredentials(props);
        AwsSnsConfiguration configuration = new AwsSnsConfiguration(props);
        String endpoint = props.endpoint();
        return new AwsSnsClient(credentials, configuration, endpoint);
    }

    public AwsSnsPlatformEndpoint createPlatformEndpoint(String token, String arn) {
        AwsSnsCreatePlatformEndpointRequest request = new AwsSnsCreatePlatformEndpointRequest(token, arn);
        return new AwsSnsPlatformEndpoint(client.createPlatformEndpoint(request.toAwsSns()));
    }

    public void publish(String endpointArn, AwsSnsNotification notification) {
        AwsSnsPublishRequest request = new AwsSnsPublishRequest(endpointArn, notification);
        client.publish(request.toAwsSns());
    }
}
