package Level6_LinkedList;

public class Searching {

    public static void main(String[] args) {

        Node head = new Node(1,
                        new Node(2,
                        new Node(3,
                        new Node(4, null))));

        int target = 3;

        Node temp = head;

        while (temp != null) {

            if (temp.data == target) {
                System.out.println(true);
                return;
            }

            temp = temp.next;
        }

        System.out.println(false);
    }
}

class Node {

    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}