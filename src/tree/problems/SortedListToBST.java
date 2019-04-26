package tree.problems;

import list.linkedlist.ListNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class SortedListToBST {
  private ListNode list;

  private Node sortedListToBST(int start, int end) {
    if (start > end) {
      return null;
    }

    int mid = (start + end) / 2;
    Node leftChild = sortedListToBST(start, mid - 1);
    Node parent = new Node(list.data);
    parent.left = leftChild;
    list = list.next;
    parent.right = sortedListToBST(mid + 1, end);
    return parent;
  }

  private Node sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }

    if (head.next == null) {
      return new Node(head.data);
    }

    int n = 0;
    ListNode p = head;
    while (p != null) {
      p = p.next;
      n++;
    }
    list = head;
    return sortedListToBST(0, n - 1);
  }
}
