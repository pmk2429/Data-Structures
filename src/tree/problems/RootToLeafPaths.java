package tree.problems;

import java.util.Arrays;

public class RootToLeafPaths {

  private static boolean isLeaf(Node node) {
    return (node.left == null && node.right == null);
  }

  private static void printPath(int[] path, int pathLen) {
    //Arrays.stream(path).filter(num -> num > 0).forEach(p -> System.out.print(p + " "));
    //System.out.println();

    for (int i = 0; i < pathLen; i++) {
      System.out.print(path[i] + " ");
    }
    System.out.println();
  }

  private static void rootToLeaf(Node node, int[] path, int pathLen) {
    // base case for recursion
    if (node == null) {
      return;
    }

    /* append this node to the path array */
    path[pathLen++] = node.data;

    if (isLeaf(node)) {
      // print the traversed path
      printPath(path, pathLen);
    } else {
      // recur left subtree
      rootToLeaf(node.left, path, pathLen);
      // recur right subtree
      rootToLeaf(node.right, path, pathLen);
    }
  }

  private static void printRootToLeaf(Node root) {
    int[] path = new int[1000];

    // start with 0th index for path length
    rootToLeaf(root, path, 0);
  }

  private static Node createNode(int data) {
    return new Node(data);
  }

  public static void main(String[] args) {
    Node root = createNode(1);
    root.left = createNode(2);
    root.right = createNode(3);
    root.left.left = createNode(4);
    root.left.right = createNode(5);

    printRootToLeaf(root);
  }
}
