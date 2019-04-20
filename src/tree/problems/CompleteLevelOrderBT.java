package tree.problems;

/**
 * Construct a complete binary tree from given array in level order fashion
 * Given an array of elements, our task is to construct a complete binary tree from this array in level order fashion.
 * That is, elements from left in the array will be filled in the tree level wise starting from level 0.
 * <p/>
 * Examples:
 * --------
 * Input  :  arr[] = {1, 2, 3, 4, 5, 6}
 * Output : Root of the following tree
 * 1
 * / \
 * 2   3
 * / \ /
 * 4  5 6
 * <p>
 * <p>
 * Input: arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6}
 * Output: Root of the following tree
 * 1
 * / \
 * 2   3
 * / \ / \
 * 4  5 6  6
 * / \ /
 * 6  6 6
 */
public class CompleteLevelOrderBT {

  private static int leftChildIndex(int i) {
    return 2 * i + 1;
  }

  private static int rightChildIndex(int i) {
    return 2 * i + 2;
  }

  private static Node insertLevelOrder(int[] arr, Node root, int index) {
    if (arr.length < 1) {
      return null;
    }

    if (index < arr.length) {
      Node curNode = new Node(arr[index]);
      root = curNode;

      // for any parent i in a BT, left child is positioned at 2*i+1 and right child at 2*i+2
      root.left = insertLevelOrder(arr, root.left, leftChildIndex(index));
      root.right = insertLevelOrder(arr, root.right, rightChildIndex(index));
    }
    return root;
  }

  private static void inOrderTraversal(Node root) {
    if (root == null) {
      return;
    }

    inOrderTraversal(root.left);
    System.out.print(root.data + " ");
    inOrderTraversal(root.right);
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 6, 6, 6};
    Node root = new Node(arr[0]);
    root = insertLevelOrder(arr, root, 0);
    System.out.println("Level order BT representation - Inorder");
    inOrderTraversal(root);
  }
}
