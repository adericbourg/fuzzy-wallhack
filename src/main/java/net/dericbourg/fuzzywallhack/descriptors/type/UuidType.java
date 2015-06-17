package net.dericbourg.fuzzywallhack.descriptors.type;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

import java.util.HashMap;
import java.util.Map;

public class UuidType implements PropertyType<UuidType.UuidParameters> {

    private final UuidParameters parameters;

    private UuidType(Builder builder) {
        this.parameters = new UuidParameters(builder.parameters);
    }

    @Override
    public String getName() {
        return "uuid";
    }

    @Override
    public UuidParameters getParameters() {
        return parameters;
    }

    public static class UuidParameters extends PropertyTypeParameters {
        public UuidParameters(Map<String, Object> parameters) {
            super(parameters);
        }
    }

    public static class Builder {
        private final Map<String, Object> parameters = new HashMap<>();

        public UuidType build() {
            return new UuidType(this);
        }
    }
}
