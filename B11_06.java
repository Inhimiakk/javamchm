package lab_12;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

public class B11_06 {

// Я знаю, что с температурами вы ожидали увидеть другое решение и это костыль, но по-другому у меня не получилось :(
    public static void main(String[] args) {
        System.out.print("Название города на украинском быстро сюда: ");
        String cityName = "київ";

        String url = "https://ua.sinoptik.ua/погода-" + cityName;
        String pageContent = getHTML(url);

        if (pageContent.isEmpty()) {
            System.out.println("Не вышло чучуть.");
            return;
        }

        String date = getCurrentDate(pageContent);
        System.out.println("Прогноз погоди на " + date + " для города " + cityName + ":");

        List<String> temperatures = getTemperatures(pageContent);
        List<String> selectedTemperatures = getTemperaturesByIndex(temperatures, 14, 6);

        if (selectedTemperatures.isEmpty()) {
            System.out.println("Не вышло чучуть");
        } else {
            System.out.println("Температура на сегодня " +
                    String.join(", ", selectedTemperatures));
        }

    }

    public static String getHTML(String urlString) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .header("Accept-Encoding", "gzip")
                .build();

        try {
            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            InputStream responseBody = response.body();
            if ("gzip".equals(response.headers().firstValue("Content-Encoding").orElse(""))) {
                responseBody = new GZIPInputStream(responseBody);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(responseBody, StandardCharsets.UTF_8));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (Exception e) {
            System.out.println("Ошибка блин: " + e.getMessage());
        }
        return "";
    }

    public static String getCurrentDate(String pageContent) {
        Pattern datePattern = Pattern.compile(
                "<p[^>]*>([А-Яа-яІіЇїЄє]+)</p>.*?<p[^>]*>(\\d+)</p>.*?<p[^>]*>([А-Яа-яІіЇїЄє]+)</p>", Pattern.DOTALL);
        Matcher dateMatcher = datePattern.matcher(pageContent);

        if (dateMatcher.find()) {
            String dayOfWeek = dateMatcher.group(1).trim();
            String dayNumber = dateMatcher.group(2).trim();
            String month = dateMatcher.group(3).trim();
            return dayOfWeek + ", " + dayNumber + " " + month;
        }
        return "Непонятная дата какая-то";
    }

    public static List<String> getTemperatures(String pageContent) {
        List<String> temperatures = new ArrayList<>();

        Pattern tempPattern = Pattern.compile("-?\\d+°");
        Matcher tempMatcher = tempPattern.matcher(pageContent);

        while (tempMatcher.find()) {
            temperatures.add(tempMatcher.group());
        }

        return temperatures;
    }

    public static List<String> getTemperaturesByIndex(List<String> temperatures, int startIndex, int step) {
        List<String> result = new ArrayList<>();

        int currentIndex = startIndex;
        while (currentIndex < temperatures.size() && result.size() < 8) {
            result.add(temperatures.get(currentIndex));
            currentIndex += step;
        }

        return result;
    }
}
