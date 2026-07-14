package Level6_LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LengthOfLoop {

    static int lengthOfLoop(ListNode head) {

        if (head == null || head.next == null)
            return 0;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                int length = 1;
                fast = fast.next;

                while (fast != slow) {
                    fast = fast.next;
                    length++;
                }

                return length;
            }
        }

        return 0;
    }

    // Safe display
    static void display(ListNode head, int limit) {
        ListNode temp = head;
        int count = 0;

        while (temp != null && count < limit) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
            count++;
        }

        if (temp != null)
            System.out.println("...");
        else
            System.out.println("null");
    }

    public static void main(String[] args) {

        // Creating nodes
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(12);
        ListNode n3 = new ListNode(18);
        ListNode n4 = new ListNode(25);
        ListNode n5 = new ListNode(31);
        ListNode n6 = new ListNode(44);

        // Creating linked list
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        // Creating a cycle
        n6.next = n4;

        ListNode head = n1;

        display(head, 10);

        int ans = lengthOfLoop(head);

        if (ans == 0)
            System.out.println("No cycle");
        else
            System.out.println("Length of loop = " + ans);
    }
}