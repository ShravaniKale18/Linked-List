package LinkedList;

import java.util.HashSet;
import java.util.Set;


class Node{
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class RemoveDuplicatesDLL {

    static Node createDLL(int[] arr) {
        if(arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node prev = head;

        for(int i = 1; i < arr.length; i++) {
            Node current = new Node(arr[i]);
            prev.next = current;
            current.prev = prev;
            prev = current;
        }

        return head;
    }


    static void printDLL(Node head) {
        Node temp = head;
        System.out.print("null<->");
        while(temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    /*
    *Approach:
    1. Create a HashSet to store unique values.
    2. Traverse the doubly linked list.
    3. For each node, check if its value is already in the HashSet.
    4. If it is not in the HashSet, add it to the HashSet and move to the next node.
    5. If it is already in the HashSet, remove the node from the list by adjusting the next and prev pointers of its neighboring nodes.
    6. Continue this process until the end of the list is reached.

    TC: O(N) - We traverse the list once, where N is the number of nodes in the list.
    SC: O(N) - In the worst case, we may store all unique values in the HashSet.

    */
    static Node removeDuplicates1(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        Set<Integer> set = new HashSet<>();

        while(temp != null) {
            if(!set.contains(temp.data)) {
                set.add(temp.data);
                temp = temp.next;
            }else{
                Node newNode = temp;
                if(newNode.prev != null) {
                    newNode.prev.next = newNode.next;
                }
                if(newNode.next != null) {
                    newNode.next.prev = newNode.prev;
                }
                temp = temp.next;
            }
        }
        return head;
    }

    /*
    * Approach:
    * 1. Since the doubly linked list is sorted, duplicate nodes will always be adjacent.
    * 2. Use two pointers:
    *    - temp points to the current node.
    *    - runner points to temp.next.
    * 3. Compare temp.data with runner.data.
    * 4. If both values are equal, remove runner by updating the next and prev pointers.
    * 5. Do not move temp after deletion because there may be more duplicates of the same value.
    * 6. If the values are different, move temp to the next node.
    * 7. Continue until the end of the list is reached.
    *
    * TC: O(N) - Each node is visited at most once.
    * SC: O(1) - No extra space is used.
    */

    static Node removeDuplicates(Node head) {

        Node temp = head;
        Node runner = temp.next;

        while(temp != null && temp.next != null) {
            runner = temp.next;

            if(temp.data == runner.data) {
                temp.next = runner.next;

                if(runner.next != null) {
                    runner.next.prev = temp;
                }
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        Node head = createDLL(arr);
        Node ans = removeDuplicates(head);
        printDLL(ans);
    }
}
