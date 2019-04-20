package tree.other_impl;

/**
 * Implement these Operations add remove find findMininum findMaximum delete
 * delMinimum delMaximum height depth countNodes isEmpty
 *
 * @author Pavitra
 */

public class StringBinaryTree {

  class Node {
    int key;
    private String value;

    Node leftChild;
    Node rightChild;

    Node(int key, String value) {
      this.key = key;
      this.value = value;
    }

    public String toString() {
      return value + " has a key " + key;
    }
  }

  Node root;

  public void addNode(int key, String name) {
    Node newNode = new Node(key, name);

    if (root == null) {
      root = newNode;
    } else {
      Node focusNode = root;
      Node parent;

      while (true) {
        parent = focusNode;
        if (key < focusNode.key) {
          focusNode = focusNode.leftChild;
          if (focusNode == null) {
            parent.leftChild = newNode;
            return;
          }
        } else {
          focusNode = focusNode.rightChild;
          if (focusNode == null) {
            parent.rightChild = newNode;
            return;
          }
        }
      }
    }
  }

  // Delete Node
  public boolean remove(int key) {
    // Start at the top of the tree
    Node focusNode = root;
    Node parent = root;

    // When searching for a Node this will tell us whether to search to the right or left
    boolean isItALeftChild = true;

    // While we haven't found the Node keep looking
    while (focusNode.key != key) {
      parent = focusNode;

      // If we should search to the left
      if (key < focusNode.key) {
        isItALeftChild = true;
        // Shift the focus Node to the left child
        focusNode = focusNode.leftChild;
      } else {
        // Greater than focus node so go to the right
        isItALeftChild = false;
        // Shift the focus Node to the right child
        focusNode = focusNode.rightChild;
      }

      // The node wasn't found
      if (focusNode == null) {
        return false;
      }
    }

    // If Node doesn't have children delete it
    if (focusNode.leftChild == null && focusNode.rightChild == null) {
      // If root delete it
      if (focusNode == root) {
        root = null;
      } else if (isItALeftChild) { // If it was marked as a left child of the parent delete it in its parent
        parent.leftChild = null;
      } else { // Vice versa for the right child
        parent.rightChild = null;
      }
    }

    // If no right child
    else if (focusNode.rightChild == null) {
      if (focusNode == root) {
        root = focusNode.leftChild;
      } else if (isItALeftChild) { // If focus Node was on the left of parent move the focus Nodes left child up to the parent node
        parent.leftChild = focusNode.leftChild;
      } else { // Vice versa for the right child
        parent.rightChild = focusNode.leftChild;
      }
    }

    // If no left child
    else if (focusNode.leftChild == null) {
      if (focusNode == root) {
        root = focusNode.rightChild;
      } // If focus Node was on the left of parent move the focus Nodes right child up to the parent node
      else if (isItALeftChild) {
        parent.leftChild = focusNode.rightChild;
      } else { // Vice versa for the left child
        parent.rightChild = focusNode.rightChild;
      }
    }

    // Two children so I need to find the deleted nodes replacement
    else {
      Node replacement = getReplacementNode(focusNode);
      // If the focusNode is root replace root with the replacement
      if (focusNode == root) {
        root = replacement;
      } // If the deleted node was a left child make the replacement the left child
      else if (isItALeftChild) {
        parent.leftChild = replacement;
      } else { // Vice versa if it was a right child
        parent.rightChild = replacement;
      }
      replacement.leftChild = focusNode.leftChild;
    }
    return true;
  }

  // Get the replacement for the Node removed.
  private Node getReplacementNode(Node replacedNode) {

    Node replacementParent = replacedNode;
    Node replacement = replacedNode;

    Node focusNode = replacedNode.rightChild;

    // While there are no more left children

    while (focusNode != null) {

      replacementParent = replacement;
      replacement = focusNode;
      focusNode = focusNode.leftChild;

    }

    // If the replacement isn't the right child
    // move the replacement into the parents
    // leftChild slot and move the replaced nodes
    // right child into the replacements rightChild

    if (replacement != replacedNode.rightChild) {

      replacementParent.leftChild = replacement.rightChild;
      replacement.rightChild = replacedNode.rightChild;

    }

    return replacement;

  }

  // find specific node
  public Node findNode(int key) {
    // Start at the top of the tree
    Node focusNode = root;

    // While we haven't found the Node keep looking
    while (focusNode.key != key) {

      // If we should search to the left
      if (key < focusNode.key) {
        // Shift the focus Node to the left child
        focusNode = focusNode.leftChild;

      } else {
        // Shift the focus Node to the right child
        focusNode = focusNode.rightChild;

      }

      // The node wasn't found
      if (focusNode == null)
        return null;
    }

    return focusNode;

  }

  // In order Traversal
  private void inOrderTraverse(Node focusNode) {
    if (focusNode != null) {
      inOrderTraverse(focusNode.leftChild);
      System.out.println(focusNode);
      inOrderTraverse(focusNode.rightChild);
    }
  }

  // Preorder Traversal
  private void preOrderTraverse(Node focusNode) {
    if (focusNode != null) {
      System.out.println(focusNode);
      preOrderTraverse(focusNode.leftChild);
      preOrderTraverse(focusNode.rightChild);
    }
  }

  // Postorder Traversal
  private void postOrderTraverse(Node focusNode) {
    if (focusNode != null) {
      postOrderTraverse(focusNode.leftChild);
      postOrderTraverse(focusNode.rightChild);
      System.out.println(focusNode);
    }
  }

  public static void main(String[] args) {
    StringBinaryTree tree = new StringBinaryTree();

    tree.addNode(50, "CEO");
    tree.addNode(25, "VP");
    tree.addNode(15, "Manager");
    tree.addNode(30, "Secretary");
    tree.addNode(75, "Sales Manager");
    tree.addNode(85, "Employee");

    System.out.println("--------------------------");
    System.out.println("In order Traversal\n");
    tree.inOrderTraverse(tree.root);

    System.out.println("\n--------------------------");
    System.out.println("Pre order Traversal\n");
    tree.preOrderTraverse(tree.root);

    System.out.println("\n--------------------------");
    System.out.println("Post order Traversal\n");
    tree.postOrderTraverse(tree.root);

    System.out.println("\nNode with the key 75: " + tree.findNode(75));

    System.out.println("Remove Key 25");
    tree.remove(25);

    System.out.println("25 is now: " + tree.findNode(25));

    System.out.println("\n---------------------------");
    System.out.println("In order traversal\n");
    tree.inOrderTraverse(tree.root);
  }
}
