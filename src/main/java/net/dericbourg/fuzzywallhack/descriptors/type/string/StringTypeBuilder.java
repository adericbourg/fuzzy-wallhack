package net.dericbourg.fuzzywallhack.descriptors.type.string;

import net.dericbourg.fuzzywallhack.descriptors.type.TypeBuilder;

import java.util.HashMap;
import java.util.Map;

public class StringTypeBuilder implements TypeBuilder<StringType, StringParameters> {

    private final Map<String, Object> parameters = new HashMap<>();

    public StringTypeBuilder withMinLength(int minLength) {
        parameters.put(StringParameters.MIN_LENGTH_PARAM, minLength);
        return this;
    }

    public StringTypeBuilder withMaxLength(int maxLength) {
        parameters.put(StringParameters.MAX_LENGTH_PARAM, maxLength);
        return this;
    }

    @Override
    public StringType build() {
        return new StringType(this);
    }

    @Override
    public StringParameters getParameters() {
        return new StringParameters(parameters);
    }
}
