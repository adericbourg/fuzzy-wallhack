package net.dericbourg.fuzzywallhack.data;

import java.util.LinkedHashMap;
import java.util.Map;

import net.dericbourg.fuzzywallhack.generators.Generator;
import net.dericbourg.fuzzywallhack.generators.GeneratorRegistry;

import com.google.common.collect.ImmutableMap;

public class ComplexData {

    private final Map<String, Object> data;

    private ComplexData(Builder builder) {
        this.data = ImmutableMap.copyOf(builder.innerData);
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        boolean first = true;
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (first) {
                first = false;
            } else {
                sb.append(", ");
            }

            sb.append("\"");
            sb.append(key);
            sb.append("\": ");
            if (value instanceof ComplexData) {
                sb.append(((ComplexData) value).generate());
            } else {
                sb.append("\"");
                sb.append(generateForType(value));
                sb.append("\"");
            }
        }
        sb.append(" }");
        return sb.toString();
    }

    private static String generateForType(Object value) {
        if (!(value instanceof String)) {
            throw new IllegalArgumentException("String expected, found" + value.getClass());
        }
        String type = (String) value;
        Generator generator = GeneratorRegistry.getGenerator(type);
        return generator.generate();
    }

    public static class Builder {

        private Map<String, Object> innerData = new LinkedHashMap<>();

        public Builder withProperty(String name, Object data) {
            innerData.put(name, data);
            return this;
        }


        public ComplexData build() {
            return new ComplexData(this);
        }
    }
}
