package pl.put.poznan.transformer.logic;

public class Lower extends TextDecorator {
    public Lower(String text) {
        super(text);
    }

    @Override
    public String getText(){
        return super.getText().toLowerCase();}
}