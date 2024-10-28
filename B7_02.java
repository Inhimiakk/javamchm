package lab_8;


import java.util.Arrays;

public class B7_02 {

    public static void main(String[] args) {
        String fileToys = "toys.txt";
        String fileSuitableToys = "suitable_toys.txt";

        Toy[] toys = {
            new Toy("Кукла", 500.0, 3, 20),
            new Toy("Лего черепашки ниндзя", 100.0, 15, 99),
            new Toy("Огромный плющевый слон", 370.0, 7, 13),
            new Toy("Жабик", 50.0, 4, 18)
        };

        Toy.write(toys, fileToys);

        Toy[] allToys = Toy.read(fileToys);
        System.out.println("все игрушки из файлика:");
        System.out.println(Arrays.toString(allToys));

        int targetAge = 6;
        Toy[] suitableToys = Toy.filterByAge(allToys, targetAge);
        System.out.println("игрушки подходящие по возрасту " + targetAge + ":");
        System.out.println(Arrays.toString(suitableToys));

        Toy.write(suitableToys, fileSuitableToys);

        Toy[] toysForAge = Toy.read(fileSuitableToys);
        System.out.println("игрушки, отфильтрованные по возрасту:");
        System.out.println(Arrays.toString(toysForAge));
    }
}
