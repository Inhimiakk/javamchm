package л3;

import java.util.Locale;
import java.util.Scanner;


public class b02_17b {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        System.out.println("Ввкдіть кількість членів послідовності: ");
        int n = in.nextInt();

        System.out.println("Введіть х по модулю менше 1:");
        double x = in.nextDouble();

        if (x > 1 || x < -1) {
            System.out.println("х по модулю не менше 1, читай уважніше. Введіть х по модулю менше 1:");
            x = in.nextDouble();
        }
        else {  
            double result = ryad(x, n);
            System.out.println(result);
            
            in.close();
        }
    }

    public static double ryad(double x, int n) {
        
        double res = x;
        double q = x;
        for (int i = 1; i < n; i++) {

            q *= x * x;

            res += q / (2 * i + 1);
        }
        
        return res;

    
    }

}
