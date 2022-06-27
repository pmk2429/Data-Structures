package tree.problems;

/**
 * A binary search tree (BST) is a node based binary tree data structure which has the following properties.
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class CheckBST {
    private static Node root;

    private static boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node node, int min, int max) {
        // an empty tree is BST
        if (node == null) {
            return true;
        }

        // false if this node violates the min/max constraints
        if (node.data < min || node.data > max) {
            return false;
        }

        return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
    }

    private static boolean isBSTLeftRight(Node root, Node l, Node r) {
        if (root == null)
            return true;

        // if left node exist then check it has
        // correct data or not i.e. left node's data
        // should be less than root's data
        if (l != null && root.data <= l.data)
            return false;

        // if right node exist then check it has
        // correct data or not i.e. right node's data
        // should be greater than root's data
        if (r != null && root.data >= r.data)
            return false;

        return isBSTLeftRight(root.left, l, root) && isBSTLeftRight(root.right, root, r);
    }

    public static void main(String[] args) {
        CheckBST tree = new CheckBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
