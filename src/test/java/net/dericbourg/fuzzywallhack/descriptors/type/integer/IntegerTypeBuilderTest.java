package net.dericbourg.fuzzywallhack.descriptors.type.integer;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

//Nothing big to test here.
public class IntegerTypeBuilderTest {

    @Test
    public void should_build_integer_type() {
        assertThat(new IntegerTypeBuilder().build())
                .isNotNull()
                .isInstanceOf(IntegerType.class);
    }

    @Test
    public void should_build_parameters() {
        assertThat(new IntegerTypeBuilder().getParameters())
                .isNotNull()
                .isInstanceOf(IntegerParameters.class);
    }
}