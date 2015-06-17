package net.dericbourg.fuzzywallhack.generators;


import net.dericbourg.fuzzywallhack.descriptors.type.BooleanType;

/**
 * Returns <code>true</code> or <code>false</code>.
 */
public class BooleanGenerator implements Generator<BooleanType.BooleanParameters> {

    @Override
    public String generate(BooleanType.BooleanParameters parameters) {
        boolean bool = Math.random() < 0.5;
        return bool
                ? "true"
                : "false";
    }
}
