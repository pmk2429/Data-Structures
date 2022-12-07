package list.linkedlist;

/**
 * Count nodes in Circular linked list
 */
public class CountNodesCircularLinkedList {

    /**
     * Inserts node in Circular LinkedList
     */
    private static ListNode push(ListNode head, int data) {
        ListNode first = new ListNode(-1);
        ListNode temp = head;
        first.next = head;
        first.data = data;

        /* If linked list is not null then set the next of last node */
        if (head != null) {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = first;
        }
        else {
            first.next = first; /* Circular list - For the first node */
        }

        head = first;
        return head;
    }

    /* Function to print nodes in a given Circular linked list */
    private static int countNodes(ListNode head) {
        int count = 0;
        if (head == null) {
            return count;
        }
        ListNode curr = head;
        do {
            curr = curr.next;
            count++;
        } while (curr != head);

        return count;
    }

    public static void main(String[] args) {
        ListNode head = null;
        head = push(head, 12);
        head = push(head, 5);
        head = push(head, 56);
        head = push(head, 2);
        head = push(head, 11);

        System.out.printf("%d", countNodes(head));
    }
}
