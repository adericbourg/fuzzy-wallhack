package net.dericbourg.fuzzywallhack.generators;


import net.dericbourg.fuzzywallhack.descriptors.type.bool.BooleanParameters;

/**
 * Returns <code>true</code> or <code>false</code>.
 */
public class BooleanGenerator implements Generator<BooleanParameters> {

    @Override
    public String generate(BooleanParameters parameters) {
        boolean bool = Math.random() < 0.5;
        return bool
                ? "true"
                : "false";
    }
}
