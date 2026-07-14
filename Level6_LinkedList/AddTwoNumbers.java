package Level6_LinkedList;

import java.util.List;

public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Create linked list from array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    // Print linked list
    public static void printList(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val);

            if (curr.next != null) {
                System.out.print(" -> ");
            }

            curr = curr.next;
        }

        System.out.println();
    }

    // Your solution goes here
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode i = l1;
        ListNode j = l2;

        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        dummy.next = new ListNode(0);
        boolean carry = false;
        int val = 0;

        while (i!=null || j!=null) {

            if(i!=null && j!=null){
            val =i.val + j.val;
            i = i.next;
            j= j.next;
            }
            else if(i!=null){
                 val = i.val;
                i = i.next;
            }
            else{
                 val = j.val;
                j=j.next;
            }
           

            if(carry==true){val += 1;}
            
            if(val>=10){
                val = val%10;
                carry = true;
            }
            else{
                carry=false;
            }

            dummy.next = new ListNode(val);
            dummy = dummy.next;

        }
        if(carry==true){
             dummy.next = new ListNode(1); 
        }


        return ans.next;
    }

    public static void main(String[] args) {

        int[] a = {9};
        int[] b = {9};

        ListNode l1 = createList(a);
        ListNode l2 = createList(b);

        System.out.println("Input Lists:");
        System.out.print("l1: ");
        printList(l1);

        System.out.print("l2: ");
        printList(l2);

        ListNode ans = addTwoNumbers(l1, l2);

        System.out.println("\nOutput:");
        printList(ans);
    }
}