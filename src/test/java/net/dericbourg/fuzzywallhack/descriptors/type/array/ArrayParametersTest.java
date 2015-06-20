package net.dericbourg.fuzzywallhack.descriptors.type.array;

import com.google.common.collect.ImmutableMap;
import net.dericbourg.fuzzywallhack.descriptors.type.StringType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayParametersTest {

    @Test
    public void get_size_should_return_by_default_a_non_zero_value() {
        ArrayParameters arrayParameters = new ArrayParameters(ImmutableMap.of());
        assertThat(arrayParameters.getSize()).isGreaterThan(0);
    }

    @Test
    public void get_inner_type_should_return_by_default_a_string_type() {
        ArrayParameters arrayParameters = new ArrayParameters(ImmutableMap.of());
        assertThat(arrayParameters.getInnerType()).isInstanceOf(StringType.class);
    }
}