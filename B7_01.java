package lab_8;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class B7_01 {


    public static void main(String[] args) {
        String fileF = "F.bin";
        String fileG = "G.bin";

        double[] numbers = { 1.5, -2.3, 4.8, 7.6, -5.4, 9.2, 0.1 };
        write(numbers, fileF);

        double[] readNumbers = read(fileF);
        System.out.println("Числа из файлика F: " + Arrays.toString(readNumbers));

        double threshold = 2.0;
        double[] filteredNumbers = filterGreaterThan(readNumbers, threshold);
        writeWithByteBuffer(filteredNumbers, fileG);

        double[] result = readWithByteBuffer(fileG);
        System.out.println("Числа из файлика G (которые больше чем " + threshold + "): " + Arrays.toString(result));
    }

    public static void write(double[] array, String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            for (double value : array) {
                dos.writeDouble(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[] read(String filename) {
        double[] array = null;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            File file = new File(filename);
            int size = (int) (file.length() / Double.BYTES);
            array = new double[size];
            for (int i = 0; i < size; i++) {
                array[i] = dis.readDouble();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void writeWithByteBuffer(double[] array, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            ByteBuffer bb = ByteBuffer.allocate(array.length * Double.BYTES);
            for (double value : array) {
                bb.putDouble(value);
            }
            fos.write(bb.array());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[] readWithByteBuffer(String filename) {
        double[] array = null;
        try (FileInputStream fis = new FileInputStream(filename)) {
            ByteBuffer bb = ByteBuffer.wrap(fis.readAllBytes());
            int size = bb.capacity() / Double.BYTES;
            array = new double[size];
            for (int i = 0; i < size; i++) {
                array[i] = bb.getDouble();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static double[] filterGreaterThan(double[] array, double threshold) {
        return Arrays.stream(array)
                .filter(value -> value > threshold)
                .toArray();
    }
}
