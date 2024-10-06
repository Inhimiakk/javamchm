import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Appliance> appliances = new ArrayList<>();

        appliances.add(new Wash_machine( 2000, 2));
        appliances.add(new Refrigerator(1500, 2.5));
        appliances.add(new Microwave(900, 0.5));

        int totalPower = 0;
        for (Appliance appliance : appliances) {
            totalPower += appliance.getPower();
        }

        System.out.println("Общая мощность: "+ totalPower +" вт");

        Collections.sort(appliances);
        System.out.println("Отсортированные по размеру: ");

        for (Appliance appliance : appliances) {
            System.out.println(appliance);
        }

        double minPrice = 1200;
        double maxPrice = 17000;

        System.out.println("\nПриборы в ценовом диаразоне от " + minPrice + " до " + maxPrice + " грн:");
        for (Appliance appliance : appliances) {
            if (appliance.getPrice() > minPrice & appliance.getPrice() < maxPrice) {
                System.out.println(appliance);
            }
        }
    }
}
