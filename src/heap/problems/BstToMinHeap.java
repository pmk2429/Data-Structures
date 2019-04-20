package heap.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * WAP to convert BST to min heap with a condition that all the elements in the right sub tree of heap should be greater
 * than all the elements in the left subtree.
 */
public class BstToMinHeap {

  void inOrderTraverse(Node root, List<Integer> nodes) {
    if (root == null) {
      return;
    }
    Node curNode = root;
    inOrderTraverse(curNode.left, nodes);
    nodes.add(curNode.data);
    inOrderTraverse(curNode.right, nodes);
  }

  void preOrderTraverse(Node root) {
    if (root == null) {
      return;
    }
    System.out.println(root.data);
    preOrderTraverse(root.left);
    preOrderTraverse(root.right);
  }

  /*
  Algo:
  1 - Create an array of size n where n is the total number of nodes in BST
  2 - Perform inorder traversal on the StringBinaryTree to get the elements in sorted order
  3 - Perform preorder traversal on the StringBinaryTree
  4 - Build heap from the sorted array
   */
  private void heapifyBst(int[] arr, int n, int i) {
    int smallest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] < arr[smallest]) {
      smallest = l;
    }

    if (r < n && arr[r] < arr[smallest]) {
      smallest = r;
    }

    if (smallest != i) {
      int swap = arr[i];
      arr[i] = arr[smallest];
      arr[smallest] = swap;

      // recursively min heapify
      heapifyBst(arr, n, smallest);
    }
  }

  private void convertBstToMinHeap(Node root) {

    // List to store the data of all the nodes of the BST
    List<Integer> nodes = new ArrayList<>();

    // inorder traversal of heap to populate 'arr'
    inOrderTraverse(root, nodes);

    // BST to MIN HEAP conversion
    int[] array = nodes.stream().mapToInt(i -> i).toArray();
    int n = array.length;
    for (int i = (n / 2) - 1; i >= 0; i--) {
      heapifyBst(array, n, i);
    }
  }

  public static void main(String[] args) {
    // BST formation
    Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(6);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.left = new Node(5);
    root.right.right = new Node(7);

    BstToMinHeap obj = new BstToMinHeap();
    obj.convertBstToMinHeap(root);

    System.out.println("Min Heap display:");
    obj.preOrderTraverse(root);
  }
}


class Node {
  int data;

  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  @Override
  public String toString() {
    return String.valueOf(data);
  }
}
