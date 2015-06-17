package net.dericbourg.fuzzywallhack.descriptors;

public interface PropertyType<P extends PropertyTypeParameters> {
    String getName();

    P getParameters();

}
