package list.linkedlist;

public class InsertInCyclicalList {

    private static ListNode insert(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        // assuming List is sorted
        while (curr.data > val) {
            curr = curr.next;
        }

        ListNode nodeToInsert = new ListNode(val);
        nodeToInsert.next = curr.next;
        curr.next = nodeToInsert;

        return head;
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n1 = new ListNode(1);
        n3.next = n4;
        n4.next = n1;
        n1.next = n3;

        ListNode head = insert(n3, 2);

        System.out.println(head.data);
    }
}
