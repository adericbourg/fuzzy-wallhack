package net.dericbourg.fuzzywallhack.generators;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterators;
import com.google.common.io.Resources;

/**
 * Word generator. Any kind of word.
 */
public class WordGenerator implements Generator {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(WordGenerator.class);

    private final Iterator<String> iterator;

    public WordGenerator() {
        this("words.values");
    }

    protected WordGenerator(String sourceFile) {
        URL resource = Resources.getResource(this.getClass(), sourceFile);
        try {
            this.iterator = Iterators.cycle(Resources.readLines(resource, Charsets.UTF_8));
        } catch (IOException e) {
            log.error("Error loading data from {}", sourceFile);
            throw Throwables.propagate(e);
        }
    }

    @Override
    public String generate() {
        String value = iterator.next();
        return "\"" + value + "\"";
    }
}
