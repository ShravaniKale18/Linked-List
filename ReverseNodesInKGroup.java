package LinkedList;

public class ReverseNodesInKGroup {

    static Node createLL(int[] arr) {
        if(arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i = 1; i < arr.length; i++){
            Node newNode = new Node(arr[i]);    
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }


    static void printLL(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }
    static Node reverseKGroup(Node head, int k) {

        if(head == null || k == 1) {
            return head;
        }

        Node prevNode = null;
        Node temp = head;

        while(temp != null) {

            Node KthNode = findKthNode(temp, k);

            if(KthNode == null) {
                if(prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }

            Node nextNode = temp.next;
            KthNode.next = null;

            Node newHead = reverseLL(temp);

            if(prevNode == null) {
                head = newHead;
            }else{
                prevNode.next = newHead;
            }

            temp.next = nextNode;
            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }

    static Node findKthNode(Node head, int k) {

        Node temp = head;
        while(temp != null && --k > 0) {
            temp = temp.next;
        }
        return temp;
    }


    static Node reverseLL(Node head) {
        Node prevNode = null;
        Node currNode = head;

        while(currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        return prevNode;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = createLL(arr);
        Node ans = reverseKGroup(head, 2);
        printLL(ans);
    }
}
