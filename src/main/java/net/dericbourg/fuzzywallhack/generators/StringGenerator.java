package net.dericbourg.fuzzywallhack.generators;

import java.math.BigInteger;
import java.security.SecureRandom;

public class StringGenerator implements Generator {

    private SecureRandom random = new SecureRandom();

    @Override
    public String generate() {
        return new BigInteger(130, random).toString(32);
    }
}
