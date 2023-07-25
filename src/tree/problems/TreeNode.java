package tree.problems;

import com.sun.source.tree.Tree;
import tree.master.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int data) {
        this.data = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
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

    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data + "  ");
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
}
