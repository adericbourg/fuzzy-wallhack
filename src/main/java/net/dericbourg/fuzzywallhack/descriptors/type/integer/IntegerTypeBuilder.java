package net.dericbourg.fuzzywallhack.descriptors.type.integer;

import net.dericbourg.fuzzywallhack.descriptors.type.TypeBuilder;

import java.util.HashMap;
import java.util.Map;

public class IntegerTypeBuilder implements TypeBuilder<IntegerType, IntegerParameters> {

    private final Map<String, Object> parameters = new HashMap<>();

    @Override
    public IntegerType build() {
        return new IntegerType(this);
    }

    @Override
    public IntegerParameters getParameters() {
        return new IntegerParameters(parameters);
    }
}
