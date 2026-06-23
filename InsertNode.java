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

public class InsertNode {

    static Node createDLL(int[] arr) {

        if(arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            current.next = newNode;
            newNode.back = current;

            current = newNode;
        }
        return head;
    }


    static void printDLL(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    static Node insertAtHead(Node head, int ele) {
        if (head == null) {
            return new Node(ele);
        }

        Node newNode = new Node(ele);
        newNode.next = head;
        head.back = newNode;
        head = newNode;

        return head;
    }

    static Node insertAtTail(Node head, int ele) {
        if (head == null || head.next == null) {
            
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        Node newNode = new Node(ele);
        temp.next = newNode;
        newNode.back = temp;
        newNode.next = null;

        return head;
    }

    static Node insertAtAnyPos(Node head, int pos, int ele) {
        if (head == null) {
            return null;
        }

        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;

            if (count == (pos - 1)) {
                Node front = temp.next;
                Node newNode = new Node(ele);

                newNode.next = front;
                newNode.back = temp;

                temp.next = newNode;

                if (front != null) {
                    front.back = newNode;
                }
                break;
            }

            temp = temp.next;
            
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Node head = createDLL(arr);
        // Node ans = insertAtHead(head, 0);
        // Node ans = insertAtTail(head, 6);
        Node ans = insertAtAnyPos(head, 2, 15);
        printDLL(ans);
    }
}
