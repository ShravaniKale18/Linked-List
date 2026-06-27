/*
 * Approach:
 * 1. If the linked list is empty, return null.
 * 2. Initialize two pointers:
 *    - slow = head (moves one node at a time)
 *    - fast = head (moves two nodes at a time)
 * 3. Traverse the linked list while fast != null && fast.next != null:
 *    - Move slow by one step.
 *    - Move fast by two steps.
 * 4. When the fast pointer reaches the end of the list (or becomes null),
 *    the slow pointer will be at the middle node.
 * 5. Return the slow pointer.
 *
 * Example:
 * Input : 1 -> 2 -> 3 -> 4 -> 5 -> 6
 *
 * Iteration 0:
 * slow = 1, fast = 1
 *
 * Iteration 1:
 * slow = 2, fast = 3
 *
 * Iteration 2:
 * slow = 3, fast = 5
 *
 * Iteration 3:
 * slow = 4, fast = null
 *
 * Output:
 * 4 (Second middle node for an even-length linked list)
 *
 * Time Complexity: O(n)
 * - The linked list is traversed only once.
 *
 * Space Complexity: O(1)
 * - Only two pointers (slow and fast) are used.
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

public class MiddleNodeLL {

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

    static Node findMiddle(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = convertToLL(arr);
        Node ans = findMiddle(head);
        System.out.println(ans.data);
    }
}
