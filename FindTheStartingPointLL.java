package LinkedList;

import java.util.HashMap;

class Node{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindTheStartingPointLL {

    static Node createLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    /*
        * Approach:
        * 1. Traverse the linked list from the head.
        * 2. Store each visited node in a HashMap.
        * 3. Before storing a node, check if it already exists in the map.
        * 4. If it exists, that node is the starting point of the cycle.
        * 5. If the traversal reaches null, there is no cycle.
        *
        * TC - O(N)
        * SC - O(N)
     */
    static Node detectCycle1(Node head) {
        Node temp = head;
        HashMap<Node, Integer> map = new HashMap<>();

        if (head == null) {
            return null;
        }

        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            map.put(temp, 1);
            temp = temp.next;
        }

        return null;
    }

    /*
        * Approach:
        * 1. Initialize two pointers, slow and fast, at the head.
        * 2. Move slow by one step and fast by two steps.
        * 3. If slow and fast never meet, there is no cycle.
        * 4. If they meet, a cycle exists.
        * 5. Move slow back to the head while keeping fast at the meeting point.
        * 6. Move both pointers one step at a time.
        * 7. The node where they meet again is the starting point of the cycle.
        *
        * TC - O(N)
        * SC - O(1)
     */

    static Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = createLL(arr);
        head.next.next.next.next = head.next;
        Node ans = detectCycle(head);
        System.out.println(ans.data);
    }
}
