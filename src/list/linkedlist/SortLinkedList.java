package list.linkedlist;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * <p>
 * Example 1:
 * ----------
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * <p>
 * Example 2:
 * ----------
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * <p>
 * Example 3:
 * ----------
 * Input: head = []
 * Output: []
 */
public class SortLinkedList {

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                p.next = l1;
                l1 = l1.next;
            }
            else if (l2.data < l1.data) {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummyHead.next;
    }

    private static ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        // this steps breaks the LinkedList into 2 separate lists
        midPrev.next = null;
        return mid;
    }

    /**
     * Top Down Merge Sort
     * ===================
     * Algorithm
     * ----------
     * - Recursively split the original list into two halves.
     * - The split continues until there is only one node in the linked list (Divide phase).
     * - To split the list into two halves, we find the middle of the linked list using the Fast and Slow pointer
     * approach as mentioned in Find Middle Of Linked List.
     * - Recursively sort each sublist and combine it into a single sorted list. (Merge Phase).
     * <p>
     * This is similar to the problem Merge two sorted linked lists
     */
    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public static void main(String[] args) {
        ListNode node = LinkedListUtil.createUnsorted();
        LinkedListUtil.printFancy(node);
        ListNode sortedHead = sortList(node);
        LinkedListUtil.printFancy(sortedHead);
    }
}
