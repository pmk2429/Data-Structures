package list.linkedlist;

/**
 * Create new linked list from two given linked list with greater element at each node
 * Given two linked list of the same size, the task is to create a new linked list using those linked lists.
 * The condition is that the greater node among both linked list will be added to the new liked list.
 * <p>
 * Examples:
 * ---------
 * Input:  list1 = 5->2->3->8
 * list2 = 1->7->4->5
 * Output:  New list = 5->7->4->8
 * <p>
 * Input: list1 = 2->8->9->3
 * list2 = 5->3->6->4
 * Output:  New list = 5->8->9->4
 */
public class MaxElementMerge {

  private static ListNode maxMerge(ListNode head1, ListNode head2) {
    ListNode ptr1 = head1;
    ListNode ptr2 = head2;
    ListNode root = null;
    ListNode temp;
    ListNode ptr;

    while (ptr1 != null && ptr2 != null) {
      temp = new ListNode(-1);

      if (ptr1.data < ptr2.data) {
        temp.data = ptr2.data;
      } else {
        temp.data = ptr1.data;
      }

      if (root == null) {
        root = temp;
      } else {
        ptr = root;
        while (ptr.next != null) {
          ptr = ptr.next;
        }
        ptr.next = temp;
      }
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }
    return root;
  }

  public static void main(String[] args) {

  }
}
