import java.util.Scanner;

public class b2_10 {
    public static int count(byte number) {
        int count = 0;
        int pred_bit = 0;

        for (int i = 0; i < 8; i++) {

            int curr_bit = (number >> i) & 1;

            if (i > 0 && curr_bit == 1 && pred_bit == 1) {
                count++;
            }

            pred_bit = curr_bit;
        }

        return count;

    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        byte number = (byte) num;
        int count = count(number);
        System.out.println("число 11 зустрічається у числі " + num +" "+ count + " разів");

        in.close();
    }
}
