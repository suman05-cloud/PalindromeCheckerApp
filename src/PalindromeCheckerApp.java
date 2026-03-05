class ListNode {
    char val;
    ListNode next;

    ListNode(char x) {
        val = x;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // UC1: Application Entry & Welcome Message
        System.out.println("--- Welcome to Palindrome Checker App ---");
        System.out.println("Application Name: Palindrome Checker");
        System.out.println("Application Version: 1.0");
        System.out.println("-----------------------------------------");

        // UC8: Linked List Based Palindrome Checker
        String input = "madam";
        System.out.println("Input String: " + input);

        // Convert string to linked list
        ListNode head = createLinkedList(input);

        // Check if palindrome
        if (isPalindrome(head)) {
            System.out.println("The word \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + input + "\" is NOT a Palindrome.");
        }
    }

    private static ListNode createLinkedList(String s) {
        if (s.isEmpty())
            return null;
        ListNode head = new ListNode(s.charAt(0));
        ListNode current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new ListNode(s.charAt(i));
            current = current.next;
        }
        return head;
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // 1. Find the middle using Fast and Slow Pointer Technique
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half In-Place
        ListNode secondHalf = reverseList(slow.next);

        // 3. Compare halves
        ListNode firstHalf = head;
        ListNode tempSecond = secondHalf;
        boolean result = true;
        while (tempSecond != null) {
            if (firstHalf.val != tempSecond.val) {
                result = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        // Optional: Restore list (omitted for brevity unless required)
        return result;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
