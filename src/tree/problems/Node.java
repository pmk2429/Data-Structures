package tree.problems;

/**
 * PMK's implementation of the Node structure
 */
public class Node {
  int data;
  int height;
  int hd; //horizontal distance of the node
  Node left, right;

  Node(int data) {
    this.data = data;
    this.height = 1;
    this.hd = 0;
    this.left = null;
    this.right = null;
  }

  @Override
  public String toString() {
    return String.valueOf(data);
  }

  public static Node createBT() {
    Node root = new Node(4);
    root.left = new Node(9);
    root.right = new Node(0);

    root.left.left = new Node(5);
    root.left.right = new Node(1);

    return root;
  }

  public static Node createBTComplex() {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    // second level
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    // third level
    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    root.left.right.left = new Node(10);
    root.right.left.right = new Node(11);
    // fourth level
    root.left.right.left.right = new Node(16);
    root.right.left.right.left = new Node(13);
    // fifth level
    root.right.left.right.left.right = new Node(12);

    return root;
  }
}
