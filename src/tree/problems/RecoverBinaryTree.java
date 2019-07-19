package tree.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Example 1:
 * ----------
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * Example 2:
 * ----------
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 *
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
    Deque<Node> stack = new ArrayDeque();
    Node x = null, y = null, pred = null;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();
      if (pred != null && root.data < pred.data) {
        y = root;
        if (x == null) x = pred;
        else break;
      }
      pred = root;
      root = root.right;
    }

    swap(x, y);
  }
}
