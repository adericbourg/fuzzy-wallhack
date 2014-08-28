package net.dericbourg.fuzzywallhack;

import net.dericbourg.fuzzywallhack.data.ComplexData;
import net.dericbourg.fuzzywallhack.data.RootData;

/**
 * Application entry point.
 */
public class FW {

    public static void main(String[] args) {

        // TODO Generator parameters.

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

        RootData root = new RootData(data);

        for (int i = 0; i < 10; i++) {
            System.out.println(generate(root));
        }
    }

    private static String generate(RootData data) {
        return data.generate();
    }
}
