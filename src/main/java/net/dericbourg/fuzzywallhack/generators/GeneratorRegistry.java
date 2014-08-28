package net.dericbourg.fuzzywallhack.generators;

public enum GeneratorRegistry implements SimpleGenerator {

    INTEGER("integer", new IntegerGenerator()),
    STRING("string", new StringGenerator()),
    FIRST_NAME("first_name", new FirstNameGenerator()),
    WORD("word", new WordGenerator());

    private final String type;
    private final SimpleGenerator generator;

    private GeneratorRegistry(String type, SimpleGenerator simpleGenerator) {
        this.type = type;
        this.generator = simpleGenerator;
    }

    public String generate() {
        return generator.generate();
    }

    public static SimpleGenerator getGenerator(String type) {
        for (GeneratorRegistry generatorRegistry : values()) {
            if (generatorRegistry.type.equals(type)) {
                return generatorRegistry;
            }
        }
        throw new IllegalArgumentException("Type has no generator: " + type);
    }
}
