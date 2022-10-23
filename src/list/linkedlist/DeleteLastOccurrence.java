package list.linkedlist;

/**
 * Created Linked list: 1 --> 2 --> 3 --> 4 --> 5 --> 4 --> 4 --> NULL
 * List after deletion of 4: 1 --> 2 --> 3 --> 4 --> 5 --> 4 --> NULL
 * <p>
 * Example 1:
 * ----------
 * Input:   1->2->3->5->2->10, key = 2
 * Output:  1->2->3->5->10
 */
public class DeleteLastOccurrence {

    private static void deleteLast(ListNode head, int keyToRemove) {
        ListNode curr = head, ptr = null;
        while (curr != null) {
            // If found key, update 
            if (curr.data == keyToRemove) {
                ptr = curr;
            }
            curr = curr.next;
        }

        // If the last occurrence is the last node 
        if (ptr != null && ptr.next == null) {
            curr = head;
            while (curr.next != ptr) {
                curr = curr.next;
            }
            curr.next = null;
        }

        // If it is not the last node 
        if (ptr != null && ptr.next != null) {
            ptr.data = ptr.next.data;
            ptr.next = ptr.next.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createWithDuplicates();
        System.out.print("Created Linked list: \n");
        LinkedListUtil.display(head);
        deleteLast(head, 4);
        System.out.print("List after deletion of last [4]: \n");
        LinkedListUtil.display(head);
    }
}
