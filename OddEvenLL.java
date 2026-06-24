//https://leetcode.com/problems/odd-even-linked-list/description/
//TC -> O(N/2) = O(N)
//SC - O(1)

package LinkedList;

class Node{
    int data;
    Node next;
    Node back;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }

    Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }
}

public class OddEvenLL {

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

    static Node oddEvenList(Node head) {

        Node odd = head;
        Node even = head.next;
        Node evenNode= head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenNode;

        return head;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        Node head = convertToLL(arr);
        Node ans = oddEvenList(head);
        printLL(ans);
    }
}
