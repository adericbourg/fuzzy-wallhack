package net.dericbourg.fuzzywallhack.descriptors.type.array;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;
import net.dericbourg.fuzzywallhack.descriptors.type.TypeBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link ArrayType} builder.
 */
public class ArrayTypeBuilder implements TypeBuilder<ArrayType, ArrayParameters> {

    private final Map<String, Object> parameters = new HashMap<>();

    public ArrayTypeBuilder withSize(int size) {
        parameters.put(ArrayParameters.SIZE_PARAMETER, size);
        return this;
    }

    public ArrayTypeBuilder withInnerType(PropertyType<?> type) {
        parameters.put(ArrayParameters.INNER_TYPE_PARAMETER, type);
        return this;
    }

    @Override
    public ArrayType build() {
        return new ArrayType(this);
    }

    @Override
    public ArrayParameters getParameters() {
        return new ArrayParameters(parameters);
    }
}
