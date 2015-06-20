package net.dericbourg.fuzzywallhack.descriptors.type.array;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeBuilder;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

import java.util.Map;

/**
 * {@link ArrayType} parameters.
 */
public class ArrayParameters extends PropertyTypeParameters {

    static final String SIZE_PARAMETER = "size";
    static final String INNER_TYPE_PARAMETER = "inner_type";

    public ArrayParameters(Map<String, Object> parameters) {
        super(parameters);
    }

    /**
     * Size of the array (number of elements).
     * <p>
     * Default size if 5.
     */
    public int getSize() {
        return getInteger(SIZE_PARAMETER).orElse(5);
    }

    /**
     * Array inner type.
     * <p>
     * Default is {@link String}.
     */
    public PropertyType<?> getInnerType() {
        return getTypeParameter(INNER_TYPE_PARAMETER).orElse(PropertyTypeBuilder.string().build());
    }
}
