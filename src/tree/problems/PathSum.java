package tree.problems;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 * ============
 * Example 1:
 * <p>
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * ============
 * Example 2:
 * <p>
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * ============
 * Example 3:
 * <p>
 * Input: root = [1,2], targetSum = 0
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) return sum == root.data;

        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }
}
