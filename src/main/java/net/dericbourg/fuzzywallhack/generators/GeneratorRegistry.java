package net.dericbourg.fuzzywallhack.generators;

import java.util.Optional;

public enum GeneratorRegistry {

    INTEGER("integer", new IntegerGenerator()),
    STRING("string", new StringGenerator()),
    UUID("uuid", new UuidGenerator()),
    BOOLEAN("bool", new BooleanGenerator()),
    STRUCTURE("structure", new StructureGenerator()),
    ARRAY("array", new ArrayGenerator());

    private final String type;
    private final Generator generator;

    GeneratorRegistry(String type, Generator generator) {
        this.type = type;
        this.generator = generator;
    }

    String getType() {
        return type;
    }

    public static Optional<Generator> getGenerator(String type) {
        for (GeneratorRegistry generatorRegistry : values()) {
            if (generatorRegistry.getType().equals(type)) {
                return Optional.of(generatorRegistry.generator);
            }
        }
        return Optional.empty();
    }
}
