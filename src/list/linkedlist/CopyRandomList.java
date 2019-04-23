package list.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer that could point to any node in the list or null.
 * Return a deep copy of the list.
 * <p>
 * O(n) runtime, O(n) space – HashMap:
 * <p>
 * It is now natural to lead to a mapping so we can quickly lookup the node to connect. We can easily build the
 * map of indices to cloned nodes. Therefore, we have reduced the complexity to O(1) when connecting the random nodes.
 * This had got us started, although it requires two maps. On closer inspection, it turns out that the two maps
 * could be shortened into one single map. We just need to map the original node to its random node directly.
 */
public class CopyRandomList {

  class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;

    RandomListNode(int label) {
      this.label = label;
      this.next = null;
      this.random = null;
    }
  }

  private RandomListNode copyRandomList(RandomListNode head) {
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode p = head;
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode q = dummy;
    while (p != null) {
      q.next = new RandomListNode(p.label);
      map.put(p, q.next);
      p = p.next;
      q = q.next;
    }

    p = head;
    q = dummy;
    while (p != null) {
      q.next.random = map.get(p.random);
      p = p.next;
      q = q.next;
    }
    return dummy.next;
  }

  private RandomListNode copyRandomListO1Space(RandomListNode head) {
    RandomListNode p = head;
    while (p != null) {
      RandomListNode next = p.next;
      RandomListNode copy = new RandomListNode(p.label);
      p.next = copy;
      copy.next = next;
      p = next;
    }
    p = head;
    while (p != null) {
      p.next.random = (p.random != null) ? p.random.next : null;
      p = p.next.next;
    }
    p = head;
    RandomListNode headCopy = (p != null) ? p.next : null;
    while (p != null) {
      RandomListNode copy = p.next;
      p.next = copy.next;
      p = p.next;
      copy.next = (p != null) ? p.next : null;
    }
    return headCopy;
  }
}

