public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Application Entry & Welcome Message
        System.out.println("--- Welcome to Palindrome Checker App ---");
        System.out.println("Application Name: Palindrome Checker");
        System.out.println("Application Version: 1.0");
        System.out.println("-----------------------------------------");

        // UC3: Palindrome Check Using String Reverse
        String original = "madam";
        String reversed = "";

        // Reverse the string using a for loop
        // Key concept: String concatenation and loop iteration
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);

        // Compare original and reversed using equals()
        if (original.equals(reversed)) {
            System.out.println("The word \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + original + "\" is NOT a Palindrome.");
        }
    }
}
