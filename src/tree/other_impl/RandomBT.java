package tree.other_impl;

import java.util.Scanner;
import java.util.Random;
import java.lang.String;

public class RandomBT {

  // node is created
  int count = 0;
  boolean a;
  private Node root;
  private int[] insert;

  public RandomBT() {
    root = null;
  }

  // insertion Function is called

  public void insert(int data) {
    root = insert(root, data);
    count++;
  }

  public Node insert(Node node, int data) {
    // if tree empty create new tree;
    if (node == null) {
      node = new Node(data);
    } else {
      // if root is bigger than the data is shifted to left
      if (data <= node.data) {
        if (node.leftNode != null) {
          insert(node.leftNode, data);
        } else {
          node.leftNode = new Node(data);
        }
      }
      // if root is smaller data is shifted to right
      else if (data > node.data) {
        if (node.rightNode != null) {
          insert(node.rightNode, data);
        } else {
          node.rightNode = new Node(data);
        }
      }
    }

    return (node);

  }

  private int height(Node n) {
    if (n == null) {
      return -1;
    }
    if (n.leftNode == null && n.rightNode == null) {
      return 0;
    } else if (n.leftNode == null) {
      return 1 + height(n.rightNode);
    } else if (n.rightNode == null) {
      return 1 + height(n.leftNode);
    } else {
      return 1 + maximum(height(n.leftNode), height(n.rightNode));
    }
  }

  private int maximum(int height, int height2) {
    if (height > height2) {
      return height;
    } else {
      return height2;
    }
  }

  // In order printing of tree

  public void printTree() {
    printTree(root);
    System.out.println();
  }

  private void printTree(Node node) {
    if (node == null)
      return;
    printTree(node.leftNode);
    System.out.print(node.data + "  ");
    printTree(node.rightNode);
  }

  // Search data in tree

  public boolean search(int data) {
    a = (search(root, data));

    return a;
  }

  private boolean search(Node node, int data) {
    if (node == null) {
      return (false);
    }
    if (data < node.data) {
      return (search(node.leftNode, data));
    } else if (data > node.data) {
      return (search(node.rightNode, data));
    }
    return true;
  }

  public void printsearch(int data) {
    if (a == true) {
      // System.out.println("The node"+ data+ " has  been found");

    } else {
      // System.out.println("The node"+ data+" has not been found");
    }

  }

  public void delete(int data) {
    root = delete(root, data);
  }

  public Node delete(Node node, int key) {
    try {
      if (node == null) {
        System.out.println("Node " + key + " not found !!");
      } else if (compare(node.data, key) < 0) {
        node.leftNode = delete(node.leftNode, key);
      } else if (compare(node.data, key) > 0) {
        node.rightNode = delete(node.rightNode, key);
      } else {
        if (node.rightNode == null) {
          System.out.println("Node deleted " + key);
          return (node.leftNode);
        } else if (node.leftNode == null) {
          System.out.println("Node deleted " + key);
          return (node.rightNode);
        } else {
          Node t = node;
          node = min(t.rightNode);
          node.rightNode = deleteMin(t.rightNode);
          node.leftNode = t.leftNode;
          System.out.println("Node deleted " + key);
        }
      }
    } catch (NullPointerException e) {
      System.out.print("node not exist");
    } catch (StackOverflowError e) {
      System.out.print("stack");
    }
    count--;
    return node;
  }

  public Node deleteMin(Node node) {
    if (node.leftNode == null)
      return node.rightNode;

    node.leftNode = deleteMin(node.leftNode);
    return node;
  }

  public Node min(Node x) {
    if (x.rightNode == null)
      return x;
    else
      return min(x.leftNode);
  }

  public int size() {
    return size(root);
  }

  // return number of key-value pairs in BST rooted at x
  private int size(Node x) {
    if (x == null)
      return 0;
    else
      return x.data;
  }

  private int compare(int data, int data2) {
    return (data2 - data);
  }

  private static class Node {
    Node leftNode, rightNode;
    int data;

    Node(int newdata) {
      leftNode = null;
      rightNode = null;
      data = newdata;
    }

  }

  public static void main(String args[]) {
    System.out.println("Enter number of elements");
    int n = 0, s = 0, a[] = new int[10000];
    // get input from user
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    // generate random nos
    Random randomGenerator = new Random();
    for (int i = 0; i < n; i++) {
      a[i] = randomGenerator.nextInt(100);
    }
    for (int i = 0; i < n; i++) {
      System.out.print(" " + a[i]);
    }
    System.out.println();
    RandomBT b = new RandomBT();
    // intial insertion
    for (int k = 0; k < n; k++) {
      if (b.count == 0 || b.count == n / 2) {
        int h = b.height(b.root);
        System.out.println("the height of the tree for n  " + b.count
            + " is " + +(h + 1));

      }
      b.insert(a[k]);

    }
    System.out.println(" ");

    b.printTree();

    int de = (int) ((2 * n) * 0.2);
    int f = (int) ((2 * n) * 0.3);
    // 2n operation
    System.out.println("During insertion");
    for (int j = 0; j < f; j++) {
      int x = randomGenerator.nextInt(100);
      // System.out.println("Count="+b.count);

      if (b.count == 0 || b.count == n / 2 || b.count == n
          || b.count == ((3 * n) / 2) || b.count == (2 * n)) {

        int h = b.height(b.root);
        System.out.println("the height of the tree for n  " + n
            + " is " + h);

      }
      // System.out.println("The no to be inserted is "+x);
      b.insert(x);
      // System.out.println("After insertion tree is ");
      // b.printTree();
    }

    // search 0.5 probability
    for (int j = 0; j < ((2 * n) * 0.5); j++) {
      s = randomGenerator.nextInt(100);
      b.search(s);
      // b.printsearch(s);
    }
    // delete
    System.out.println("During deletion");
    for (int j = 0; j < de; j++) {
      int y = randomGenerator.nextInt(100);

      // System.out.println("Count="+b.count);
      if (b.count == 0 || b.count == n / 2 || b.count == n
          || b.count == ((3 * n) / 2) || b.count == 2 * n) {
        int h = b.height(b.root);
        System.out.println("the height of the tree for n  " + n
            + " is " + h);
      }
      // System.out.println("The no to be deleted is "+y);
      b.delete(y);
      System.out.println("After deletion tree is ");
      b.printTree();

    }
    System.out.println("Program done");
  }
}
