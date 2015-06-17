package net.dericbourg.fuzzywallhack.generators;

import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

import java.util.UUID;

/**
 * UUID generator.
 */
public class UuidGenerator implements Generator {

    @Override
    public String generate(PropertyTypeParameters parameters) {
        return "\"" + UUID.randomUUID().toString() + "\"";
    }
}
