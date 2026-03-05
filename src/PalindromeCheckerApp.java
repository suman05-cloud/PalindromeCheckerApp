public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Application Entry & Welcome Message
        System.out.println("--- Welcome to Palindrome Checker App ---");
        System.out.println("Application Name: Palindrome Checker");
        System.out.println("Application Version: 1.0");
        System.out.println("-----------------------------------------");

        // UC10: Case-Insensitive & Space-Ignored Palindrome
        String input = "A man a plan a canal Panama";
        System.out.println("Original Input: \"" + input + "\"");

        // Normalize string: convert to lower case and remove all
        // spaces/non-alphanumeric chars
        // Key concept: String preprocessing and Regular expressions
        String normalized = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        System.out.println("Normalized Input: \"" + normalized + "\"");

        // Performance check using two-pointer approach (from UC4)
        boolean isPalindrome = checkPalindrome(normalized);

        if (isPalindrome) {
            System.out.println("The processed string is a Palindrome.");
        } else {
            System.out.println("The processed string is NOT a Palindrome.");
        }
    }

    private static boolean checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
