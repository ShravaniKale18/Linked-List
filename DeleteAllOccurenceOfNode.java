package LinkedList;

class Node {
    public int data;
    public Node next;
    public Node prev;

    Node() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class DeleteAllOccurenceOfNode {

    static Node createDLL(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev;
            prev = temp;
        }

        return head;
    }

    static void printDLL(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    /*
     * Approach:
     * 1. Traverse the doubly linked list.
     * 2. If the current node contains the given value:
     *    - If it is the head node, move head to the next node.
     *    - Store references to the previous and next nodes.
     *    - Connect the previous node to the next node.
     *    - Connect the next node back to the previous node.
     * 3. Move to the next node and continue until the end.
     * 4. Return the updated head.
     *
     * TC - O(N)
     * SC - O(1)
     */

    public static Node deleteAllOccurrences(Node head, int k) {

        Node temp = head;

        while (temp != null) {

            if (temp.data == k) {

                if (temp == head) {
                    head = head.next;
                }

                Node prevNode = temp.prev;
                Node nextNode = temp.next;

                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }
            }

            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

        int[] arr = {10, 4, 10, 6, 10, 8, 10};

        Node head = createDLL(arr);

        System.out.println("Original DLL:");
        printDLL(head);

        head = deleteAllOccurrences(head, 10);

        System.out.println("After deleting all occurrences of 10:");
        printDLL(head);
    }
}