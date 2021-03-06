package tree.problems;

public class Diameter {

  // manages height of each subtree
  static class Height {
    int value;
  }

  private static int height(Node root) {
    if (root == null) {
      return 0;
    }

    return (1 + Math.max(height(root.left), height(root.right)));
  }

  private static int diameter(Node root, Height height) {

    Height rh = new Height();
    Height lh = new Height();

    if (root == null) {
      height.value = 0;
      return 0;
    }

    int leftDiameter = diameter(root.left, lh);
    int rightDiameter = diameter(root.right, rh);

    height.value = Math.max(lh.value, rh.value) + 1;

    return Math.max(lh.value + rh.value + 1, Math.max(leftDiameter, rightDiameter));
  }

  private static int diam(Node root) {
    Height h = new Height();
    Node curr = root;
    return diameter(curr, h);
  }

  public static void main(String[] args) {
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

    System.out.println("The diameter of given binary tree is : " + diam(root));
  }
}
