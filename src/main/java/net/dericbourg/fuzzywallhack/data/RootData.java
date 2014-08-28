package net.dericbourg.fuzzywallhack.data;

import net.dericbourg.fuzzywallhack.api.GenerationConfiguration;

public class RootData {

    private final GenerationConfiguration configuration;
    private final ComplexData data;

    public RootData(ComplexData data) {
        this(data, new GenerationConfiguration());
    }

    public RootData(ComplexData data, GenerationConfiguration configuration) {
        this.configuration = configuration;
        this.data = data;
    }

    public String generate() {
        String generate = data.generate();
        return generate;
    }
}
