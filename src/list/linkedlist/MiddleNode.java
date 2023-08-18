package list.linkedlist;

public class MiddleNode {
    private static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.create();
        LinkedListUtil.printFancy(head);
        System.out.println(getMiddleNode(head));
    }
}
