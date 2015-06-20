package net.dericbourg.fuzzywallhack.descriptors.type.string;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;

public class StringType implements PropertyType<StringParameters> {

    private final StringParameters parameters;

    StringType(StringTypeBuilder builder) {
        parameters = builder.getParameters();
    }

    @Override
    public String getName() {
        return "string";
    }

    @Override
    public StringParameters getParameters() {
        return parameters;
    }
}
