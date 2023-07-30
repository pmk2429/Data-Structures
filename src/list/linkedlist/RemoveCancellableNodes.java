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
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();

        while (curr != null) {
            // if it's negative then pop and cancel nodes
            if (curr.data < 0) {
                int sum = curr.data;
                while (!stack.isEmpty()) {
                    ListNode temp = stack.pop();
                    sum += temp.data;
                    if (sum == 0) {
                        curr = stack.peek();
                        break;
                    }
                }
            }
            else { // if value is positive, push it on to the stack
                stack.push(curr);
            }
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {6, -6, 8, 4, -12, 9, 8, -8};
        ListNode head = LinkedListUtil.createFromArray(arr);
        LinkedListUtil.printFancy(head);
        ListNode updatedHead = removeCancellableNodes(head);
        LinkedListUtil.printFancy(updatedHead);
    }
}
