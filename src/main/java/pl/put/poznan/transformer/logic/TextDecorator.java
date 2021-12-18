package pl.put.poznan.transformer.logic;

public abstract class TextDecorator {
    private final String text;

    public TextDecorator(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}