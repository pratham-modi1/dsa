package Level6_LinkedList;

public class ReverseDLLtest {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        Node head = CreateDLL.createDLL(arr);

        System.out.println("Original List:");
        printDLL(head);

        head = reverseDLL(head);

        System.out.println("\nReversed List:");
        printDLL(head);
    }

    public static Node reverseDLL(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node newHead = null;

        while (curr != null) {
            Node temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            newHead = curr;
            curr = curr.prev;
        }

        return newHead;
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

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class CreateDLL {

    public static Node createDLL(int[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node current = new Node(arr[i]);

            prev.next = current;
            current.prev = prev;

            prev = current;
        }

        return head;
    }
}