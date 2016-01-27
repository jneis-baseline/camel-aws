package org.jneis.hack.camelaws;

import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.util.ImmutableMapParameter;
import java.util.Map;
import java.util.stream.Stream;

public class AwsSnsPlatformAttributes {

    private final Map<String, MessageAttributeValue> attributes;

    private AwsSnsPlatformAttributes(Map<String, MessageAttributeValue> attributes) {
        this.attributes = attributes;
    }

    public static AwsSnsPlatformAttributes none() {
        return new AwsSnsPlatformAttributes(ImmutableMapParameter.<String, MessageAttributeValue>builder().build());
    }

    public static AwsSnsPlatformAttributes.Builder builder() {
        return new Builder();
    }

    public Stream<Map.Entry<String, MessageAttributeValue>> stream() {
        return attributes.entrySet().stream();
    }

    public Map<String, MessageAttributeValue> toAwsSns() {
        return attributes;
    }

    public static class Builder {
        private final ImmutableMapParameter.Builder<String, MessageAttributeValue> builder;

        public Builder() {
            this.builder = ImmutableMapParameter.builder();
        }

        public Builder put(String key, String type, String value) {
            builder.put(key, new MessageAttributeValue().withDataType(type).withStringValue(value));
            return this;
        }

        public AwsSnsPlatformAttributes build() {
            return new AwsSnsPlatformAttributes(builder.build());
        }

    }

}
