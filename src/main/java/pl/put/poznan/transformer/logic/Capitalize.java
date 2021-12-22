package pl.put.poznan.transformer.logic;

import org.apache.commons.lang.WordUtils;

/**
 * This is a concrete decorator which capitalize given text
 */

class Capitalize extends TextDecorator {
    /**
     * class constructor
     * @param text string which we want to transform
     */
    public Capitalize(String text) {
        super(text);
    }

    /**
     * Converts all words in a text into capitalized words
     * @return transformed text
     */
    @Override
    public String getText(){
        return WordUtils.capitalizeFully(super.getText());}
}
