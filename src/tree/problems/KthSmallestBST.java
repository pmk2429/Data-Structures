package tree.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all
 * the values of the nodes in the tree.
 * <p>
 * Example 1:
 * ----------
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * <p>
 * Example 2:
 * ----------
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * <p>
 * Constraints:
 * ------------
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * <p>
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the
 * kth smallest frequently, how would you optimize?
 */
public class KthSmallestBST {

    private static List<Integer> inorder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return arr;
        }
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
        return arr;
    }

    private static int kthSmallestIterative(TreeNode root, int k) {
        List<Integer> result = inorder(root, new ArrayList<>());
        return result.get(k - 1);
    }

    private static int kthSmallestRecursive(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (true) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.data;
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBST();
        System.out.println(kthSmallestRecursive(root, 3));
    }

}
