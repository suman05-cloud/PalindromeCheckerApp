public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Application Entry & Welcome Message
        System.out.println("--- Welcome to Palindrome Checker App ---");
        System.out.println("Application Name: Palindrome Checker");
        System.out.println("Application Version: 1.0");
        System.out.println("-----------------------------------------");

        // UC2: Print a Hardcoded Palindrome Result
        // Hardcoded string to check
        String input = "madam";

        // Logical check for a palindrome (for a simple hardcoded case, we manually
        // verify "madam" is a palindrome)
        if (input.equals("madam")) {
            System.out.println("The word \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + input + "\" is NOT a Palindrome.");
        }
    }
}
