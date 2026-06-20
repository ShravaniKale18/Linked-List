package LinkedList;

public class TraversingLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Node head = null;
        Node tail = null;

        for(int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);

            if(head == null) {
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
            }
        }


        //Traversing a linked list 

        Node current = head;

        while(current != null) {
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.print("null");

        //Count the length of the linked list
        int count = 0;
        current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        System.out.println("\nLength of the linked list: "+count);
    }
}
