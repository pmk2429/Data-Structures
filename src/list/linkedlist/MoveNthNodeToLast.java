package list.linkedlist;

public class MoveNthNodeToLast {

    private static ListNode rearrangeNthToLast(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        // ptr represents node before the nth Node to remove
        ListNode ptr = head;

        for (int i = 0; i < n - 2; i++) {
            ptr = ptr.next;
        }

        // move `curr` to tail end of the list
        ListNode curr = ptr;
        while (curr.next != null) {
            curr = curr.next;
        }

        // rewiring
        ListNode nthNode = ptr.next;
        ptr.next = ptr.next.next;
        nthNode.next = null;
        curr.next = nthNode;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createFromArray();
        LinkedListUtil.printFancy(head);
        ListNode nthRearrange = rearrangeNthToLast(head, 3);
        LinkedListUtil.printFancy(nthRearrange);
    }
}
