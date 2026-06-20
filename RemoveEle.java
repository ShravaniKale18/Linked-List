package LinkedList;
class Node {
    int data;
    Node next = null;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveEle {    

    public static Node convertArrLL(int[] arr) {
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < n; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }

        return head;
    }

    static Node removeElement(Node head, int val) {
        if (head == null) {
            return null;
        }
        
        Node temp = head;
        Node prev = null;

        if (temp.data == val) {
            head = head.next;
            return head;
        }

        while(temp != null) {
            if(temp.data == val) {
                prev.next = prev.next.next;
            }
            prev = temp;
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
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = convertArrLL(arr);
        Node ans = removeElement(head, 3);
        printLL(ans);
    }
}
