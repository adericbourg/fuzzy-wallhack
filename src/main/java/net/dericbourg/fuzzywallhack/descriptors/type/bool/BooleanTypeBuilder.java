package net.dericbourg.fuzzywallhack.descriptors.type.bool;

import net.dericbourg.fuzzywallhack.descriptors.type.TypeBuilder;

import java.util.HashMap;
import java.util.Map;

public class BooleanTypeBuilder implements TypeBuilder<BooleanType, BooleanParameters> {

    private final Map<String, Object> parameters = new HashMap<>();

    public BooleanType build() {
        return new BooleanType(this);
    }

    @Override
    public BooleanParameters getParameters() {
        return new BooleanParameters(parameters);
    }
}
