package net.dericbourg.fuzzywallhack;

import net.dericbourg.fuzzywallhack.api.GenerationConfiguration;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeBuilder;
import net.dericbourg.fuzzywallhack.descriptors.StructureDescriptor;
import net.dericbourg.fuzzywallhack.descriptors.type.ArrayType;
import net.dericbourg.fuzzywallhack.descriptors.type.StructureType;
import net.dericbourg.fuzzywallhack.generators.RootGenerator;

/**
 * Application entry point.
 */
public class FW {

    public static void main(String[] args) {

        // TODO Generator parameters.
        GenerationConfiguration cfg = new GenerationConfiguration();
        cfg.setFormatted(true);

        StructureType innerComplexData = PropertyTypeBuilder.structure()
                .addProperty("inner", PropertyTypeBuilder.string().build())
               // .addProperty("name", null)
                .build();

        ArrayType simpleArray = PropertyTypeBuilder.array()
                .withInnerType(PropertyTypeBuilder.string().build())
                .withSize(5)
                .build();


        ArrayType complexArray = PropertyTypeBuilder.array()
                .withInnerType(PropertyTypeBuilder.structure()
                                .addProperty("val1", PropertyTypeBuilder.integer().build())
                                .addProperty("val2", PropertyTypeBuilder.uuid().build())
                                .build()
                )
                .build();


        StructureDescriptor data = new StructureDescriptor.Builder()
                .withProperty("field1", PropertyTypeBuilder.string().build())
                        // .addProperty("field2", PropertyTypeBuilder.word().build())
                .withProperty("field3", PropertyTypeBuilder.integer().build())
                .withProperty("field4", innerComplexData)
                .withProperty("field5", simpleArray)
                .withProperty("field6", complexArray)
                .withProperty("field7", PropertyTypeBuilder.bool().build())
                .build();

        RootGenerator rootGenerator = new RootGenerator();

        for (int i = 0; i < 10; i++) {
            System.out.println(rootGenerator.generate(data));
            System.out.println("--");
        }
    }
}
