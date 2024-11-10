package lab_10;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;

public class B9_01 {

    public static void main(String[] args) {
        long T1 = 1000; 
        long T2 = 2000; 
        long T3 = 3000; 
        int n = 10; 

        ArrayBlockingQueue<String> queue1 = new ArrayBlockingQueue<>(n);
        ArrayBlockingQueue<String> queue2 = new ArrayBlockingQueue<>(n);

        Thread readerThread = new Thread(() -> readFile(T1, "F.txt", queue1, queue2));

        Thread writerThread1 = new Thread(() -> processAndWrite(T2, queue1, "фалик1.txt"));
        Thread writerThread2 = new Thread(() -> processAndWrite(T3, queue2, "файлик2.txt"));

        System.out.println("Начинаем обработочку(хитрую)");
        readerThread.start();
        writerThread1.start();
        writerThread2.start();

        try {
            readerThread.join();
            writerThread1.join();
            writerThread2.join();
        } catch (InterruptedException e) {
            System.out.println("Что то сломалось :(");
        }
        System.out.println("Конец");
    }

    public static void readFile(long interval, String fileName, ArrayBlockingQueue<String> queue1,
            ArrayBlockingQueue<String> queue2) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean toggle = true; 
            while ((line = br.readLine()) != null) {
                System.out.println("Читаем строчечку: " + line);
                if (toggle) {
                    queue1.put(line); 
                } else {
                    queue2.put(line); 
                }
                toggle = !toggle; 
                Thread.sleep(interval); 
            }
            queue1.put("");
            queue2.put(""); 
        } catch (IOException | InterruptedException e) {
            System.out.println("Эррор чтения файлика: " + e.getMessage());
        }
    }

    public static void processAndWrite(long processTime, ArrayBlockingQueue<String> queue, String outputFileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            while (true) {
                String line = queue.take(); 
                if (line.equals(""))
                    break; 
                System.out.println("Обработка строки в " + outputFileName + ": " + line);
                Thread.sleep(processTime); 
                bw.write(line);
                bw.newLine();
                System.out.println("Строчечка записана в " + outputFileName + ": " + line);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Эррор записи в файлик: " + e.getMessage());
        }
    }
}
