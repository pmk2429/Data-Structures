package tree.problems;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {

    private static void pathBuilder(TreeNode root, StringBuilder sb, List<String> result) {
        if (root == null) {
            return;
        }

        sb.append(root.data);

        if (root.left == null && root.right == null) { // leaf node
            result.add(sb.toString());
            return;
        }

        // if we are here root has at least 1 child node
        sb.append("->");
        String answer = sb.toString();

        pathBuilder(root.left, sb, result);
        pathBuilder(root.right, new StringBuilder(answer), result);
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        pathBuilder(root, sb, result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBT();
        System.out.println(binaryTreePaths(root));
    }
}
