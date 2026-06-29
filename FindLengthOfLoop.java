package LinkedList;

public class FindLengthOfLoop {

    static Node createLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        return head;
    }

    static int lengthOfLoop(Node head) {
        int length = 0;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                Node temp = slow;

                do{
                    length++;
                    temp = temp.next;
                }while(temp != slow);
                
                return length;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Node head = createLL(arr);
        head.next.next.next.next.next = head.next;

        int ans = lengthOfLoop(head);
        System.out.println(ans);
    }
}
