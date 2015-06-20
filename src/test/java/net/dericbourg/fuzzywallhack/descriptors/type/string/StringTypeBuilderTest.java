package net.dericbourg.fuzzywallhack.descriptors.type.string;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTypeBuilderTest {

    @Test
    public void should_build_string_type() {
        assertThat(new StringTypeBuilder().build())
                .isNotNull()
                .isInstanceOf(StringType.class);
    }

    @Test
    public void should_build_parameters() {
        assertThat(new StringTypeBuilder().getParameters())
                .isNotNull()
                .isInstanceOf(StringParameters.class);
    }

    @Test
    public void min_length_should_be_passed_to_parameters() {
        for (int i = 0; i < 3; i++) {
            assertThat(new StringTypeBuilder().withMinLength(i).getParameters().getMinLength()).isEqualTo(i);
        }
    }

    @Test
    public void max_length_should_be_passed_to_parameters() {
        for (int i = 0; i < 3; i++) {
            assertThat(new StringTypeBuilder().withMaxLength(i).getParameters().getMaxLength()).isEqualTo(i);
        }
    }
}