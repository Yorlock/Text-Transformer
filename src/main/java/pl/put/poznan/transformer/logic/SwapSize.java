package pl.put.poznan.transformer.logic;

class SwapSize extends TextDecorator {
    public SwapSize(String text) {
        super(text);
    }

    @Override
    public String getText() {
        StringBuilder result = new StringBuilder();
        String text = super.getText();
        char[] splitedText = text.toCharArray();
        for(char word : splitedText)
        {
            int ascii = (byte) word;
            if (ascii >= 65 && ascii <= 90){
                word = (char) ((ascii+32));
            }
            else if(ascii >= 97 && ascii <= 122){
                word = (char) ((ascii-32));
            }
            result.append(word);
        }
        return result.toString();
    }
}