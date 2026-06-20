package LinkedList;

public class CreatingLL {

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

        // Node newNode = new Node(arr[0]);
        // System.out.println(newNode.data);

        for(int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
            }
            System.out.print(newNode.data+"->");
        }
        System.out.print("null");
    }
}
