package LinkedList;

import java.util.HashMap;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedLCycle {

    static Node createLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        return head;
    }

    /**
     * Approach 1: Using HashMap
     * 1. Traverse the linked list from the head.
     * 2. Store every visited node in a HashMap.
     * 3. If a node is encountered again, it means a cycle exists.
     * 4. If traversal reaches null, the linked list has no cycle.
     *
     * Time Complexity: O(N)
     * - Each node is visited only once.
     *
     * Space Complexity: O(N)
     * - HashMap stores all visited nodes.
     */
    static boolean hasCycle1(Node head) {
        Node temp = head;
        HashMap<Node, Integer> map = new HashMap<>();

        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }

            map.put(temp, 1);
            temp = temp.next;
        }

        return false;
    }

    /**
     * Approach 2: Floyd's Cycle Detection (Tortoise and Hare)
     * 1. Initialize two pointers: slow and fast.
     * 2. Move slow by one node and fast by two nodes.
     * 3. If the linked list contains a cycle, both pointers
     *    will eventually meet.
     * 4. If fast reaches null or fast.next becomes null,
     *    there is no cycle.
     *
     * Time Complexity: O(N)
     * - Each pointer traverses the list at most once.
     *
     * Space Complexity: O(1)
     * - No extra space is used.
     */
    static boolean hasCycle(Node head) {

        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Node head = createLL(arr);

        // Create cycle: 5 -> 3
        head.next.next.next.next.next = head.next.next;

        boolean ans = hasCycle(head);

        System.out.println(ans);
    }
}