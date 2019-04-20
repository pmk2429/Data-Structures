package tree.problems;

import java.util.Arrays;

public class ArrayToBst {
  static Node constructBST(int[] arr, int start, int end, Node root) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;

    if (root == null) {
      root = new Node(arr[mid]);
    }

    root.left = constructBST(arr, start, mid - 1, root.left);
    root.right = constructBST(arr, mid + 1, end, root.right);

    return root;
  }

  public static void main(String[] args) {
    Node root = null;
    int[] arr = {99, 35, 19, 0, 11, 40, 5};
    int length = arr.length;
    Arrays.sort(arr);
    root = constructBST(arr, 0, length - 1, root);
  }
}
