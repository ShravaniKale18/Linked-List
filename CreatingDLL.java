package LinkedList;

class Node {
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
public class CreatingDLL {

    static Node createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            prev.next = newNode;
            newNode.back = prev;
            prev = newNode;
        }

        return head;
    }

    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = createList(arr);
        printList(head);
    }
}
