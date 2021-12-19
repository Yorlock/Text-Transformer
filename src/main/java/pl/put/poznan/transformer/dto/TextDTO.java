package pl.put.poznan.transformer.dto;

public class TextDTO {

    private String Text;

    public TextDTO(String text) {
        Text = text;
    }


    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

}
