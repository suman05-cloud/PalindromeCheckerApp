public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Application Entry & Welcome Message
        System.out.println("--- Welcome to Palindrome Checker App ---");
        System.out.println("Application Name: Palindrome Checker");
        System.out.println("Application Version: 1.0");
        System.out.println("-----------------------------------------");

        // UC4: Character Array Based Palindrome Check
        String input = "madam";

        // Convert string to char[]
        char[] charArray = input.toCharArray();

        boolean isPalindrome = true;
        int left = 0;
        int right = charArray.length - 1;

        // Two-pointer approach
        while (left < right) {
            // Compare start & end characters
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Input String: " + input);
        if (isPalindrome) {
            System.out.println("The word \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + input + "\" is NOT a Palindrome.");
        }
    }
}
