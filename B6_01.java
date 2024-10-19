package lab_7;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B6_01 {
    public static void main(String[] args) {
        String input = "Дорогой дневник, сегодня 15.10.2024. Мне было утром очень плохо, ведь сегодня __.__.____ контрольная по компстату, а вчера мы вместо подготовки играли во взрывных котят";

        String currentDate = LocalDate.now().toString();

        String rgx = "\\b(\\d{2}\\.\\d{2}\\.\\d{4}|__\\.__\\.____)\\b";

        Pattern p = Pattern.compile(rgx);
        Matcher m = p.matcher(input);
        String result = m.replaceAll(currentDate);


        System.out.println("Текст с сегодняшней датой: " + result);
    }
}
