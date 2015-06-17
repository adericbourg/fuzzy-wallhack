package net.dericbourg.fuzzywallhack.descriptors.type;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeBuilder;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

import java.util.HashMap;
import java.util.Map;

public class ArrayType implements PropertyType<ArrayType.ArrayParameters> {

    private final ArrayParameters parameters;

    private ArrayType(Builder builder) {
        this.parameters = new ArrayParameters(builder.parameters);
    }

    @Override
    public String getName() {
        return "array";
    }

    @Override
    public ArrayParameters getParameters() {
        return parameters;
    }

    public static class ArrayParameters extends PropertyTypeParameters {

        private static final String SIZE_PARAMETER = "size";
        private static final String INNER_TYPE_PARAMETER = "inner_type";

        public ArrayParameters(Map<String, Object> parameters) {
            super(parameters);
        }

        public int getSize() {
            return getInteger(SIZE_PARAMETER).orElse(5);
        }

        public PropertyType<?> getInnerType() {
            return getTypeParameter(INNER_TYPE_PARAMETER).orElse(PropertyTypeBuilder.string().build());
        }
    }


    public static class Builder {
        private final Map<String, Object> parameters = new HashMap<>();

        public ArrayType build() {
            return new ArrayType(this);
        }

        public Builder withSize(int size) {
            parameters.put(ArrayParameters.SIZE_PARAMETER, size);
            return this;
        }

        public Builder withInnerType(PropertyType<?> type) {
            parameters.put(ArrayParameters.INNER_TYPE_PARAMETER, type);
            return this;
        }
    }
}
