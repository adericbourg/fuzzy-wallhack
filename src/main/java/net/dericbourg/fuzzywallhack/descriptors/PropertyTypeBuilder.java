package net.dericbourg.fuzzywallhack.descriptors;

import net.dericbourg.fuzzywallhack.descriptors.type.*;

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

    public static BooleanType.Builder bool() {
        return new BooleanType.Builder();
    }

    public static ArrayType.Builder array() {
        return new ArrayType.Builder();
    }
}
