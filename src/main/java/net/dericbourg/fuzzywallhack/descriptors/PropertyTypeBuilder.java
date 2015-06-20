package net.dericbourg.fuzzywallhack.descriptors;

import net.dericbourg.fuzzywallhack.descriptors.type.IntegerType;
import net.dericbourg.fuzzywallhack.descriptors.type.StringType;
import net.dericbourg.fuzzywallhack.descriptors.type.StructureType;
import net.dericbourg.fuzzywallhack.descriptors.type.UuidType;
import net.dericbourg.fuzzywallhack.descriptors.type.array.ArrayTypeBuilder;
import net.dericbourg.fuzzywallhack.descriptors.type.bool.BooleanTypeBuilder;

public class PropertyTypeBuilder {

    public static StructureType.Builder structure() {
        return new StructureType.Builder();
    }

    public static StringType.Builder string() {
        return new StringType.Builder();
    }

    public static IntegerType.Builder integer() {
        return new IntegerType.Builder();
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
