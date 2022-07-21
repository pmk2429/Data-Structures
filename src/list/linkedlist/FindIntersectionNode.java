package list.linkedlist;

public class FindIntersectionNode {

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        while (ptrA != ptrB) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;

            if (ptrA == ptrB) {
                return ptrA;
            }

            if (ptrA == null) {
                ptrA = headB;
            }

            if (ptrB == null) {
                ptrB = headA;
            }
        }

        return ptrA;
    }

    public static void main(String[] args) {
        ListNode newNode;
        ListNode head1 = new ListNode();
        head1.data = 10;
        ListNode head2 = new ListNode();
        head2.data = 3;
        newNode = new ListNode();
        newNode.data = 6;
        head2.next = newNode;
        newNode = new ListNode();
        newNode.data = 9;
        head2.next.next = newNode;
        newNode = new ListNode();
        newNode.data = 15;
        head1.next = newNode;
        head2.next.next.next = newNode;
        newNode = new ListNode();
        newNode.data = 30;
        head1.next.next = newNode;
        head1.next.next.next = null;
        ListNode intersect_node = null;

        ListNode intersection = getIntersectionNode(head1, head2);
        System.out.println(intersection.data);
    }
}
