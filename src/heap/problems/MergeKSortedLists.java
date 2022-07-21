package heap.problems;

import list.linkedlist.ListNode;

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
        ListNode dummyHead = new ListNode(0);

        if (lists == null || lists.length == 0) {
            return dummyHead;
        }

        PriorityQueue<Integer> nodesQueue = new PriorityQueue<>();

        for (ListNode n : lists) {
            ListNode curNode = n;
            while (curNode != null) {
                nodesQueue.add(curNode.data);
                curNode = curNode.next;
            }
        }

        ListNode result = dummyHead;
        while (!nodesQueue.isEmpty()) {
            result.next = new ListNode(nodesQueue.poll());
            result = result.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
