package net.dericbourg.fuzzywallhack.descriptors.type.integer;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;

public class IntegerType implements PropertyType<IntegerParameters> {

    private final IntegerParameters parameters;

    IntegerType(IntegerTypeBuilder builder) {
        this.parameters = builder.getParameters();
    }

    @Override
    public String getName() {
        return "integer";
    }

    @Override
    public IntegerParameters getParameters() {
        return parameters;
    }
}
