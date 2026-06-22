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
public class DeleteNodeDLL {

    static Node createDLL(int[] arr) {
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

    static void printDLL(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    static Node removeHead(Node head) {

        if (head == null || head.next == null) {
            return null;
        }

        Node newNode = head.next;
        newNode.back = null;

        return newNode;
    }

    static Node removeTail(Node head) {

        if(head == null ) {
            return null;
        }
        Node newNode = head;
        Node prev = null;

        while(newNode.next != null) {
            newNode = newNode.next;
        }

        prev = newNode.back;
        prev.next = null;
        newNode.back = null;

        return head;
    }

    static Node removeAnyNode(Node head, int k) {

        if (head == null) {
            return null;
        }

        int count = 1;
        Node temp = head;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // k is greater than list length
        if (temp == null) {
            return head;
        }

        // Remove head
        if (temp == head) {
            return removeHead(head);
        }

        // Remove tail
        if (temp.next == null) {
            return removeTail(head);
        }

        // Remove middle node
        Node prev = temp.back;
        Node front = temp.next;

        prev.next = front;
        front.back = prev;

        temp.next = null;
        temp.back = null;

        return head;
    }

    static Node removeNode(Node head, Node temp) {

        Node prev = temp.back;
        Node front = temp.next;

        // deleting head
        if (prev == null) {
            head = front;
            if (front != null) {
                front.back = null;
            }
            return head;
        }

        // deleting tail
        if (front == null) {
            prev.next = null;
            return head;
        }

        // deleting middle node
        prev.next = front;
        front.back = prev;

        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Node head = createDLL(arr);
        Node temp = new Node(2);
        Node ans = removeNode(head, temp);
        printDLL(ans);

    }
}
