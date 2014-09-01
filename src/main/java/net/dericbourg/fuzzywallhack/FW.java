package net.dericbourg.fuzzywallhack;

import net.dericbourg.fuzzywallhack.api.GenerationConfiguration;
import net.dericbourg.fuzzywallhack.data.ComplexData;
import net.dericbourg.fuzzywallhack.data.Generator;

/**
 * Application entry point.
 */
public class FW {

    public static void main(String[] args) {

        // TODO Generator parameters.
        GenerationConfiguration cfg = new GenerationConfiguration();
        cfg.setFormatted(false);

        ComplexData innerComplexData = new ComplexData.Builder()
                .withProperty("inner", "string")
                .withProperty("name", "first_name")
                .build();

        ComplexData data = new ComplexData.Builder()
                .withProperty("field1", "string")
                .withProperty("field2", "word")
                .withProperty("field3", "integer")
                .withProperty("field4", innerComplexData)
                .build();

        Generator generator = new Generator(data, cfg);

        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate());
        }
    }
}
