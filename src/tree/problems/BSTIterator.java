package tree.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 * <p>
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of
 * the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise
 * returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the
 * smallest element in the BST.
 * <p>
 * You may assume that next() calls will always be valid. That is, there will be at least a next number in the
 * in-order traversal when next() is called.
 * <p>
 * Example 1:
 * ----------
 * Input
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * Output
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 * <p>
 * Explanation:
 * ------------
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // return 3
 * bSTIterator.next();    // return 7
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 9
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 15
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 20
 * bSTIterator.hasNext(); // return False
 * <p>
 * Constraints:
 * ------------
 * The number of nodes in the tree is in the range [1, 105].
 * 0 <= Node.val <= 106
 * At most 105 calls will be made to hasNext, and next.
 */
public class BSTIterator {

    private final List<Integer> sortedNodes;
    private int index;

    public BSTIterator(TreeNode root) {
        sortedNodes = new ArrayList<>();

        // Pointer to the next smallest element in the BST
        index = -1;

        // Call to flatten the input binary search tree
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        sortedNodes.add(root.data);
        inOrder(root.right);
    }

    public int next() {
        return sortedNodes.get(++index);
    }

    public boolean hasNext() {
        return index + 1 < sortedNodes.size();
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinarySearchTree();
        BSTIterator obj = new BSTIterator(root);
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
    }
}
