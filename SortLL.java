// Problem: Sort a Linked List of 0s, 1s and 2s
//
// Approach:
// 1. Traverse the linked list and count the number of 0s, 1s, and 2s.
// 2. Reset the traversal pointer to the head.
// 3. Overwrite node values:
//    - Fill all 0s first.
//    - Then fill all 1s.
//    - Finally fill all 2s.
// 4. Return the modified linked list.
//
// Time Complexity: O(2N)
// Space Complexity: O(1)

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

public class SortLL {

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

    static Node sortList(Node head) {
        Node temp = head;
        int count0 = 0, count1 = 0, count2 = 0;

        while (temp != null) {
            if (temp.data == 0) {
                count0++;
            }else if (temp.data == 1) {
                count1++;
            }else{
                count2++;
            }
        }

        temp = head;

        while (temp != null) {
            if (count0 > 0) {
                temp.data = 0;
                count0--;
            }else if (count1 > 0) {
                temp.data = 1;
                count1--;
            }else{
                temp.data = 2;
                count2--;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 0};
        Node head = convertToLL(arr);
        Node ans = sortList(head);
        printLL(ans);
    }
}
