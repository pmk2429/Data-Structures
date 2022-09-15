package tree.problems;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * A height-balanced tree is a tree whose subtrees differ in height by no more than one and the subtrees are height-balanced, too.
 */
public class SortedArrayToBST {
    private Node sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        if (arr.length == 0) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);

        return root;
    }

    public Node sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length - 1);
    }
}
