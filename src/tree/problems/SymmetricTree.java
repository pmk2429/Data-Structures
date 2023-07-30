package tree.problems;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * https://leetcode.com/problems/symmetric-tree/?envType=study-plan-v2&envId=top-interview-150
 */
public class SymmetricTree {

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.data == t2.data) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    private static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.createSymmetric();
        System.out.println(isSymmetric(t1));
    }
}
