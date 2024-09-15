import java.util.Scanner;

public class b2_2 {
    public static double max(double[] array) {
        if (array.length == 0) {
            System.out.println("масив поганий, читай умову краще(він не може бути нульової довжини)");
        }

        double max_num = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max_num) {
                max_num = array[i];
            }
        }

        return max_num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        try {
            
            System.out.println("кількість елементів у масиві:");

            n = in.nextInt();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("кількість елементів у масиві не може бути дабл");
            in.close();
            return;
        }

        if (n <= 0) {
            System.out.println("кількість елементів у масиві не може бути від`ємною або нульовою :(");
            in.close();
            
            return;
        }

        double[] array = new double[n];

        for (int i = 0; i < n; i++) {
            
            System.out.println("введіть наступний елемент масиву: ");

            array[i] = in.nextDouble();
        }

        in.close();

        double max_number = max(array);
        System.out.println("Максимальний елемент твого масивчику: " + max_number);

    }
}
