package tree.problems;

import javax.swing.tree.TreeCellRenderer;

/**
 * Question:
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.
 * For example, given the below binary tree,
 * <p>
 * 1
 * /\
 * 2  4
 * /\
 * 2  3
 * The highlighted path(1-4-2-3) yields the maximum sum 10.
 * <p>
 * Example Questions Candidate Might Ask:
 * Q: What if the tree is empty?
 * A: Assume the tree is non-empty.
 * Q: How about a tree that contains only a single node?
 * A: Then the maximum path sum starts and ends at the same node.
 * Difficulty: Hard, Frequency: Medium
 * Q: What if every node contains negative value?
 * A: Then you should return the single node value that is the least negative.
 * Q: Does the maximum path have to go through the root node?
 * A: Not necessarily. For example, the below tree yield 6 as the maximum path sum and does not go through root.
 * -5
 * /\ 23
 * /\ -1 4
 * Hint:
 * Anytime when you found that doing top down approach uses a lot of repeated calculation, bottom up approach usually
 * is able to be more efficient.
 */
public class MaximumPathSum {
    private static int maxSum;

    /**
     * At any given node in the binary tree, the max sum of a Node can be represented using one of following
     * 1 - Max(left subtree) + node
     * 2 - Max(right subtree) + node
     * 3 - Max(left subtree) + Max(Right subtree) + node
     * 4 - Node
     */
    private static int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = findMax(root.left);
        int rightSum = findMax(root.right);
        int sum = root.data + leftSum + rightSum;
        maxSum = Math.max(maxSum, sum);
        int res = root.data + Math.max(leftSum, rightSum);
        return Math.max(res, 0);
    }

    private static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBTComplex();
        System.out.println(maxPathSum(root));
    }
}
