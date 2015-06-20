package net.dericbourg.fuzzywallhack.descriptors.type.array;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;

public class ArrayType implements PropertyType<ArrayParameters> {

    private final ArrayParameters parameters;

    ArrayType(ArrayTypeBuilder arrayTypeBuilder) {
        this.parameters = arrayTypeBuilder.getParameters();
    }

    @Override
    public String getName() {
        return "array";
    }

    @Override
    public ArrayParameters getParameters() {
        return parameters;
    }
}
