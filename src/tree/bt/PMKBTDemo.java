package tree.bt;

import java.util.List;

public class PMKBTDemo {
  public static void main(String[] args) {
    BinaryTreeImpl binaryTree = new BinaryTreeImpl();

    Node a = new Node(5, "PMK");
    Node b = new Node(3, "MMK");
    Node c = new Node(7, "RMK");
    Node d = new Node(4, "MDK");
    Node e = new Node(6, "KPK");
    Node f = new Node(2, "HPK");
    Node g = new Node(8, "BMK");
    Node h = new Node(9, "TPK");

    binaryTree.add(a);
    binaryTree.add(b);
    binaryTree.add(c);
    binaryTree.add(d);
    binaryTree.add(e);
    binaryTree.add(f);
    binaryTree.add(g);
    binaryTree.add(h);

    //binaryTree.printTree();

    binaryTree.levelOrder();

    List<List<Node>> levels = binaryTree.levelOrder();

    for (List<Node> nodes : levels) {
      System.out.println(nodes);
    }

//    System.out.println(binaryTree.height(e));
//    System.out.println(binaryTree.depth());
//
//    System.out.println(binaryTree.parent(d).value);
//
//    Node predecessor = binaryTree.predecessor(b);
//    System.out.println(predecessor.data + " -PD- " + predecessor.value);
//
//    Node successor = binaryTree.successor(b);
//    System.out.println(successor.data + " -SU- " + successor.value);
//
//    System.out.println(binaryTree.isFull());
//
//    List<Node> successors = binaryTree.immediateSuccessors(a, 2);
//    System.out.println(successors);

//    List<Node> inorders = binaryTree.inOrderTraversal();
//    for (Node n : inorders) {
//      System.out.println(n.data + " - " + n.value);
//    }
//
//    System.out.println("---------------");
//
//    List<Node> preOrder = binaryTree.preOrderTraversal();
//    for (Node n : preOrder) {
//      System.out.println(n.data + " - " + n.value);
//    }
//
//    System.out.println("---------------");
//
//    List<Node> postOrder = binaryTree.postOrderTraversal();
//    for (Node n : postOrder) {
//      System.out.println(n.data + " - " + n.value);
//    }

//    List<Node> immediateSuccessors = binaryTree.immediateSuccessors(a, 2);
//    for (Node n : immediateSuccessors) {
//      System.out.println(n.data + " - " + n.value);
//    }
//
//    int totalChild = binaryTree.totalChild(b);
//    System.out.println(totalChild);

  }
}
