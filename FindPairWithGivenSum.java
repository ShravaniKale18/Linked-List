package LinkedList;

import java.util.ArrayList;

class Node {
    int data;
    Node next, prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

public class FindPairWithGivenSum {

    static Node createDLL(int[] arr) {

        if (arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev;
            prev = temp;
        }

        return head;
    }

    /*
     * Brute Force Approach
    
     * 1. Fix the first pointer (temp1) at each node.
     * 2. Traverse the remaining list using temp2.
     * 3. If temp1.data + temp2.data == target, store the pair.
     * 4. Continue until all pairs are checked.
     *
     * Time Complexity : O(N²)
     * Space Complexity: O(1) (excluding the output list)
     * ------------------------------------------------------------
     */
    static ArrayList<ArrayList<Integer>> findPair1(Node head, int k) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        Node temp1 = head;

        while (temp1 != null) {

            Node temp2 = temp1.next;

            while (temp2 != null) {

                if (temp1.data + temp2.data == k) {

                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(temp1.data);
                    pair.add(temp2.data);

                    list.add(pair);
                }

                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }

        return list;
    }

    /*
     * Optimal Two Pointer Approach

     * 1. Place the left pointer at the head.
     * 2. Traverse to the last node and place the right pointer there.
     * 3. While the left and right pointers have not met or crossed:
     *      - Calculate the sum of left.data and right.data.
     *      - If sum == target:
     *          • Store the pair.
     *          • Move the left pointer forward.
     *          • Move the right pointer backward.
     *      - If sum > target:
     *          • Move the right pointer backward to reduce the sum.
     *      - Otherwise:
     *          • Move the left pointer forward to increase the sum.
     * 4. Repeat until the pointers meet or cross.
     *
     * Time Complexity : O(N)
     * Space Complexity: O(1) (excluding the output list)
     * ------------------------------------------------------------
     */
    static ArrayList<ArrayList<Integer>> findPair(Node head, int k) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if (head == null) {
            return list;
        }

        Node left = head;
        Node right = head;

        // Move right pointer to the last node
        while (right.next != null) {
            right = right.next;
        }

        // Traverse until the pointers meet or cross
        while (left != right && left.prev != right) {

            int sum = left.data + right.data;

            if (sum == k) {

                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);

                list.add(pair);

                left = left.next;
                right = right.prev;

            } else if (sum > k) {

                right = right.prev;

            } else {

                left = left.next;
            }
        }

        return list;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 9};
        int target = 5;

        Node head = createDLL(arr);

        System.out.println("Brute Force : " + findPair1(head, target));
        System.out.println("Optimal     : " + findPair(head, target));
    }
}