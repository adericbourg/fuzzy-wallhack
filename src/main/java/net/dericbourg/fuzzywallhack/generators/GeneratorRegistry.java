package net.dericbourg.fuzzywallhack.generators;

import java.util.Optional;

public enum GeneratorRegistry {

    ARRAY("array", new ArrayGenerator()),
    BOOLEAN("bool", new BooleanGenerator()),
    INTEGER("integer", new IntegerGenerator()),
    STRING("string", new StringGenerator()),
    STRUCTURE("structure", new StructureGenerator()),
    UUID("uuid", new UuidGenerator());

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
