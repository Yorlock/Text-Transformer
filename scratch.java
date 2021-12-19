package scratch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
	
	public static boolean isFloat(String string) {
		if (string == null) {
			return false;
		}
		try {
			float f = Float.parseFloat(string);
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}
	
	public static String capitalize(String text) {
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
        String result = "";
        ArrayList<Boolean> uppers = new ArrayList<Boolean>();
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
    
    public static String remove_duplicates(String text) {
    	String result = "";
    	text = text.trim();
    	String[] tmp_list = text.split("\\s+");
    	List<String> text_list = new ArrayList<String>();
    	text_list = Arrays.asList(tmp_list);
    	
    	for (int i=0; i<text_list.size()-1; i++) {
    		if (!text_list.get(i).equals(text_list.get(i+1))) {
    			result = result + " " + text_list.get(i);
    		}
    	}
    	if (!text_list.get(text_list.size() - 1).equals(text_list.size() - 2)) {
			result = result + " " + text_list.get(text_list.size() - 1);
		}
    	return result.trim();
    }

    
    
	public static void main(String[] args) {
		String text = "To jest jest jest jest  przykladowe    zdanie";
		System.out.println("Oryginalny tekst:		" + text);
        System.out.println("Wszystko z dużych liter:	" + text.toUpperCase());
        System.out.println("Wszystko z małych liter:	" + text.toLowerCase());
        System.out.println("Duże pierwsze litery:		" + capitalize(text));
        System.out.println("Odwrócony:			" + inverse(text));
        System.out.println("Usunięte duplikaty:		" + remove_duplicates(text));
	}
}
