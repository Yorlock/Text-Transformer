package pl.put.poznan.transformer.logic;

class Upper extends TextDecorator {
    public Upper(String text) {
        super(text);
    }

    @Override
    public String getText(){
        return super.getText().toUpperCase();}
}