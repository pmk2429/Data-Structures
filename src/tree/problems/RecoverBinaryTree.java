package tree.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * <p>
 * Example 1:
 * ----------
 * Input: [1,3,null,null,2]
 * <p>
 * 1
 * /
 * 3
 * \
 * 2
 * <p>
 * Output: [3,1,null,null,2]
 * <p>
 * 3
 * /
 * 1
 * \
 * 2
 * <p>
 * Example 2:
 * ----------
 * Input: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 * /
 * 2
 * <p>
 * Output: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 * /
 * 3
 * <p>
 * Follow up:
 * ----------
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
public class RecoverBinaryTree {

    public void swap(Node a, Node b) {
        int tmp = a.data;
        a.data = b.data;
        b.data = tmp;
    }

    public void recoverTree(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        Node x = null, y = null, prev = null;

        while (!queue.isEmpty() || root != null) {
            while (root != null) {
                queue.add(root);
                root = root.left;
            }
            root = queue.removeLast();
            if (prev != null && root.data < prev.data) {
                y = root;
                if (x == null) {
                    x = prev;
                }
                else {
                    break;
                }
            }
            prev = root;
            root = root.right;
        }

        swap(x, y);
    }
}
