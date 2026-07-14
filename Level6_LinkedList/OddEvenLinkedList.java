package Level6_LinkedList;

public class OddEvenLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Create Linked List from array
    static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    // Print Linked List
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Your method
    static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode i = head;
        ListNode j = head.next;
        ListNode evenHead = j;

        while (i.next != null && j.next != null) {

            i.next = i.next.next;
            i = i.next;

            j.next = i.next;
            j = j.next;
        }

        i.next = evenHead;

        return head;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};

        ListNode head = createList(arr);

        System.out.println("Before:");
        printList(head);

        head = oddEvenList(head);

        System.out.println("After:");
        printList(head);
    }
}
