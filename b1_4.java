import java.util.Scanner;

public class b1_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int number1 = 0;
        int number2 = 0;
        int number3 = 0;
        try {
            
            System.out.println("1 chislo:");
            number1 = in.nextInt();

            System.out.println("2 chislo:");
            number2 = in.nextInt();

            System.out.println("3 chislo:");
            number3 = in.nextInt();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Числа не такі, читай умову(повинні бути цілими нажаль)");
            in.close();
            return;
        }

        String ser_geom = String.format("%.4f", Math.pow(number1 * number2 * number3, 1.0 / 3.0));

        in.close();

    System.out.println("середнє геометричне: " + ser_geom);
    }
}
