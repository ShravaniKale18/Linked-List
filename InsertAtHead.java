package LinkedList;

class Node{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class InsertAtHead {

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

    static Node insertAtHead(Node head, int ele) {

        Node temp = new Node(ele);
        temp.next = head;
        return temp;

    }

    static void printLL(Node head) {
        Node current = head;

        while(current != null) {
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4};
        int ele = 1;

        Node head = convertToLL(arr);
        Node ans = insertAtHead(head, ele);
        printLL(ans);
    }
}
