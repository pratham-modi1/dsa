package Level6_LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListCycleII {

    static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Phase 2: Find the start of the cycle
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    // Safe display (prints only first 'limit' nodes)
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

        // Safe display
        display(head, 10);

        ListNode ans = detectCycle(head);

        if (ans == null)
            System.out.println("No cycle");
        else
            System.out.println("Cycle starts at node with value: " + ans.val);
    }
}