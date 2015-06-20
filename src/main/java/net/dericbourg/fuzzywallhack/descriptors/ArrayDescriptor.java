package net.dericbourg.fuzzywallhack.descriptors;

import net.dericbourg.fuzzywallhack.descriptors.type.array.ArrayType;

public class ArrayDescriptor extends Descriptor {
    private final ArrayType arrayType;

    ArrayDescriptor(ArrayType arrayType) {
        this.arrayType = arrayType;
    }

    public ArrayType getArrayType() {
        return arrayType;
    }

    public static class Builder {
        public ArrayDescriptor of(ArrayType arrayType) {
            return new ArrayDescriptor(arrayType);
        }
    }
}
