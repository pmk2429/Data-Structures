package tree.problems;

import java.util.Arrays;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ArrayToBst {
    private static TreeNode constructBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        if (arr.length == 0) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = constructBST(arr, start, mid - 1);
        root.right = constructBST(arr, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root;
        int[] arr = {99, 35, 19, 0, 11, 40, 5};
        // Most IMP step. Can't convert Array to BST without sorting Array first
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        root = constructBST(arr, 0, arr.length - 1);
        System.out.println(root.data);
    }
}
