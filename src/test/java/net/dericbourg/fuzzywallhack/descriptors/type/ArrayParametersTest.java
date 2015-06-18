package net.dericbourg.fuzzywallhack.descriptors.type;

import com.google.common.collect.ImmutableMap;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeBuilder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayParametersTest {

    @Test
    public void get_size_should_return_by_default_a_non_zero_value() {
        ArrayType.ArrayParameters arrayParameters = new ArrayType.ArrayParameters(ImmutableMap.of());
        assertThat(arrayParameters.getSize()).isGreaterThan(0);
    }

    @Test
    public void get_inner_type_should_return_by_default_a_string_type() {
        ArrayType.ArrayParameters arrayParameters = new ArrayType.ArrayParameters(ImmutableMap.of());
        assertThat(arrayParameters.getInnerType()).isInstanceOf(StringType.class);
    }

    @Test
    public void builder_should_keep_size_parameter_value() {
        for (int i = 0; i < 3; i++) {
            // Just a few iterations to prevent "default value" issue.
            ArrayType.ArrayParameters parameters = new ArrayType.Builder().withSize(i).build().getParameters();
            assertThat(parameters.getSize()).isEqualTo(i);
        }
    }

    @Test
    public void builder_should_keep_inner_type_value() {
        ArrayType.ArrayParameters innerBoolParameters = new ArrayType.Builder()
                .withInnerType(PropertyTypeBuilder.bool().build())
                .build()
                .getParameters();
        assertThat(innerBoolParameters.getInnerType()).isInstanceOf(BooleanType.class);

        ArrayType.ArrayParameters innerIntegerParameters = new ArrayType.Builder()
                .withInnerType(PropertyTypeBuilder.integer().build())
                .build()
                .getParameters();
        assertThat(innerIntegerParameters.getInnerType()).isInstanceOf(IntegerType.class);
    }
}