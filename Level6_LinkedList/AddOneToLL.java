package Level6_LinkedList;

class Solution {
    public ListNode addOne(ListNode head) {

        if (head == null) {
            return null;
        }

        boolean allNines = (head.val == 9);

        ListNode i = head;
        ListNode j = head;

        while (i != null) {

            if (i.val != 9) {
                allNines = false;
            }

            if (i.next != null && i.next.val == 9 && i.val != 9) {
                j = i;
            }

            if (i.next == null && i.val != 9) {
                i.val++;
            }
            else if (i.next == null && i.val == 9) {

                if (allNines) {

                    ListNode newHead = new ListNode(1);
                    newHead.next = head;

                    ListNode curr = head;

                    while (curr != null) {
                        curr.val = 0;
                        curr = curr.next;
                    }

                    return newHead;
                }

                while (j != null) {

                    j.val++;

                    if (j.val == 10) {
                        j.val = 0;
                    }

                    j = j.next;
                }
            }

            i = i.next;
        }

        return head;
    }

      public ListNode addOneStandardApproach(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode i = head;
        ListNode j = dummy;

        while (i != null) {

            if (i.val != 9) {
                j = i;
            }

            i = i.next;
        }

        j.val++;

        i = j.next;

        while (i != null) {
            i.val = 0;
            i = i.next;
        }

        if (dummy.val == 1) {
            return dummy;
        }

        return head;
    }
}


