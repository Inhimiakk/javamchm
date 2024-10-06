package lab_6;

public class B5_02 {
    public static void main(String[] args) {
        String input = "4abc";

        System.out.println("свойство а: " + a(input));
        System.out.println("свойство б: " + b(input));
        System.out.println("свойство в: " + c(input));
    }

    public static boolean a(String input) {
        if (input.length() >= 2 && input.charAt(0) >= '1' && input.charAt(0) < '9') {
            int digit = input.charAt(0) - '0';
            String letters = input.substring(1);

            return letters.length() == digit && letters.chars().allMatch(Character::isLetter);
        }
        return false;
    }

    static boolean b(String input) {
        int digitCount = 0;
        int digitValue = -1;

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitCount++;
                digitValue = Character.getNumericValue(ch);
            }
        }
        return digitCount == 1 && digitValue == input.length();
    }

    public static boolean c(String input) {
        int sum = 0;

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
            }
        }
        return sum == input.length();
    }
}
