package net.dericbourg.fuzzywallhack.descriptors.type;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StructureType implements PropertyType<StructureType.StructureParameters> {

    private final StructureParameters parameters;

    private StructureType(Builder builder) {
        this.parameters = new StructureParameters(builder.parameters);
    }

    @Override
    public String getName() {
        return "structure";
    }

    @Override
    public StructureParameters getParameters() {
        return parameters;
    }

    public static class StructureParameters extends PropertyTypeParameters {
        public StructureParameters(Map<String, Object> parameters) {
            super(parameters);
        }

        public Map<String, PropertyType<?>> getProperties() {
            // It works by construction but a bit of type-safety wouldn't be bad there.
            return getParameters().entrySet()
                    .stream()
                    .collect(Collectors.toMap(Entry::getKey,
                            e -> (PropertyType<?>) e.getValue()));
        }
    }

    public static class Builder {
        private final Map<String, Object> parameters = new HashMap<>();

        public Builder addProperty(String name, PropertyType<?> propertyType) {
            parameters.put(name, propertyType);
            return this;
        }

        public StructureType build() {
            return new StructureType(this);
        }
    }
}
