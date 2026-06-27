package LinkedList;

import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IntersectionLL {

    /*
     * Approach 1: HashMap
     *
     * 1. Traverse the first linked list and store each node in a HashMap.
     * 2. Traverse the second linked list.
     * 3. If any node is already present in the HashMap,
     *    that node is the intersection point.
     * 4. Otherwise, return null.
     *
     * Time Complexity: O(N + M)
     * Space Complexity: O(N)
     */

    static Node getIntersectionNode1(Node headA, Node headB) {

        if (headA == null || headB == null) {
            return null;
        }

        Map<Node, Integer> map = new HashMap<>();

        Node temp = headA;

        while (temp != null) {
            map.put(temp, 1);
            temp = temp.next;
        }

        temp = headB;

        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    /*
     * Approach 2: Difference in Lengths
     *
     * 1. Find the lengths of both linked lists.
     * 2. Compute the difference in lengths.
     * 3. Move the pointer of the longer list ahead by the difference.
     * 4. Traverse both lists together.
     * 5. The first node where both pointers are the same
     *    (reference equality) is the intersection node.
     * 6. If no common node is found, return null.
     *
     * Time Complexity: O(N + M)
     * Space Complexity: O(1)
     */

    static Node getIntersectionNode(Node headA, Node headB) {

        if (headA == null || headB == null) {
            return null;
        }

        Node temp1 = headA;
        Node temp2 = headB;

        int n1 = 0, n2 = 0;

        while (temp1 != null) {
            n1++;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            n2++;
            temp2 = temp2.next;
        }

        int diff = Math.abs(n1 - n2);

        temp1 = headA;
        temp2 = headB;

        for (int i = 0; i < diff; i++) {
            if (n1 > n2) {
                temp1 = temp1.next;
            } else {
                temp2 = temp2.next;
            }
        }

        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2) {
                return temp2;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;
    }

    public static void main(String[] args) {

        Node common = new Node(8);
        common.next = new Node(4);
        common.next.next = new Node(5);

        // List A: 4 -> 1 -> 8 -> 4 -> 5
        Node head1 = new Node(4);
        head1.next = new Node(1);
        head1.next.next = common;

        // List B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(1);
        head2.next.next.next = common;

        Node ans = getIntersectionNode(head1, head2);

        if (ans != null) {
            System.out.println("Intersection Node: " + ans.data);
        } else {
            System.out.println("No intersection");
        }
    }
}