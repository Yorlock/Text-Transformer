package pl.put.poznan.transformer.logic;

public abstract class TextDecorator implements IText {
    private final String text;

    public TextDecorator(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }
}