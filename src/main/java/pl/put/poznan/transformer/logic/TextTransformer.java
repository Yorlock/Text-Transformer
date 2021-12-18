package pl.put.poznan.transformer.logic;

import org.apache.commons.lang.WordUtils;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){
        String result = text;
        for(String transform: transforms) {
            switch (transform) {
                case "upper":
                    result = upper(text);
                    break;
                case "lower":
                    result = lower(text);
                    break;
                case "capitalize":
                    result = capitalize(text);
                    break;
                case "inverse":
                    result = inverse(text);
                    break;
                case "intToWord":
                    result = intToWord(text);
                    break;
                case "repeats":
                    result = repeats(text);
                    break;

            }
        }
        return result;
    }

    public String upper(String text) {
        return text.toUpperCase();
    }

    public String lower (String text) {
        return text.toLowerCase();
    }

    public String capitalize (String text) {
        return WordUtils.capitalizeFully(text);
    }

    public String inverse(String text) {
        return null;
    }

    public String intToWord(String text) {
        return null;
    }

    public String repeats (String text) {
        return null;
    }

}
