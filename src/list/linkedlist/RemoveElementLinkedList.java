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
        ListNode prev = dummy;
        ListNode cur = head;

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
}
