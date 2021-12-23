package pl.put.poznan.transformer.logic;

public class LatexFormat extends TextDecorator {
    public LatexFormat(String text) {
        super(text);
    }

    @Override
    public String getText() {
        String text = super.getText();
        StringBuilder result = new StringBuilder();
        for (int i=0; i<text.length(); i++)
            switch (text.charAt(i)){
                case '&': result.append("\\&"); break;
                case '$': result.append("\\$"); break;
                default: result.append(text.charAt(i));
            }
        return result.toString();
    }
}