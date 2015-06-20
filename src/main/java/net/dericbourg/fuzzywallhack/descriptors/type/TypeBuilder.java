package net.dericbourg.fuzzywallhack.descriptors.type;

import net.dericbourg.fuzzywallhack.descriptors.PropertyType;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeParameters;

public interface TypeBuilder<T extends PropertyType<P>, P extends PropertyTypeParameters> {

    T build();

    P getParameters();
}
