package Level6_LinkedList;

public class CreateDLL {


public static void main(String[] args) {

    // Manual Creation
    Node head1 = createDLLManual();

    // Helper Method Creation
    int[] arr = {1, 2, 3, 4, 5};
    Node head2 = createDLL(arr);

    // Insert before head
    head2 = insertBeforeHead(head2, 0);
}

// -----------------------------------------
// Method 1 : Manual Creation
// -----------------------------------------
public static Node createDLLManual() {

    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);

    // Connect 1 and 2
    n1.next = n2;
    n2.prev = n1;

    // Connect 2 and 3
    n2.next = n3;
    n3.prev = n2;

    // Connect 3 and 4
    n3.next = n4;
    n4.prev = n3;

    // Connect 4 and 5
    n4.next = n5;
    n5.prev = n4;

    return n1;
}

// -----------------------------------------
// Method 2 : Create DLL using Array
// -----------------------------------------
public static Node createDLL(int[] arr) {

    if (arr == null || arr.length == 0)
        return null;

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

// -----------------------------------------
// Method 3 : Insert before head
// -----------------------------------------
public static Node insertBeforeHead(Node head, int data) {

    Node newNode = new Node(data);

    // If list is empty
    if (head == null) {
        return newNode;
    }

    newNode.next = head;
    head.prev = newNode;

    return newNode;
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
