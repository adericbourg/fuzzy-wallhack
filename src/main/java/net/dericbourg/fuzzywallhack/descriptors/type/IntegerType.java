package net.dericbourg.fuzzywallhack.descriptors.type;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

import java.util.HashMap;
import java.util.Map;

public class IntegerType implements PropertyType<IntegerType.IntegerParameters> {

    private final IntegerParameters parameters;

    private IntegerType(Builder builder) {
        this.parameters = new IntegerParameters(builder.parameters);
    }

    @Override
    public String getName() {
        return "integer";
    }

    @Override
    public IntegerParameters getParameters() {
        return parameters;
    }

    public static class IntegerParameters extends PropertyTypeParameters {
        public IntegerParameters(Map<String, Object> parameters) {
            super(parameters);
        }
    }

    public static class Builder {
        private final Map<String, Object> parameters = new HashMap<>();

        public IntegerType build() {
            return new IntegerType(this);
        }
    }
}
