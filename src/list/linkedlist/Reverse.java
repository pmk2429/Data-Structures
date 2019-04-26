package list.linkedlist;

public class Reverse {
  ListNode reverse(ListNode node) {
    ListNode prev = null;
    ListNode current = node;
    ListNode next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }
}
