package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

class Inverse extends TextDecorator {
    public Inverse(String text) {
        super(text);
    }

    @Override
    public String getText() {
        String text = super.getText();
        StringBuilder result = new StringBuilder();
        ArrayList<Boolean> uppers = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                uppers.add(true);
            } else {
                uppers.add(false);
            }
        }
        for (int i = 0; i < text.length(); i++) {
            if (uppers.get(text.length() - i - 1)) {
                result.insert(0, Character.toUpperCase(text.charAt(i)));
            } else {
                result.insert(0, Character.toLowerCase(text.charAt(i)));
            }
        }
        return result.toString();
    }
}