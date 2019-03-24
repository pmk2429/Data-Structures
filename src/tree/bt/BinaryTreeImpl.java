package tree.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeImpl implements BinaryTreeApi {

  private Node root = null;
  private int count = 0;

  // Utility helper method to add new Node to Binary Tree
  private Node add(Node root, Node newNode) {
    if (root == null) {
      root = newNode;
    }

    if (newNode.data < root.data) {
      root.left = root.left != null ? add(root.left, newNode) : newNode;
    } else if (newNode.data > root.data) {
      root.right = root.right != null ? add(root.right, newNode) : newNode;
    }

    return root;
  }

  @Override
  public void add(Node node) {
    root = add(root, node);
    count++;
  }

  @Override
  public void delete(Node node) {
  }

  @Override
  public Node search(int key) {
    if (root == null) {
      return null;
    }

    if (root.data == key) {
      return root;
    }

    Node searchNode = root;

    while (searchNode != null) {
      if (key < searchNode.data) {
        searchNode = searchNode.left;
      } else if (key > searchNode.data) {
        searchNode = searchNode.right;
      } else if (searchNode.data == key) {
        return searchNode;
      }
    }

    // in this case, the key is not equal to Root and yet searchNode was traversed indicating mismatch
    if (searchNode == null) {
      return getNullNode();
    }

    return searchNode;
  }

  @Override
  public boolean contains(Node node) {
    return false;
  }

  /**
   * Utility method to deduce the height of a specific Node of BST.
   *
   * @param node
   * @return
   */
  private int deduceHeight(Node node) {

    if (node == null) {
      return 0;
    }

    int leftHeight = deduceHeight(node.left);
    int rightHeight = deduceHeight(node.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }

  @Override
  public int height() {
    return deduceHeight(root);
  }

  @Override
  public int height(Node node) {
    return deduceHeight(node);
  }

  private int deduceDepth(Node node) {
    int h1 = 0, h2 = 0;
    if (node == null) {
      return -1;
    } else if (node == root) {
      return 0;
    } else {
      if (root.left != null) {
        h1 = depth(root.left);
      }
      if (root.right != null) {
        h2 = depth(root.right);
      }
      return Math.max(h1, h2) + 1;
    }
  }

  @Override
  public int depth() {
    return deduceDepth(root);
  }

  @Override
  public int depth(Node node) {
    return deduceDepth(node);
  }

  @Override
  public int width() {
    return 0;
  }

  private Node findMaximum(Node node) {
    if (node == null) {
      return null;
    }

    while (node.right != null) {
      node = node.right;
    }
    return node;
  }

  @Override
  public Node maximum() {
    return findMaximum(root);
  }

  @Override
  public Node maximum(Node node) {
    return findMaximum(node);
  }

  private Node findMinimum(Node node) {
    if (node == null) {
      return null;
    }

    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  @Override
  public Node minimum() {
    return findMinimum(root);
  }

  @Override
  public Node minimum(Node node) {
    return findMinimum(node);
  }

  @Override
  public boolean hasLeft(Node node) {
    return node.left != null;
  }

  @Override
  public boolean hasRight(Node node) {
    return node.right != null;
  }

  // Helper function for getLevel()
  private int getLevelUtil(Node root, Node node, int level) {
    if (node == null) {
      return 0;
    }

    if (node.data == root.data) {
      return level;
    }

    int downlevel = getLevelUtil(root.left, node, level + 1);

    if (downlevel != 0) {
      return downlevel;
    }

    downlevel = getLevelUtil(root.right, node, level + 1);

    return downlevel;
  }

  @Override
  public int getLevel(Node node) {
    return getLevelUtil(root, node, 1);
  }

  @Override
  public List<LinkedList<Node>> getNodesAtLevel(int level) {
    List<LinkedList<Node>> lists = new ArrayList<>();
    LinkedList<Node> list = new LinkedList<>();

    int i = 0;
    while (i < depth(root)) {
      LinkedList<Node> s = new LinkedList<>(list);
      lists.add(i, s);
      list.clear();
      i++;
    }

    return lists;
  }

  @Override
  public int size() {
    return count;
  }

  private int countTotalLeaves(Node node) {
    if (node == null) {
      return 0;
    }
    if (node.left == null && node.right == null) {
      return 1;
    }

    return countTotalLeaves(node.left) + countTotalLeaves(node.right);
  }

  @Override
  public int countLeaves() {
    return countTotalLeaves(root);
  }

  @Override
  public int countLeaves(Node node) {
    return countTotalLeaves(node);
  }

  @Override
  public void deleteMin() {

  }

  @Override
  public void deleteMax() {

  }

  @Override
  public Node getRoot() {
    return root;
  }

  @Override
  public boolean isRoot(Node node) {
    return this.root.equals(node);
  }

  private Node getParent(Node root, Node node) {
    if (isRoot(node) || root == null) {
      return getNullNode();
    } else {
      if (root.left == node || root.right == node) {
        return root;
      }

      if (compare(root, node) < 0) {
        return getParent(root.right, node);
      } else {
        return getParent(root.left, node);
      }
    }
  }

  @Override
  public Node parent(Node node) {
    return getParent(root, node);
  }

  @Override
  public boolean hasChild(Node node) {
    return (node.left != null || node.right != null);
  }

  @Override
  public int getTotalChild() {
    return 0;
  }

  private Node findPredecessor(Node node) {
    // max value in left subtree
    if (node == null) {
      return getNullNode();
    }

    if (node.left == null) {
      return getNullNode();
    }

    Node leftRoot = node.left;

    return maximum(leftRoot);
  }

  @Override
  public Node predecessor() {
    return findPredecessor(root);
  }

  @Override
  public Node predecessor(Node node) {
    return findPredecessor(node);
  }

  private Node findSuccessor(Node node) {
    // min value in right sub tree
    if (node == null) {
      return getNullNode();
    }

    if (node.right == null) {
      return getNullNode();
    }

    Node rightRoot = node.right;

    return minimum(rightRoot);
  }

  @Override
  public Node successor() {
    return findSuccessor(root);
  }

  @Override
  public Node successor(Node node) {
    return findSuccessor(node);
  }

  @Override
  public List<Node> immediateSuccessors(Node node, int n) {

    if (node == null) {
      return null;
    }

    // build the list using inorder traversal
    List<Node> inorder = inOrderTraversal();

    if (n < inorder.size()) {
      if (inorder.contains(node)) {
        int startIndex = inorder.indexOf(node) + 1;
        // now get the element starting 5 until n
        return inorder.subList(startIndex, startIndex + n);
      }
    }

    return null;
  }

  @Override
  public List<List<Node>> levelOrder() {
    return null;
  }

  @Override
  public Node getLowestCommonAncestor(Node a, Node b) {
    return null;
  }

  private void buildInorderTraversal(Node node, List<Node> inorder) {
    if (node != null) {
      if (node.left != null) {
        buildInorderTraversal(node.left, inorder);
      }
      inorder.add(node);
      if (node.right != null) {
        buildInorderTraversal(node.right, inorder);
      }
    }
  }

  @Override
  public List<Node> inOrderTraversal() {
    if (root == null) {
      return null;
    }
    List<Node> inorder = new ArrayList<>();
    buildInorderTraversal(root, inorder);
    return inorder;
  }

  private void buildPreOrderTraversal(Node node, List<Node> preOrder) {
    if (node != null) {
      preOrder.add(node);
      if (node.left != null) {
        buildPreOrderTraversal(node.left, preOrder);
      }
      if (node.right != null) {
        buildPreOrderTraversal(node.right, preOrder);
      }
    }
  }

  @Override
  public List<Node> preOrderTraversal() {
    if (root == null) {
      return null;
    }

    List<Node> preOrder = new ArrayList<>();
    buildPreOrderTraversal(root, preOrder);

    return preOrder;
  }

  private void buildPostOrderTraversal(Node node, List<Node> postOrder) {
    if (node != null) {
      if (node.left != null) {
        buildPostOrderTraversal(node.left, postOrder);
      }
      if (node.right != null) {
        buildPostOrderTraversal(node.right, postOrder);
      }
      postOrder.add(node);
    }
  }

  @Override
  public List<Node> postOrderTraversal() {
    if (root == null) {
      return null;
    }

    List<Node> postOrder = new ArrayList<>();
    buildPostOrderTraversal(root, postOrder);

    return postOrder;
  }

  private Node getNullNode() {
    Node node = new Node(0, "Node Unavailable");
    return node;
  }

  @Override
  public boolean isComplete() {
    return false;
  }

  private boolean isFullTree(Node node) {
    boolean isFull = false;

    // empty tree is a full BT
    if (node == null) {
      return true;
    }

    if (node.left == null && node.right == null) {
      return true;
    }

    // a full binary tree always has odd number of nodes
    if (count % 2 == 0) {
      return false;
    }

    if ((node.left != null) && (node.right != null)) {
      isFull = (isFullTree(node.left) && isFullTree(node.right));
    }

    return isFull;
  }

  @Override
  public boolean isFull() {
    return isFullTree(root);
  }

  @Override
  public boolean isLeaf(Node node) {
    return node.right == null && node.left == null;
  }

  // In order printing of tree
  public void printTree() {
    printTree(root);
    System.out.println();
  }

  private void printTree(Node node) {
    if (node == null) {
      return;
    }
    printTree(node.left);
    System.out.println(node.data + "  " + node.value);
    printTree(node.right);
  }

  private int compare(Node a, Node b) {
    return Integer.compare(a.data, b.data);
  }
}
