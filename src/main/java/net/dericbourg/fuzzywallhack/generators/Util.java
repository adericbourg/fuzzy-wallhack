package net.dericbourg.fuzzywallhack.generators;

class Util {

    private Util() { }

    static String generate(Object generator) {
        StringBuilder sb = new StringBuilder();
        if (generator instanceof ComplexDataGenerator) {
            sb.append(((ComplexDataGenerator) generator).generate());
        } else if (generator instanceof ArrayGenerator) {
            sb.append(((ArrayGenerator) generator).generate());
        } else {
            sb.append(generateForType(generator));
        }
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
}
