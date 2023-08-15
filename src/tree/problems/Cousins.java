package tree.problems;

public class Cousins {
    private static class NodeInfo {
        TreeNode node;
        TreeNode parent;
        int level;

        NodeInfo(TreeNode node, int level, TreeNode parent) {
            this.node = node;
            this.level = level;
            this.parent = parent;
        }
    }

    // Perform inorder traversal on a given binary tree and update 'x' and 'y'
    private static void updateLevelAndParent(TreeNode root, TreeNode parent, int level, NodeInfo x, NodeInfo y) {
        // base case: tree is empty
        if (root == null) {
            return;
        }

        // traverse left subtree
        updateLevelAndParent(root.left, root, level + 1, x, y);

        // if the first element is found, save its level and parent node
        if (root == x.node) {
            x.level = level;
            x.parent = parent;
        }

        // if the second element is found, save its level and parent node
        if (root == y.node) {
            y.level = level;
            y.parent = parent;
        }

        // traverse right subtree
        updateLevelAndParent(root.right, root, level + 1, x, y);
    }

    private static boolean checkCousins(TreeNode root, TreeNode node1, TreeNode node2) {
        // return if the tree is empty
        if (root == null) {
            return false;
        }

        int level = 1; // level of the root is 1

        NodeInfo x = new NodeInfo(node1, level, null);
        NodeInfo y = new NodeInfo(node2, level, null);

        // perform inorder traversal on the array and update `level` and `parent` info for each Node.
        updateLevelAndParent(root, null, 1, x, y);

        // return true if 'x' and 'y' are at the same level, but different parent
        return x.level == y.level && x.parent != y.parent;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        if (checkCousins(root, root.left.right, root.right.left)) {
            System.out.println("Nodes are cousins of each other");
        }
        else {
            System.out.println("Nodes are not cousins of each other");
        }
    }
}
