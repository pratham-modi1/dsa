package Level6_LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DeleteNode {

    // ----------------------------------------------------
    // Method 1: Normal deletion (Head is given)
    // Deletes the first occurrence of target
    // ----------------------------------------------------
    public ListNode deleteByValue(ListNode head, int target) {

        if (head == null)
            return null;

        // If head itself is to be deleted
        if (head.val == target)
            return head.next;

        ListNode temp = head;

        while (temp != null && temp.next != null) {

            if (temp.next.val == target) {
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }

        return head;
    }

    // ----------------------------------------------------
    // Method 2: LeetCode 237
    // Only the node to be deleted is given
    // ----------------------------------------------------
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}