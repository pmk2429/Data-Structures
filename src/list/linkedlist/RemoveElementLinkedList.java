package list.linkedlist;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that
 * has Node.val == val, and return the new head.
 * <p>
 * Example 1:
 * =========
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * <p>
 * Example 2:
 * ==========
 * Input: head = [], val = 1
 * Output: []
 * <p>
 * Example 3:
 * ==========
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 */
public class RemoveElementLinkedList {

    /**
     * Iterative solution using just one pointer - `curr`
     */
    public ListNode removeElement(ListNode head, int data) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.data == data) {
                cur.next = cur.next.next;
                // Here cannot move cur to cur.next as we need to validate the next node.
            }
            else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public ListNode removeElementsUsingPrevious(ListNode head, int data) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;

        while (cur != null) {
            if (cur.data == data) {
                prev.next = cur.next;
            }
            else {
                prev = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    /**
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     * <p>
     * Example 1:
     * ==========
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     * <p>
     * Example 2:
     * ==========
     * Input: head = [1], n = 1
     * Output: []
     * <p>
     * Example 3:
     * ==========
     * Input: head = [1,2], n = 1
     * Output: [1]
     * <p>
     * Constraints:
     * ============
     * The number of nodes in the list is sz.
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        /**
         * If fast == null at the end of the for loop, then it means that the Nth node from the end is
         * actually the first node.
         * The while loop is an attempt to move slow to the node _before_ the node to be removed,
         * which obviously can't happen if the node to be removed is the first node, as there is no node before it.
         * So if (fast == null), then we should just return the list with the first node removed, or head -> next.
         */
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
