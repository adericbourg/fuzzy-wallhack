package net.dericbourg.fuzzywallhack.descriptors;

public class Property {

    private final String name;
    private final PropertyType type;

    private Property(String name, PropertyType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public PropertyType getType() {
        return type;
    }

    public static Property of(String name, PropertyType propertyType) {
        return new Property(name, propertyType);
    }
}
