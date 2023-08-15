package tree.problems;

public class CompareTree {
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.data != q.data) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = TreeNode.createBT();
        TreeNode q = TreeNode.createUnusualTree();
        System.out.println(isSameTree(p, q));
    }
}
