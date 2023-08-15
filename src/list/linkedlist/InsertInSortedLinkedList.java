package list.linkedlist;

import static list.linkedlist.LinkedListUtil.printFancy;

public class InsertInSortedLinkedList {

    private static ListNode sortedInsert(ListNode head, ListNode newNode) {
        if (head == null) {
            return null;
        }

        if (newNode.data <= head.data) {
            newNode.next = head;
            head = newNode;
        }
        else {
            ListNode curr = head;
            while (curr.next != null && curr.next.data < newNode.data) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4, 5, 7, 8};
        ListNode head = LinkedListUtil.createFromArray(keys);
        printFancy(head);
        ListNode newNode = new ListNode(6);
        head = sortedInsert(head, newNode);
        printFancy(head);
    }
}
