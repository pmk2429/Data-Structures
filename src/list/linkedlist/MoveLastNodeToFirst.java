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

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " —> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // input keys
        int[] keys = {1, 2, 3, 4, 5, 8, 24, 9, 15};

        ListNode head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new ListNode(keys[i], head);
        }
        printList(head);
        head = rearrange(head);
        System.out.println();
        printList(head);
    }
}
