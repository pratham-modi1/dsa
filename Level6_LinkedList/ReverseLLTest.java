//iterative
package Level6_LinkedList;

public class ReverseLLTest {

    public static void main(String[] args) {

        int[] arr = {1,2};

        Node head = createLL(arr);

        System.out.println("Original List:");
        printLL(head);

        head = reverseLL(head);

        System.out.println("\nAfter Reverse:");
        printLL(head);
    }


    public static Node reverseLL(Node head) {

    if (head == null || head.next == null) {
        return head;
    }

    Node p = head;
    Node q = p.next;
    Node r = p.next.next;

    p.next = null;

    while (r != null) {

        q.next = p;

        p = q;
        q = r;
        r = r.next;
    }

    q.next = p;

    return q;
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