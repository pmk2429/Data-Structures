package list.linkedlist;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p>
 * Example 1:
 * ==========
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * <p>
 * Example 2:
 * ==========
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class RotateLinkedList {
    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int size = 1; // since we are already at head node
        ListNode fast = head;
        ListNode slow = head;

        // move the fast pointer to one Node before end of list
        while (fast.next != null) {
            size++;
            fast = fast.next;
        }

        /**
         * Since n may be a large number compared to the length of list.
         * So we need to know the length of linked list. After that, move the list after the (l - n % l)th node
         * to the front to finish the rotation.
         * Ex: {1,2,3} k=2 Move the list after the 1st node to the front
         * Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front.
         */
        // i>1 because we need to put slow.next at the start.
        int rotateFactor = size - k % size;
        for (int i = rotateFactor; i > 1; i--) {
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createSmall();
        int k = 2;
        ListNode rotatedHead = rotateRight(head, k);
        LinkedListUtil.display(rotatedHead);
    }
}
