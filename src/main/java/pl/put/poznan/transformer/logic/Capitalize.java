package pl.put.poznan.transformer.logic;

import org.apache.commons.lang.WordUtils;

class Capitalize extends TextDecorator {
    public Capitalize(String text) {
        super(text);
    }

    @Override
    public String getText(){
        return WordUtils.capitalizeFully(super.getText());}
}
