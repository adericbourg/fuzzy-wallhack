package net.dericbourg.fuzzywallhack.generators;

public enum GeneratorRegistry implements Generator {

    INTEGER("integer", new IntegerGenerator()),
    STRING("string", new StringGenerator()),
    FIRST_NAME("first_name", new FirstNameGenerator()),
    WORD("word", new WordGenerator()),
    UUID("uuid", new UuidGenerator());

    private final String type;
    private final Generator generator;

    private GeneratorRegistry(String type, Generator generator) {
        this.type = type;
        this.generator = generator;
    }

    public String generate() {
        return generator.generate();
    }

    public static Generator getGenerator(String type) {
        for (GeneratorRegistry generatorRegistry : values()) {
            if (generatorRegistry.type.equals(type)) {
                return generatorRegistry;
            }
        }
        throw new IllegalArgumentException("Type has no generator: " + type);
    }
}
