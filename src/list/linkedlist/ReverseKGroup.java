package list.linkedlist;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not
 * a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * <p>
 * Example 1:
 * ----------
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * <p>
 * Example 2:
 * ----------
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * <p>
 * Constraints:
 * ------------
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 */
public class ReverseKGroup {

    /**
     * Reverse k nodes of the given linked list. This function assumes that the list contains atleast k nodes.
     */
    private static ListNode reverseLinkedList(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (k > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            k--;
        }
        head = prev;
        return head;
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;

        // First, see if there are atleast k nodes left in the linked list.
        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }

        // If we have k nodes, then we reverse them
        if (count == k) {
            // Reverse the first k nodes of the list and get the reversed list's head.
            ListNode reversedHead = reverseLinkedList(head, k);

            // Now recurse on the remaining linked list. Since
            // our recursion returns the head of the overall processed
            // list, we use that and the "original" head of the "k" nodes
            // to re-wire the connections.
            head.next = reverseKGroup(curr, k);
            return reversedHead;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createSmall();
        LinkedListUtil.printFancy(head);
        ListNode newHead = reverseKGroup(head, 2);
        LinkedListUtil.printFancy(newHead);
    }

}
