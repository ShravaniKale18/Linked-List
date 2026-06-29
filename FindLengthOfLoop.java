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

    /**
     * Approach:
     * 1. Use Floyd's Cycle Detection Algorithm (Tortoise and Hare) to detect
     *    whether a cycle exists in the linked list.
     * 2. Initialize two pointers, slow and fast, at the head.
     * 3. Move slow by one node and fast by two nodes.
     * 4. If both pointers meet, a cycle is present.
     * 5. From the meeting point, traverse the cycle using a temporary pointer
     *    until it reaches the same node again, counting each visited node.
     * 6. The count represents the length of the loop.
     * 7. If no cycle is found, return 0.
     *
     * Time Complexity: O(N)
     * - Floyd's algorithm detects the cycle in O(N) time.
     * - Counting the loop length takes O(L), where L is the loop length.
     * - Since L ≤ N, the overall complexity is O(N).
     *
     * Space Complexity: O(1)
     * - Only a few pointer variables are used.
     */

    static int lengthOfLoop(Node head) {
        int length = 0;

        Node slow = head;
        Node fast = head;

        // Detect the cycle using Floyd's Algorithm
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {

                Node temp = slow;

                // Count the number of nodes in the cycle
                do {
                    length++;
                    temp = temp.next;
                } while (temp != slow);

                return length;
            }
        }

        // No cycle found
        return 0;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        Node head = createLL(arr);

        // Create a cycle: 5 -> 2
        head.next.next.next.next.next = head.next;

        int ans = lengthOfLoop(head);

        System.out.println(ans);
    }
}