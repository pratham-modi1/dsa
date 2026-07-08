package Level6_LinkedList;

public class DeleteHeadTest {

    public static void main(String[] args) {

        // Create DLL using the method from CreateDLL.java
        int[] arr = {10, 20, 30, 40, 50};
        Node head = CreateDLL.createDLL(arr);

        System.out.println("Before Deleting Head:");
        printDLL(head);

        head = deleteHead(head);

        System.out.println("\nAfter Deleting Head:");
        printDLL(head);
    }

    public static Node deleteHead(Node head) {

        if (head == null)
            return null;

        if (head.next == null)
            return null;

        head = head.next;
        head.prev = null;

        return head;
    }

    public static void printDLL(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}