package net.dericbourg.fuzzywallhack.generators;

import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

public interface Generator<P extends PropertyTypeParameters> {

    String generate(P parameters);
}
