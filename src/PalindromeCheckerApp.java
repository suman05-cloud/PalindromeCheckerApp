/**
 * UC11: Object-Oriented Palindrome Service
 * This class encapsulates the palindrome checking logic.
 * Follows Single Responsibility Principle (SRP).
 */
class PalindromeService {
    /**
     * Checks if the given text is a palindrome.
     * Encapsulates normalization and validation logic.
     */
    public boolean isPalindrome(String text) {
        if (text == null)
            return false;

        // Internal logic: Normalization
        String normalized = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        // Internal logic: Comparison (using two-pointer)
        int left = 0;
        int right = normalized.length() - 1;
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("--- Welcome to Palindrome Checker App ---");
        System.out.println("Application Name: Palindrome Checker");
        System.out.println("Application Version: 1.0");
        System.out.println("-----------------------------------------");

        // UC11: Object-Oriented Palindrome Service
        PalindromeService service = new PalindromeService();

        String input = "Race Car";
        System.out.println("Checking: \"" + input + "\"");

        if (service.isPalindrome(input)) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }
}
