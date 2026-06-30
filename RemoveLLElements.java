package LinkedList;


/*
 * Approach:
 * 1. Create a dummy node pointing to the head.
 * 2. Initialize two pointers:
 *    - prev = dummy
 *    - temp = head
 * 3. Traverse the linked list.
 * 4. If the current node's value equals the given value,
 *    remove it by setting prev.next = temp.next.
 * 5. Otherwise, move prev to the current node.
 * 6. Move temp to the next node.
 * 7. Return dummy.next as the new head.
 *
 * TC - O(N)
 * SC - O(1)
 */

class Node{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class RemoveLLElements {

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

    static Node removeDupElements(Node head, int val) {

        if (head == null) {
            return null;
        }

        Node dummy = new Node(-1);
        dummy.next = head;
        Node temp = head;
        Node prev = dummy;
        

        while (temp != null) {
            if (temp.data == val) {
                prev.next = temp.next;
            }else{
                prev = temp;
            }
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 10, 10, 6, 10};
        int val = 10;
        Node head = createLL(arr);
        Node ans = removeDupElements(head, val);
        printLL(ans);
    }
}
