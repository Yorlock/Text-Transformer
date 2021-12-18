package pl.put.poznan.transformer.logic;

import java.util.regex.Pattern;

class IntToWord extends TextDecorator {
    public IntToWord(String text) {
        super(text);
    }
    @Override
    public String getText() {
        String text = super.getText();
        String[] words = text.split("\\s");
        String regexDouble = "^-?\\d+[.,]\\d+";
        String regexInt = "^-?\\d+";
        String result = "";

        for (String word : words) {
            if(Pattern.matches(regexDouble,word)) {
                String[] number = word.split("[.,]");

                if(number[0].equals("-0")) {
                    result += "minus";
                }
                else {
                    int part1 = Integer.parseInt(number[0]);
                    result += numberPartsDivider(part1);
                }
                int part2 = Integer.parseInt((number[1]));
                int sizeAfterComma = number[1].length();
                result += " i ";
                result += numberPartsDivider(part2);
                if (sizeAfterComma == 1)
                    result += " dziesiate";
                else if (sizeAfterComma == 2)
                    result += " setne";
            }
            else  if (Pattern.matches(regexInt, word)) {
                int numberInt = Integer.parseInt(word);
                result+= numberPartsDivider(numberInt);
            }
            else
                result += word;
            result += " ";
        }

        return result.trim();
    }

    public String digitToString(int digit, int size) {
        String[] jednosci = {"", " jeden", " dwa", " trzy", " cztery", " pięć", " sześć", " siedem", " osiem", " dziewięć"};
        String[] nascie = {"dziesięć", " jedenaście", " dwanaście", " trzynaście", " czternaście", " piętnaście", " szesnaście", " siedemnaście", " osiemnaście", " dziewiętnaście"};
        String[] dziesiatki ={"", " dziesięć", " dwadzieścia", " trzydzieści", " czterdzieści", " pięćdziesiąt", " sześćdziesiąt", " siedemdziesiąt", " osiemdziesiąt", " dziewięćdziesiąt"};
        String[] setki = {"", " sto", " dwieście", " trzysta", " czterysta", " pięćset", " sześćset", " siedemset", " osiemset", " dziewięćset"};

        if(size == 1)
            return jednosci[digit];
        else if (size == 10)
            return nascie[digit];
        else if (size == 20)
            return dziesiatki[digit];
        else if (size == 100)
            return setki[digit];
        return "";
    }

    private String numberPartsDivider(int number) {
        String result = "";

        if(number < 0) {
            result += "minus";
            number *= -1;
        }

        if(number == 0)
            result += "zero";

        if (number == 1000)
            result += "tysiąc";

        if (number >= 100 && number <= 999) {
            result += digitToString(number / 100, 100);
            number %= 100;
        }

        if ((number >= 20 && number <= 99) || number==10) {
            result += digitToString(number / 10, 20);
            number %= 10;
        }

        else if (number >= 11 && number <= 19) {
            result += digitToString(number / 10, 10);
            number = 0;
        }

        if (number >= 1 && number <= 9) {
            result += digitToString(number, 1);
        }
        result = result.trim();
        return result;
    }
}