package tree.problems;

import java.util.ArrayList;
import java.util.List;

public class PathFromRootToNode {
    private static boolean hasPath(TreeNode root, int key, List<Integer> result) {
        if (root == null) {
            return false;
        }

        result.add(root.data);

        if (root.data == key) {
            return true;
        }

        if (hasPath(root.left, key, result) || hasPath(root.right, key, result)) {
            return true;
        }

        // required node does not lie either in the left or right subtree of the current node
        // Thus, remove current node's value from array and then return false.
        result.remove(result.size() - 1);

        return false;
    }

    private static void printPath(TreeNode root, int key) {
        List<Integer> res = new ArrayList<>();

        if (hasPath(root, key, res)) {
            for (int i = 0; i < res.size() - 1; i++) {
                System.out.print(res.get(i) + " -> ");
            }
            System.out.print(res.get(res.size() - 1));
        }
        else {
            System.out.print("No Path");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int key = 5;
        printPath(root, key);
    }
}
