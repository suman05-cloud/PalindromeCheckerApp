import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Application Entry & Welcome Message
        System.out.println("--- Welcome to Palindrome Checker App ---");
        System.out.println("Application Name: Palindrome Checker");
        System.out.println("Application Version: 1.0");
        System.out.println("-----------------------------------------");

        // UC5: Stack-Based Palindrome Checker
        String input = "madam";
        Stack<Character> stack = new Stack<>();

        // Push characters into stack (LIFO principle)
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        StringBuilder reversed = new StringBuilder();
        // Pop and build reversed string
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println("Input String: " + input);
        System.out.println("Reversed using Stack: " + reversed.toString());

        // Compare original and reversed result
        if (input.equals(reversed.toString())) {
            System.out.println("The word \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + input + "\" is NOT a Palindrome.");
        }
    }
}
