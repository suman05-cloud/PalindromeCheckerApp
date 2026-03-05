import java.util.*;

/**
 * UC12: Strategy Pattern for Palindrome Algorithms
 * This interface defines the contract for any palindrome checking strategy.
 */
interface PalindromeStrategy {
    boolean check(String text);
}

/**
 * Strategy implementation using a Stack (LIFO principle).
 */
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        if (text == null)
            return false;
        String normalized = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return normalized.equals(reversed.toString());
    }
}

/**
 * Strategy implementation using a Deque (Double-Ended Queue).
 */
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        if (text == null)
            return false;
        String normalized = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Context class that uses a PalindromeStrategy.
 */
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String text) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return strategy.check(text);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("--- Welcome to Palindrome Checker App ---");
        System.out.println("Application Name: Palindrome Checker");
        System.out.println("Application Version: 1.0");
        System.out.println("-----------------------------------------");

        // UC12: Strategy Pattern
        String input = "Was it a car or a cat I saw?";
        System.out.println("Input: \"" + input + "\"");

        PalindromeCheckerContext context = new PalindromeCheckerContext();

        // Testing with Stack Strategy
        System.out.println("\n--- Testing with Stack Strategy ---");
        context.setStrategy(new StackStrategy());
        if (context.validate(input)) {
            System.out.println("Stack Strategy: It's a Palindrome!");
        } else {
            System.out.println("Stack Strategy: Not a Palindrome.");
        }

        // Testing with Deque Strategy
        System.out.println("\n--- Testing with Deque Strategy ---");
        context.setStrategy(new DequeStrategy());
        if (context.validate(input)) {
            System.out.println("Deque Strategy: It's a Palindrome!");
        } else {
            System.out.println("Deque Strategy: Not a Palindrome.");
        }
    }
}
