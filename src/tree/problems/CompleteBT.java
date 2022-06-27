package tree.problems;

/**
 * In the array representation of a binary tree, if the parent node is assigned an index of ‘i’ and left child
 * gets assigned an index of ‘2*i + 1’ while the right child is assigned an index of ‘2*i + 2’.
 * If we represent the above binary tree as an array with the respective indices assigned to the different nodes
 * of the tree above from top to down and left to right.
 * <p>
 * Hence we proceed in the following manner in order to check if the binary tree is complete binary tree.
 * <p>
 * - Calculate the number of nodes (count) in the binary tree.
 * - Start recursion of the binary tree from the root node of the binary tree with index (i) being set as 0 and the
 * number of nodes in the binary (count).
 * - If the current node under examination is NULL, then the tree is a complete binary tree. Return true.
 * - If index (i) of the current node is greater than or equal to the number of nodes in the binary tree (count)
 * i.e. (i>= count), then the tree is not a complete binary. Return false.
 * - Recursively check the left and right sub-trees of the binary tree for same condition.
 * For the left sub-tree use the index as (2*i + 1) while for the right sub-tree use the index as (2*i + 2).
 */
public class CompleteBT {

    private int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    boolean isComplete(Node root, int index, int totalNodes) {
        // An empty tree is complete
        if (root == null) {
            return true;
        }

        // If index assigned to current node is more than
        // number of nodes in tree, then tree is not complete
        if (index >= totalNodes) {
            return false;
        }

        return (isComplete(root.left, 2 * index + 1, totalNodes)
            && isComplete(root.right, 2 * index + 2, totalNodes));

    }
}
