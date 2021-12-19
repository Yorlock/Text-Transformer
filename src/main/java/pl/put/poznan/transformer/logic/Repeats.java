package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Repeats extends TextDecorator { //TODO
    public Repeats(String text) {
        super(text);
    }

    @Override
    public String getText() {
        String result = "";
        String text = super.getText();
        text = text.trim();
        String[] tmp_list = text.split("\\s+");
        List<String> text_list = new ArrayList<String>();
        text_list = Arrays.asList(tmp_list);

        for (int i = 0; i < text_list.size() - 1; i++) {
            if (!text_list.get(i).equals(text_list.get(i + 1))) {
                result = result + " " + text_list.get(i);
            }
        }
        if (!text_list.get(text_list.size() - 1).equals(text_list.size() - 2)) {
            result = result + " " + text_list.get(text_list.size() - 1);
        }
        return result.trim();
    }
}