package list.linkedlist;

public class SwapAdjacentNodes {

    private static ListNode swapAdjacentPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode p = curr.next;
            ListNode q = curr.next.next;
            p.next = q.next;
            curr.next = q;
            curr.next.next = p;
            curr = curr.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createFromArray();
        head = swapAdjacentPairs(head);
        LinkedListUtil.printFancy(head);
    }
}
