package list.linkedlist;

public class MoveNthNodeToLast {

    private static ListNode rearrangeNthToLast(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode curr = head;


        return head;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createFromArray();
        LinkedListUtil.printFancy(head);
        ListNode nthRearrange = rearrangeNthToLast(head, 3);
        LinkedListUtil.printFancy(nthRearrange);
    }
}
