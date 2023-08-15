package list.linkedlist;

import static list.linkedlist.LinkedListUtil.printFancy;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before
 * nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example 1:
 * ----------
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * <p>
 * Example 2:
 * ----------
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 * <p>
 * Constraints:
 * -----------
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class PartitionList {

    private static ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null) {
            // If the original list node is lesser than the given x, assign it to the before list.
            if (head.data < x) {
                before.next = head;
                before = before.next;
            }
            else {
                // If the original list node is greater or equal to the given x, assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // move ahead in the original list
            head = head.next;
        }

        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists, combine them to form a single list which would
        // be returned.
        before.next = afterHead.next;

        return beforeHead.next;
    }

    public static void main(String[] args) {
        int[] keys = {1, 4, 3, 2, 5, 2};
        ListNode head = LinkedListUtil.createFromArray(keys);
        printFancy(head);
        ListNode partitionedHead = partition(head, 3);
        printFancy(partitionedHead);
    }
}
