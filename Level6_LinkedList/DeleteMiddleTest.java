package Level6_LinkedList;

public class DeleteMiddleTest {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Create Linked List from array
    static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        return head;
    }

    // Print Linked List
    static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Your function
    static ListNode deleteMiddle(ListNode head) {

        ListNode i = head;
        ListNode j = head;

        while (true) {

            if(i == null || i.next == null){
                return null;
            }

            if(j.next.next==null){
                i.next = i.next.next;
                return head;
            }
            
            if(j.next.next.next == null){
                i.next = i.next.next;
                return head;
            }

            i = i.next;
            j = j.next.next;
        }
        // Write your algorithm here
    }

    public static void main(String[] args) {

        int[] arr = {1};

        ListNode head = createList(arr);

        System.out.println("Before:");
        printList(head);

        head = deleteMiddle(head);

        System.out.println("After:");
        printList(head);
    }
}