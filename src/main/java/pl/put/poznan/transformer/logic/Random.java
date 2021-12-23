package pl.put.poznan.transformer.logic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.isWhitespace;

class Random extends TextDecorator {
    public Random(String text) {
        super(text);
    }

    @Override
    public String getText() {
        StringBuilder result = new StringBuilder();
        List<String> randomText = new ArrayList<>();
        String text = super.getText();
        String[] splitedText = text.split(" ");
        for(String t : splitedText)
        {
            t = randomOrder(t);
            randomText.add(t);
        }
        char[] splitedTextToChar = text.toCharArray();
        int usedRandomText = 0;
        for(int i=0; i<splitedTextToChar.length; i++)
        {
            if(!isWhitespace(splitedTextToChar[i])){
                result.append(randomText.get(usedRandomText));
                i = i + randomText.get(usedRandomText).length() - 1;
                usedRandomText++;
            }
            else{
                result.append(splitedTextToChar[i]);
            }
        }
        return result.toString();
    }

    private String randomOrder(String text){
        List<String> splitedText = new ArrayList<String>(Arrays.asList(text.split("")));
        StringBuilder newText  = new StringBuilder();
        while(splitedText.size() > 0){
            int randomNumber = (int)(Math.random()*(splitedText.size()));
            newText.append(splitedText.get(randomNumber));
            splitedText.remove(randomNumber);
        }
        return newText.toString();
    }
}