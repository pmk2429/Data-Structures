package list.linkedlist;

import java.util.Stack;

/**
 * Given some resources in the form of linked list you have to canceled out all the resources whose sum up to 0
 * (Zero) and return the remaining list.
 * <p>
 * E.g -> 6 -6 8 4 -12 9 8 -8
 * the above example lists which gets canceled :
 * 6 -6
 * 8 4 -12
 * 8 -8
 * o/p : 9
 * <p>
 * case 3 : 4 6 -10 8 9 10 -19 10 -18 20 25
 * O/P : 20 25
 */
public class RemoveCancellableNodes {

    private static ListNode removeCancellableNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        Stack<ListNode> stack = new Stack<>();

        while (node != null) {
            if (node.data < 0) {
                int sum = node.data;
                while (!stack.isEmpty()) {
                    ListNode temp = stack.pop();
                    sum += temp.data;
                    if (sum == 0) {
                        node = stack.peek();
                        break;
                    }
                }
            }
            else {
                stack.push(node);
            }
            node = node.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
