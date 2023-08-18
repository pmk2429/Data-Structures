package tree.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Find the next node at the same level as the given node in a binary tree
 */
public class FindNextNodeAtSameLevel {

    /**
     * A simple solution is to perform a level order traversal on the tree.
     * The idea is to modify the level order traversal to maintain the level number of each node, and if
     * the given node is found, we return its immediate right node, present at the same level.
     */
    private static TreeNode findNextNodeAtSameLevel(TreeNode root, TreeNode node) {
        // return null if a tree is empty
        if (root == null) {
            return null;
        }

        // create an empty queue and enqueue the root node
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        TreeNode curr;

        // loop till queue is empty
        while (!queue.isEmpty()) {
            // calculate the total number of nodes at the current level
            int size = queue.size();

            // process every node of the current level and enqueue their non-empty left and right child
            while (size-- > 0) {
                curr = queue.poll();
                // if the desired node is found, return its next right node
                if (curr == node) {
                    // if the next right node doesn't exist, return null
                    if (size == 0) {
                        return null;
                    }
                    return queue.peek();
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        /* Construct the following tree
                  1
                /  \
               /    \
              2      3
             / \      \
            4   5      6
                      / \
                     7   8
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        TreeNode right = findNextNodeAtSameLevel(root, root.left.right);
        if (right != null) {
            System.out.print("Right node is " + right.data);
        }
        else {
            System.out.print("Right node doesn't exist");
        }
    }
}
