package net.dericbourg.fuzzywallhack.generators;

import net.dericbourg.fuzzywallhack.descriptors.type.StructureType;
import net.dericbourg.fuzzywallhack.descriptors.type.UuidType;
import net.dericbourg.fuzzywallhack.descriptors.type.array.ArrayTypeBuilder;
import net.dericbourg.fuzzywallhack.descriptors.type.bool.BooleanTypeBuilder;
import net.dericbourg.fuzzywallhack.descriptors.type.integer.IntegerTypeBuilder;
import net.dericbourg.fuzzywallhack.descriptors.type.string.StringTypeBuilder;
import org.junit.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static net.dericbourg.fuzzywallhack.generators.GeneratorRegistry.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorRegistryTest {

    @Test
    public void registry_types_should_be_unique() {
        Set<String> types = new HashSet<>();
        for (GeneratorRegistry generatorRegistry : GeneratorRegistry.values()) {
            assertThat(types).doesNotContain(generatorRegistry.getType());
            types.add(generatorRegistry.getType());
        }
    }

    @Test
    public void getting_unknown_generator_type_should_return_empty_optional() {
        assertThat(GeneratorRegistry.getGenerator("-1")).isEmpty();
    }

    @Test
    public void passing_null_type_parameter_should_return_empty_optional() {
        assertThat(GeneratorRegistry.getGenerator(null)).isEmpty();
    }

    @Test
    public void property_type_name_should_match_registry_name() {
        assertThat(new ArrayTypeBuilder().build().getName())
                .isEqualTo(ARRAY.getType());
        assertThat(new BooleanTypeBuilder().build().getName())
                .isEqualTo(BOOLEAN.getType());
        assertThat(new IntegerTypeBuilder().build().getName())
                .isEqualTo(INTEGER.getType());
        assertThat(new StringTypeBuilder().build().getName())
                .isEqualTo(STRING.getType());
        assertThat(new UuidType.Builder().build().getName())
                .isEqualTo(UUID.getType());
        assertThat(new StructureType.Builder().build().getName())
                .isEqualTo(STRUCTURE.getType());
    }

    @Test
    public void generators_from_registry_should_match_property_type() {
        checkGeneratorTypeFromRegistry(ARRAY, ArrayGenerator.class);
        checkGeneratorTypeFromRegistry(BOOLEAN, BooleanGenerator.class);
        checkGeneratorTypeFromRegistry(INTEGER, IntegerGenerator.class);
        checkGeneratorTypeFromRegistry(STRING, StringGenerator.class);
        checkGeneratorTypeFromRegistry(STRUCTURE, StructureGenerator.class);
        checkGeneratorTypeFromRegistry(UUID, UuidGenerator.class);
    }

    private <T extends Generator> void checkGeneratorTypeFromRegistry(GeneratorRegistry registry, Class<T> expectedClass) {
        Optional<Generator> generator = getGenerator(registry);
        assertThat(generator).isPresent();
        assertThat(generator).containsInstanceOf(expectedClass);
    }

    private Optional<Generator> getGenerator(GeneratorRegistry registry) {
        return GeneratorRegistry.getGenerator(registry.getType());
    }
}