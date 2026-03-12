import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

/**
 * UC6: Queue + Stack Based Palindrome Check
 * Goal: Demonstrate FIFO vs LIFO using Queue and Stack.
 * 
 * Flow:
 * 1. Enqueue characters (Queue - FIFO)
 * 2. Push characters to stack (Stack - LIFO)
 * 3. Compare dequeue vs pop
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC6: Queue + Stack Based Palindrome Check ---");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (checkPalindrome(input)) {
            System.out.println("Result: \"" + input + "\" is a Palindrome!");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }

    /**
     * Logic to check palindrome using Queue and Stack.
     */
    public static boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        // Pre-processing: remove non-alphanumeric and convert to lower case
        String cleanedStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // 1. Enqueue characters to Queue (FIFO)
        // 2. Push characters to Stack (LIFO)
        for (int i = 0; i < cleanedStr.length(); i++) {
            char c = cleanedStr.charAt(i);
            queue.add(c);
            stack.push(c);
        }

        System.out.println("\nLogic demonstration:");
        System.out.println("Processing characters...");

        // 3. Compare dequeue (FIFO) with pop (LIFO)
        while (!queue.isEmpty()) {
            char fromQueue = queue.remove(); // First In, First Out
            char fromStack = stack.pop();    // Last In, First Out (which is reverse order)

            if (fromQueue != fromStack) {
                return false; // Character mismatch
            }
        }

        return true;
    }
}
