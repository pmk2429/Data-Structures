package tree.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * Each root-to-leaf path in the tree represents a number.
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 * A leaf node is a node with no children.
 * <p>
 * Example 1:
 * ----------
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * <p>
 * Example 2:
 * ----------
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 * <p>
 * Constraints:
 * ------------
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 9
 * The depth of the tree will not exceed 10.
 */
public class SumRootToLeaf {

    private static int mergeRootToLeafPath(int[] path, int pathLen) {
        int mergedPath = 0;
        for (int i = 0; i < pathLen; i++) {
            mergedPath = mergedPath * 10 + path[i];
        }
        return mergedPath;
    }

    private static boolean isLeafNode(Node root) {
        return root.left == null && root.right == null;
    }

    private static void buildRootToLeafPath(Node root, int[] path, int pathLen, List<Integer> rootToLeafPaths) {
        if (root == null) {
            return;
        }

        path[pathLen++] = root.data;

        if (isLeafNode(root)) {
            int mergedPath = mergeRootToLeafPath(path, pathLen);
            rootToLeafPaths.add(mergedPath);
        }
        else {
            buildRootToLeafPath(root.left, path, pathLen, rootToLeafPaths);
            buildRootToLeafPath(root.right, path, pathLen, rootToLeafPaths);
        }
    }

    private static int sumNumbersList(Node root) {
        List<Integer> allPaths = new ArrayList<>();

        int[] path = new int[1000];
        int pathLen = 0;

        buildRootToLeafPath(root, path, pathLen, allPaths);

        int sum = 0;
        for (Integer val : allPaths) {
            sum += val;
        }
        return sum;
    }

    /**
     * Main solution - Recursive DFS.
     */
    private static int sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum = sum * 10 + root.data;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }

    private static int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createUnusualTree();
        System.out.println(sumNumbers(root));
    }
}
