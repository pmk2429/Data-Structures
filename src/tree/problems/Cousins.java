package tree.problems;

public class Cousins {
    static class NodeInfo {
        Node node;
        int level;
        Node parent;

        NodeInfo(Node node, int level, Node parent) {
            this.node = node;
            this.level = level;
            this.parent = parent;
        }
    }

    // Perform inorder traversal on a given binary tree and update 'x' and 'y'
    public static void updateLevelandParent(Node root, Node parent, int level, NodeInfo x, NodeInfo y) {
        // base case: tree is empty
        if (root == null) {
            return;
        }

        // traverse left subtree
        updateLevelandParent(root.left, root, level + 1, x, y);

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
        updateLevelandParent(root.right, root, level + 1, x, y);
    }

    public static boolean checkCousins(Node root, Node node1, Node node2) {
        // return if the tree is empty
        if (root == null) {
            return false;
        }

        int level = 1;          // level of the root is 1
        Node parent = null;     // parent of the root is null

        NodeInfo x = new NodeInfo(node1, level, parent);
        NodeInfo y = new NodeInfo(node2, level, parent);

        // perform inorder traversal on the array and update 'x' and 'y'
        updateLevelandParent(root, null, 1, x, y);

        // return true if 'x' and 'y' are at the same level, but different parent
        return x.level == y.level && x.parent != y.parent;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        if (checkCousins(root, root.left.right, root.right.left)) {
            System.out.println("Nodes are cousins of each other");
        }
        else {
            System.out.println("Nodes are not cousins of each other");
        }
    }
}
