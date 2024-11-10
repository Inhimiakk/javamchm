package lab_11;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 10010;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                        BufferedReader clientReader = new BufferedReader(
                                new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
                        PrintStream clientWriter = new PrintStream(clientSocket.getOutputStream(), true, "UTF-8")) {

                    System.out.println("Подключение от: " + clientSocket.getRemoteSocketAddress());

                    String line;
                    while ((line = clientReader.readLine()) != null) {
                        System.out.println("Получено: " + line);

                        String longestWord = findLongestWord(line);
                        System.out.println("Самое длинное слово: " + longestWord);

                        clientWriter.println(longestWord);
                    }

                    System.out.println("Соединение закрыто с " + clientSocket.getRemoteSocketAddress());
                } catch (IOException e) {
                    System.err.println("Ошибка обработки подключения: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка запуска сервера: " + e.getMessage());
        }
    }

    public static String findLongestWord(String line) {
        String[] words = line.split(" ");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}
