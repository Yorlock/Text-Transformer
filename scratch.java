import java.util.ArrayList;

class Scratch {
    public static String capitalize(String text) {
        char character;
        String result = "";
        for (int i=0; i<text.length(); i++)
        {
            if (i != 0) {
                if (Character.isLowerCase(text.charAt(i)) && text.charAt(i - 1) == ' ') {
                    result = result + Character.toUpperCase(text.charAt(i));
                } else {
                    result = result + text.charAt(i);
                }
            }
            else{
                if (text.charAt(i) != ' ') {
                    result = result + Character.toUpperCase(text.charAt(i));
                }
                else{
                    result = result + text.charAt(i);
                }
            }
        }
        return result;
    }

    public static String inverse(String text) {
        char character;
        String result = "";
        ArrayList<Boolean> uppers = new ArrayList<Boolean>();;
        for (int i=0; i<text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                uppers.add(true);
            } else {
                uppers.add(false);
            }
        }
        for (int i=0; i<text.length(); i++) {
            if (uppers.get(text.length() - i - 1)){
                result = Character.toUpperCase(text.charAt(i)) + result;
            }
            else{
                result = Character.toLowerCase(text.charAt(i)) + result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "ToapfihSDUAI  aid";
        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());
        System.out.println(capitalize(text));
        System.out.println(inverse(text));
        
    }
}
