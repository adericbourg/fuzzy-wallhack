package net.dericbourg.fuzzywallhack.generators;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.dericbourg.fuzzywallhack.descriptors.Property;
import net.dericbourg.fuzzywallhack.descriptors.PropertyTypeBuilder;
import net.dericbourg.fuzzywallhack.descriptors.StructureDescriptor;
import net.dericbourg.fuzzywallhack.descriptors.type.StructureType;

public class RootGenerator {

    public String generate(StructureDescriptor descriptor) {
        StructureType.Builder structure = PropertyTypeBuilder.structure();
        for (Property property : descriptor.getProperties()) {
            structure.addProperty(property.getName(), property.getType());
        }
        StructureType build = structure.build();

        String json = GeneratorRegistry.getGenerator(build.getName())
                .map(generator -> generator.generate(build.getParameters()))
                .orElseThrow(() -> new IllegalArgumentException("No generator found for type: " + build.getName()));

        return format(json);
    }

    private String format(String json) {
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonElement el = parser.parse(json);
        return gson.toJson(el);
    }
}