package pl.put.poznan.transformer.logic;

/**
 * This is a concrete decorator which converts all lowercase characters to uppercase
 */
public class Upper extends TextDecorator {
    /**
     * Class constructor
     * @param text String which we want to transform
     */
    public Upper(String text) {
        super(text);
    }

    /**
     * converts all lowercase characters to uppercase
     * @return the uppercased string
     */
    @Override
    public String getText(){
        return super.getText().toUpperCase();}
}