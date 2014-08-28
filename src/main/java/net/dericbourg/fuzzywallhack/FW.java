package net.dericbourg.fuzzywallhack;

import java.util.LinkedHashMap;
import java.util.Map;

import net.dericbourg.fuzzywallhack.data.ComplexData;

/**
 * Application entry point.
 */
public class FW {

    public static void main(String[] args) {

        // TODO Generator parameters.

        Map<String, Object> innerData = new LinkedHashMap<>();
        innerData.put("inner", "string");
        innerData.put("name", "first_name");
        ComplexData cd = new ComplexData(innerData);

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("field1", "string");
        data.put("field2", "word");
        data.put("field3", "integer");
        data.put("field4", cd);

        ComplexData d = new ComplexData(data);

        for (int i = 0; i < 10; i++) {
            System.out.println(generate(d));
        }
    }

    private static String generate(ComplexData data) {
        return data.generate();
    }
}
