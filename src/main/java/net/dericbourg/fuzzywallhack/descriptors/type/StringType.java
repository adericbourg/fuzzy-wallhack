package net.dericbourg.fuzzywallhack.descriptors.type;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

import java.util.HashMap;
import java.util.Map;

public class StringType implements PropertyType<StringType.StringParameters> {

    private final StringParameters parameters;

    private StringType(Builder builder) {
        parameters = new StringParameters(builder.parameters);
    }

    @Override
    public String getName() {
        return "string";
    }

    @Override
    public StringParameters getParameters() {
        return parameters;
    }

    public static class StringParameters extends PropertyTypeParameters {

        private static final String MIN_LENGTH_PARAM = "min_length";
        private static final String MAX_LENGTH_PARAM = "max_length";

        public StringParameters(Map<String, Object> parameters) {
            super(parameters);
        }

        public int getMinLength() {
            return getInteger(MIN_LENGTH_PARAM).orElse(1);
        }

        public int getMaxLength() {
            return getInteger(MAX_LENGTH_PARAM).orElse(10);
        }
    }

    public static class Builder {

        private final Map<String, Object> parameters = new HashMap<>();

        public StringType build() {
            return new StringType(this);
        }

        public Builder withMinLength(int minLength) {
            parameters.put(StringParameters.MIN_LENGTH_PARAM, minLength);
            return this;
        }

        public Builder withMaxLength(int maxLength) {
            parameters.put(StringParameters.MAX_LENGTH_PARAM, maxLength);
            return this;
        }
    }
}
