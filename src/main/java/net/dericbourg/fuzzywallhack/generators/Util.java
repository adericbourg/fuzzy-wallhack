package net.dericbourg.fuzzywallhack.generators;

import java.util.Optional;

class Util {

    private Util() {
    }

    static String generate(Object generator) {
        StringBuilder sb = new StringBuilder();
        if (generator instanceof NestedDataGenerator) {
            sb.append(((NestedDataGenerator) generator).generate());
        } else {
            generateForType(generator).ifPresentOrElse(
                    sb::append,
                    () -> { throw new IllegalArgumentException("No generator found for type " + generator); }
            );
        }
        return sb.toString();
    }

    private static Optional<String> generateForType(Object value) {
        if (!(value instanceof String)) {
            throw new IllegalArgumentException("String expected, found" + value.getClass());
        }
        String type = (String) value;
        return GeneratorRegistry.getGenerator(type)
                .map(Generator::generate);
    }
}
