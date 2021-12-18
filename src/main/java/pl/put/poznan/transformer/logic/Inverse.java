package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

class Inverse extends TextDecorator {
    public Inverse(String text) {
        super(text);
    }

    @Override
    public String getText() {
        String text = super.getText();
        String result = "";
        ArrayList<Boolean> uppers = new ArrayList<Boolean>();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                uppers.add(true);
            } else {
                uppers.add(false);
            }
        }
        for (int i = 0; i < text.length(); i++) {
            if (uppers.get(text.length() - i - 1)) {
                result = Character.toUpperCase(text.charAt(i)) + result;
            } else {
                result = Character.toLowerCase(text.charAt(i)) + result;
            }
        }
        return result;
    }
}