package lab_8;

import java.io.*;
import java.util.ArrayList;

public class Toy implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private double price;
    private int minAge;
    private int maxAge;

    public Toy(String name, double price, int minAge, int maxAge) {
        this.name = name;
        this.price = price;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public boolean isSuitableForAge(int age) {
        return age >= minAge && age <= maxAge;
    }

    @Override
    public String toString() {
        return "Toy{name='" + name + "', price=" + price + ", ageRange=" + minAge + "-" + maxAge + "}";
    }

    public static void write(Toy[] toys, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Toy toy : toys) {
                oos.writeObject(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Toy[] read(String filename) {
        ArrayList<Toy> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                try {
                    list.add((Toy) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list.toArray(new Toy[0]);
    }

    public static Toy[] filterByAge(Toy[] toys, int age) {
        ArrayList<Toy> suitableToys = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy.isSuitableForAge(age)) {
                suitableToys.add(toy);
            }
        }
        return suitableToys.toArray(new Toy[0]);
    }
}
