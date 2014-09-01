package net.dericbourg.fuzzywallhack.generators;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class ObjectGenerator implements NestedDataGenerator {

    private final Map<String, Object> data;

    private ObjectGenerator(Builder builder) {
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
            sb.append(Util.generate(value));
        }
        sb.append(" }");
        return sb.toString();
    }



    public static class Builder {

        private Map<String, Object> innerData = new LinkedHashMap<String, Object>();

        public Builder withProperty(String name, Object data) {
            innerData.put(name, data);
            return this;
        }


        public ObjectGenerator build() {
            return new ObjectGenerator(this);
        }
    }
}
