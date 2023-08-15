package tree.problems;

public class KthLargestMorrisTraversalO1 {

    private static TreeNode kthLargest(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        TreeNode curr = root;
        TreeNode kLargest = null;
        // count variable to keep count of visited Nodes
        int count = 0;
        while (curr != null) {
            // if right child is NULL
            if (curr.right == null) {
                // first increment count and check if count = k
                if (++count == k) {
                    kLargest = curr;
                }
                // otherwise move to the left child
                curr = curr.left;
            }
            else {
                // find inorder successor of current Node
                TreeNode successor = TreeNode.successor(curr);

                if (successor.left == null) {
                    // set left child of successor to the
                    // current Node
                    successor.left = curr;
                    // move current to its right
                    curr = curr.right;
                }
                // restoring the tree back to original binary search tree removing threaded links
                else {
                    successor.left = null;
                    if (++count == k) {
                        kLargest = curr;
                    }
                    // move current to its left child
                    curr = curr.left;
                }
            }
        }
        return kLargest;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBSTEven();
        System.out.println(kthLargest(root, 3));
    }

}
