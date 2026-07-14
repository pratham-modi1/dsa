package Level6_LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {

        ListNode p = head;
        ListNode q = head;

        while (q != null && q.next != null) {

            p = p.next;
            q = q.next.next;

            if (p == q) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Create: 1 -> 2 -> 3 -> 4 -> 5
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // Uncomment to create a cycle:
        // 5 -> 3
        n5.next = n3;

        System.out.println(hasCycle(n1));
    }
}