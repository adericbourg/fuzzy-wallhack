package net.dericbourg.fuzzywallhack.descriptors;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Optional;

public class PropertyTypeParameters {

    private final Map<String, Object> parameters;

    public PropertyTypeParameters(Map<String, Object> parameters) {
        this.parameters = ImmutableMap.copyOf(parameters);
    }

    public Optional<Object> get(String key) {
        return Optional.ofNullable(parameters.get(key));
    }

    public Optional<String> getString(String key) {
        return get(key)
                .filter(o -> o instanceof String)
                .map(o -> (String) o);
    }

    public Optional<Integer> getInteger(String key) {
        return get(key)
                .filter(o -> o instanceof Integer)
                .map(o -> (Integer) o);
    }

    public Optional<PropertyType<?>> getTypeParameter(String key) {
        return get(key)
                .filter(o -> o instanceof PropertyType)
                .map(o -> (PropertyType<?>) o);
    }

    protected Map<String, Object> getParameters() {
        return parameters;
    }
}
