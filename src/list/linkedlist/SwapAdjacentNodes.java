package list.linkedlist;

public class SwapAdjacentNodes {

  private static ListNode swapAdjacentPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    // used for traversal
    ListNode p = head;
    ListNode prev = dummy;
    while (head != null) {
      ListNode q = p.next;
      ListNode r = p.next.next;
      q.next = p;
      p.next = r;
      prev = p;
      p = r;
    }
    return dummy.next;
  }

  public static void main(String[] args) {

  }
}
