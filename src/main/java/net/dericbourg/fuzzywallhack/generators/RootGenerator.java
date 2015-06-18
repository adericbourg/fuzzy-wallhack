package net.dericbourg.fuzzywallhack.generators;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.dericbourg.fuzzywallhack.descriptors.*;

import static com.google.common.base.Preconditions.checkNotNull;

public class RootGenerator {

    public String generate(Descriptor descriptor) {
        checkNotNull(descriptor, "Provide non-null descriptor");
        PropertyType<? extends PropertyTypeParameters> propertyType;
        if (descriptor instanceof ObjectDescriptor) {
            propertyType = ((ObjectDescriptor) descriptor).getPropertyType();
        } else if (descriptor instanceof ArrayDescriptor) {
            propertyType = ((ArrayDescriptor) descriptor).getArrayType();
        } else {
            throw new IllegalArgumentException("Unknows descriptor type: " + descriptor.getClass());
        }

        String json = GeneratorRegistry.getGenerator(propertyType.getName())
                .map(generator -> generator.generate(propertyType.getParameters()))
                .orElseThrow(() -> new IllegalArgumentException("No generator found for type: " + propertyType.getName()));

        return format(json);
    }

    private String format(String json) {
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonElement el = parser.parse(json);
        return gson.toJson(el);
    }
}