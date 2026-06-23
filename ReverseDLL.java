package LinkedList;

import java.util.Stack;

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

public class ReverseDLL {
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

    static Node reverse(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node temp = head;

        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;

        while (temp != null) {
            temp.data = stack.peek();
            stack.pop();
            temp = temp.next;
        }
        return head;
    }


    static Node reverse1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node current = head;

        while (current != null) {
            prev = current.back;
            current.back = current.next;
            current.next = prev;
            current = current.back;
        }

        return prev.back;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Node head = createDLL(arr);
        // Node ans = reverse(head);
        Node ans = reverse1(head);
        printDLL(ans);
    }
}
