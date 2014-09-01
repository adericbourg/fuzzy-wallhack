package net.dericbourg.fuzzywallhack.generators;

/**
 * Returns <code>true</code> or <code>false</code>.
 */
public class BooleanGenerator implements Generator {
    @Override
    public String generate() {
        boolean bool = Math.random() < 0.5;
        return bool
                ? "true"
                : "false";
    }
}
