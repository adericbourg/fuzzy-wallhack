package net.dericbourg.fuzzywallhack.generators;

/**
 * Array generator.
 */
public class ArrayGenerator implements Generator {

    private final Object dataType;
    private final int size;

    public ArrayGenerator(Object dataType, int size) {
        this.dataType = dataType;
        this.size = size;
    }

    @Override
    public String generate() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        boolean firstItem = true;
        for (int i = 0; i < size; i++) {
            if (firstItem) {
                firstItem = false;
            } else {
                sb.append(",");
            }
            sb.append(Util.generate(dataType));
        }

        sb.append("]");
        return sb.toString();
    }
}
