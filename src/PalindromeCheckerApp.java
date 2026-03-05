import java.util.*;

/**
 * UC12/13: Strategy and Performance Comparison
 */
interface PalindromeStrategy {
    boolean check(String text);
}

class LoopReverseStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        String normalized = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        String reversed = "";
        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversed += normalized.charAt(i);
        }
        return normalized.equals(reversed);
    }
}

class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        String normalized = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0, right = normalized.length() - 1;
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        String normalized = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray())
            stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty())
            reversed.append(stack.pop());
        return normalized.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        String normalized = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray())
            deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast())
                return false;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("--- Welcome to Palindrome Checker App ---");
        System.out.println("Application Name: Palindrome Checker");
        System.out.println("Application Version: 1.0");
        System.out.println("-----------------------------------------");

        // UC13: Performance Comparison
        String input = "A man a plan a canal Panama".repeat(100); // Larger input for measurable time
        System.out.println("Testing performance with length: " + input.length() + " characters\n");

        Map<String, PalindromeStrategy> strategies = new LinkedHashMap<>();
        strategies.put("Loop Reverse (+)", new LoopReverseStrategy());
        strategies.put("Two-Pointer", new TwoPointerStrategy());
        strategies.put("Stack-Based", new StackStrategy());
        strategies.put("Deque-Based", new DequeStrategy());

        System.out.printf("%-25s | %-15s | %-10s%n", "Algorithm", "Time (ns)", "Result");
        System.out.println("---------------------------------------------------------------");

        for (Map.Entry<String, PalindromeStrategy> entry : strategies.entrySet()) {
            long startTime = System.nanoTime();
            boolean result = entry.getValue().check(input);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.printf("%-25s | %-15d | %-10s%n", entry.getKey(), duration, result ? "Pass" : "Fail");
        }
    }
}
