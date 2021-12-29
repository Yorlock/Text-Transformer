package pl.put.poznan.transformer.logic;

public class FoldShortcut extends TextDecorator {
    public FoldShortcut(String text) {
        super(text);
    }

    @Override
    public String getText() {
        String text = super.getText();
        return replaceStuff(text);
    }

    private String replaceStuff(String text){
        if(text.toLowerCase().contains("na przykład")){
            text = text.replaceAll("\\bna przykład\\b", "np."); //dodac na poczatek regex (?i) by było canse insensitive
        }
        if(text.toLowerCase().contains("między innymi")){
            text = text.replaceAll("\\bmiędzy innymi\\b", "m.in.");
        }
        if(text.toLowerCase().contains("i tym podobne")){
            text = text.replaceAll("\\bi tym podobne\\b", "itd.");
        }
        return text;
    }
}