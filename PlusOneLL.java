/*
 * Problem: Plus One Linked List
 *
 * Approach:
 * 1. Reverse the linked list.
 * 2. Add 1 to the first node of the reversed list.
 * 3. Propagate the carry while traversing the list.
 * 4. Reverse the list back to its original order.
 * 5. If a carry remains after processing all nodes,
 *    create a new node with value 1 and attach it
 *    at the beginning of the list.
 *
 * Example:
 * Input:  9 -> 9 -> 9 -> 9
 * Output: 1 -> 0 -> 0 -> 0 -> 0
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)  // due to recursive reversal
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

public class PlusOneLL {

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
    static Node addOneLL(Node head) {
        if (head == null) {
            return null;
        }

        head = reverseLinkedList(head);

        Node temp = head;
        int carry = 1;

        while (temp != null) {
            temp.data = temp.data + carry;

            if (temp.data < 10) {
                carry = 0;
                break;
            }else{
                carry = 1;
                temp.data = 0;
            }
            temp = temp.next;
        }

        head = reverseLinkedList(head);

        if (carry == 1) {
            Node newNode = new Node(carry);
            newNode.next = head;

            return newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        int arr[] = {9, 9, 9, 9};
        Node head = convertToLL(arr);
        Node ans = addOneLL(head);
        printLL(ans);
    }
}
