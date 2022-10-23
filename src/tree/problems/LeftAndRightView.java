package tree.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Uses Level Order implementation to find the Nodes at start and end of current level.
 * Node at start of current level indicates left view while nodes at end of the current level indicates right view.
 */
public class LeftAndRightView {

    private static void leftView(Node root) {
        if (root == null) {
            return;
        }

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node curr;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;

            while (i++ < size) {
                curr = queue.poll();

                // if `i` is at the start of current level
                if (i == 1) {
                    System.out.print(curr.data + " ");
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }

    private static void rightView(Node root) {
        if (root == null) {
            return;
        }

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        Node curr;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;

            while (i++ < size) {
                curr = queue.poll();

                // if `i` is at the end of current level
                if (i == size) {
                    System.out.print(curr.data + " ");
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        leftView(root);
        rightView(root);
    }
}
