package list.linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Solution:
 * O(nk^2) runtime, O(1) space – Brute force:
 */
public class MergeKSortedLinkedLists {

  private static final Comparator<ListNode> nodeComparator = Comparator.comparingInt(o -> o.data);

  /**
   * O(nk log k) runtime, O(k) space – Min Heap:
   * <p>
   * We could use a min heap of size k. The heap is first initialized with the smallest element from each list.
   * Then as we extract the nodes out from the heap, we must remember to insert its next node into the heap.
   * As each insert operation into the heap costs log(k) and there are a total of nk elements, the total runtime
   * complexity is O(nk log k).
   * Ignoring the extra space that is used to store the output list, we only use extra space of O(k) due to the heap.
   *
   * @param nodes
   * @return
   */
  private ListNode mergeKLists(List<ListNode> nodes) {
    if (nodes.isEmpty()) {
      return null;
    }

    Queue<ListNode> nodeQueue = new PriorityQueue<>(nodes.size(), nodeComparator);

    for (ListNode node : nodes) {
      if (node != null) {
        nodeQueue.offer(node);
      }
    }

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (!nodeQueue.isEmpty()) {
      ListNode node = nodeQueue.poll();
      curr.next = node;
      curr = curr.next;
      if (node.next != null) {
        nodeQueue.add(node.next);
      }
    }
    return dummy.next;
  }

  private static ListNode merge2Lists(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = dummyHead;

    while (l1 != null && l2 != null) {
      if (l1.data < l2.data) {
        p.next = l1;
        l1 = l1.next;
      } else if (l2.data < l1.data) {
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

  private ListNode mergeKListsO1(List<ListNode> lists) {
    if (lists.isEmpty()) return null;
    int end = lists.size() - 1;
    while (end > 0) {
      int begin = 0;
      while (begin < end) {
        lists.set(begin, merge2Lists(lists.get(begin), lists.get(end)));
        begin++;
        end--;
      }
    }
    return lists.get(0);
  }
}
