package net.dericbourg.fuzzywallhack.data;

import java.util.Map;

import net.dericbourg.fuzzywallhack.generators.Generator;
import net.dericbourg.fuzzywallhack.generators.GeneratorRegistry;

public class ComplexData {

    private final Map<String, Object> data;

    public ComplexData(Map<String, Object> data) {
        this.data = data;
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

    private String generateForType(Object value) {
        if (!(value instanceof String)) {
            throw new IllegalArgumentException("String expected, found" + value.getClass());
        }
        String type = (String) value;
        Generator generator = GeneratorRegistry.getGenerator(type);
        return generator.generate();
    }
}
