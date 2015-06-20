package net.dericbourg.fuzzywallhack.descriptors.type.bool;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

//Nothing be to test here.
public class BooleanTypeBuilderTest {

    @Test
    public void should_build_boolean_type() {
        assertThat(new BooleanTypeBuilder().build())
                .isNotNull()
                .isInstanceOf(BooleanType.class);
    }

    @Test
    public void should_build_parameters() {
        assertThat(new BooleanTypeBuilder().getParameters())
                .isNotNull()
                .isInstanceOf(BooleanParameters.class);
    }
}