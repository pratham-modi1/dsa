package Level6_LinkedList;

public class InsertionAtHead {

    public static void main(String[] args) {

        // Create the linked list: 10 -> 9 -> 8 -> 7
        Node head = new Node(10,
                        new Node(9,
                            new Node(8,
                                new Node(7))));

        display(head);

        // Insert 11 at the head
        head = new Node(11, head);

        display(head);
    }

    public static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
        return;
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}