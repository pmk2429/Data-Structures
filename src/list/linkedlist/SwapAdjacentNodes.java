package list.linkedlist;

public class SwapAdjacentNodes {

    private static ListNode swapAdjacentPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode p = current.next;
            ListNode q = current.next.next;
            p.next = q.next;
            current.next = q;
            current.next.next = p;
            current = current.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
