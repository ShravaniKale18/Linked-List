/*
 * Problem: Check if a Linked List is Palindrome
 *
 * Approach:
 * 1. Find the middle of the linked list using slow and fast pointers.
 * 2. Reverse the second half of the linked list using recursion.
 * 3. Compare nodes from the first half and the reversed second half.
 * 4. If any pair of nodes has different values, the list is not a palindrome.
 * 5. Restore the original linked list by reversing the second half again.
 * 6. Return the result.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)  // Recursive call stack
 */
package LinkedList;

class Node{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeLL {
    static Node convertToLL(int[] arr) {
        int n = arr.length;

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < n; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }

    static void printLL(Node head) {
        Node current = head;

        while(current != null) {
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.print("null");
    }
    static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseLinkedList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverseLinkedList(slow.next);
        Node first = head;
        Node second = newHead;

        while (second != null) {
            if (first.data != second.data) {
                reverseLinkedList(newHead);
                return false;
            }

            first = first.next;
            second = second.next;
        }
        reverseLinkedList(newHead);

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};
        Node head1 = convertToLL(arr);

        boolean ans = isPalindrome(head1); 
        System.out.println(ans);
    }
}
