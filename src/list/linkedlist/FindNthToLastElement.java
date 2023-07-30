package list.linkedlist;

import java.util.LinkedList;

/**
 * FindElement class implements an algorithm to find nth to last element of a
 * singly linked list. For example in a LinkedList from 1-10, 3rd element from
 * last should return 8.
 *
 * @author Pavitra
 */

public class FindNthToLastElement {
    private static int removeNthElementFromLast(LinkedList<Integer> list, int position) {
        int nthToLastIndex = list.size() - position;
        return list.get(nthToLastIndex);
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

    private static ListNode removeNthElementFromLast(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // Advances fast pointer so that the gap between fast and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        // Move fast to the end, maintaining the gap
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        int position = 4;
        int desiredElement = removeNthElementFromLast(list, position);
        System.out.println("List: " + list);
        System.out.println("'" + position + "' Element to last in List is: " + desiredElement);

        ListNode head = LinkedListUtil.createFromArray();
        LinkedListUtil.printFancy(head);
        head = removeNthElementFromLast(head, 3);
        LinkedListUtil.printFancy(head);
    }
}
