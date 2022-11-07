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

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " —> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4, 5, 8, 24, 9, 15};
        ListNode head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new ListNode(keys[i], head);
        }
        printList(head);
        System.out.println();
        head = swapAdjacentPairs(head);
        printList(head);
    }
}
