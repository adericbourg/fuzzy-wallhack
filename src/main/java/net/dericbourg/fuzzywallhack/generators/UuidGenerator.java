package net.dericbourg.fuzzywallhack.generators;

import java.util.UUID;

/**
 * UUID generator.
 */
public class UuidGenerator implements Generator {

    @Override
    public String generate() {
        return "\"" + UUID.randomUUID().toString() + "\"";
    }
}
