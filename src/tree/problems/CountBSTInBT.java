package tree.problems;

/**
 * Given a binary tree, the task is to count the number of Binary Search Trees present in it.
 * <p>
 * A Binary Tree is a Binary Search Tree if the following are true for every node X:
 * 1 - The largest value in left subtree (of X) is smaller than value of X.
 * 2 - The smallest value in right subtree (of X) is greater than value of X.
 * <p>
 * Input:
 * <p>
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4   5 6  7
 * Output: 7
 * Here each node represents a binary search tree and there are total 7 nodes.
 * <p>
 * Input:
 * <p>
 * 11
 * /  \
 * 8    10
 * /    /  \
 * 5    9    8
 * / \
 * 4   6
 * Output: 10
 * We know that a single node represents a BST and since here 8
 * nodes are present they all are BSTs. Also a subtree rooted under node 5 is a BST
 * <p>
 * 5
 * / \
 * 4   6
 * Another BST we have is rooted under the node 8
 * <p>
 * 8
 * /
 * 5
 * / \
 * 4   6
 * Thus total 10 BSTs are present.
 */
public class CountBSTInBT {

    private static class NodeInfo {
        int numBST;
        int max;
        int min;
        boolean isBST;

        NodeInfo(int a, int b, int c, boolean d) {
            numBST = a;
            max = b;
            min = c;
            isBST = d;
        }

        NodeInfo() {
        }
    }

    private static NodeInfo countBinarySearchTrees(TreeNode root) {
        if (root == null) {
            return new NodeInfo(0, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        }

        // single element is BST in itself
        if (root.left == null && root.right == null) {
            return new NodeInfo(1, root.data, root.data, true);
        }

        NodeInfo left = countBinarySearchTrees(root.left);

        NodeInfo right = countBinarySearchTrees(root.right);

        NodeInfo info = new NodeInfo();

        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            info.min = Math.min(root.data, (Math.min(left.min, right.min)));
            info.max = Math.max(root.data, (Math.max(left.max, right.max)));

            info.numBST = 2 + left.numBST + right.numBST;

            return info;
        }

        info.isBST = false;
        info.numBST = 1 + left.numBST + right.numBST;

        return info;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(8);
        root.right = new TreeNode(10);
        // 2nd level
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);
        // 3rd level
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);

        NodeInfo info = countBinarySearchTrees(root);
        System.out.println("total BST - " + info.numBST);
    }

}
