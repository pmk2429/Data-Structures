package tree.problems;

/**
 * Construct a Binary Tree using Preorder and Postorder problems
 * <p>
 * Let us consider the two given arrays as pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7} and post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
 * In pre[], the leftmost element is root of tree. Since the tree is full and array size is more than 1.
 * The value next to 1 in pre[], must be left child of root. So we know 1 is root and 2 is left child.
 * How to find the all nodes in left subtree? We know 2 is root of all nodes in left subtree.
 * All nodes before 2 in post[] must be in left subtree. Now we know 1 is root, elements {8, 9, 4, 5, 2} are
 * in left subtree, and the elements {6, 7, 3} are in right subtree.
 */
public class ConstructBSTFromPrePostTraversals {

    // variable to hold index in pre[] array
    private static int preIndex;

    private static TreeNode constructBinaryTreeFromPrePost(int[] preOrder, int[] postOrder, int postStart, int postEnd) {
        // Base case
        if (preIndex > preOrder.length - 1 || postStart > postEnd) {
            return null;
        }

        // The first node in preorder traversal is root. So take the node at preIndex from
        // preorder and make it root, and increment preIndex
        TreeNode root = new TreeNode(preOrder[preIndex]);
        preIndex++;

        // If the current sub array has only one element, no need to recur or
        // preIndex > size after incrementing
        if (preIndex > preOrder.length - 1 || postStart == postEnd) {
            return root;
        }

        int postIndex;
        // Search the next element of pre[] in post[]
        for (postIndex = postStart; postIndex <= postEnd; postIndex++) {
            if (postOrder[postIndex] == root.data)
                break;
        }

        // `i` will be the index of the root in postOrder (left subtree)

        // Use the index of element found in postorder to divide postorder array
        // in two parts. Left subtree and right subtree
        if (postIndex <= postEnd) {
            root.left = constructBinaryTreeFromPrePost(preOrder, postOrder, postStart, postIndex);
            root.right = constructBinaryTreeFromPrePost(preOrder, postOrder, postIndex + 1, postEnd);
        }

        return root;
    }

    /**
     * The main function to construct Full Binary Tree from given preorder and
     * postorder problems. This function mainly uses constructTreeUtil()
     */
    private static TreeNode constructTree(int[] pre, int[] post) {
        preIndex = 0;
        return constructBinaryTreeFromPrePost(pre, post, 0, post.length - 1);
    }

    static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int[] post = {8, 9, 4, 5, 2, 6, 7, 3, 1};

        TreeNode root = constructTree(pre, post);

        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
    }
}
