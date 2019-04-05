package heap.problems;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * --------
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

  private ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Integer> nodes = new PriorityQueue<>();

    for (ListNode n : lists) {
      ListNode curNode = n;
      while (curNode != null) {
        nodes.add(curNode.val);
        curNode = curNode.next;
      }
    }

    ListNode result = new ListNode(0);
    ListNode resultNode = result;
    while (!nodes.isEmpty()) {
      resultNode.next = new ListNode(nodes.poll());
      resultNode = resultNode.next;
    }

    return result.next;
  }

  public static void main(String[] args) {

  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}