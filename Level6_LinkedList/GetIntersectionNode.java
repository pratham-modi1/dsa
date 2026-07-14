package Level6_LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class GetIntersectionNode {

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int counter = 0;

        ListNode i = headA;
        ListNode j = headB;

        while (i != null || j != null) {

            if (i != null) {
                counter++;
                i = i.next;
            }

            if (j != null) {
                counter--;
                j = j.next;
            }
        }

        if (counter > 0) {
            while (counter != 0) {
                headA = headA.next;
                counter--;
            }
        } else {
            while (counter != 0) {
                headB = headB.next;
                counter++;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Common Part
        ListNode common1 = new ListNode(8);
        ListNode common2 = new ListNode(10);

        common1.next = common2;

        // List A
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);

        a1.next = a2;
        a2.next = common1;

        // List B
        ListNode b1 = new ListNode(3);

        b1.next = common1;

        System.out.println("List A:");
        print(a1);

        System.out.println("List B:");
        print(b1);

        ListNode ans = getIntersectionNode(a1, b1);

        if (ans != null)
            System.out.println("Intersection = " + ans.val);
        else
            System.out.println("No Intersection");
    }
}