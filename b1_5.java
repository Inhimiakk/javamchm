import java.util.Scanner;

public class b1_5 {
    public static void main(String[] args) {

        int N = 0;
        int M = 0;

        if (args.length == 2) {
            try {

                N = Integer.parseInt(args[0]);
                M = Integer.parseInt(args[1]);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("M та N повинні бути цілими, ти шо читати не вмієш?");
                return;
            }
        } else {
            Scanner in = new Scanner(System.in);
            
            try {
                System.out.println("N chislo:");
                N = in.nextInt();

                System.out.println("M chislo:");
                M = in.nextInt();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("M та N повинні бути цілими, ти шо читати не вмієш?");
                
                in.close();
                return;
            }

            in.close();

        }



        if (N <= 0 || M <= 0) {
            System.out.println("M та N повинні бути додатні, ти шо читати не вмієш?");
        }
        
        for (int i = 0; i < N; i++) {
            
            int rand_number = (int) (Math.random() * M);
            
            System.out.println(rand_number);
        }

    }
}
