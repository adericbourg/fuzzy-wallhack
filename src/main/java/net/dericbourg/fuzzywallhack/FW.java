package net.dericbourg.fuzzywallhack;

import net.dericbourg.fuzzywallhack.api.GenerationConfiguration;
import net.dericbourg.fuzzywallhack.descriptors.ArrayDescriptor;
import net.dericbourg.fuzzywallhack.descriptors.Descriptor;
import net.dericbourg.fuzzywallhack.descriptors.ObjectDescriptor;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeBuilder;
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


        ObjectDescriptor objectDescriptor = Descriptor.object()
                .of(PropertyTypeBuilder.structure()
                        .addProperty("field1", PropertyTypeBuilder.string().build())
                                // .addProperty("field2", PropertyTypeBuilder.word().build())
                        .addProperty("field3", PropertyTypeBuilder.integer().build())
                        .addProperty("field4", innerComplexData)
                        .addProperty("field5", simpleArray)
                        .addProperty("field6", complexArray)
                        .addProperty("field7", PropertyTypeBuilder.bool().build())
                        .build());

        RootGenerator rootGenerator = new RootGenerator();

        System.out.println("OBJECT");
        System.out.println(rootGenerator.generate(objectDescriptor));

        System.out.println();
        System.out.println("ARRAY");
        ArrayDescriptor arrayDescriptor = ObjectDescriptor.array().of(complexArray);
        System.out.println(rootGenerator.generate(arrayDescriptor));
    }
}
