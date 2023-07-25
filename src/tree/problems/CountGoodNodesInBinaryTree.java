package tree.problems;

/**
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no
 * nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
 * <p>
 * Example 1:
 * ----------
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * <p>
 * Example 2:
 * ----------
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * <p>
 * Example 3:
 * ----------
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 * <p>
 * Constraints:
 * ------------
 * The number of nodes in the binary tree is in the range [1, 10^5].
 * Each node's value is between [-10^4, 10^4].
 */
public class CountGoodNodesInBinaryTree {

    private static int numGoodNodes = 0;

    private static void dfs(TreeNode node, int maxSoFar) {
        if (node.data >= maxSoFar) {
            numGoodNodes++;
            maxSoFar = node.data;
        }

        if (node.right != null) {
            // traverse left subtree and update `maxSoFar` for next level of left subtree
            dfs(node.right, maxSoFar);
        }

        if (node.left != null) {
            // traverse right subtree and update `maxSoFar` for next level of right subtree
            dfs(node.left, maxSoFar);
        }
    }

    public static int goodNodes(TreeNode root) {
        // we always init `maxSoFar` with Integer.MIN_VALUE so root is always a `good node`.
        dfs(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(goodNodes(root));
    }
}
