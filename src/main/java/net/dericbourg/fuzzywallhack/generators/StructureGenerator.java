package net.dericbourg.fuzzywallhack.generators;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;
import net.dericbourg.fuzzywallhack.descriptors.type.StructureType;

import java.util.Map;

public class StructureGenerator implements Generator<StructureType.StructureParameters> {

    @Override
    public String generate(StructureType.StructureParameters parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        boolean first = true;
        for (Map.Entry<String, PropertyType<?>> propertyEntry : parameters.getProperties().entrySet()) {
            String name = propertyEntry.getKey();
            PropertyType<?> propertyType = propertyEntry.getValue();
            if (first) {
                first = false;
            } else {
                sb.append(", ");
            }
            sb.append("\"");
            sb.append(name);
            sb.append("\": ");
            sb.append(
                    GeneratorRegistry.getGenerator(propertyType.getName())
                            .map(g -> g.generate(propertyType.getParameters()))
                            .orElseThrow(() -> new IllegalArgumentException(
                                            "No generator found for " + propertyType.getName()
                                                    + " (property " + name + ")")
                            )
            );
        }
        sb.append(" }");
        return sb.toString();
    }
}
