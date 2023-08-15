package tree.problems;

public class BinaryTreeIndexExists {

    /**
     * Binary String represents the path from root to the node, where '1' means going right and '0' means going left.
     * For example
     * 4 = "100", starting from index 1, we go from root = 1, going left --> 2, going left --> 4
     * 7 = "111", starting from index 1, we go from root = 1, going right --> 3, going right --> 7.
     */
    public static boolean indexExists(TreeNode root, int index) {
        if (root == null || index < 0) {
            return false;
        }

        // Convert the index to binary representation
        String binaryIndex = Integer.toBinaryString(index + 1);

        TreeNode current = root;
        for (int i = 1; i < binaryIndex.length(); i++) {
            if (binaryIndex.charAt(i) == '0') {
                current = current.left;
            }
            else {
                current = current.right;
            }

            if (current == null) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int indexToCheck = 42;
        boolean exists = indexExists(root, indexToCheck);

        if (exists) {
            System.out.println("Index `" + indexToCheck + "` ~~exists~~ in the binary tree.");
        }
        else {
            System.out.println("Index `" + indexToCheck + "` ~~does not exist~~ in the binary tree.");
        }
    }
}
