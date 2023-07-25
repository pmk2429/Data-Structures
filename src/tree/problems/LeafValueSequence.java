package tree.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * <p>
 * Example 1:
 * ----------
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 */
public class LeafValueSequence {
    private static void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leafValues.add(node.data);
            }
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public static void main(String[] args) {

    }
}
