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
                    result = new Upper(result).getText();
                    break;
                case "lower":
                    result = new Lower(result).getText();
                    break;
                case "capitalize":
                    result = new Capitalize(result).getText();
                    break;
                case "inverse":
                    result = new Inverse(result).getText();
                    break;
                case "intToWord":
                    result = new IntToWord(result).getText();
                    break;
                case "repeats":
                    result = new Repeats(result).getText();
                    break;
                case "swapsize":
                    result = new SwapSize(result).getText();
                    break;
                case "random":
                    result = new Random(result).getText();
                case "unfoldshortcut":
                   result = new UnfoldShortcut(result).getText();
            }
        }
        return result;
    }
}
