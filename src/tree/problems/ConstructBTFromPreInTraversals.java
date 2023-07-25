package tree.problems;

/**
 * Say we have 2 arrays, PRE and IN.
 * Preorder traversing implies that PRE[0] is the root node.
 * Then we can find this PRE[0] in IN, say it's IN[5].
 * Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
 * Recursively doing this on subarrays, we can build a tree out of it.
 */
public class ConstructBTFromPreInTraversals {
    public TreeNode helper(int[] preOrder, int[] inorder, int preIndex, int inStart, int inEnd) {
        if (preIndex > preOrder.length - 1 || inStart > inEnd) {
            return null;
        }

        // PRE[0] is always root
        TreeNode root = new TreeNode(preOrder[preIndex]);
        preIndex++;

        int inIndex; // Index of current root in inOrder
        for (inIndex = inStart; inIndex <= inEnd; inIndex++) {
            if (inorder[inIndex] == root.data) {
                // find the root in inOrder
                break;
            }
        }

        if (inIndex <= inEnd) {
            root.left = helper(preOrder, inorder, preIndex, inStart, inIndex - 1);
            root.right = helper(preOrder, inorder, preIndex + inIndex - inStart, inIndex + 1, inEnd);
        }

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }
}
