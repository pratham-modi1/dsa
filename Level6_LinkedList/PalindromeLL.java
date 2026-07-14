package Level6_LinkedList;

public class PalindromeLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create linked list: 1 -> 2 -> 3 -> 2 -> 1
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.print("Original list: ");
        printList(head);

        if (head == null || head.next == null) {
            System.out.println("Palindrome: true");
            return;
        }

        // Step 1: Find middle using slow and fast pointers
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalfStart = reverse(slow.next);

        System.out.print("Reversed second half: ");
        printList(secondHalfStart);

        // Step 3: Compare first half and reversed second half
        Node first = head;
        Node second = secondHalfStart;
        boolean isPalindrome = true;

        while (second != null) {
            if (first.data != second.data) {
                isPalindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        // Step 4: Restore the list back to original
        slow.next = reverse(secondHalfStart);

        System.out.print("List after restoring: ");
        printList(head);

        System.out.println("Palindrome: " + isPalindrome);
    }
}