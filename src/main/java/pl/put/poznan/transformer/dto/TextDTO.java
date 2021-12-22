package pl.put.poznan.transformer.dto;

import java.util.List;

public class TextDTO {

    private String text;
    private List<String> transforms;

    public String[] getTransforms() {
        return transforms.toArray(new String[0]);
    }

    public String getText() {
        return text;
    }

}
