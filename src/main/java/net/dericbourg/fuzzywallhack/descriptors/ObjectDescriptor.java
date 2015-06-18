package net.dericbourg.fuzzywallhack.descriptors;

public class ObjectDescriptor extends Descriptor {

    private final PropertyType<? extends PropertyTypeParameters> propertyType;

    private ObjectDescriptor(PropertyType<? extends PropertyTypeParameters> propertyType) {
        this.propertyType = propertyType;
    }

    public PropertyType<? extends PropertyTypeParameters> getPropertyType() {
        return propertyType;
    }

    public static class Builder {
        public <P extends PropertyTypeParameters> ObjectDescriptor of(PropertyType<P> propertyType) {
            return new ObjectDescriptor(propertyType);
        }
    }
}
