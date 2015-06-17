package net.dericbourg.fuzzywallhack.descriptors.type;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

import java.util.HashMap;
import java.util.Map;

public class BooleanType implements PropertyType<BooleanType.BooleanParameters> {

    private final BooleanParameters parameters;

    private BooleanType(Builder builder) {
        this.parameters = new BooleanParameters(builder.parameters);
    }

    @Override
    public String getName() {
        return "bool";
    }

    @Override
    public BooleanParameters getParameters() {
        return parameters;
    }

    public static class BooleanParameters extends PropertyTypeParameters {
        public BooleanParameters(Map<String, Object> parameters) {
            super(parameters);
        }
    }

    public static class Builder {
        private final Map<String, Object> parameters = new HashMap<>();

        public BooleanType build() {
            return new BooleanType(this);
        }
    }
}
