package net.dericbourg.fuzzywallhack.descriptors;

import com.google.common.collect.ImmutableList;

import java.util.LinkedList;
import java.util.List;

public class StructureDescriptor {

    private final List<Property> properties;

    private StructureDescriptor(Builder builder) {
        this.properties = ImmutableList.copyOf(builder.innerData);
    }

    public List<Property> getProperties() {
        return properties;
    }

    public static class Builder {
        private List<Property> innerData = new LinkedList<>();

        public Builder withProperty(String name, PropertyType data) {
            innerData.add(Property.of(name, data));
            return this;
        }


        public StructureDescriptor build() {
            return new StructureDescriptor(this);
        }
    }

}
