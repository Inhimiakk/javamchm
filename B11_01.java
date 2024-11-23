package lab_12;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B11_01 {

    public static void main(String[] args) {
        String url = "https://www.timeanddate.com/worldclock/ukraine/kyiv";

        String html = getHtml(url);

        String onlineTime = getOnlineTime(html);
        if (!onlineTime.isEmpty()) {
            System.out.println("Время на сайте: " + onlineTime);

            LocalTime localTime = LocalTime.now();
            String formattedLocalTime = localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.println("Мое время: " + formattedLocalTime);

            if (formattedLocalTime.equals(onlineTime)) {
                System.out.println("Совпадает ура!");
            } else {
                System.out.println("Не совпадает");
            }
        } else {
            System.out.println("Не вышло получить точное время из сайта.");
        }
    }

    public static String getHtml(String url) {
        URI uri = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status: " + response.statusCode());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getOnlineTime(String html) {
        Pattern pattern = Pattern.compile("<span id=ct class=h1>(\\d{2}:\\d{2}:\\d{2})</span>");
        Matcher matcher = pattern.matcher(html);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}
