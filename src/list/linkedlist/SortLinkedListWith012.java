package list.linkedlist;

import static list.linkedlist.LinkedListUtil.printFancy;

/**
 * Sort linked list containing 0’s, 1’s, and 2’s in a single traversal
 * Given a linked list containing 0's, 1's, and 2's, sort the linked list by doing a single traversal of it.
 * <p>
 * For example:
 * ------------
 * Input:  0 —> 1 —> 2 —> 2 —> 1 —> 0 —> 0 —> 2 —> 0 —> 1 —> 1 —> 0 —> NULL
 * Output: 0 —> 0 —> 0 —> 0 —> 0 —> 1 —> 1 —> 1 —> 1 —> 2 —> 2 —> 2 —> NULL
 */
public class SortLinkedListWith012 {

    private static ListNode sortList(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode zero = new ListNode(0);
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);

        ListNode n0 = zero;
        ListNode n1 = first;
        ListNode n2 = second;

        ListNode curr = head;

        while (curr != null) {
            if (curr.data == 0) {
                n0.next = curr;
                n0 = n0.next;
            }
            else if (curr.data == 1) {
                n1.next = curr;
                n1 = n1.next;
            }
            else if (curr.data == 2) {
                n2.next = curr;
                n2 = n2.next;
            }
            curr = curr.next;
        }

        n0.next = (first.next != null) ? first.next : second.next;
        n1.next = second.next;
        n2.next = null;

        return zero.next;
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 0, 0, 1, 2, 1, 2, 1};

        ListNode head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new ListNode(keys[i], head);
        }

        head = sortList(head);
        printFancy(head);
    }

}
