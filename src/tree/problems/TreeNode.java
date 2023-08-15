package tree.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int height;
    int horizontalDistance;

    TreeNode() {
    }

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
        this.horizontalDistance = 0;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = 1;
        this.horizontalDistance = 0;
    }

    TreeNode(int data, TreeNode left, TreeNode right, int horizontalDistance, int height) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = height;
        this.horizontalDistance = horizontalDistance;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }

    public static TreeNode createBT() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        return root;
    }

    public static TreeNode createBTWithNull() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.right = new TreeNode(1);

        return root;
    }

    public static TreeNode createSymmetric() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        return root;
    }

    public static TreeNode createBTComplex() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        // second level
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // third level
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);
        // fourth level
        root.left.right.left.right = new TreeNode(16);
        root.right.left.right.left = new TreeNode(13);
        // fifth level
        root.right.left.right.left.right = new TreeNode(12);

        return root;
    }

    public static TreeNode createUnusualTree() {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        return root;
    }

    public static TreeNode createBSTEven() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(12);

        return root;
    }

    public static TreeNode createBST() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        return root;
    }

    public static TreeNode createBSTUneven() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(33);

        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(40);

        root.right.left.left = new TreeNode(11);
        root.right.right.left = new TreeNode(34);

        root.right.left.left.left = new TreeNode(7);
        root.right.left.left.right = new TreeNode(12);
        root.right.right.left.right = new TreeNode(36);

        root.right.left.left.right.right = new TreeNode(13);

        return root;
    }

    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "  ");
        printTree(node.left);
        printTree(node.right);
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode currNode = root;
        Deque<TreeNode> nodesQ = new ArrayDeque<>();
        nodesQ.add(currNode);

        while (!nodesQ.isEmpty()) {
            // print the current node
            System.out.print(nodesQ.peek().data + " ");

            if (currNode.left != null) {
                nodesQ.add(currNode.left);
            }

            if (currNode.right != null) {
                nodesQ.add(currNode.right);
            }

            nodesQ.remove();
            currNode = nodesQ.peek();
        }
    }

    public TreeNode maximum(TreeNode node) {
        if (node == null) {
            return null;
        }

        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    public TreeNode minimum(TreeNode node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public static TreeNode successor(TreeNode node) {
        TreeNode successor = node.right;
        while (successor.left != null && successor.left != node) {
            successor = successor.left;
        }
        return successor;
    }

    public static TreeNode predecessor(TreeNode node) {
        TreeNode predecessor = node.left;
        while (predecessor.right != null && predecessor.right != node) {
            predecessor = predecessor.right;
        }
        return predecessor;
    }
}
