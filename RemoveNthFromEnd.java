/**
 * Remove Nth Node From End of Linked List
 *
 * Approach:
 * 1. Move the fast pointer n steps ahead.
 * 2. If fast becomes null, remove the head node.
 * 3. Move both slow and fast pointers until fast reaches the last node.
 * 4. Slow will be at the node before the target node.
 * 5. Delete the target node by updating links.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */


package LinkedList;

class ListNode {
    int data;
    ListNode next;
    ListNode() {}
    ListNode(int data) { 
        this.data = data;
    }
    ListNode(int data, ListNode next) { 
        this.data = data; 
        this.next = next; 
    }
}
  
public class RemoveNthFromEnd {
    static ListNode convertToLL(int[] arr) {
        int n = arr.length;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    static void printLL(ListNode head) {
        ListNode current = head;

        while(current != null) {
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.print("null");
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null) {
            return null;
        }

        ListNode fast = head;

        for(int i = 0; i <  n; i++) {
            fast = fast.next;
        }
        
        if (fast == null) {
            return head.next; 
        }

        ListNode slow = head;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 2;

        ListNode head = convertToLL(arr);
        ListNode ans = removeNthFromEnd(head, n);
        printLL(ans);
    }
}
