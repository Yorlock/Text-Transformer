package pl.put.poznan.transformer.logic;

public class FoldShortcut extends TextDecorator {
    public FoldShortcut(String text) {
        super(text);
    }

    @Override
    public String getText() {
        String text = super.getText();
        String[] splitedText = text.split(" ");
        if(splitedText.length == 2 && (splitedText[0].toLowerCase().contains("na") &&
                splitedText[1].toLowerCase().contains("przykład")) ||
                (splitedText[0].toLowerCase().contains("między") && splitedText[1].toLowerCase().contains("innymi"))){
            text = replaceStuff(text,"", "");
        }
        if(splitedText.length == 3 && splitedText[0].toLowerCase().contains("i") &&
                splitedText[1].toLowerCase().contains("tym") &&
                splitedText[2].toLowerCase().contains("podobne")){
            text = replaceStuff(text,"", "");
        }
        if(splitedText.length >= 2 && (splitedText[0].toLowerCase().contains("na") &&
                splitedText[1].toLowerCase().contains("przykład")) ||
                (splitedText[0].toLowerCase().contains("między") && splitedText[1].toLowerCase().contains("innymi"))){
            text = replaceStuff(text," ", "");
            text = replaceStuff(text,"", " ");
        }
        if(splitedText.length >= 3 && splitedText[0].toLowerCase().contains("i") &&
                splitedText[1].toLowerCase().contains("tym") &&
                splitedText[2].toLowerCase().contains("podobne")){
            text = replaceStuff(text," ", "");
            text = replaceStuff(text,"", " ");
        }
        return replaceStuff(text," ", " ");
    }

    private String replaceStuff(String text, String left, String right){
        if(text.toLowerCase().contains(left+"na przykład"+right)){
            text = text.toLowerCase().replaceAll(left+"na przykład"+right, left+"np."+right);
        }
        if(text.toLowerCase().contains(left+"między innymi"+right)){
            text = text.toLowerCase().replaceAll(left+"między innymi"+right, left+"m.in."+right);
        }
        if(text.toLowerCase().contains(left+"i tym podobne"+right)){
            text = text.toLowerCase().replaceAll(left+"i tym podobne"+right, left+"itd."+right);
        }
        return text;
    }
}