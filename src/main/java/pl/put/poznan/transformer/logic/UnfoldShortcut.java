package pl.put.poznan.transformer.logic;

import java.util.Locale;

public class UnfoldShortcut extends TextDecorator {
    public UnfoldShortcut(String text) {
        super(text);
    }

    @Override
    public String getText() {
        String text = super.getText();
        return replaceStuff(text);
    }

    private String replaceStuff(String text){
        if(text.toLowerCase().contains("prof.")){
            text = text.replaceAll("\\bProf\\b", "Profesor");
            text = text.replaceAll("\\bprof\\b", "profesor");
        }
        else if(text.toLowerCase().contains("prof")){
            text = text.replaceAll("\\bProf\\b", "Profesor");
            text = text.replaceAll("\\bprof\\b", "profesor");
        }
        if(text.toLowerCase().contains("dr.")){
            text = text.replaceAll("\\bDr\\b", "Doktor");
            text = text.replaceAll("\\bdr\\b", "doktor");
        }
        else if(text.toLowerCase().contains("dr")){
            text = text.replaceAll("\\bDr\\b", "Doktor");
            text = text.replaceAll("\\bdr\\b", "doktor");
        }
        if(text.toLowerCase().contains("np.")){
            if(Character.isUpperCase(text.charAt(0))){
                text = text.replaceAll("\\bNp\\b", "Na przyklad");
            }
            else if(Character.isUpperCase(text.charAt(1))){
                text = text.replaceAll("\\bnP\\b", "na Przyklad");
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1))){
                text = text.replaceAll("\\bNP\\b", "Na Przyklad");
            }
            text = text.replaceAll("\\bnp\\b", "na przyklad");
        }
        else if(text.toLowerCase().contains("np")){
            if(Character.isUpperCase(text.charAt(0))){
                text = text.replaceAll("\\bNp\\b", "Na przyklad");
            }
            else if(Character.isUpperCase(text.charAt(1))){
                text = text.replaceAll("\\bnP\\b", "na Przyklad");
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1))){
                text = text.replaceAll("\\bNP\\b", "Na Przyklad");
            }
            text = text.replaceAll("\\bnp\\b", "na przyklad");
        }
        if(text.toLowerCase().contains("itp.")){
            if(Character.isUpperCase(text.charAt(0))){
                text = text.replaceAll("\\bItp\\b", "I tym podobne");
            }
            else if(Character.isUpperCase(text.charAt(1))){
                text = text.replaceAll("\\biTp\\b", "i Tym podobne");
            }
            else if(Character.isUpperCase(text.charAt(2))){
                text = text.replaceAll("\\bitP\\b", "i tym Podobne");
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1))){
                text = text.replaceAll("\\bITp\\b", "I Tym podobne");
            }
            else if(Character.isUpperCase(text.charAt(1)) && Character.isUpperCase(text.charAt(2))){
                text = text.replaceAll("\\biTP\\b", "i Tym Podobne");
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(2))){
                text = text.replaceAll("\\bItP\\b", "I tym Podobne");
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1)) && Character.isUpperCase(text.charAt(2))){
                text = text.replaceAll("\\bITP\\b", "I tym Podobne");
            }
            text = text.replaceAll("\\bitp\\b", "i tym podobne");
        }
        else if(text.toLowerCase().contains("itp")){
            if(Character.isUpperCase(text.charAt(0))){
                text = text.replaceAll("\\bItp\\b", "I tym podobne");
            }
            else if(Character.isUpperCase(text.charAt(1))){
                text = text.replaceAll("\\biTp\\b", "i Tym podobne");
            }
            else if(Character.isUpperCase(text.charAt(2))){
                text = text.replaceAll("\\bitP\\b", "i tym Podobne");
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1))){
                text = text.replaceAll("\\bITp\\b", "I Tym podobne");
            }
            else if(Character.isUpperCase(text.charAt(1)) && Character.isUpperCase(text.charAt(2))){
                text = text.replaceAll("\\biTP\\b", "i Tym Podobne");
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(2))){
                text = text.replaceAll("\\bItP\\b", "I tym Podobne");
            }
            else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1)) && Character.isUpperCase(text.charAt(2))){
                text = text.replaceAll("\\bITP\\b", "I tym Podobne");
            }
            text = text.replaceAll("\\bitp\\b", "i tym podobne");
        }
        return text;
    }
}