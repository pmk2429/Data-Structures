package tree.problems;

/**
 * Print BST keys in given Range | O(1) Space
 * Given two values n1 and n2 (where n1 < n2) and a root pointer to a Binary Search Tree. Print all the keys of tree
 * in range n1 to n2. i.e. print all Nodes n such that n1<=n<=n2 and n is a data of given BST.
 * Print all the keys in increasing order.
 * <p>
 * Prerequisites : Morris traversal | Threaded binary trees
 * <p>
 * Inorder traversal uses recursion or stack/queue which consumes O(n) space.
 * But there is one efficient way to do inorder tree traversal using Morris Traversal which is based in Threaded Binary trees.
 * Morris traversal uses no recursion or stack/queue and simply stores some important information in the wasted NULL pointers.
 * Morris traversal consumes constant extra memory O(1) as it uses no recursion or stack/queue.
 * <p>
 * The concept of Threaded Binary trees is simple that they store some useful information in the wasted NULL pointers.
 * In a normal binary tree with n Nodes, n+1 NULL pointers waste memory.
 * <p>
 * Approach : Morris Traversal is a very nice memory efficient technique to do tree traversal without using stack
 * or recursion in constant memory O(1) based on Threaded Binary Trees. Morris traversal can be used in solving
 * problems where inorder tree problems are used especially in order statistics eg-Kth largest element in BST,
 * Kth smallest in BST etc. Hence, this is where Morris traversal would come handy as a more efficient method to do
 * inorder traversal in constant O(1) space without using any stack or recursion.
 */
public class MorrisTraversal {

    private static void rangeTraversal(TreeNode root, int n1, int n2) {
        if (root == null) {
            return;
        }

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                // check if current Node lies between n1 and n2
                if (curr.data >= n1 && curr.data <= n2) {
                    System.out.print(curr.data + " ");
                }
                curr = curr.right;
            }
            else {
                // finding the inorder predecessor is the right most in left subtree or the left
                // child, i.e. in BST it is the maximum(right most) in left subtree.
                TreeNode pre = TreeNode.predecessor(curr);

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                }
                else {
                    pre.right = null;
                    // check if current Node lies between n1 and n2
                    if (curr.data >= n1 && curr.data <= n2) {
                        System.out.print(curr.data + " ");
                    }
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBSTEven();
        rangeTraversal(root, 4, 8);
    }
}
