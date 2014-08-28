package net.dericbourg.fuzzywallhack.generators;

import java.util.Random;

public class IntegerGenerator implements Generator {

    private final Random random = new Random(System.nanoTime());

    @Override
    public String generate() {
        return "" + Math.abs(random.nextInt());
    }
}
