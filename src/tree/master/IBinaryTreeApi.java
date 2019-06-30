package tree.master;

import java.util.List;

/**
 * Implement the following API for the Binary Tree
 */
public interface IBinaryTreeApi {
  void add(Node node);

  void delete(Node node);

  /**
   * Returns the corresponding Node based on the Key
   *
   * @param key
   * @return
   */
  Node search(int key);

  boolean contains(Node node);

  /**
   * The height of a node is the number of edges on the longest path from the node to a leaf.
   * A leaf node will have a height of 0.
   *
   * @return height of root Node
   */
  int height();

  int height(Node node);

  /**
   * The depth of a node is the number of edges from the node to the tree's root node.
   * A root node will have a depth of 0.
   *
   * @return depth of root Node
   */
  int maxDepth();

  int maxDepth(Node node);

  int minDepth();

  int minDepth(Node node);

  /**
   * The diameter (or width) of a tree is the number of nodes on the longest path between any two leaf nodes.
   * The tree below has a diameter of 6 nodes.
   *
   * @return
   */
  int width();

  Node maximum();

  Node maximum(Node node);

  Node minimum();

  Node minimum(Node node);

  boolean hasLeft(Node node);

  boolean hasRight(Node node);

  int getLevel(Node node);

  List<List<Node>> getNodesAtLevel(int level);

  int size();

  int countLeaves();

  int countLeaves(Node node);

  void deleteMin();

  void deleteMax();

  Node getRoot();

  boolean isRoot(Node node);

  Node parent(Node node);

  boolean hasChild(Node node);

  int totalChild();

  int totalChild(Node node);

  /**
   * If X has two childrenits predecessor is the maximum value in its left subtree
   *
   * @return
   */
  Node predecessor();

  Node predecessor(Node node);

  /**
   * If X has two childrenits successor is the minimum value in its right subtree
   *
   * @return
   */
  Node successor();

  Node successor(Node node);

  /**
   * Prints n immediate successors of the specified node.
   *
   * @param n
   * @return
   */
  List<Node> immediateSuccessors(Node node, int n);

  /**
   * Returns the list of nodes by each level as a list constituent
   *
   * @return
   */
  List<List<Node>> levelOrder();

  void printLevelOrder();

  /**
   * Provides Recursive approach to find the <tt>Lowest Common Ancestor</tt>.
   * <p>
   * <b>Conditions for LCA in Binary Tree</b>
   * <ul>
   * <li>If the binary tree itself is null, you don't have any common ancestor. This is an error condition.</li>
   * <li>If one of the two nodes is the root, then the root itself is the common ancestor.</li>
   * <li>Otherwise, recursively start finding the ancestor on the leftChild node and right node.</li>
   * </ul>
   * <p>
   * If Node a and Node b lie in the leftChild, their Lowest Common Ancestor is in the leftChild.
   * If Node a and Node b lie in the right,their Lowest Common Ancestor is in the right.
   * Otherwise, root is the Lowest common ancestor.
   *
   * @return
   */
  Node getLowestCommonAncestor(Node a, Node b);

  /**
   * Returns list of Nodes by traversing in order
   *
   * @return
   */
  List<Node> inOrderTraversal();

  /**
   * Returns list of Nodes by traversing pre order
   *
   * @return
   */
  List<Node> preOrderTraversal();

  /**
   * Returns list of nodes by traversing post order
   *
   * @return
   */
  List<Node> postOrderTraversal();

  /**
   * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled
   * and all nodes are as far left as possible.
   *
   * @return
   */
  boolean isComplete();

  /**
   * A full binary tree (sometimes proper binary tree or 2-tree or strictly binary tree) is a tree in
   * which every node other than the leaves has two children.
   *
   * @return
   */
  boolean isFull();

  boolean isLeaf(Node node);

  void reverse();

  /**
   * Returns true if the max node at ith level is less than or equal to getMin node at i+1th level.
   *
   * @return
   */
  boolean isLevelOrderSorted();

  Node kthLargest();

  boolean isBalanced();

  /**
   * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two
   * end nodes. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest
   * path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
   *
   * @return
   */
  int diameter();

  boolean isValidBST();

  boolean isValidBST(Node node);
}
