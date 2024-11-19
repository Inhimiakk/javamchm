package lab_9;

import java.util.Stack;

public class B8_02 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String expression1 = "{[()]}";
        String expression2 = "{[(])}";

        System.out.println("в 1 примере " + (isValid(expression1) ? "очень крутые скобки" : "очень плохие скобки"));
        System.out.println("во 2 примере " + (isValid(expression2) ? "очень крутые скобки" : "очень плохие скобки"));
    }
}
