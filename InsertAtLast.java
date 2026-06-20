package LinkedList;


class Node{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtLast {

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

    static Node insertAtLast(Node head, int ele) {
        if (head == null) {
            //head.data = ele;
            head = new Node(ele);
            return head;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(ele);
        return head;
    }
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int ele = 5;

        Node head = convertToLL(arr);
        Node ans = insertAtLast(head, ele);
        printLL(ans);
    }
}
