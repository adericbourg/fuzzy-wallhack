package net.dericbourg.fuzzywallhack.generators;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;
import net.dericbourg.fuzzywallhack.descriptors.type.ArrayType;

/**
 * Array generator.
 */
public class ArrayGenerator implements Generator<ArrayType.ArrayParameters> {

    @Override
    public String generate(ArrayType.ArrayParameters parameters) {
        PropertyType<?> innerType = parameters.getInnerType();
        int size = parameters.getSize();

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        boolean firstItem = true;
        for (int i = 0; i < size; i++) {
            if (firstItem) {
                firstItem = false;
            } else {
                sb.append(",");
            }
            sb.append(GeneratorRegistry.getGenerator(innerType.getName())
                            .map(g -> g.generate(innerType.getParameters()))
                            .orElseThrow(() -> new RuntimeException("Could not generate inner array value"))
            );
        }

        sb.append("]");
        return sb.toString();
    }
}
