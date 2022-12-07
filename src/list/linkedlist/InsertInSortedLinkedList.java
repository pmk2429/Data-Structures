package list.linkedlist;

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
            ListNode current = head;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        return head;
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
        // input keys
        int[] keys = {1, 2, 3, 4, 5, 7, 8};

        ListNode head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new ListNode(keys[i], head);
        }
        printList(head);
        ListNode newNode = new ListNode(6);
        head = sortedInsert(head, newNode);
        System.out.println();
        printList(head);
    }
}
