package net.dericbourg.fuzzywallhack.generators;

import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

import java.math.BigInteger;
import java.util.Random;

public class StringGenerator implements Generator {

    private final Random random = new Random();

    @Override
    public String generate(PropertyTypeParameters parameters) {
        String value = new BigInteger(130, random).toString(32);
        return "\"" + value + "\"";
    }
}
