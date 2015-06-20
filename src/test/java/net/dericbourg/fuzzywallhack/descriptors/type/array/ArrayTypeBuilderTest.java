package net.dericbourg.fuzzywallhack.descriptors.type.array;

import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeBuilder;
import net.dericbourg.fuzzywallhack.descriptors.type.IntegerType;
import net.dericbourg.fuzzywallhack.descriptors.type.bool.BooleanType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayTypeBuilderTest {

    @Test
    public void should_keep_size_parameter_value() {
        for (int i = 0; i < 3; i++) {
            // Just a few iterations to prevent "default value" issue.
            ArrayParameters parameters = new ArrayTypeBuilder().withSize(i).build().getParameters();
            assertThat(parameters.getSize()).isEqualTo(i);
        }
    }

    @Test
    public void should_keep_inner_type_value() {
        ArrayParameters innerBoolParameters = new ArrayTypeBuilder()
                .withInnerType(PropertyTypeBuilder.bool().build())
                .build()
                .getParameters();
        assertThat(innerBoolParameters.getInnerType()).isInstanceOf(BooleanType.class);

        ArrayParameters innerIntegerParameters = new ArrayTypeBuilder()
                .withInnerType(PropertyTypeBuilder.integer().build())
                .build()
                .getParameters();
        assertThat(innerIntegerParameters.getInnerType()).isInstanceOf(IntegerType.class);
    }
}