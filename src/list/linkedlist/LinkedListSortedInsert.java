package list.linkedlist;

public class LinkedListSortedInsert {

    private static ListNode sortedInsert(ListNode head, ListNode newNode) {
        if (head == null) {
            return null;
        }

        if (newNode.data <= head.data) {
            newNode.next = head;
            head = newNode;
        }
        else {
            ListNode current = head;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
