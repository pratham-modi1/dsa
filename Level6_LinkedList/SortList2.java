package Level6_LinkedList;

class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        // Add all 0's
        ListNode i = head;
        while (i != null) {
            if (i.val == 0) {
                temp.next = i;
                temp = temp.next;
            }
            i = i.next;
        }

        // Add all 1's
        i = head;
        while (i != null) {
            if (i.val == 1) {
                temp.next = i;
                temp = temp.next;
            }
            i = i.next;
        }

        // Add all 2's
        i = head;
        while (i != null) {
            if (i.val == 2) {
                temp.next = i;
                temp = temp.next;
            }
            i = i.next;
        }

        temp.next = null;

        return dummy.next;
    }


    

    public ListNode sortList2(ListNode head) {

    if (head == null || head.next == null) {
        return head;
    }

    ListNode zeroHead = new ListNode(-1);
    ListNode oneHead = new ListNode(-1);
    ListNode twoHead = new ListNode(-1);

    ListNode zero = zeroHead;
    ListNode one = oneHead;
    ListNode two = twoHead;

    ListNode curr = head;

    while (curr != null) {

        if (curr.val == 0) {
            zero.next = curr;
            zero = zero.next;
        }
        else if (curr.val == 1) {
            one.next = curr;
            one = one.next;
        }
        else {
            two.next = curr;
            two = two.next;
        }

        curr = curr.next;
    }

    // Connect the three lists
    zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
    one.next = twoHead.next;
    two.next = null;

    return zeroHead.next;
}
}
