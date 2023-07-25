package list.linkedlist;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 * <p>
 * Example 1:
 * ==========
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * <p>
 * Example 2:
 * ==========
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * <p>
 * Constraints:
 * ============
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while (curr != null) {
            // here we check `curr.next` so that the condition `curr.next.data` doesn't throw NPE
            while (curr.next != null && curr.data == curr.next.data) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                pre = pre.next;
            }
            else {
                // here bypass all the nodes that are equal; duplicates
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
