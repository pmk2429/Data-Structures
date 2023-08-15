package tree.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * Example 1:
 * ----------
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * <p>
 * Example 2:
 * ----------
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * ----------
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * ------------
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class ZigZagOrderTraversal {

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean even = true;

        while (!q.isEmpty()) {
            int size = q.size();
            // use of LinkedList ensures that we can have insertion of elements from both ends
            LinkedList<Integer> currentLevelNodes = new LinkedList<>();

            while (size-- > 0) {
                TreeNode top = q.poll();

                if (top.left != null) {
                    q.offer(top.left);
                }
                if (top.right != null) {
                    q.offer(top.right);
                }

                if (even) {
                    currentLevelNodes.add(top.data); // adds to the end of the LinkedList : FIFO
                }
                else {
                    currentLevelNodes.addFirst(top.data); // adds to the start of the LinkedList : FILO
                }
            }
            list.add(currentLevelNodes);
            even = !even;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBSTUneven();
        List<List<Integer>> zigzag = zigzagLevelOrder(root);
        zigzag.stream()
            .flatMap(List::stream)
            .forEach(s -> System.out.print(s + " "));

        // Expected ans - 2 33 1 25 40 34 11 7 12 36 13
    }
}
