package tree.problems;

import java.util.Stack;

/**
 * Recover a Tree From Preorder Traversal
 * We run a preorder depth first search on the root of a binary tree.
 * At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the
 * value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.
 * The depth of the root node is 0.)
 * If a node has only one child, that child is guaranteed to be the left child.
 * Given the output S of this traversal, recover the tree and return its root.
 * <p>
 * Example 1:
 * ----------
 * Input: "1-2--3--4-5--6--7"
 * Output: [1,2,5,3,4,6,7]
 * <p>
 * Example 2:
 * ----------
 * Input: "1-2--3---4-5--6---7"
 * Output: [1,2,5,3,null,6,null,4,null,7]
 * <p>
 * Example 3:
 * ----------
 * Input: "1-401--349---90--88"
 * Output: [1,401,null,349,88,90]
 * <p>
 * Note:
 * -----
 * The number of nodes in the original tree is between 1 and 1000.
 * Each node will have a value between 1 and 10^9.
 */
public class RecoverTreePreOrder {

    private static Node recoverFromPreOrder(String S) {
        Node root = null;
        var parents = new Stack<Node>();

        for (int i = 0; i < S.length(); ) {
            // parse depth and value
            int depth = 0, val = 0;
            for (; i < S.length() && S.charAt(i) == '-'; i++) {
                depth++;
            }
            for (; i < S.length() && S.charAt(i) != '-'; i++) {
                val = val * 10 + (S.charAt(i) - '0');
            }
            var node = new Node(val);

            while (parents.size() > depth) {
                parents.pop();
            }

            if (root == null) {
                root = node;
            }
            else {
                var p = parents.peek();
                if (p.left == null) {
                    p.left = node;
                }
                else {
                    p.right = node;
                }
            }

            parents.push(node);
        }

        return root;
    }

    public static void main(String[] args) {
        String input = "1-2--3--4-5--6--7";
        recoverFromPreOrder(input);
    }
}
