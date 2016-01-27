package org.jneis.hack.camelaws;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class AwsSnsProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        AwsSnsProperties props = AwsSnsProperties.fromPropsFile();
        AwsSnsClient client = AwsSnsClient.from(props);

//        Notification notification =	exchange.getIn().getBody(Notification.class);
        String token = ""; // notification.getToken
        String arn = ""; // notification.getArn
        String platform = "I"; // notification.getPlatform
        String message = "hello world"; // notification.getMessage

        AwsSnsPlatformEndpoint endpoint = client.createPlatformEndpoint(token, arn);

        client.publish(endpoint.getArn(), AwsSnsPlatform.from(platform).notification(message));
    }

}
