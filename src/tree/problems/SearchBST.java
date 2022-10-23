package tree.problems;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.data != val) {
            root = val < root.data ? root.left : root.right;
        }
        return root;
    }
}
