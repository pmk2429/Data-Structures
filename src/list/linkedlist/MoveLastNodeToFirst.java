package list.linkedlist;

/**
 * Given a linked list, move its last node to the front.
 * <p>
 * For example, list {1, 2, 3, 4} should be changed to {4, 1, 2, 3}.
 */
public class MoveLastNodeToFirst {

    private static ListNode rearrange(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;

        // move to the second last node
        while (curr.next.next != null) {
            curr = curr.next;
        }

        // transform the list into a circular list
        curr.next.next = head;

        // Fix head
        head = curr.next;

        // break the chain
        curr.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createFromArray();
        LinkedListUtil.printFancy(head);
        head = rearrange(head);
        System.out.println();
        LinkedListUtil.printFancy(head);
    }
}
