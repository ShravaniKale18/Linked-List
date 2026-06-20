package LinkedList;

class Node{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class InsertAtkthPosition {

    static Node createLL(int[] arr) {
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

    static Node insertAtkthPos(Node head, int pos, int ele) {
        if(head == null) {
            return new Node(ele);
        }

        if(pos == 1) {
            Node newNode = new Node(ele);
            newNode.next = head;
            return newNode;
        }
        Node temp = head;
        int cnt = 1;

        while(temp.next != null) {

            if(cnt == (pos - 1)) {
                Node newNode = new Node(ele);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            cnt++;
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 54};
        Node head = createLL(arr);
        Node ans = insertAtkthPos(head, 2, 12);
        printLL(ans);
    }
}
