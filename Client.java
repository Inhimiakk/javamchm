package lab_11;


import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 10010;

        String inputFile = "фалик1.txt";
        String outputFile = "файлик2.txt";

        try (Socket socket = new Socket(host, port);
                BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile));
                BufferedReader serverReader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream(), "UTF-8"));
                PrintStream serverWriter = new PrintStream(socket.getOutputStream(), true, "UTF-8")) {

            System.out.println("Подключено к " + socket.getRemoteSocketAddress());

            String line;
            while ((line = fileReader.readLine()) != null) {
                serverWriter.println(line);
                System.out.println("Отправлено: " + line);
                String response = serverReader.readLine();
                System.out.println("Получено: " + response);

                fileWriter.write(response + "\n");
            }

            System.out.println("Соединение закрыто с " + socket.getRemoteSocketAddress());

        } catch (IOException e) {
            System.err.println("Ошибка подключения к серверу: " + e.getMessage());
        }
    }
}
