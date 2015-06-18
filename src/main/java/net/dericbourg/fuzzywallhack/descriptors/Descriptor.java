package net.dericbourg.fuzzywallhack.descriptors;

public class Descriptor {

    public static ArrayDescriptor.Builder array() {
        return new ArrayDescriptor.Builder();
    }

    public static ObjectDescriptor.Builder object() {
        return new ObjectDescriptor.Builder();
    }
}
