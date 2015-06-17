package net.dericbourg.fuzzywallhack.generators;

import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

import java.util.Random;

public class IntegerGenerator implements Generator {

    private final Random random = new Random(System.nanoTime());

    @Override
    public String generate(PropertyTypeParameters parameters) {
        // TODO Handle bounds
        return "" + Math.abs(random.nextInt());
    }
}
