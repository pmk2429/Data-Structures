package tree.problems;

public class ValidBST {

    private static boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.data <= low) || (high != null && root.data >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.left, low, root.data) && validate(root.right, root.data, high);
    }

    private static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }


    public static void main(String[] args) {
        TreeNode node = TreeNode.createBSTEven();
        System.out.println("Is BST valid -> " + isValidBST(node));
    }
}
