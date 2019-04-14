package tree.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
  public List<List<Node>> getNodesAtLevel(int level) {
    List<List<Node>> lists = new ArrayList<>();
    List<Node> list = new LinkedList<>();

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

  private int deduceTotalChild(Node node) {
    if (node == null) {
      return -1;
    }

    if (node == root) {
      return count - 1;
    }

    if (node.right == null || node.left == null) {
      return 1;
    } else {
      return deduceTotalChild(node.right) + deduceTotalChild(node.left);
    }
  }

  @Override
  public int totalChild() {
    return deduceTotalChild(root);
  }

  @Override
  public int totalChild(Node node) {
    return deduceTotalChild(node);
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
    List<List<Node>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    LinkedList<Node> nodeQueue = new LinkedList<>();
    LinkedList<Integer> levelQueue = new LinkedList<>();

    nodeQueue.offer(root);
    levelQueue.offer(1); //start from 1

    while (!nodeQueue.isEmpty()) {
      Node node = nodeQueue.poll();
      int level = levelQueue.poll();

      // get the most recent level to add the node to that list
      List<Node> temp;
      if (result.size() < level) {
        temp = new ArrayList<>();
        result.add(temp);
      } else {
        temp = result.get(level - 1);
      }

      // add the node to current level list
      temp.add(node);

      // check for left node
      if (node.left != null) {
        nodeQueue.offer(node.left);
        levelQueue.offer(level + 1);
      }

      // check for right node
      if (node.right != null) {
        nodeQueue.offer(node.right);
        levelQueue.offer(level + 1);
      }
    }

    return result;
  }

  @Override
  public void printLevelOrder() {
    if (root == null) {
      return;
    }

    Node currNode = root;
    LinkedList<Node> nodesQ = new LinkedList<>();
    nodesQ.add(currNode);

    while (!nodesQ.isEmpty()) {
      // print the current node
      System.out.println(nodesQ.peek().value);

      if (currNode.left != null) {
        nodesQ.add(currNode.left);
      }

      if (currNode.right != null) {
        nodesQ.add(currNode.right);
      }

      nodesQ.remove();
      currNode = nodesQ.peek();
    }

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

  // Util method to check if the current tree is complete or not.
  private boolean isComplete(Node root) {
    return false;
  }

  @Override
  public boolean isComplete() {
    return isComplete(root);
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

  private void reverseTree(Node root) {
    if (root == null) {
      return;
    }

    // swap nodes
    Node temp = root.right;
    root.right = root.left;
    root.left = temp;

    // reverse left tree
    reverseTree(root.left);

    // reverse right tree
    reverseTree(root.right);
  }

  @Override
  public void reverse() {
    reverseTree(root);
  }

  @Override
  public boolean isLevelOrderSorted() {
    boolean isSorted = true;

    Node currNode = root;

    // to store maximum value of previous level
    int prevMax = Integer.MIN_VALUE;

    // to store minimum value of current level
    int minVal;

    // to store maximum value of current level
    int maxVal;

    // to store number of nodes in current level
    int levelSize;

    // queue to perform level order traversal.
    Queue<Node> q = new LinkedList<>();
    q.add(currNode);

    while (!q.isEmpty()) {

      // find number of nodes in current level
      levelSize = q.size();

      minVal = Integer.MAX_VALUE;
      maxVal = Integer.MIN_VALUE;

      // traverse current level and find minimum and maximum value of this level
      while (levelSize > 0) {
        currNode = q.poll();

        levelSize--;

        minVal = Math.min(minVal, currNode.data);
        maxVal = Math.max(maxVal, currNode.data);

        if (currNode.left != null) {
          q.add(currNode.left);
        }

        if (currNode.right != null) {
          q.add(currNode.right);
        }
      }

      // if minimum value of this level is not greater than maximum
      // value of previous level then given tree is not level sorted.
      if (minVal <= prevMax) {
        isSorted = false;
      }

      // maximum value of this level is
      // previous maximum value for
      // next level.
      prevMax = maxVal;
    }

    return isSorted;
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
