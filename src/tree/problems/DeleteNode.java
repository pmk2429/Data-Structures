package tree.problems;

public class DeleteNode {

    /**
     * One step right and then always left
     */
    public static int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.data;
    }

    /**
     * One step left and then always right
     */
    public static int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.data;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key > root.data) {
            root.right = deleteNode(root.right, key);
        }
        else if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }
        else {
            if (root.left == null && root.right == null) {
                root = null;
            }
            else if (root.right != null) {
                root.data = successor(root);
                root.right = deleteNode(root.right, root.data);
            }
            else {
                root.data = predecessor(root);
                root.left = deleteNode(root.left, root.data);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createUnusualTree();
        TreeNode deletedNode = deleteNode(root, 3);
        TreeNode.printLevelOrder(deletedNode);
    }

}
