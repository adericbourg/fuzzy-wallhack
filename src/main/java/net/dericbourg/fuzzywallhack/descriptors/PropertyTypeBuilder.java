package net.dericbourg.fuzzywallhack.descriptors;

import net.dericbourg.fuzzywallhack.descriptors.type.StructureType;
import net.dericbourg.fuzzywallhack.descriptors.type.UuidType;
import net.dericbourg.fuzzywallhack.descriptors.type.array.ArrayTypeBuilder;
import net.dericbourg.fuzzywallhack.descriptors.type.bool.BooleanTypeBuilder;
import net.dericbourg.fuzzywallhack.descriptors.type.integer.IntegerTypeBuilder;
import net.dericbourg.fuzzywallhack.descriptors.type.string.StringTypeBuilder;

public class PropertyTypeBuilder {

    public static StructureType.Builder structure() {
        return new StructureType.Builder();
    }

    public static StringTypeBuilder string() {
        return new StringTypeBuilder();
    }

    public static IntegerTypeBuilder integer() {
        return new IntegerTypeBuilder();
    }

    public static UuidType.Builder uuid() {
        return new UuidType.Builder();
    }

    public static BooleanTypeBuilder bool() {
        return new BooleanTypeBuilder();
    }

    public static ArrayTypeBuilder array() {
        return new ArrayTypeBuilder();
    }
}
