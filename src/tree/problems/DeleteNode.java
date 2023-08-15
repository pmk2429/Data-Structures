package tree.problems;

public class DeleteNode {

    private static int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.data;
    }

    /*
    One step left and then always right
    */
    private static int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.data;
    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // delete from the right subtree
        if (key > root.data) {
            root.right = deleteNode(root.right, key);
        }
        else if (key < root.data) { // delete from the left subtree
            root.left = deleteNode(root.left, key);
        }
        else { // delete the current node
            // the node is a leaf
            if (root.left == null && root.right == null) {
                root = null;
            }
            else if (root.right != null) { // the node is not a leaf and has a right child
                root.data = successor(root);
                root.right = deleteNode(root.right, root.data);
            }
            else { // the node is not a leaf, has no right child, and has a left child
                root.data = predecessor(root);
                root.left = deleteNode(root.left, root.data);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createUnusualTree();
        root = deleteNode(root, 3);
        TreeNode.printTree(root);
    }

}
