package tree.bt;

/**
 * PMK's implementation of the Node structure
 */
public class Node {
  int data;
  String value;

  Node left;
  Node right;

  Node(int data, String value) {
    this.data = data;
    this.value = value;
    this.left = null;
    this.right = null;
  }

  @Override
  public String toString() {
    return data + " - " + value;
  }
}
