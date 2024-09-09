public class b1_3 {
    public static void main(String[] args) {

        int prod = 1;
        try {
            for (int i = 0; i < args.length; i++) {

                prod *= Integer.parseInt(args[i]);
            }
            System.out.println("Добуток : " + prod);
            } catch (NumberFormatException e) {
                System.err.println("введіть лише цілі числа >:(");
            }

        
    }
}
