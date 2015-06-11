package net.dericbourg.fuzzywallhack.generators;

import com.google.common.collect.ImmutableList;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum GeneratorRegistry implements Generator {

    INTEGER("integer", new IntegerGenerator()),
    STRING("string", new StringGenerator()),
    FIRST_NAME("first_name", new FirstNameGenerator()),
    WORD("word", new WordGenerator()),
    UUID("uuid", new UuidGenerator()),
    BOOLEAN("bool", new BooleanGenerator());

    private static final Map<String, Generator> reverseRegistry = ImmutableList.copyOf(values())
            .stream()
            .collect(Collectors.toMap(
                    GeneratorRegistry::getType, Function.identity()
            ));

    private final String type;
    private final Generator generator;

    GeneratorRegistry(String type, Generator generator) {
        this.type = type;
        this.generator = generator;
    }

    String getType() {
        return type;
    }

    public String generate() {
        return generator.generate();
    }

    public static Optional<Generator> getGenerator(String type) {
        return Optional.ofNullable(reverseRegistry.get(type));
    }
}
