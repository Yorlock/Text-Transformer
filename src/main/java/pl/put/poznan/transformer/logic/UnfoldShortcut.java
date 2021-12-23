package pl.put.poznan.transformer.logic;

public class UnfoldShortcut extends TextDecorator {
    public UnfoldShortcut(String text) {
        super(text);
    }

    @Override
    public String getText() {
        StringBuilder result = new StringBuilder();
        String text = super.getText();
        String[] splitedText = text.split(" ");
        for(int i=0; i<splitedText.length - 1; i++) {
            result.append(findShortcut(splitedText[i])).append(" ");
        }
        result.append(findShortcut(splitedText[splitedText.length - 1]));
        return result.toString();
    }

    private String findShortcut(String text){
        switch (text.toLowerCase()){
            case "prof.":
            case "prof":
                if(Character.isUpperCase(text.charAt(0))){
                    return "Profesor";
                }
                return "profesor";
            case "dr.":
            case "dr":
                if(Character.isUpperCase(text.charAt(0))){
                    return "Doktor";
                }
                return "doktor";
            case "np.":
            case "np":
                if(Character.isUpperCase(text.charAt(0))){
                    return "Na przyklad";
                }
                else if(Character.isUpperCase(text.charAt(1))){
                    return "na Przyklad";
                }
                else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1))){
                    return "Na Przyklad";
                }
                return "na przyklad";
            case "itp.":
            case "itp":
                if(Character.isUpperCase(text.charAt(0))){
                    return "I tym podobne";
                }
                else if(Character.isUpperCase(text.charAt(1))){
                    return "i Tym podobne";
                }
                else if(Character.isUpperCase(text.charAt(2))){
                    return "i tym Podobne";
                }
                else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1))){
                    return "I Tym podobne";
                }
                else if(Character.isUpperCase(text.charAt(1)) && Character.isUpperCase(text.charAt(2))){
                    return "i Tym Podobne";
                }
                else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(2))){
                    return "I tym Podobne";
                }
                else if(Character.isUpperCase(text.charAt(0)) && Character.isUpperCase(text.charAt(1)) && Character.isUpperCase(text.charAt(2))){
                    return "I tym Podobne";
                }
                return "i tym podobne";
        }
        return text;
    }
}