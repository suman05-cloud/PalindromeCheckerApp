public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Application Entry & Welcome Message
        System.out.println("--- Welcome to Palindrome Checker App ---");
        System.out.println("Application Name: Palindrome Checker");
        System.out.println("Application Version: 1.0");
        System.out.println("-----------------------------------------");

        // UC9: Recursive Palindrome Checker
        String input = "madam";
        System.out.println("Input String: " + input);

        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println("The word \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + input + "\" is NOT a Palindrome.");
        }
    }

    /**
     * Recursive method to check if a string is a palindrome.
     * 
     * @param s     The string to check
     * @param left  Starting index
     * @param right Ending index
     * @return true if palindrome, false otherwise
     */
    private static boolean isPalindrome(String s, int left, int right) {
        // Base Condition: If indices cross or meet, it's a palindrome
        if (left >= right) {
            return true;
        }

        // Compare start and end characters
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        // Recursive call with smaller subproblem
        return isPalindrome(s, left + 1, right - 1);
    }
}
