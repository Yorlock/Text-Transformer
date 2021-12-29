package pl.put.poznan.transformer.logic;

import java.util.Locale;

public class UnfoldShortcut extends TextDecorator {
    public UnfoldShortcut(String text) {
        super(text);
    }

    @Override
    public String getText() {
        String text = super.getText();
        String[] splitedText = text.split(" ");
        if(splitedText.length == 1){
            if(splitedText[0].toLowerCase().contains("prof.") || splitedText[0].toLowerCase().contains("prof") ||
                    splitedText[0].toLowerCase().contains("dr.") || splitedText[0].toLowerCase().contains("dr") ||
                    splitedText[0].toLowerCase().contains("np.") || splitedText[0].toLowerCase().contains("np") ||
                    splitedText[0].toLowerCase().contains("itp.") || splitedText[0].toLowerCase().contains("itp")){
                text = replaceStuff(text,"", "");
            }
        }
        if(splitedText[0].toLowerCase().contains("prof.") || splitedText[0].toLowerCase().contains("prof") ||
                splitedText[0].toLowerCase().contains("dr.") || splitedText[0].toLowerCase().contains("dr") ||
                splitedText[0].toLowerCase().contains("np.") || splitedText[0].toLowerCase().contains("np") ||
                splitedText[0].toLowerCase().contains("itp.") || splitedText[0].toLowerCase().contains("itp")){
            text = replaceStuff(text,"", " ");
        }
        if(splitedText[splitedText.length - 1].toLowerCase().contains("prof.") ||
                splitedText[splitedText.length - 1].toLowerCase().contains("prof") ||
                splitedText[splitedText.length - 1].toLowerCase().contains("dr.") ||
                splitedText[splitedText.length - 1].toLowerCase().contains("dr") ||
                splitedText[splitedText.length - 1].toLowerCase().contains("np.") ||
                splitedText[splitedText.length - 1].toLowerCase().contains("np") ||
                splitedText[splitedText.length - 1].toLowerCase().contains("itp.") ||
                splitedText[splitedText.length - 1].toLowerCase().contains("itp")){
            text = replaceStuff(text," ", "");
        }
        return replaceStuff(text," ", " ");
    }

    private String replaceStuff(String text, String left, String right){
        if(text.toLowerCase().contains(left+"prof."+right)){
            if(Character.isUpperCase(text.charAt(0))){
                text = text.toLowerCase().replaceAll(left+"prof."+right, left+"Profesor"+right);
            }
            text = text.toLowerCase().replaceAll(left+"prof."+right, left+"profesor"+right);
        }
        if(text.toLowerCase().contains(left+"prof"+right)){
            if(Character.isUpperCase(text.charAt(0))){
                text = text.toLowerCase().replaceAll(left+"prof"+right, left+"Profesor"+right);
            }
            text = text.toLowerCase().replaceAll(left+"prof"+right, left+"profesor"+right);
        }
        if(text.toLowerCase().contains(left+"dr."+right)){
            if(Character.isUpperCase(text.charAt(0))){
                text = text.toLowerCase().replaceAll(left+"dr."+right, left+"Doktor"+right);
            }
            text = text.toLowerCase().replaceAll(left+"dr."+right, left+"doktor"+right);
        }
        if(text.toLowerCase().contains(left+"dr"+right)){
            if(Character.isUpperCase(text.charAt(0))){
                text = text.toLowerCase().replaceAll(left+"dr"+right, left+"Doktor"+right);
            }
            text = text.toLowerCase().replaceAll(left+"dr"+right, left+"doktor"+right);
        }
        if(text.toLowerCase().contains(left+"np."+right)){
            if(Character.isUpperCase(text.charAt(0))){
                text = text.toLowerCase().replaceAll(left+"np."+right, left+"Na przyklad"+right);
            }
            else if(Character.isUpperCase(text.charAt(1))){
                text = text.toLowerCase().replaceAll(left+"np."+right, left+"na Przyklad"+right);
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1))){
                text = text.toLowerCase().replaceAll(left+"np."+right, left+"Na Przyklad"+right);
            }
            text = text.toLowerCase().replaceAll(left+"np."+right, left+"na przyklad"+right);
        }
        if(text.toLowerCase().contains(left+"np"+right)){
            if(Character.isUpperCase(text.charAt(0))){
                text = text.toLowerCase().replaceAll(left+"np"+right, left+"Na przyklad"+right);
            }
            else if(Character.isUpperCase(text.charAt(1))){
                text = text.toLowerCase().replaceAll(left+"np"+right, left+"na Przyklad"+right);
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1))){
                text = text.toLowerCase().replaceAll(left+"np"+right, left+"Na Przyklad"+right);
            }
            text = text.toLowerCase().replaceAll(left+"np"+right, left+"na przyklad"+right);
        }
        if(text.toLowerCase().contains(left+"itp."+right)){
            if(Character.isUpperCase(text.charAt(0))){
                text = text.toLowerCase().replaceAll(left+"itp."+right, left+"I tym podobne"+right);
            }
            else if(Character.isUpperCase(text.charAt(1))){
                text = text.toLowerCase().replaceAll(left+"itp."+right, left+"i Tym podobne"+right);
            }
            else if(Character.isUpperCase(text.charAt(2))){
                text = text.toLowerCase().replaceAll(left+"itp."+right, left+"i tym Podobne"+right);
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1))){
                text = text.toLowerCase().replaceAll(left+"itp."+right, left+"I Tym podobne"+right);
            }
            else if(Character.isUpperCase(text.charAt(1)) && Character.isUpperCase(text.charAt(2))){
                text = text.toLowerCase().replaceAll(left+"itp."+right, left+"i Tym Podobne"+right);
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(2))){
                text = text.toLowerCase().replaceAll(left+"itp."+right, left+"I tym Podobne"+right);
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1)) && Character.isUpperCase(text.charAt(2))){
                text = text.toLowerCase().replaceAll(left+"itp."+right, left+"I tym Podobne"+right);
            }
            text = text.toLowerCase().replaceAll(left+"itp."+right, left+"i tym podobne"+right);
        }
        if(text.toLowerCase().contains("itp.")){
            if(Character.isUpperCase(text.charAt(0))){
                text = text.toLowerCase().replaceAll(left+"itp"+right, left+"I tym podobne"+right);
            }
            else if(Character.isUpperCase(text.charAt(1))){
                text = text.toLowerCase().replaceAll(left+"itp"+right, left+"i Tym podobne"+right);
            }
            else if(Character.isUpperCase(text.charAt(2))){
                text = text.toLowerCase().replaceAll(left+"itp"+right, left+"i tym Podobne"+right);
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1))){
                text = text.toLowerCase().replaceAll(left+"itp"+right, left+"I Tym podobne"+right);
            }
            else if(Character.isUpperCase(text.charAt(1)) && Character.isUpperCase(text.charAt(2))){
                text = text.toLowerCase().replaceAll(left+"itp"+right, left+"i Tym Podobne"+right);
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(2))){
                text = text.toLowerCase().replaceAll(left+"itp"+right, left+"I tym Podobne"+right);
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1)) && Character.isUpperCase(text.charAt(2))){
                text = text.toLowerCase().replaceAll(left+"itp"+right, left+"I tym Podobne"+right);
            }
            text = text.toLowerCase().replaceAll(left+"itp"+right, left+"i tym podobne"+right);
        }
        return text;
    }
}