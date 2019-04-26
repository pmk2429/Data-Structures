package tree.problems;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left
 * where the original right nodes turned into left leaf nodes. Return the new root.
 * <p>
 * Top down approach:
 * We need to be very careful when reassigning current node’s left and right children.
 * Besides making a copy of the parent node, you would also need to make a copy of the parent’s right child too.
 * The reason is the current node becomes the parent node in the next iteration.
 */
public class UpsideDown {
  public Node upsideBTTopDown(Node root) {
    Node p = root, parent = null, parentRight = null;
    while (p != null) {
      Node left = p.left;
      p.left = parentRight;
      parentRight = p.right;
      p.right = parent;
      parent = p;
      p = left;
    }
    return parent;
  }

  /**
   * Bottom up approach:
   * Although the code for the top-down approach seems concise, it is actually subtle and there are a lot of hidden
   * traps if you are not careful. The other approach is thinking recursively in a bottom-up fashion.
   * If we reassign the bottom-level nodes before the upper ones, we won’t have to make copies and worry about
   * overwriting something. We know the new root will be the left-most leaf node, so we begin the reassignment here.
   */
  public Node upsideBTBottomUp(Node root) {
    return dfsBottomUp(root, null);
  }

  private Node dfsBottomUp(Node p, Node parent) {
    if (p == null) return parent;
    Node root = dfsBottomUp(p.left, p);
    p.left = (parent == null) ? parent : parent.right;
    p.right = parent;
    return root;
  }
}
