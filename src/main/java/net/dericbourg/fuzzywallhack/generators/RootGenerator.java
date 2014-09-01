package net.dericbourg.fuzzywallhack.generators;

import net.dericbourg.fuzzywallhack.api.GenerationConfiguration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class RootGenerator {

    private final GenerationConfiguration configuration;
    private final ObjectGenerator data;

    public RootGenerator(ObjectGenerator data, GenerationConfiguration configuration) {
        this.configuration = configuration;
        this.data = data;
    }

    public String generate() {
        String generate = data.generate();
        if (configuration.isFormatted()) {
            JsonParser parser = new JsonParser();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            JsonElement el = parser.parse(generate);
            generate = gson.toJson(el);
        }
        return generate;
    }
}
