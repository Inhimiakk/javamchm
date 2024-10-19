package lab_7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B6_03 {

    public static void main(String[] args) {
        String input = "+2 - 57 * 33 + 25 / -4";

        String rgx = "\\s*([+-]?\\d+)(\\s*[-+*\\\\/]\\s*[+-]?\\d+)*\\s*";


        Pattern p = Pattern.compile(rgx);
        Matcher m = p.matcher(input);
        
        if (m.matches()) {
            System.out.println("класс правильно");
        } else {
            System.out.println("не круто, не правильно");
        }
    }
}
