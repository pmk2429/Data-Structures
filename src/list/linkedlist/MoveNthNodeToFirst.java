package list.linkedlist;

public class MoveNthNodeToFirst {

    private static ListNode rearrangeNthToFirst(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode curr = head;

        for (int i = 0; i < n - 2; i++) {
            curr = curr.next;
        }

        ListNode nthNode = curr.next;
        // break the link
        curr.next = curr.next.next;
        nthNode.next = head;
        head = nthNode;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createFromArray();
        LinkedListUtil.printFancy(head);
        ListNode nthRearrange = rearrangeNthToFirst(head, 3);
        LinkedListUtil.printFancy(nthRearrange);
    }
}
