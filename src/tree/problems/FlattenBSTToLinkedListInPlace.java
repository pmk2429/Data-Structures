package tree.problems;

/**
 * Flatten BST to LinkedList
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBSTToLinkedListInPlace {

  // Definition for a binary tree node.
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private TreeNode prev = null;

  private void flatten(TreeNode root) {
    if (root == null)
      return;
    flatten(root.right);
    flatten(root.left);
    // reverse
    root.right = prev;
    root.left = null;
    prev = root;
  }
}
