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

    private static Node constructTreeUtil(int[] pre, int[] post, int l, int r, int size) {
        // Base case
        if (preIndex >= size || l > r) {
            return null;
        }

        // The first node in preorder traversal is root. So take the node at preIndex from
        // preorder and make it root, and increment preIndex
        Node root = new Node(pre[preIndex]);
        preIndex++;

        // If the current sub array has only one element, no need to recur or
        // preIndex > size after incrementing
        if (preIndex >= size || l == r) {
            return root;
        }

        int i;
        // Search the next element of pre[] in post[]
        for (i = l; i <= r; i++) {
            if (post[i] == pre[preIndex])
                break;
        }

        // `i` will be the index of the root in left subtree

        // Use the index of element found in postorder to divide postorder array
        // in two parts. Left subtree and right subtree
        if (i <= r) {
            root.left = constructTreeUtil(pre, post, l, i, size);
            root.right = constructTreeUtil(pre, post, i + 1, r, size);
        }

        return root;
    }

    /**
     * The main function to construct Full Binary Tree from given preorder and
     * postorder problems. This function mainly uses constructTreeUtil()
     */
    private static Node constructTree(int[] pre, int[] post, int size) {
        preIndex = 0;
        return constructTreeUtil(pre, post, 0, size - 1, size);
    }

    static void printInorder(Node root) {
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

        int size = pre.length;
        Node root = constructTree(pre, post, size);

        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
    }
}
