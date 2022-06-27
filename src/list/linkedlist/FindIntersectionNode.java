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
        ListNode headA = new ListNode(4);
        ListNode head11 = new ListNode(1);
        ListNode head12 = new ListNode(8);
        ListNode head13 = new ListNode(4);
        ListNode head14 = new ListNode(5);

        headA.next = head11;
        head11.next = head12;
        head12.next = head13;
        head13.next = head14;

        // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]

        ListNode headB = new ListNode(5);
        ListNode head21 = new ListNode(6);
        ListNode head22 = new ListNode(1);
        ListNode head23 = new ListNode(8);
        ListNode head24 = new ListNode(4);
        ListNode head25 = new ListNode(5);

        headB.next = head21;
        head21.next = head22;
        head22.next = head23;
        head23.next = head24;
        head24.next = head25;

        ListNode intersection = getIntersectionNode(headA, headB);
        System.out.println(intersection);
    }
}
