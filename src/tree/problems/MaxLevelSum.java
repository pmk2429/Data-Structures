package tree.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 * <p>
 * Example 1:
 * ----------
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * <p>
 * Example 2:
 * ----------
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 * <p>
 * Constraints:
 * ----------
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 */
public class MaxLevelSum {

    /**
     * Get sum of Level Order Traversal
     */
    private static int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int ans = 0, level = 0;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            level++;
            int sumAtCurrentLevel = 0;
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                sumAtCurrentLevel += node.data;

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            if (sumAtCurrentLevel > maxSum) {
                maxSum = sumAtCurrentLevel;
                ans = level;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        System.out.println(maxLevelSum(root));
    }

}
