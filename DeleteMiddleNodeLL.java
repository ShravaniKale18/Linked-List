/*
 * Approach:
 * 1. Handle the edge case where the linked list has only one node.
 * 2. Initialize three pointers:
 *    - slow: moves one step at a time.
 *    - fast: moves two steps at a time.
 *    - prev: keeps track of the node before slow.
 * 3. Traverse the linked list until fast reaches the end.
 * 4. At this point, slow points to the middle node and prev points
 *    to the node just before the middle.
 * 5. Delete the middle node by updating:
 *        prev.next = slow.next;
 * 6. Return the modified linked list.
 *
 * Time Complexity: O(N)
 * - The linked list is traversed only once.
 *
 * Space Complexity: O(1)
 * - Only a few pointer variables are used.
 */
package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteMiddleNodeLL {

    static Node createLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
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

    static Node deleteMiddle(Node head) {

        Node slow = head;
        Node fast = head;
        Node prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = slow.next;

        return head;
    }
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        Node head = createLL(arr);

        Node ans = deleteMiddle(head);
        printLL(ans);
    }
}
