import java.util.Locale;
import java.util.Scanner;

public class b1_1{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        System.out.print("Введіть ваше ім'я : ");

        String name = in.nextLine();

        System.out.println("Привіт, " + name + "!");

        in.close();
    }
}