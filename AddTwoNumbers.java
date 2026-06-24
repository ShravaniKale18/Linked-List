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

public class AddTwoNumbers {
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

    static Node addList(Node head1, Node head2) {
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        Node temp1 = head1;
        Node temp2 = head2;

        int sum = 0;
        int carry = 0;

        while (temp1 != null || temp2 != null) {

            sum = carry;

            if (temp1 != null) {
                sum += temp1.data;
            }

            if(temp2 != null) {
                sum += temp2.data;
            }

            Node newNode = new Node(sum % 10);
            carry = sum / 10;

            current.next = newNode;
            current = current.next;

            if (temp1 != null) {
                temp1 = temp1.next;
            }

            if(temp2 != null) {
                temp2 = temp2.next;
            }

            if (carry > 0) {
                Node temp = new Node(carry);
                current.next = temp;
            }
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] arr2 = {4, 8, 7, 5};

        Node head1 = convertToLL(arr);
        Node head2 = convertToLL(arr2);

        Node ans = addList(head1, head2); 
        printLL(ans);
    }
}
