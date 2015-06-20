package net.dericbourg.fuzzywallhack.descriptors.type.string;

import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

import java.util.Map;

public class StringParameters extends PropertyTypeParameters {

    static final String MIN_LENGTH_PARAM = "min_length";
    static final String MAX_LENGTH_PARAM = "max_length";

    public StringParameters(Map<String, Object> parameters) {
        super(parameters);
    }

    /**
     * Generated {@link String} minimum length.
     * <p>
     * Default is 1 character.
     */
    public int getMinLength() {
        return getInteger(MIN_LENGTH_PARAM).orElse(1);
    }

    /**
     * Generated {@link String} maximum length.
     * <p>
     * Default is 10.
     */
    public int getMaxLength() {
        return getInteger(MAX_LENGTH_PARAM).orElse(10);
    }
}