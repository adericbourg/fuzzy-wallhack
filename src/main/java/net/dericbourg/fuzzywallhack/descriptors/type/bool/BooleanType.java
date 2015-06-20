package net.dericbourg.fuzzywallhack.descriptors.type.bool;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;

public class BooleanType implements PropertyType<BooleanParameters> {

    private final BooleanParameters parameters;

    BooleanType(BooleanTypeBuilder builder) {
        this.parameters = builder.getParameters();
    }

    @Override
    public String getName() {
        return "bool";
    }

    @Override
    public BooleanParameters getParameters() {
        return parameters;
    }
}
