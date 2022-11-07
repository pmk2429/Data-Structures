package tree.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 * - Collect all the leaf nodes.
 * - Remove all the leaf nodes.
 * - Repeat until the tree is empty.
 * <p>
 * Example 1:
 * ----------
 * Input: root = [1,2,3,4,5]
 * Output: [[4,5,3],[2],[1]]
 * Explanation:
 * ------------
 * [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level
 * it does not matter the order on which elements are returned.
 * <p>
 * Example 2:
 * ----------
 * Input: root = [1]
 * Output: [[1]]
 */
public class FindAllLeaves {
    private List<List<Integer>> solution;

    private int getHeight(TreeNode root) {
        // return -1 for null nodes
        if (root == null) {
            return -1;
        }

        // first calculate the height of the left and right children
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int currHeight = 1 + Math.max(leftHeight, rightHeight);

        if (solution.size() == currHeight) {
            solution.add(new ArrayList<>());
        }

        solution.get(currHeight).add(root.data);

        return currHeight;
    }

    private List<List<Integer>> findLeaves(TreeNode root) {
        this.solution = new ArrayList<>();
        getHeight(root);
        return this.solution;
    }
}
