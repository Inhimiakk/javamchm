package lab_7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B6_02 {
    public static void main(String[] args) {
        String input = "Номера Катюши, Тани, Ренаты и Вити: +380(67)123-45-67, 0671234567, 380671234567, (067)123-45-67.";

        String rgx = "\\+?\\d{0,3}[- ]?\\(?\\d{2,3}\\)?[- ]?\\d{2,3}[- ]?\\d{2}[- ]?\\d{2}";
        Pattern p = Pattern.compile(rgx);
        Matcher m = p.matcher(input);

        while (m.find()) {
            System.out.println(m.group());
        }

    }
}
