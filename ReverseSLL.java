/*
LeetCode 206: Reverse Linked List

Approach:
1. Recursively reverse the linked list from the second node.
2. During backtracking, reverse the links.
3. Make the next node point to the current node.
4. Set current node's next to null to avoid cycles.
5. Return the new head of the reversed list.

Time Complexity: O(N)
Space Complexity: O(N)
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

class ReverseSLL {

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

    static Node reverseList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        Node head = convertToLL(arr);
        Node ans = reverseList(head);
        printLL(ans);
    }
}