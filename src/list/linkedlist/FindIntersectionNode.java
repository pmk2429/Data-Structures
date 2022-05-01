package list.linkedlist;

public class FindIntersectionNode {

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            // for the end of first iteration, we just reset the pointer to the head of another LinkedList
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        ListNode head11 = new ListNode(1);
        ListNode head12 = new ListNode(8);
        ListNode head13 = new ListNode(4);
        ListNode head14 = new ListNode(5);

        head1.next = head11;
        head11.next = head12;
        head12.next = head13;
        head13.next = head14;

        // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]

        ListNode head2 = new ListNode(5);
        ListNode head21 = new ListNode(6);
        ListNode head22 = new ListNode(1);
        ListNode head23 = new ListNode(8);
        ListNode head24 = new ListNode(4);
        ListNode head25 = new ListNode(5);

        head2.next = head21;
        head21.next = head22;
        head22.next = head23;
        head23.next = head24;
        head24.next = head25;

        ListNode intersection = getIntersectionNode(head1, head2);
        System.out.println(intersection);
    }
}
