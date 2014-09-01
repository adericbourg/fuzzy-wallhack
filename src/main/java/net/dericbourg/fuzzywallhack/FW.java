package net.dericbourg.fuzzywallhack;

import net.dericbourg.fuzzywallhack.api.GenerationConfiguration;
import net.dericbourg.fuzzywallhack.generators.ArrayGenerator;
import net.dericbourg.fuzzywallhack.generators.ComplexDataGenerator;
import net.dericbourg.fuzzywallhack.generators.RootGenerator;

/**
 * Application entry point.
 */
public class FW {

    public static void main(String[] args) {

        // TODO Generator parameters.
        GenerationConfiguration cfg = new GenerationConfiguration();
        cfg.setFormatted(true);

        ComplexDataGenerator innerComplexData = new ComplexDataGenerator.Builder()
                .withProperty("inner", "string")
                .withProperty("name", "first_name")
                .build();

        ArrayGenerator simpleArray = new ArrayGenerator("string", 5);

        ComplexDataGenerator complexArrayData = new ComplexDataGenerator.Builder()
                .withProperty("val1", "integer")
                .withProperty("val2", "word")
                .build();
        ArrayGenerator complexArray = new ArrayGenerator(complexArrayData, 2);

        ComplexDataGenerator data = new ComplexDataGenerator.Builder()
                .withProperty("field1", "string")
                .withProperty("field2", "word")
                .withProperty("field3", "integer")
                .withProperty("field4", innerComplexData)
                .withProperty("field5", simpleArray)
                .withProperty("field6", complexArray)
                .build();

        RootGenerator rootGenerator = new RootGenerator(data, cfg);

        for (int i = 0; i < 10; i++) {
            System.out.println(rootGenerator.generate());
            System.out.println("--");
        }
    }
}
