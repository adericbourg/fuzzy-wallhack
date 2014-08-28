package net.dericbourg.fuzzywallhack.api;

/**
 * Configure here JSON generation.
 */
public class GenerationConfiguration {

    private boolean formatted = true;

    public boolean isFormatted() {
        return formatted;
    }

    public void setFormatted(boolean formatted) {
        this.formatted = formatted;
    }
}
