package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repeats extends TextDecorator {
    public Repeats(String text) {
        super(text);
    }

    @Override
    public String getText() {
        StringBuilder result = new StringBuilder();
        String text = super.getText();
        text = text.trim();
        String[] tmp_list = text.split("\\s+");
        List<String> text_list;
        text_list = Arrays.asList(tmp_list);

        for (int i = 0; i < text_list.size() - 1; i++) {
            if (!text_list.get(i).equals(text_list.get(i + 1))) {
                result.append(" ").append(text_list.get(i));
            }
        }
        if (!text_list.get(text_list.size() - 1).equals(text_list.size() - 2)) {
            result.append(" ").append(text_list.get(text_list.size() - 1));
        }
        return result.toString().trim();
    }
}