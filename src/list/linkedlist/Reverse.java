package list.linkedlist;

public class Reverse {
    /**
     * Algorithm:
     * ==========
     * - Start with prev = null, curr = head and next = null
     * - We realign the next pointers of nodes as we process them
     * - `prev` keeps track of the next node to process in the original list
     * - Insert the node pointed to by "curr" at the beginning of the reversed list
     * - Updated `curr` to move to the next node
     */
    ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
