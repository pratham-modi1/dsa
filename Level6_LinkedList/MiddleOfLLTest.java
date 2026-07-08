package Level6_LinkedList;

public class MiddleOfLLTest {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};

        Node head = createLL(arr);

        System.out.println("Original List:");
        printLL(head);

        Node middle = middleNode(head);

        System.out.println("\nMiddle Node: " + middle.data);
    }

    public static Node middleNode(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // -------------------------
    // Create Singly Linked List
    // -------------------------
    public static Node createLL(int[] arr) {

        if (arr == null || arr.length == 0)
            return null;

        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        return head;
    }

    // -------------------------
    // Print Linked List
    // -------------------------
    public static void printLL(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}