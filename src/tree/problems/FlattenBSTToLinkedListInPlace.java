package tree.problems;

/**
 * Flatten BST to LinkedList
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example, given the following tree:
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class FlattenBSTToLinkedListInPlace {

    private static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode node = root;

        while (node != null) {
            // If the node has a left child
            if (node.left != null) {
                // Find the rightmost node
                TreeNode rightRoot = node.left;
                while (rightRoot.right != null) {
                    rightRoot = rightRoot.right;
                }

                // rewire the connections
                rightRoot.right = node.right;
                node.right = node.left;
                node.left = null;
            }

            // move on to the right side of the tree
            node = node.right;
        }
    }

    public static void main(String[] args) {
        TreeNode bst = TreeNode.createBSTEven();
        flatten(bst);
    }
}
